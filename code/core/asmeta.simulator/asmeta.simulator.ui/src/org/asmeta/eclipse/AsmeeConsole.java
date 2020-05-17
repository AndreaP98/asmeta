package org.asmeta.eclipse;

import java.io.IOException;

import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;

/** ASMEE Console*/
public class AsmeeConsole extends IOConsole {
	private static final String CONSOLE_NAME = "ASMEE console";

	public AsmeeConsole() {
		super(CONSOLE_NAME, null);			
	}	

	/** write a simple string message
	 * 
	 * @param s
	 */
	public void writeMessage(String s){
		IOConsoleOutputStream output = newOutputStream();
		try {
			output.write(s + "\n");
			output.flush();
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
