asm c_supervisor02
import StandardLibrary
import TimeLibrary

signature:

/****************************					 
 * DEFINITION OF DOMAINS	*
 ***************************/						
	enum domain States = {STARTUP | INIT | SELFTEST | VENTILATIONON | VENTILATIONOFF | FAILSAFE}
	
	enum domain Reply = {RESPONSE | ERROR | NORESPONSE}
	
	//breath_on = VENTILATIONON
	enum domain Watchst = {INACTIVE | BREATH_ON | ALARM} //watchdogs bits status
	
	enum domain BuzState = {ENABLE|DISABLE}
	
	enum domain StatusSelf = {PERFORMING | ENDED}
	
	enum domain ValveStatus = {OPEN | CLOSED}
	
	enum domain BreathSync = {EXP | INSP} 

	enum domain Alarm = {NONE | LOW | MEDIUM | HIGH} //Alarm bits
	
	enum domain Led = {YELLOW_CONSTANT | RED_CONSTANT | YELLOW_FLASHING | RED_FLASHING | OFF}

	domain Num subsetof Integer
/************************					 
 * INPUT SUPERVISOR	*
 ************************/	
	dynamic controlled watchdog: Boolean 
	
	/* ***MONITORED*** */
	//start - stop bits
	dynamic monitored enter_self: Boolean
	dynamic monitored exit_self: Boolean
	
	//Run bit 1 when ventilation on and 0 otherwise
	
	dynamic monitored run_command: Boolean   
	dynamic monitored stop_command: Boolean
	
	/* ***MONITORED*** */
	dynamic controlled temperature: Num
	
	//TRUE working || FALSE not working	
	/* ***MONITORED*** */
	dynamic controlled fan_working: Boolean	 //tachometer	
			
	/* PRESSURE SENSOR ***MONITORED*** */
	dynamic controlled pi_6: Num
	dynamic controlled pi_6_reply: Reply //There is a response from the sensor || The response reported an error

	/* ADC ***MONITORED*** */	 
	dynamic controlled adc_reply: Reply //There is a response from the ADC || The response reported an error

	dynamic monitored breath_sync: BreathSync
	
	/* ***MONITORED*** */	
	dynamic controlled all_cont: Alarm
	dynamic controlled snooze: Boolean 
	
	dynamic monitored insp_board_valve: ValveStatus
	dynamic monitored exp_board_valve: ValveStatus
	
	//v1 e v4 = true means enable
	dynamic monitored iValve: ValveStatus //v1
	dynamic monitored oValve: ValveStatus //v4
	
 /*
  * IN OUTPUT
  */
	dynamic out watchdog_st: Watchst //It indicates the state of the supervisor to the controller
	dynamic out status_selftest: StatusSelf //Self test bit
	
	dynamic out run_status: Boolean /*****************/
		
	dynamic out run_bit: Boolean /*****************/
	
	dynamic out led: Led
	
	dynamic out buzzer: BuzState 
		
	dynamic out al_bit: Alarm
		
	/* 
	 *	SUPPORT VARIABLES  
	 */
	dynamic controlled state: States
		
	dynamic controlled count_ie: Num
	
	dynamic controlled count_ppmax: Num
	dynamic controlled count_pkmax: Num  
	dynamic controlled count_ppmin: Num
	dynamic controlled count_pkmin: Num 
	dynamic controlled count_rr_max: Num
	dynamic controlled count_rr_min: Num 
	
	dynamic controlled time_insp: Integer //t_insp = time of inspiration
	dynamic controlled time_exp: Integer //t_esp = time of expiration

	//max attempts using counter   SUP.16
	dynamic controlled max_attempts_pi_6: Num
	dynamic controlled max_attempts_adc: Num 	
	
	dynamic controlled peep_max: Num
	dynamic controlled peep_min: Num //PER.52 default parameter?
	
	//Is the range ok?
	dynamic controlled peak_max: Num //ex. peak_c
	dynamic controlled peak_min: Num
	
	dynamic controlled insp_valve: ValveStatus
	dynamic controlled exp_valve: ValveStatus

	dynamic controlled previous_breath: BreathSync
	
	dynamic controlled min_rr: Real
	dynamic controlled max_rr: Real
	
	dynamic controlled rr_supp:Real
	
	controlled paw_max: Num 
	
	derived temperatured: Boolean
	
	derived watch: Boolean
	
	derived pi_6_time: Boolean
	
	derived rr_check_min: Boolean
	derived rr_check_max: Boolean
	
	derived max_attempts: Num -> Boolean
	
	derived calc_t: Timer->Integer
	
	derived revo: Prod(Integer,Integer) -> Real
	
	/* 
	 *	Timer 
	 */
	static timer_breath: Timer
	static timer_insp: Timer
	static timer_exp: Timer
	
	static timer1secondPassed:Timer
	static timer4secondPassed: Timer
	
	/* 
	 *	Function 
	 */

	
