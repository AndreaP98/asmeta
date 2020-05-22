/*
 * generated by Xtext 2.17.0
 */
package org.asmeta.avallaxt.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.asmeta.avallaxt.avallaXt.AvallaXtPackage;
import org.asmeta.avallaxt.avallaXt.Block;
import org.asmeta.avallaxt.avallaXt.Check;
import org.asmeta.avallaxt.avallaXt.Exec;
import org.asmeta.avallaxt.avallaXt.ExecBlock;
import org.asmeta.avallaxt.avallaXt.Invariant;
import org.asmeta.avallaxt.avallaXt.Scenario;
import org.asmeta.avallaxt.avallaXt.Step;
import org.asmeta.avallaxt.avallaXt.StepUntil;
import org.asmeta.avallaxt.services.AvallaGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractAvallaSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AvallaGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == AvallaXtPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case AvallaXtPackage.BLOCK:
				sequence_Block(context, (Block) semanticObject); 
				return; 
			case AvallaXtPackage.CHECK:
				sequence_Check(context, (Check) semanticObject); 
				return; 
			case AvallaXtPackage.EXEC:
				sequence_Exec(context, (Exec) semanticObject); 
				return; 
			case AvallaXtPackage.EXEC_BLOCK:
				sequence_ExecBlock(context, (ExecBlock) semanticObject); 
				return; 
			case AvallaXtPackage.INVARIANT:
				sequence_Invariant(context, (Invariant) semanticObject); 
				return; 
			case AvallaXtPackage.SCENARIO:
				sequence_Scenario(context, (Scenario) semanticObject); 
				return; 
			case AvallaXtPackage.SET:
				sequence_Set(context, (org.asmeta.avallaxt.avallaXt.Set) semanticObject); 
				return; 
			case AvallaXtPackage.STEP:
				sequence_Command(context, (Step) semanticObject); 
				return; 
			case AvallaXtPackage.STEP_UNTIL:
				sequence_StepUntil(context, (StepUntil) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Element returns Block
	 *     Block returns Block
	 *
	 * Constraint:
	 *     (name=GOOD_CHARS_NO_COLON elements+=Element*)
	 */
	protected void sequence_Block(ISerializationContext context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns Check
	 *     Command returns Check
	 *     Check returns Check
	 *
	 * Constraint:
	 *     expression=sentence
	 */
	protected void sequence_Check(ISerializationContext context, Check semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AvallaXtPackage.Literals.CHECK__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AvallaXtPackage.Literals.CHECK__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCheckAccess().getExpressionSentenceParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Element returns Step
	 *     Command returns Step
	 *
	 * Constraint:
	 *     {Step}
	 */
	protected void sequence_Command(ISerializationContext context, Step semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns ExecBlock
	 *     Command returns ExecBlock
	 *     ExecBlock returns ExecBlock
	 *
	 * Constraint:
	 *     (scenario=GOOD_CHARS_NO_COLON? block=GOOD_CHARS_NO_COLON)
	 */
	protected void sequence_ExecBlock(ISerializationContext context, ExecBlock semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns Exec
	 *     Command returns Exec
	 *     Exec returns Exec
	 *
	 * Constraint:
	 *     rule=sentencePlusAssign
	 */
	protected void sequence_Exec(ISerializationContext context, Exec semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AvallaXtPackage.Literals.EXEC__RULE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AvallaXtPackage.Literals.EXEC__RULE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExecAccess().getRuleSentencePlusAssignParserRuleCall_1_0(), semanticObject.getRule());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Invariant returns Invariant
	 *
	 * Constraint:
	 *     (name=GOOD_CHARS_NO_COLON expression=sentence)
	 */
	protected void sequence_Invariant(ISerializationContext context, Invariant semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AvallaXtPackage.Literals.INVARIANT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AvallaXtPackage.Literals.INVARIANT__NAME));
			if (transientValues.isValueTransient(semanticObject, AvallaXtPackage.Literals.INVARIANT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AvallaXtPackage.Literals.INVARIANT__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getInvariantAccess().getNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getInvariantAccess().getExpressionSentenceParserRuleCall_3_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Scenario returns Scenario
	 *
	 * Constraint:
	 *     (name=GOOD_CHARS_NO_COLON spec=Path invariants+=Invariant* elements+=Element*)
	 */
	protected void sequence_Scenario(ISerializationContext context, Scenario semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Element returns Set
	 *     Command returns Set
	 *     Set returns Set
	 *
	 * Constraint:
	 *     (location=sentence value=sentence)
	 */
	protected void sequence_Set(ISerializationContext context, org.asmeta.avallaxt.avallaXt.Set semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AvallaXtPackage.Literals.SET__LOCATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AvallaXtPackage.Literals.SET__LOCATION));
			if (transientValues.isValueTransient(semanticObject, AvallaXtPackage.Literals.SET__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AvallaXtPackage.Literals.SET__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSetAccess().getLocationSentenceParserRuleCall_1_0(), semanticObject.getLocation());
		feeder.accept(grammarAccess.getSetAccess().getValueSentenceParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Element returns StepUntil
	 *     Command returns StepUntil
	 *     StepUntil returns StepUntil
	 *
	 * Constraint:
	 *     expression=sentence
	 */
	protected void sequence_StepUntil(ISerializationContext context, StepUntil semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AvallaXtPackage.Literals.STEP_UNTIL__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AvallaXtPackage.Literals.STEP_UNTIL__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStepUntilAccess().getExpressionSentenceParserRuleCall_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
}