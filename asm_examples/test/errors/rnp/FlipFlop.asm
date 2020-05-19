// with parameters - parameteric FSM
// ATTENZIONE NON FUNZIONA perch� trova natural invece che state
//  anche se state � un sottoinsieme di natural

asm FlipFlop

import ../../STDL/StandardLibrary

signature: 
	domain State subsetof Natural

	dynamic controlled ctl_state : State
	dynamic monitored high : Boolean
	dynamic monitored low : Boolean

definitions:

	domain State = {0n, 1n}

	macro rule r_Fsm($ctl_state in State, $aState in State , 
			$nextState in State, $cond in Boolean, $rule in Rule) =
		if $ctl_state = $aState and $cond then  
			par
				$rule
				$ctl_state := $nextState
			endpar
		endif

    macro rule r_skip = skip

	invariant inv_neverBoth over high(), low(): not(high and low)


	main rule r_Main =  
		seq
			r_Fsm[ctl_state, 0n, 1n, high, <<r_skip>>]
			r_Fsm[ctl_state, 1n, 0n, low, <<r_skip>>]
		endseq

default init s0:

	function ctl_state = 0n
