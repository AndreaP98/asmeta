/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package asmeta.structure.validation;

import org.eclipse.emf.common.util.EList;

import asmeta.structure.Body;
import asmeta.structure.Header;
import asmeta.structure.Initialization;
import asmeta.transitionrules.basictransitionrules.MacroDeclaration;

/**
 * A sample validator interface for {@link asmeta.structure.Asm}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AsmValidator {
	boolean validate();

	boolean validateInitialState(EList<Initialization> value);
	boolean validateDefaultInitialState(Initialization value);
	boolean validateBodySection(Body value);
	boolean validateHeaderSection(Header value);
	boolean validateMainrule(MacroDeclaration value);
	boolean validateIsAsynchr(Boolean value);
}