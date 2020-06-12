asm caseRule
import ../../../../../asm_examples/STDL/StandardLibrary

signature:
	enum domain EnumDom = {AA | BB | CC | DD}
	dynamic controlled sw: EnumDom
	dynamic controlled foo: EnumDom
	
definitions:
	
	main rule r_Main = 
		switch(sw)
			case AA:
				foo := CC
			case BB:
				foo := BB
			otherwise
				foo := AA
		endswitch

default init s0:
	function sw = CC