definitions:		
	domain Num = {-1000:1000}
	
	function calc_t($t in Timer) =
		mCurrTimeSecs - start($t)
	
	function revo($insp in Integer, $expi in Integer) =
		60/($insp + $expi)
	
	function watch = 
		if(expired(timer4secondPassed) and not(watchdog)) then
			false
		else
			 true
		endif
	
	function temperatured =	//derivate
		if(temperature >= -25 and temperature <= 75) then
			true
		else
			false
		endif
		
	function pi_6_time =
		if not(expired(timer1secondPassed) and (pi_6 > paw_max)) then // SUP.152.1
			true
		else
			false
		endif
			
	function max_attempts($t in Num) =
		if($t = 4) then
			true
		else
			false
		endif
	
	function rr_check_min =
		if(revo(time_insp, calc_t(timer_exp)) < min_rr) then
			true
		else
			false
		endif

	function rr_check_max =
		if(revo(time_insp, calc_t(timer_exp)) > max_rr) then
			true
		else
			false
		endif		 
		 
	//SUP 26.3
	macro rule r_check_peep_max =
			if(pi_6 > peep_max) then
				par
					if(count_ppmax = 2) then
						state := FAILSAFE
					endif
					count_ppmax := count_ppmax + 1 
				endpar
			else
				count_ppmax := 0
			endif
	
	//SUP 26.4
	macro rule r_check_peak_max =
		if(pi_6 > peak_max) then
			par
				if(count_pkmax = 2) then
					state := FAILSAFE
				endif
				count_pkmax := count_pkmax + 1
			endpar
		else
			count_pkmax := 0
		endif
		
	//SUP 27.1
	macro rule r_check_peep_min =
		if(pi_6 < peep_min) then
			al_bit := HIGH		
		endif
	
	//SUP 26.3
	macro rule r_check_peak_min =
		if(pi_6 < peak_min) then
			par
				if(count_pkmin = 2) then
					al_bit := HIGH
				endif
				count_pkmin := count_pkmin + 1
			endpar
		else
			count_pkmin := 0	
		endif		

	//SUP 26.5 
	macro rule r_check_ie($insp in Integer,$exp in Integer) =
		if((div($insp,$exp))<0.01) then
			if(count_ie = 3) then
				state := FAILSAFE
			else
				count_ie :=  count_ie + 1
			endif
		endif
		
	//SUP 25.3		
	macro rule r_check_rr_min =
			if(rr_check_min) then
				par
					if(count_rr_min = 3) then
						al_bit := HIGH
					endif
					count_rr_min := count_rr_min + 1
				endpar
			else
				count_rr_min := 0
			endif
 
	//SUP 25.3
	macro rule r_check_rr_max =
			if (rr_check_max) then
				par
					if(count_rr_max = 3) then
						al_bit := HIGH
					endif
					count_rr_max := count_rr_max + 1
				endpar
			else
				count_rr_max := 0
			endif
		
	macro rule r_breath_transition =
		if(not(previous_breath = breath_sync) and not(isUndef(previous_breath))) then
			par
				r_reset_timer[timer_breath]
				previous_breath := breath_sync	
				if(breath_sync = EXP) then
						par				
							r_check_peak_max[] //SUP 26.4
							r_check_peak_min[] //SUP 26.3	
							time_insp:= mCurrTimeSecs - start(timer_insp)  
							r_reset_timer[timer_exp]
						endpar
			     endif
				if(breath_sync = INSP) then
					par	
						rr_supp := revo(time_insp, calc_t(timer_exp))
						r_check_peep_max[]	//SUP 26.2
						r_check_peep_min[]	//SUP.27.1
						r_check_rr_min[]	//SUP.25.3	
						r_check_rr_max[]	//SUP.25.3
						time_exp:= calc_t(timer_exp)
						r_reset_timer[timer_insp]	
						r_check_ie[time_insp,  (currentTime(timer_insp) - start(timer_exp))] //SUP.26.5
					endpar 
				endif
			endpar
		endif
	
	macro rule r_same =
		if(breath_sync = previous_breath)then
				if not(expired(timer_breath)) then //25.4
					par
						previous_breath := breath_sync
						if(breath_sync = EXP) then				
								time_exp:= mCurrTimeSecs - start(timer_exp)  
						endif
						if(breath_sync = INSP) then
								time_insp:= mCurrTimeSecs - start(timer_insp)		
						endif
					endpar
					else
						state := FAILSAFE
				endif	
		endif
		
	macro rule r_firstbreath =
		if(isUndef(previous_breath))then	
					par
						r_reset_timer[timer_breath]
						previous_breath := breath_sync
						if(breath_sync = EXP) then
							r_reset_timer[timer_exp]
						endif
						if(breath_sync = INSP) then		
							r_reset_timer[timer_insp]
						endif	
					endpar
		endif

	macro rule r_check_sync =	
				par	
					r_breath_transition[] //when previous breath != of the current
					r_same[] // previous breath = of the current
					r_firstbreath[] //it's the first breath
				endpar
				
	macro rule r_led_board($s in Alarm) =	
		switch($s)
			case LOW:
					led := YELLOW_CONSTANT
			case MEDIUM:
					led := YELLOW_FLASHING	
			case HIGH:
					led := RED_FLASHING	
			otherwise
					led := OFF
		endswitch	
		
	macro rule r_al_manage($r in Alarm) = 		
			if not($r=NONE) then
				par
					r_led_board[$r]
							if(snooze)then
								buzzer := DISABLE
							else
								buzzer := ENABLE
							endif
				endpar
			endif

	macro rule r_al_con =
		if al_bit = NONE and not(all_cont = NONE) then //supervisor takes precedence SUP.30
			r_al_manage[all_cont] //SUP.150
		endif 
		 /*
		    SUP150 already set 
			insp_board_valve = CLOSED
			esp_board_valve = OPEN
		  */	

	macro rule r_execute_st =
		par
		  state := SELFTEST
		  insp_valve := OPEN  //SUP.160
		  exp_valve := CLOSED
		  status_selftest := PERFORMING
		endpar

	macro rule r_stop_st =
		par
		  state := VENTILATIONOFF
		  insp_valve := CLOSED //SUP.19
		  exp_valve := OPEN
		  r_reset_timer[timer1secondPassed]
		  r_reset_timer[timer4secondPassed]
		  status_selftest := ENDED
		endpar

		/*Controller and supervisor say the same thing */
	macro rule r_check_v =
		if(breath_sync = INSP) then
			if not(insp_board_valve = OPEN and exp_board_valve = CLOSED) then
				state := FAILSAFE
			endif
		else if(breath_sync = EXP) then
				if not(exp_board_valve = OPEN and insp_board_valve = CLOSED) then
					state := FAILSAFE
				endif
			endif
		endif

	macro rule r_start_v =
 		par
			r_reset_timer[timer1secondPassed]
		    r_reset_timer[timer4secondPassed]
			watchdog_st := BREATH_ON
			run_bit := true 
			insp_valve := OPEN //SUP.23
			exp_valve := CLOSED
			r_check_sync[]
			par
				r_al_con[]
				r_check_v[]					
			endpar
		endpar
							
	macro rule r_stop_v =
 		par
 			state := VENTILATIONOFF 
			r_reset_timer[timer1secondPassed]
		    r_reset_timer[timer4secondPassed]
			watchdog_st := INACTIVE
			insp_valve := CLOSED
			exp_valve := OPEN 	
			time_insp := 0
			time_exp := 0
			rr_supp := 0.0
			count_ppmax := 0
			count_ppmin := 0
			count_pkmax := 0
			count_pkmin := 0
			count_rr_min := 0	//here or at the start of ventilation on?
			count_rr_max := 0
			previous_breath := undef
		endpar

	//SUP.16
	macro rule r_check_pi6 =
		if not(pi_6_reply = RESPONSE) then //response received with errors from pi_6
			par
				if(max_attempts(max_attempts_pi_6)) then
					state := FAILSAFE
				endif					
				max_attempts_pi_6 := max_attempts_pi_6 + 1
			endpar
		else
			max_attempts_pi_6 := 0
		endif
	
	//SUP.17
	macro rule r_check_adc =
		if not(adc_reply = RESPONSE) then //response received with errors from  adc
			par
				if(max_attempts(max_attempts_adc)) then
					state := FAILSAFE	
				endif
				max_attempts_adc := max_attempts_adc + 1
			endpar
		else
			max_attempts_adc := 0
		endif
	
	macro rule r_in_init =
			state := INIT
			/***SUP.14 already declared in the initialization 
			insp_board_valve := CLOSED 
			exp_board_valve := OPEN    
			***/
	
	macro rule r_startup =
		par
			max_attempts_pi_6 := 0 //reset when a response without errors is received
			max_attempts_adc := 0
			if(watch) then	//SUP.18
				if(watchdog) then //SUP.13 first watchdog from the controller
					par
						r_in_init[]
						r_reset_timer[timer1secondPassed]
						r_reset_timer[timer4secondPassed]
					endpar
				endif
			else
				state := FAILSAFE
			endif
		endpar
					
	macro rule r_init =
		if temperatured and fan_working and watch and pi_6_time then //SUP.151.3 //SUP.151.4 //SUP.152.1 //SUP.152.2  
				par
				 	r_al_con[]
					if (enter_self) then //152.3 ??? 
						par	
							r_execute_st[]
							r_reset_timer[timer4secondPassed]
						endpar
					endif 
					if(watchdog) then
						r_reset_timer[timer4secondPassed]
					endif
				endpar
		else 
			state := FAILSAFE	
		endif
	
	macro rule r_selftest =
			if watch then //SUP.161
				par
					if not(al_bit = NONE) then //SUP.162 SUP.163 
						r_al_manage[al_bit]
					endif
					if(watchdog) then
						r_reset_timer[timer4secondPassed]
					endif
					if (exit_self)then	//SUP.164
						r_stop_st[]						
					endif
				endpar
			 else
				state := FAILSAFE
			endif		 	
		
	macro rule r_ventilation_off =
			if(temperatured) //SUP 20.4
				and (watch) //SUP 21.2
				and (pi_6_time) then //21.1
					par	
						r_al_con[] //SUP.19
						if(watchdog) then
							r_reset_timer[timer4secondPassed]
						endif
						if (run_command) then
							par	
								state := VENTILATIONON
								r_start_v[]
							endpar
						endif
					endpar			
			else
					state := FAILSAFE	
			endif		
	
	macro rule r_ventilation_on =  
			if(temperatured) and (watch) and (pi_6_time) //SUP 20.4 //SUP.21.1 //SUP.21.2
				 then 
					if(stop_command) then
						par
							r_stop_v[]
							r_reset_timer[timer4secondPassed]
							r_reset_timer[timer1secondPassed]
						endpar
					else
						par
							r_al_con[]
							r_check_sync[]
							if(rr_supp != 0.0) then
								par
									r_check_rr_min[]
									r_check_rr_max[]
								endpar
							endif
							r_check_v[] //SUP.25.1 //SUP.25.2
						endpar
					endif					
			else
				state := FAILSAFE	
			endif
									
	macro rule r_failsafe =
		par
			insp_valve := CLOSED //SUP.104
			exp_valve := OPEN 
			watchdog_st := ALARM 
			r_al_manage[al_bit] //SUP.30
		endpar
				
