package org.asmeta.nusmv;

import org.asmeta.nusmv.util.Util;

public class ICSA2018 {

	public static void main(String[] args) throws Exception {
		AsmetaSMV as = new AsmetaSMV("examples/ComfortableHeating_ref_MC.asm");
		AsmetaSMVOptions.keepNuSMVfile = true;
		//Class<? extends Flattener>[] oldALL_FLATTENERS = MapVisitor.ALL_FLATTENERS;
		Util.setRunNuSMV(true); //execute the NuSMV model after the mapping
		AsmetaSMVOptions.setPrintCounterExample(true);
		AsmetaSMVOptions.setPrintCounterExample(false);
		Util.setUseNuXmv(false);
		as.translation();
		as.createNuSMVfile();
		Util.setPrintNuSMVoutput(true);
		as.executeNuSMV();
		
	}
}