/*
 * generated by Xtext 2.17.0
 */
package org.asmeta.avallaxt.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.asmeta.avallaxt.ide.contentassist.antlr.internal.InternalAvallaParser;
import org.asmeta.avallaxt.services.AvallaGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class AvallaParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(AvallaGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, AvallaGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getElementAccess().getAlternatives(), "rule__Element__Alternatives");
			builder.put(grammarAccess.getCommandAccess().getAlternatives(), "rule__Command__Alternatives");
			builder.put(grammarAccess.getPathAccess().getAlternatives(), "rule__Path__Alternatives");
			builder.put(grammarAccess.getPathAccess().getAlternatives_0(), "rule__Path__Alternatives_0");
			builder.put(grammarAccess.getSentenceAccess().getAlternatives(), "rule__Sentence__Alternatives");
			builder.put(grammarAccess.getSentencePlusAssignAccess().getAlternatives(), "rule__SentencePlusAssign__Alternatives");
			builder.put(grammarAccess.getScenarioAccess().getGroup(), "rule__Scenario__Group__0");
			builder.put(grammarAccess.getInvariantAccess().getGroup(), "rule__Invariant__Group__0");
			builder.put(grammarAccess.getCommandAccess().getGroup_2(), "rule__Command__Group_2__0");
			builder.put(grammarAccess.getCheckAccess().getGroup(), "rule__Check__Group__0");
			builder.put(grammarAccess.getSetAccess().getGroup(), "rule__Set__Group__0");
			builder.put(grammarAccess.getStepUntilAccess().getGroup(), "rule__StepUntil__Group__0");
			builder.put(grammarAccess.getExecAccess().getGroup(), "rule__Exec__Group__0");
			builder.put(grammarAccess.getBlockAccess().getGroup(), "rule__Block__Group__0");
			builder.put(grammarAccess.getExecBlockAccess().getGroup(), "rule__ExecBlock__Group__0");
			builder.put(grammarAccess.getExecBlockAccess().getGroup_1(), "rule__ExecBlock__Group_1__0");
			builder.put(grammarAccess.getScenarioAccess().getNameAssignment_1(), "rule__Scenario__NameAssignment_1");
			builder.put(grammarAccess.getScenarioAccess().getSpecAssignment_3(), "rule__Scenario__SpecAssignment_3");
			builder.put(grammarAccess.getScenarioAccess().getInvariantsAssignment_4(), "rule__Scenario__InvariantsAssignment_4");
			builder.put(grammarAccess.getScenarioAccess().getElementsAssignment_5(), "rule__Scenario__ElementsAssignment_5");
			builder.put(grammarAccess.getInvariantAccess().getNameAssignment_1(), "rule__Invariant__NameAssignment_1");
			builder.put(grammarAccess.getInvariantAccess().getExpressionAssignment_3(), "rule__Invariant__ExpressionAssignment_3");
			builder.put(grammarAccess.getCheckAccess().getExpressionAssignment_1(), "rule__Check__ExpressionAssignment_1");
			builder.put(grammarAccess.getSetAccess().getLocationAssignment_1(), "rule__Set__LocationAssignment_1");
			builder.put(grammarAccess.getSetAccess().getValueAssignment_3(), "rule__Set__ValueAssignment_3");
			builder.put(grammarAccess.getStepUntilAccess().getExpressionAssignment_2(), "rule__StepUntil__ExpressionAssignment_2");
			builder.put(grammarAccess.getExecAccess().getRuleAssignment_1(), "rule__Exec__RuleAssignment_1");
			builder.put(grammarAccess.getBlockAccess().getNameAssignment_1(), "rule__Block__NameAssignment_1");
			builder.put(grammarAccess.getBlockAccess().getElementsAssignment_2(), "rule__Block__ElementsAssignment_2");
			builder.put(grammarAccess.getExecBlockAccess().getScenarioAssignment_1_0(), "rule__ExecBlock__ScenarioAssignment_1_0");
			builder.put(grammarAccess.getExecBlockAccess().getBlockAssignment_2(), "rule__ExecBlock__BlockAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private AvallaGrammarAccess grammarAccess;

	@Override
	protected InternalAvallaParser createParser() {
		InternalAvallaParser result = new InternalAvallaParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public AvallaGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(AvallaGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}