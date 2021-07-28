asm MVMcontroller03NoTime
//Third refinement: transition from inspiration to expiration and vice versa 

import StandardLibrary
import LTLlibrary

signature:
	//*************************************************
	// DOMAINS
	//*************************************************
	enum domain States = {STARTUP | SELFTEST | VENTILATIONOFF | PCV_STATE | PSV_STATE}

	enum domain Modes = {PCV | PSV}
	
	enum domain Ventilation = {INSPIRATION | EXPIRATION | INPAUSE | EXPAUSE | RM}

	enum domain ValveStatus = {OPEN | CLOSED}

	//*************************************************
	// FUNCTIONS
	//*************************************************
	dynamic monitored startupEnded: Boolean
	dynamic monitored selfTestPassed: Boolean
	dynamic monitored startVentilation: Boolean
	dynamic monitored stopRequested: Boolean
	dynamic monitored respirationMode: Modes

	dynamic controlled state: States
	
	dynamic monitored flowDropPSV: Boolean
	dynamic controlled stopVentilation: Boolean
	
	dynamic controlled iValve: ValveStatus
	dynamic controlled oValve: ValveStatus
	dynamic controlled phase: Ventilation
		
	dynamic monitored cmdExPause: Boolean
	dynamic monitored cmdInPause: Boolean
	dynamic monitored cmdRm: Boolean
	
	dynamic controlled apneaBackupMode: Boolean
	
	dynamic monitored pawGTMaxPinsp: Boolean
	dynamic monitored dropPAW_ITS: Boolean
	
	monitored timerInspirationDurPCV: Boolean
	monitored timerExpirationDurPCV: Boolean
	monitored timerMaxInspTimePSV: Boolean
	monitored timerMinInspTimePSV: Boolean
	monitored timerMinExpTimePSV: Boolean	
	
	monitored timerMaxInPause: Boolean
	monitored timerMaxRmTime: Boolean
	monitored timerMaxExPause: Boolean
	monitored timerApneaLag: Boolean

	monitored timerTriggerWindowDelay: Boolean
	
	
	monitored mCurrTimeSecs: Integer
	
