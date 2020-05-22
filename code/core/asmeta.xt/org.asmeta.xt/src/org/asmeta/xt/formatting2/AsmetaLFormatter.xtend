/*
 * generated by Xtext 2.21.0
 */
package org.asmeta.xt.formatting2

import com.google.inject.Inject
import org.asmeta.xt.asmetal.Asm
import org.asmeta.xt.asmetal.Header
import org.asmeta.xt.services.AsmetaLGrammarAccess
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.asmeta.xt.asmetal.BlockRule

class AsmetaLFormatter extends AbstractFormatter2 {
	
	@Inject extension AsmetaLGrammarAccess

	def dispatch void format(Asm asm, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		asm.headerSection.format
		asm.bodySection.format
		asm.mainrule.format
		for (initialization : asm.initialState) {
			initialization.format
		}
		asm.defaultInitialState.format
	}

	def dispatch void format(Header header, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (importClause : header.importClause) {
			importClause.format
			importClause.append[newLine]
			
		}
		header.exportClause.format
		header.signature.format
	}
		
	// TODO: implement for ImportClause, Signature, Initialization, DomainInitialization, FunctionInitialization, AgentInitialization, Body, DomainDefinition, FunctionDefinition, MacroDeclaration, TurboDeclaration, Invariant, InvariantElement, CtlSpec, LtlSpec, JusticeConstraint, CompassionConstraint, InvariantConstraint, ConcreteDomain, EnumTD, RuleDomain, ProductDomain, SequenceDomain, PowersetDomain, BagDomain, MapDomain, DerivedFunction, StaticFunction, LocalFunction, ControlledFunction, SharedFunction, MonitoredFunction, OutFunction, BinaryOperation, Expression, FunctionTerm, LocationTerm, ConditionalTerm, CaseTerm, TupleTerm, SequenceTerm, MapTerm, SetTerm, BagTerm, ExistUniqueTerm, ExistTerm, ForallTerm, LetTerm, SetCT, MapCT, SequenceCT, BagCT, RuleAsTerm, TermAsRule, UpdateRule, BlockRule, ConditionalRule, ChooseRule, ForallRule, LetRule, MacroCallRule, ExtendRule, SeqRule, IterateRule, TurboCallRule, TurboReturnRule, TurboLocalStateRule, CaseRule, RecursiveWhileRule, IterativeWhileRule
	
	// implement for BlockRule
	def dispatch void format(BlockRule block, extension IFormattableDocument document) {	
		block.append[newLine]
		interior(
			block.regionFor.keyword(blockRuleAccess.parKeyword_0),
			block.regionFor.keyword(blockRuleAccess.endparKeyword_3)
		)[indent]
		// format the elements inside the block
		for (element : block.getRules) {
			element.format
		}
	}
}