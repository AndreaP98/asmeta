package org.asmeta.runtime_commander;

import java.util.List;
import java.util.Map;

import org.asmeta.runtime_container.InvariantData;
import org.asmeta.runtime_container.RunOutput;

/**
 * @author Federico Rebucini
 */
public class CommanderOutput {
	private CommanderStatus status; // gives out how this result should be interpreted
	private int num; // integer result
	private RunOutput ro; // run output result
	private InvariantData invl; // invariant data result
	private boolean success; // result of add/update/remove operations on invariants
	private String errorMessage;
	private Map<Integer, String> loadids;
	
	public CommanderOutput(CommanderStatus status, int num) {
		this(status,num,null,null,false,null,null);
	}
	
	public CommanderOutput(CommanderStatus status, Map<Integer, String> loadids) {
		this(status,0,null,null,false,null,loadids);
	}
	
	public CommanderOutput(CommanderStatus status, InvariantData invl) {
		this(status,0,null,invl,false,null,null);
	}
	
	public CommanderOutput(CommanderStatus status, RunOutput ro) {
		this(status,0,ro,null,false,null,null);
	}
	public CommanderOutput(CommanderStatus status, String errorMessage) {
		this(status,0,null,null,false,errorMessage,null);
	}
	
	public CommanderOutput(CommanderStatus status, boolean success) {
		this(status,0,null,null,success,null,null);
	}
	
	public CommanderOutput(CommanderStatus status, int num, RunOutput ro, InvariantData invl, boolean success, String errorMessage, Map<Integer, String> loadids) {
		this.ro=ro;
		this.num=num;
		this.status=status;
		this.invl=invl;
		this.success=success;
		this.errorMessage=errorMessage;
		this.loadids=loadids;
	}
	
	public RunOutput getRunOutput() throws CommanderException{
		if (status!=CommanderStatus.RUNOUTPUT)
			throw new CommanderException("Parser output type not correct", status);
		return ro;
	}
	public int getStop() throws CommanderException{
		if (status!=CommanderStatus.STOP)
			throw new CommanderException("Parser output type not correct", status);
		return num;
	}
	public int getInstances() throws CommanderException{
		if (status!=CommanderStatus.INSTANCES)
			throw new CommanderException("Parser output type not correct", status);
		return num;
	}
	public int getID() throws CommanderException{
		if (status!=CommanderStatus.SIM_ID)
			throw new CommanderException("Parser output type not correct", status);
		return num;
	}
	public InvariantData getInvList() throws CommanderException{
		if (status!=CommanderStatus.VIEWINV)
			throw new CommanderException("Parser output type not correct", status);
		return invl;
	}
	public boolean getSuccess() throws CommanderException{
		if (status!=CommanderStatus.BOOLRES)
			throw new CommanderException("Parser output type not correct", status);
		return success;
	}
	public String getErrorMessage() throws CommanderException{
		if (status!=CommanderStatus.FAILURE)
			throw new CommanderException("Parser output type not correct", status);
		return errorMessage;
	}
	public Map<Integer, String> getLoadedIDs() throws CommanderException{
		if (status!=CommanderStatus.LOADED_IDS)
			throw new CommanderException("Parser output type not correct", status);
		return loadids;
	}
	public CommanderStatus getStatus() {
		return status;
	}
}
