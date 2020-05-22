package org.asmeta.runtime_container;

import java.io.Serializable;
import java.util.Map;

import org.asmeta.animator.MyState;
import org.asmeta.simulator.Location;
import org.asmeta.simulator.value.Value;

// TODO: Auto-generated Javadoc
/**
 * The Class RunOutput.
 */
public class RunOutput implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The model state. */
	private MyState ms = null; 
	
	/** The location value. */
	@SuppressWarnings("rawtypes")
	private Map<Location, Value> locationValue = null; //Monitored map
	
	/** The outcome of a simulation run/step: SAFE (default value) or UNSAFE. */
	private Esit esit = Esit.SAFE; 
	
	/** The test. */
	private String message = "";
	
	/** Flag to check if the run has finished */
	private boolean timeoutFlag = false;
	
	/**
	 * Instantiates a new run output.
	 *
	 * @param esit the esit
	 * @param locationValue the location value
	 * @param ms the model state
	 */
	public RunOutput(Esit esit, @SuppressWarnings("rawtypes") Map<Location, Value> locationValue, MyState ms) {
		this.locationValue = locationValue;
		this.esit = esit;
		this.ms = ms;
		
	}
	

	/**
	 * Instantiates a new run output.
	 *
	 * @param esit the esit
	 * @param test the test
	 */
	public RunOutput(Esit esit, String message) {
		this.esit = esit;
		this.message = message;
	
	}
	
	/**
	 * Instantiates a new run output.
	 *
	 * @param esit the esit
	 * @param ms the model state
	 */
	
	public RunOutput(Esit esit, MyState ms) {
		this.esit = esit;
		this.ms = ms;
	}

	/** Changes the timeout flag value */
	public void setResult(boolean result) {
		timeoutFlag = result;
	}

	/** Shows the timeout flag value */
	public boolean getResult() {
		return timeoutFlag;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("The Esit of the running is: " + esit + "\n");
		sb.append("Reason: " + message + "\n");
		return sb.toString();
	}
	

	//JUST IN USE FOR TESTING
	public String MytoString() {
		StringBuilder sb = new StringBuilder();
		sb.append("The esit of the running is: " + esit + "\n");
		sb.append("The monitored is: " + locationValue + "\n");
		sb.append("The new state is: " + ms.getControlledValues());
		return sb.toString();
	}


	@Override
	public boolean equals(Object obj) {
		    
        if (obj == this) { 
            return true; 
        } 
  
      
        if (!(obj instanceof RunOutput)) { 
            return false; 
        } 
          
        
        RunOutput c = (RunOutput) obj; 
          
       
        return this.esit == c.esit;
	}
	
	public boolean equalsMessage(Object obj) {
        return equals(obj) && this.message == ((RunOutput)obj).message;
	}
	

}