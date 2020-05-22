/*
 * generated by Xtext 2.16.0
 */
package org.asmeta.avallaxt.ide

import com.google.inject.Guice
import org.asmeta.avallaxt.AvallaRuntimeModule
import org.asmeta.avallaxt.AvallaStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class AvallaIdeSetup extends AvallaStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new AvallaRuntimeModule, new AvallaIdeModule))
	}
	
}