/** simple
*/

asm simple

import STDL/StandardLibrary

signature:

	monitored m1: Integer
	monitored m2: Integer
	controlled c1: Integer
	controlled c2: Integer

definitions:

	main rule r_Main =
		par
			c1 := m1 + 1
			c2 := m2 + 2
		endpar

default init s1:    
	function m1 = 1
	function c1 = m1

