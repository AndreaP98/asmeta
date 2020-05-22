/*
 * generated by Xtext 2.17.0
 */
package org.asmeta.avallaxt.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class AvallaGrammarAccess extends AbstractGrammarElementFinder {
	
	public class ScenarioElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.Scenario");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cScenarioKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLoadKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cSpecAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cSpecPathParserRuleCall_3_0 = (RuleCall)cSpecAssignment_3.eContents().get(0);
		private final Assignment cInvariantsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cInvariantsInvariantParserRuleCall_4_0 = (RuleCall)cInvariantsAssignment_4.eContents().get(0);
		private final Assignment cElementsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cElementsElementParserRuleCall_5_0 = (RuleCall)cElementsAssignment_5.eContents().get(0);
		
		//// PROVIAMO METODO BARBARICO
		//Scenario:
		//	'scenario' name=GOOD_CHARS_NO_COLON
		//	'load' spec=Path
		//	invariants+=Invariant*
		//	elements+=Element*;
		@Override public ParserRule getRule() { return rule; }
		
		//'scenario' name=GOOD_CHARS_NO_COLON 'load' spec=Path invariants+=Invariant* elements+=Element*
		public Group getGroup() { return cGroup; }
		
		//'scenario'
		public Keyword getScenarioKeyword_0() { return cScenarioKeyword_0; }
		
		//name=GOOD_CHARS_NO_COLON
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//GOOD_CHARS_NO_COLON
		public RuleCall getNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0() { return cNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0; }
		
		//'load'
		public Keyword getLoadKeyword_2() { return cLoadKeyword_2; }
		
		//spec=Path
		public Assignment getSpecAssignment_3() { return cSpecAssignment_3; }
		
		//Path
		public RuleCall getSpecPathParserRuleCall_3_0() { return cSpecPathParserRuleCall_3_0; }
		
		//invariants+=Invariant*
		public Assignment getInvariantsAssignment_4() { return cInvariantsAssignment_4; }
		
		//Invariant
		public RuleCall getInvariantsInvariantParserRuleCall_4_0() { return cInvariantsInvariantParserRuleCall_4_0; }
		
		//elements+=Element*
		public Assignment getElementsAssignment_5() { return cElementsAssignment_5; }
		
		//Element
		public RuleCall getElementsElementParserRuleCall_5_0() { return cElementsElementParserRuleCall_5_0; }
	}
	public class InvariantElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.Invariant");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInvariantKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cExpressionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cExpressionSentenceParserRuleCall_3_0 = (RuleCall)cExpressionAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Invariant:
		//	'invariant' name=GOOD_CHARS_NO_COLON ':' expression=sentence ";";
		@Override public ParserRule getRule() { return rule; }
		
		//'invariant' name=GOOD_CHARS_NO_COLON ':' expression=sentence ";"
		public Group getGroup() { return cGroup; }
		
		//'invariant'
		public Keyword getInvariantKeyword_0() { return cInvariantKeyword_0; }
		
		//name=GOOD_CHARS_NO_COLON
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//GOOD_CHARS_NO_COLON
		public RuleCall getNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0() { return cNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0; }
		
		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
		
		//expression=sentence
		public Assignment getExpressionAssignment_3() { return cExpressionAssignment_3; }
		
		//sentence
		public RuleCall getExpressionSentenceParserRuleCall_3_0() { return cExpressionSentenceParserRuleCall_3_0; }
		
		//";"
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}
	public class ElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.Element");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cCommandParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cBlockParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Element:
		//	Command | Block;
		@Override public ParserRule getRule() { return rule; }
		
		//Command | Block
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Command
		public RuleCall getCommandParserRuleCall_0() { return cCommandParserRuleCall_0; }
		
		//Block
		public RuleCall getBlockParserRuleCall_1() { return cBlockParserRuleCall_1; }
	}
	public class CommandElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.Command");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cCheckParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cSetParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Action cStepAction_2_0 = (Action)cGroup_2.eContents().get(0);
		private final RuleCall cStepParserRuleCall_2_1 = (RuleCall)cGroup_2.eContents().get(1);
		private final RuleCall cStepUntilParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cExecParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cExecBlockParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		//Command:
		//	Check | Set | {Step} Step | StepUntil | Exec | ExecBlock;
		@Override public ParserRule getRule() { return rule; }
		
		//Check | Set | {Step} Step | StepUntil | Exec | ExecBlock
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Check
		public RuleCall getCheckParserRuleCall_0() { return cCheckParserRuleCall_0; }
		
		//Set
		public RuleCall getSetParserRuleCall_1() { return cSetParserRuleCall_1; }
		
		//{Step} Step
		public Group getGroup_2() { return cGroup_2; }
		
		//{Step}
		public Action getStepAction_2_0() { return cStepAction_2_0; }
		
		//Step
		public RuleCall getStepParserRuleCall_2_1() { return cStepParserRuleCall_2_1; }
		
		//StepUntil
		public RuleCall getStepUntilParserRuleCall_3() { return cStepUntilParserRuleCall_3; }
		
		//Exec
		public RuleCall getExecParserRuleCall_4() { return cExecParserRuleCall_4; }
		
		//ExecBlock
		public RuleCall getExecBlockParserRuleCall_5() { return cExecBlockParserRuleCall_5; }
	}
	public class CheckElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.Check");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCheckKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExpressionSentenceParserRuleCall_1_0 = (RuleCall)cExpressionAssignment_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//Check:
		//	'check' expression=sentence ";";
		@Override public ParserRule getRule() { return rule; }
		
		//'check' expression=sentence ";"
		public Group getGroup() { return cGroup; }
		
		//'check'
		public Keyword getCheckKeyword_0() { return cCheckKeyword_0; }
		
		//expression=sentence
		public Assignment getExpressionAssignment_1() { return cExpressionAssignment_1; }
		
		//sentence
		public RuleCall getExpressionSentenceParserRuleCall_1_0() { return cExpressionSentenceParserRuleCall_1_0; }
		
		//";"
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}
	public class SetElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.Set");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSetKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cLocationAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cLocationSentenceParserRuleCall_1_0 = (RuleCall)cLocationAssignment_1.eContents().get(0);
		private final Keyword cColonEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueSentenceParserRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Set:
		//	'set' location=sentence ':=' value=sentence ";";
		@Override public ParserRule getRule() { return rule; }
		
		//'set' location=sentence ':=' value=sentence ";"
		public Group getGroup() { return cGroup; }
		
		//'set'
		public Keyword getSetKeyword_0() { return cSetKeyword_0; }
		
		//location=sentence
		public Assignment getLocationAssignment_1() { return cLocationAssignment_1; }
		
		//sentence
		public RuleCall getLocationSentenceParserRuleCall_1_0() { return cLocationSentenceParserRuleCall_1_0; }
		
		//':='
		public Keyword getColonEqualsSignKeyword_2() { return cColonEqualsSignKeyword_2; }
		
		//value=sentence
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }
		
		//sentence
		public RuleCall getValueSentenceParserRuleCall_3_0() { return cValueSentenceParserRuleCall_3_0; }
		
		//";"
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}
	public class StepElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.Step");
		private final Keyword cStepKeyword = (Keyword)rule.eContents().get(1);
		
		//Step:
		//	'step';
		@Override public ParserRule getRule() { return rule; }
		
		//'step'
		public Keyword getStepKeyword() { return cStepKeyword; }
	}
	public class StepUntilElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.StepUntil");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cStepKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cUntilKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cExpressionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExpressionSentenceParserRuleCall_2_0 = (RuleCall)cExpressionAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//StepUntil:
		//	'step' 'until' expression=sentence ";";
		@Override public ParserRule getRule() { return rule; }
		
		//'step' 'until' expression=sentence ";"
		public Group getGroup() { return cGroup; }
		
		//'step'
		public Keyword getStepKeyword_0() { return cStepKeyword_0; }
		
		//'until'
		public Keyword getUntilKeyword_1() { return cUntilKeyword_1; }
		
		//expression=sentence
		public Assignment getExpressionAssignment_2() { return cExpressionAssignment_2; }
		
		//sentence
		public RuleCall getExpressionSentenceParserRuleCall_2_0() { return cExpressionSentenceParserRuleCall_2_0; }
		
		//";"
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}
	public class ExecElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.Exec");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cExecKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cRuleAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cRuleSentencePlusAssignParserRuleCall_1_0 = (RuleCall)cRuleAssignment_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//Exec:
		//	'exec' rule=sentencePlusAssign ";";
		@Override public ParserRule getRule() { return rule; }
		
		//'exec' rule=sentencePlusAssign ";"
		public Group getGroup() { return cGroup; }
		
		//'exec'
		public Keyword getExecKeyword_0() { return cExecKeyword_0; }
		
		//rule=sentencePlusAssign
		public Assignment getRuleAssignment_1() { return cRuleAssignment_1; }
		
		//sentencePlusAssign
		public RuleCall getRuleSentencePlusAssignParserRuleCall_1_0() { return cRuleSentencePlusAssignParserRuleCall_1_0; }
		
		//";"
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}
	public class BlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.Block");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cBeginKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cElementsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cElementsElementParserRuleCall_2_0 = (RuleCall)cElementsAssignment_2.eContents().get(0);
		private final Keyword cEndKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//Block:
		//	'begin' name=GOOD_CHARS_NO_COLON
		//	elements+=Element*
		//	'end';
		@Override public ParserRule getRule() { return rule; }
		
		//'begin' name=GOOD_CHARS_NO_COLON elements+=Element* 'end'
		public Group getGroup() { return cGroup; }
		
		//'begin'
		public Keyword getBeginKeyword_0() { return cBeginKeyword_0; }
		
		//name=GOOD_CHARS_NO_COLON
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//GOOD_CHARS_NO_COLON
		public RuleCall getNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0() { return cNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0; }
		
		//elements+=Element*
		public Assignment getElementsAssignment_2() { return cElementsAssignment_2; }
		
		//Element
		public RuleCall getElementsElementParserRuleCall_2_0() { return cElementsElementParserRuleCall_2_0; }
		
		//'end'
		public Keyword getEndKeyword_3() { return cEndKeyword_3; }
	}
	public class ExecBlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.ExecBlock");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cExecblockKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cScenarioAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cScenarioGOOD_CHARS_NO_COLONTerminalRuleCall_1_0_0 = (RuleCall)cScenarioAssignment_1_0.eContents().get(0);
		private final Keyword cColonKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cBlockAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cBlockGOOD_CHARS_NO_COLONTerminalRuleCall_2_0 = (RuleCall)cBlockAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//// example sc:bl -> search block bl in the scenario sc
		//// a block bl2 can be defined inside another block bll
		//// begin bl1
		////    begin bl2
		////    end 
		//// end
		//// we refer to bl2 only with bl2 (NOT bl1:bl2)
		//// example scanrio:block -> search block in the scenario
		//// if a block is inside the same scenario, scenario can be skipped 
		//ExecBlock:
		//	'execblock' (scenario=GOOD_CHARS_NO_COLON ':')? block=GOOD_CHARS_NO_COLON ';';
		@Override public ParserRule getRule() { return rule; }
		
		//'execblock' (scenario=GOOD_CHARS_NO_COLON ':')? block=GOOD_CHARS_NO_COLON ';'
		public Group getGroup() { return cGroup; }
		
		//'execblock'
		public Keyword getExecblockKeyword_0() { return cExecblockKeyword_0; }
		
		//(scenario=GOOD_CHARS_NO_COLON ':')?
		public Group getGroup_1() { return cGroup_1; }
		
		//scenario=GOOD_CHARS_NO_COLON
		public Assignment getScenarioAssignment_1_0() { return cScenarioAssignment_1_0; }
		
		//GOOD_CHARS_NO_COLON
		public RuleCall getScenarioGOOD_CHARS_NO_COLONTerminalRuleCall_1_0_0() { return cScenarioGOOD_CHARS_NO_COLONTerminalRuleCall_1_0_0; }
		
		//':'
		public Keyword getColonKeyword_1_1() { return cColonKeyword_1_1; }
		
		//block=GOOD_CHARS_NO_COLON
		public Assignment getBlockAssignment_2() { return cBlockAssignment_2; }
		
		//GOOD_CHARS_NO_COLON
		public RuleCall getBlockGOOD_CHARS_NO_COLONTerminalRuleCall_2_0() { return cBlockGOOD_CHARS_NO_COLONTerminalRuleCall_2_0; }
		
		//';'
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}
	public class PathElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.Path");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cAlternatives.eContents().get(0);
		private final RuleCall cGOOD_CHARS_NO_COLONTerminalRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final Keyword cColonKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final RuleCall cSTRINGTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//// or a word or a string (with spaces in it)
		//Path:
		//	(GOOD_CHARS_NO_COLON | ':')+ | STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//(GOOD_CHARS_NO_COLON | ':')+ | STRING
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//(GOOD_CHARS_NO_COLON | ':')+
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//GOOD_CHARS_NO_COLON
		public RuleCall getGOOD_CHARS_NO_COLONTerminalRuleCall_0_0() { return cGOOD_CHARS_NO_COLONTerminalRuleCall_0_0; }
		
		//':'
		public Keyword getColonKeyword_0_1() { return cColonKeyword_0_1; }
		
		//STRING
		public RuleCall getSTRINGTerminalRuleCall_1() { return cSTRINGTerminalRuleCall_1; }
	}
	public class SentenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.sentence");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cGOOD_CHARS_NO_COLONTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cSTRINGTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//// a sequence of char string terminated by ; or by : semicolon
		//// it can be also a string like "even"
		//// it can be found also assignments in case of exec, like c:=y
		//// it can be f( "pippo" ) = "jjj"
		//sentence:
		//	(GOOD_CHARS_NO_COLON | STRING)+;
		@Override public ParserRule getRule() { return rule; }
		
		//(GOOD_CHARS_NO_COLON | STRING)+
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//GOOD_CHARS_NO_COLON
		public RuleCall getGOOD_CHARS_NO_COLONTerminalRuleCall_0() { return cGOOD_CHARS_NO_COLONTerminalRuleCall_0; }
		
		//STRING
		public RuleCall getSTRINGTerminalRuleCall_1() { return cSTRINGTerminalRuleCall_1; }
	}
	public class SentencePlusAssignElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.sentencePlusAssign");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cGOOD_CHARS_NO_COLONTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cColonEqualsSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final RuleCall cSTRINGTerminalRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//sentencePlusAssign:
		//	(GOOD_CHARS_NO_COLON | ':=' | STRING)+;
		@Override public ParserRule getRule() { return rule; }
		
		//(GOOD_CHARS_NO_COLON | ':=' | STRING)+
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//GOOD_CHARS_NO_COLON
		public RuleCall getGOOD_CHARS_NO_COLONTerminalRuleCall_0() { return cGOOD_CHARS_NO_COLONTerminalRuleCall_0; }
		
		//':='
		public Keyword getColonEqualsSignKeyword_1() { return cColonEqualsSignKeyword_1; }
		
		//STRING
		public RuleCall getSTRINGTerminalRuleCall_2() { return cSTRINGTerminalRuleCall_2; }
	}
	
	
	private final ScenarioElements pScenario;
	private final InvariantElements pInvariant;
	private final ElementElements pElement;
	private final CommandElements pCommand;
	private final CheckElements pCheck;
	private final SetElements pSet;
	private final StepElements pStep;
	private final StepUntilElements pStepUntil;
	private final ExecElements pExec;
	private final BlockElements pBlock;
	private final ExecBlockElements pExecBlock;
	private final PathElements pPath;
	private final TerminalRule tSTRING;
	private final TerminalRule tML_COMMENT;
	private final TerminalRule tSL_COMMENT;
	private final TerminalRule tWS;
	private final SentenceElements pSentence;
	private final SentencePlusAssignElements pSentencePlusAssign;
	private final TerminalRule tGOOD_CHAR_NO_COLON;
	private final TerminalRule tGOOD_CHARS_NO_COLON;
	
	private final Grammar grammar;

	@Inject
	public AvallaGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pScenario = new ScenarioElements();
		this.pInvariant = new InvariantElements();
		this.pElement = new ElementElements();
		this.pCommand = new CommandElements();
		this.pCheck = new CheckElements();
		this.pSet = new SetElements();
		this.pStep = new StepElements();
		this.pStepUntil = new StepUntilElements();
		this.pExec = new ExecElements();
		this.pBlock = new BlockElements();
		this.pExecBlock = new ExecBlockElements();
		this.pPath = new PathElements();
		this.tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.STRING");
		this.tML_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.ML_COMMENT");
		this.tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.SL_COMMENT");
		this.tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.WS");
		this.pSentence = new SentenceElements();
		this.pSentencePlusAssign = new SentencePlusAssignElements();
		this.tGOOD_CHAR_NO_COLON = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.GOOD_CHAR_NO_COLON");
		this.tGOOD_CHARS_NO_COLON = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.asmeta.avallaxt.Avalla.GOOD_CHARS_NO_COLON");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.asmeta.avallaxt.Avalla".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	
	//// PROVIAMO METODO BARBARICO
	//Scenario:
	//	'scenario' name=GOOD_CHARS_NO_COLON
	//	'load' spec=Path
	//	invariants+=Invariant*
	//	elements+=Element*;
	public ScenarioElements getScenarioAccess() {
		return pScenario;
	}
	
	public ParserRule getScenarioRule() {
		return getScenarioAccess().getRule();
	}
	
	//Invariant:
	//	'invariant' name=GOOD_CHARS_NO_COLON ':' expression=sentence ";";
	public InvariantElements getInvariantAccess() {
		return pInvariant;
	}
	
	public ParserRule getInvariantRule() {
		return getInvariantAccess().getRule();
	}
	
	//Element:
	//	Command | Block;
	public ElementElements getElementAccess() {
		return pElement;
	}
	
	public ParserRule getElementRule() {
		return getElementAccess().getRule();
	}
	
	//Command:
	//	Check | Set | {Step} Step | StepUntil | Exec | ExecBlock;
	public CommandElements getCommandAccess() {
		return pCommand;
	}
	
	public ParserRule getCommandRule() {
		return getCommandAccess().getRule();
	}
	
	//Check:
	//	'check' expression=sentence ";";
	public CheckElements getCheckAccess() {
		return pCheck;
	}
	
	public ParserRule getCheckRule() {
		return getCheckAccess().getRule();
	}
	
	//Set:
	//	'set' location=sentence ':=' value=sentence ";";
	public SetElements getSetAccess() {
		return pSet;
	}
	
	public ParserRule getSetRule() {
		return getSetAccess().getRule();
	}
	
	//Step:
	//	'step';
	public StepElements getStepAccess() {
		return pStep;
	}
	
	public ParserRule getStepRule() {
		return getStepAccess().getRule();
	}
	
	//StepUntil:
	//	'step' 'until' expression=sentence ";";
	public StepUntilElements getStepUntilAccess() {
		return pStepUntil;
	}
	
	public ParserRule getStepUntilRule() {
		return getStepUntilAccess().getRule();
	}
	
	//Exec:
	//	'exec' rule=sentencePlusAssign ";";
	public ExecElements getExecAccess() {
		return pExec;
	}
	
	public ParserRule getExecRule() {
		return getExecAccess().getRule();
	}
	
	//Block:
	//	'begin' name=GOOD_CHARS_NO_COLON
	//	elements+=Element*
	//	'end';
	public BlockElements getBlockAccess() {
		return pBlock;
	}
	
	public ParserRule getBlockRule() {
		return getBlockAccess().getRule();
	}
	
	//// example sc:bl -> search block bl in the scenario sc
	//// a block bl2 can be defined inside another block bll
	//// begin bl1
	////    begin bl2
	////    end 
	//// end
	//// we refer to bl2 only with bl2 (NOT bl1:bl2)
	//// example scanrio:block -> search block in the scenario
	//// if a block is inside the same scenario, scenario can be skipped 
	//ExecBlock:
	//	'execblock' (scenario=GOOD_CHARS_NO_COLON ':')? block=GOOD_CHARS_NO_COLON ';';
	public ExecBlockElements getExecBlockAccess() {
		return pExecBlock;
	}
	
	public ParserRule getExecBlockRule() {
		return getExecBlockAccess().getRule();
	}
	
	//// or a word or a string (with spaces in it)
	//Path:
	//	(GOOD_CHARS_NO_COLON | ':')+ | STRING;
	public PathElements getPathAccess() {
		return pPath;
	}
	
	public ParserRule getPathRule() {
		return getPathAccess().getRule();
	}
	
	//terminal STRING:
	//	'"' !'"'* '"';
	public TerminalRule getSTRINGRule() {
		return tSTRING;
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return tML_COMMENT;
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return tSL_COMMENT;
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return tWS;
	}
	
	//// a sequence of char string terminated by ; or by : semicolon
	//// it can be also a string like "even"
	//// it can be found also assignments in case of exec, like c:=y
	//// it can be f( "pippo" ) = "jjj"
	//sentence:
	//	(GOOD_CHARS_NO_COLON | STRING)+;
	public SentenceElements getSentenceAccess() {
		return pSentence;
	}
	
	public ParserRule getSentenceRule() {
		return getSentenceAccess().getRule();
	}
	
	//sentencePlusAssign:
	//	(GOOD_CHARS_NO_COLON | ':=' | STRING)+;
	public SentencePlusAssignElements getSentencePlusAssignAccess() {
		return pSentencePlusAssign;
	}
	
	public ParserRule getSentencePlusAssignRule() {
		return getSentencePlusAssignAccess().getRule();
	}
	
	//terminal GOOD_CHAR_NO_COLON:
	//	'\\u0021'..'\\u0039' // da ! (0021) - spazio escluso a 9 (0039) // skip ':' ';'
	//	| '\\u003C'..'\\u007E' // da < a ~
	//;
	public TerminalRule getGOOD_CHAR_NO_COLONRule() {
		return tGOOD_CHAR_NO_COLON;
	}
	
	//terminal GOOD_CHARS_NO_COLON:
	//	GOOD_CHAR_NO_COLON+;
	public TerminalRule getGOOD_CHARS_NO_COLONRule() {
		return tGOOD_CHARS_NO_COLON;
	}
}