definitions:
	//*************************************************
	// RULE DEFINITIONS
	//*************************************************
	rule r_startup =
		if startupEnded then state := SELFTEST endif
		
	rule r_selftest =
		if selfTestPassed then state := VENTILATIONOFF endif
	
	rule r_stopVent = 
		par
			state := VENTILATIONOFF
			stopVentilation := false
		endpar
	
	//set phase and valves state when inspiration
	rule r_inspPhase = 
		par
			phase := INSPIRATION
			iValve := OPEN
			oValve := CLOSED
		endpar
	
	//set phase and valves state when expiration
	rule r_expPhase = 
		par
			phase := EXPIRATION
			iValve := CLOSED 
			oValve := OPEN
		endpar
			
	rule r_PCVStartInsp =
		r_inspPhase[]

	
	rule r_PCVStartExp =
		r_expPhase[]

	
	rule r_PCV =
		par
			state := PCV_STATE
			r_PCVStartInsp[]
		endpar
	
	rule r_PSVStartInsp =
		r_inspPhase[]
	
		
	rule r_PSVStartExp =
	r_expPhase[]

		
	rule r_PSV =
		par
			state := PSV_STATE
			r_PSVStartInsp[]
		endpar
	
	rule r_runApnea = 
		par
			state := PCV_STATE
			r_PCVStartInsp[]
			apneaBackupMode := true
		endpar
	
	//When in PCV because of apnea, reset the variable when the user goes back to PSV voluntary 	
	rule r_resetApneaBackup =
		if apneaBackupMode then
			apneaBackupMode := false
		endif
			
	rule r_ventilationoff =
		if startVentilation	then
			par
				if respirationMode = PCV	then r_PCV[] endif
				if respirationMode = PSV	then r_PSV[] endif
			endpar
		endif
	
	//Inspiratory Pause
	rule r_InPause =
		par
			phase := INPAUSE
			iValve := CLOSED 
		endpar

	//Recruitment Maneuver
	rule r_rm =
		phase := RM

	
	//Expiratory Pause
	rule r_exPause =
		par
			phase := EXPAUSE
			oValve := CLOSED 
		endpar
			
	rule r_runPCVInsp =	
		par
			//if stop ventilation is requested store the request if not already requested
			if not stopVentilation then
				if stopRequested then
					stopVentilation := true
				endif
			endif
			//when inspiration duration expires go to expiration based on selected mode
			if timerInspirationDurPCV	then
				par
					if respirationMode = PCV then
						//in pause has precedence over rm and rm has precedence over expiration
						if cmdInPause then
							r_InPause[]
						else if cmdRm then
							r_rm[]
						else
							r_PCVStartExp[]
						endif endif 
					endif
					if respirationMode = PSV then
						par
							state := PSV_STATE
							r_PSVStartExp[]
							r_resetApneaBackup[]
						endpar
					endif
				endpar
			else if pawGTMaxPinsp then
				r_PCVStartExp[]
			endif endif
		endpar
	
		
	//PCV expiration
	rule r_runPCVExp =	
		//if stop ventilation go to ventilation off immediately
		if stopVentilation then
			r_stopVent[]
		else 
			if stopRequested then
				r_stopVent[]
			else
			//when expiration duration is expired go to inspiration
				if timerExpirationDurPCV then
					//ex pause has precedence over inspiration
					if cmdExPause then
						r_exPause[]
					else
						r_PCVStartInsp[]
					endif	
				else if timerTriggerWindowDelay and dropPAW_ITS then
					r_PCVStartInsp[]
				endif endif 	
			endif 
		endif
	
	rule r_runInPause = 
	 	if ((not cmdInPause) or timerMaxInPause) then
			par
				if state = PCV_STATE then
					r_PCVStartExp[]
				endif
				if state = PSV_STATE then
					r_PSVStartExp[]
				endif
			endpar
		endif
	
	rule r_runRm = 
		if (not cmdRm) or timerMaxRmTime then
			par
				if state = PCV_STATE then
					r_PCVStartExp[]
				endif
				if state = PSV_STATE then
					r_PSVStartExp[]
				endif
			endpar
		endif
	
	rule r_runExPause = 
		if (not cmdExPause) or timerMaxExPause then
			par
				if state = PCV_STATE then
					r_PCVStartInsp[]
				endif
				if state = PSV_STATE then
					r_PSVStartInsp[]
				endif
			endpar
		endif
		
		
	//PCV mode					
	rule r_runPCV =
		par
			if phase = INSPIRATION then
				r_runPCVInsp[]
			endif
			if phase = EXPIRATION then
				r_runPCVExp[]
			endif
			if phase = INPAUSE then
				r_runInPause[]
			endif
			if phase = RM then
				r_runRm[]
			endif
			if phase = EXPAUSE then
				r_runExPause[]
			endif
		endpar
	
	//PSV inspiration
	rule r_runPSVInsp =	
		par
			//if stop ventilation is requested store the request if not already requested
			if not stopVentilation then
				if stopRequested then
					stopVentilation := true
				endif
			endif
			//when min inspiration time is expired and flow drop or max expiration time is expired go to expiration
			if (timerMinInspTimePSV and flowDropPSV) or timerMaxInspTimePSV then
				//in pause has precedence over rm and rm has precedence over expiration
				if cmdInPause then
					r_InPause[]
				else if cmdRm then
					r_rm[]
				else
					r_PSVStartExp[]
				endif endif
			else if pawGTMaxPinsp then
				r_PSVStartExp[]
			endif endif 
		endpar
	
	
	//PSV expiration	
	rule r_runPSVExp =	
		//if stop ventilation go to ventilation off immediately
		if stopVentilation then
			r_stopVent[]
		else 
			if stopRequested then
				r_stopVent[]
		else
		//when min expiration time expires go to inspiration based on selected mode
			if timerTriggerWindowDelay and dropPAW_ITS then
				r_PSVStartInsp[]
			else if timerApneaLag then
				r_runApnea[]
			else 
			if timerMinExpTimePSV then
				par
					if respirationMode = PCV then
						par
							state := PCV_STATE
							r_PCVStartInsp[]
						endpar
					endif
					if respirationMode = PSV then
						//ex pause has precedence over inspiration
						if cmdExPause then
							r_exPause[]
						endif
					endif
				endpar
			endif
		endif	endif	endif endif
	
	//PSV mode
	rule r_runPSV =
		par
			if phase = INSPIRATION then
				r_runPSVInsp[]
			endif
			if phase = EXPIRATION then
				r_runPSVExp[]
			endif
			if phase = INPAUSE then
				r_runInPause[]
			endif
			if phase = RM then
				r_runRm[]
			endif
			if phase = EXPAUSE then
				r_runExPause[]
			endif
		endpar
		
	//*************************************************
	// Property Verification
	//*************************************************
 	//safety: valves are never both open or both closed at the same time
	//LTLSPEC not f(iValve=CLOSED and oValve=CLOSED)
	//LTLSPEC not f(iValve=OPEN and oValve=OPEN)
	//LTLSPEC not f(iValve=oValve)
	//when ventilation is off, out valve is open and in valve is closed
	LTLSPEC g(state=VENTILATIONOFF implies (iValve=CLOSED and oValve=OPEN))
	//when ventilation is in inspiration, in valve is open and out valve is closed
	LTLSPEC g((phase=INSPIRATION and (state = PCV_STATE or state = PSV_STATE)) implies (iValve=OPEN and oValve=CLOSED))
	//when ventilation is in expiration, out valve is open and in valve is closed
	LTLSPEC g((phase=EXPIRATION and (state = PCV_STATE or state = PSV_STATE)) implies (iValve=CLOSED and oValve=OPEN))
	//when ventilation is in in pause or ex pause, valves are closed
	LTLSPEC g(((phase=INPAUSE or phase=EXPAUSE) and (state = PCV_STATE or state = PSV_STATE)) implies (iValve=CLOSED and oValve=CLOSED))
	//when ventilation is in rm, in valve is open and out valve is closed
	LTLSPEC g((phase=RM and (state = PCV_STATE or state = PSV_STATE)) implies (iValve=OPEN and oValve=CLOSED))
	//both valves closed only happens during pauses
	LTLSPEC g((iValve=CLOSED and oValve=CLOSED) implies ((phase=INPAUSE or phase=EXPAUSE) and (state = PCV_STATE or state = PSV_STATE)))

	//*************************************************
	// MAIN Rule
	//*************************************************
	main rule r_Main =

		par
		
		if mCurrTimeSecs>0 then skip endif
		
		//transition from startup to selftest
		if state = STARTUP then
			r_startup[]
		endif

		//transition from selftest to ventilation off
		if state = SELFTEST then
			r_selftest[]
		endif

		//start ventilation, either pcv or psv
		if state = VENTILATIONOFF then
			r_ventilationoff[]
		endif

		//transition from PCV to ventilation off if requested
		if state = PCV_STATE then
			r_runPCV[]
		endif

		//transition from PSV to ventilation off if requested
		if state = PSV_STATE	then
			r_runPSV[]
		endif

	endpar

default init s0:
//controlled functions
	function state = STARTUP
	function phase = INSPIRATION
	function iValve = CLOSED
	function oValve = OPEN
	function stopVentilation = false 
	function flowDropPSV = false
	
	function startupEnded = false
	function selfTestPassed = false
	function startVentilation = false
	function stopRequested = false
	function respirationMode  = PCV
	
	function cmdExPause = false
	function cmdInPause = false
	function cmdRm = false
	function apneaBackupMode = false
	
	function pawGTMaxPinsp = false
	function dropPAW_ITS = false

