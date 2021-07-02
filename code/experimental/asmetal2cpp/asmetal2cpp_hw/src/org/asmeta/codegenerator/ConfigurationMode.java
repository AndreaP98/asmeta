package org.asmeta.codegenerator;

import org.asmeta.codegenerator.arduino.ArduinoPinFeature;
import org.eclipse.cdt.core.parser.ParseError;

public enum ConfigurationMode {
	DIGITALIN, DIGITALOUT, DIGITALINVERTEDIN, DIGITALINVERTEDOUT, ANALOGLINEARIN, ANALOGLINEAROUT, PWM, USERDEFINED, SWITCH;
	
	public static ConfigurationMode fromString(String configMode){
		return valueOf(configMode);
		}
	}