main rule r_main =  
  if(state = SELFTEST) then
	 	r_selftest[]
	 else
	 	 if(state = FAILSAFE) then
		 	r_failsafe[]
		else
			 if (adc_reply = RESPONSE) //SUP.100.2 e SUP.17
				and (pi_6_reply = RESPONSE) then //SUP.100.1 e SUP.16 
					if (fan_working) then //SUP.20.5 SUP.15 SUP.151.4
					 	switch(state)
							case(STARTUP):
								r_startup[]
							case(INIT):
								r_init[]
							 case(SELFTEST):
								r_selftest[]
							case(VENTILATIONOFF):
								r_ventilation_off[]
							case(VENTILATIONON):
								r_ventilation_on[]
						endswitch
					 
					else
						state := FAILSAFE
					endif
			else
				par
					r_check_adc[]
					r_check_pi6[]
				endpar
			endif	
		endif 
	endif
		
default init s0:
	function state = STARTUP 
	function paw_max = 65
    function iValve = CLOSED
	function oValve = OPEN
	function watchdog_st = INACTIVE
	function duration($t in Timer) = 
		if $t = timer1secondPassed then
			1 
		else
			if $t = timer4secondPassed then
				4 
		else 
			if $t = timer_breath then
				62
			endif
			endif
		endif
	
	
	/*Check all parameters */
	
	function start($t in Timer) = 
		mCurrTimeSecs
	
	function run_bit = false	
	function max_attempts_pi_6 = 0
	function max_attempts_adc = 0
	function insp_valve = CLOSED //SUP.14
	function exp_valve = OPEN
	function peep_max = 25
	function peak_max = 25 //Test parameters !!!
	function peak_min = 20 //Test parameters !!!
	function time_insp = 0
	function time_exp = 0
	function count_ie = 0
	function peep_min = 20 //Test parameters!!!
	function min_rr = 4.0
	function max_rr = 50.0
	function al_bit = NONE
	
	//Counter initialization 
	function count_ppmax = 0
	function count_ppmin = 0
	function count_pkmax = 0
	function count_pkmin = 0
	function count_rr_min = 0
	function count_rr_max = 0
	function rr_supp = 0.0
	function pi_6_reply = RESPONSE
	function adc_reply = RESPONSE
	function fan_working = true
	function pi_6 = 58
	function temperature = 25
	function watchdog = true
	function all_cont = NONE
	function snooze = false