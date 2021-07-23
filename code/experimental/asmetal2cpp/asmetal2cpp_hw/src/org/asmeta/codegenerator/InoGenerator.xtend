package org.asmeta.codegenerator

import org.asmeta.codegenerator.configuration.HWConfiguration
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import asmeta.structure.Asm
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Arrays
import java.nio.charset.StandardCharsets
import org.asmeta.codegenerator.configuration.LCD

class InoGenerator implements IGenerator {
	public static String Ext = ".ino"
	SetupFunctionCreator setup
	public HWConfiguration config

	new(HWConfiguration config) {
		this.config = config
		setup = new org.asmeta.codegenerator.SetupFunctionCreator(config)
	}

	def generate(Asm model, String path) {
		Files.write(Paths.get(path), compile(model).getBytes())
	}

	def String compile(Asm asm) {
		val asmName = asm.name
		val asmInstance = asmName.toFirstLower

		return '''
			#include"«asmName».h"
			«getLcdDeclaration(config.lcd)»
			«setup.getSetupFunction(asm)»
			
			«asmName» «asmInstance»;
						
			void loop(){
			  «IF (config.stepTime > 0)»
			  	long cicleStart = millis();
			  «ENDIF»
			  «asmInstance».getInputs();
			  «asmInstance».«asm.mainrule.name»();
			  «asmInstance».setOutputs();
			  «asmInstance».fireUpdateSet();
			  «IF (config.stepTime > 0)»
			  	delay(«config.stepTime»-(millis()-cicleStart));
			  «ENDIF»
			}
			
		'''
	}
	
	def String getLcdDeclaration(LCD lcd)
	{
		var StringBuffer sb = new StringBuffer
		
		if (lcd !== null)
		{
			if (lcd.isi2c)
			{
				sb.append(System.lineSeparator)
				sb.append('''LiquidCrystal_I2C «config.lcd.name»(«config.lcd.address.toString», «config.lcd.numberofcolumns», «config.lcd.numberofrows»);''')
				sb.append(System.lineSeparator)
				sb.append(System.lineSeparator)
			}
			else
			{
				sb.append(System.lineSeparator)
				
				if (config.lcd.rw === null)
					// a seconda dei pin utilizzati per la LiquidCrystal imposto il costruttore adatto, i pin totali possono essere 6 (o 7 con rw opzionale) 10 (o 11 con rw opzionale)
					/*
					 * rs: Register Select  indica il tipo di comando che inviamo
					 * rw: indica all’lcd se deve scrivere o leggere – 0 scrivi 1 leggi
					 * enable: per abilitare la scrittura nei registri
					 * pin0-pin7: linee dei dati collegati ai pin dell'arduino
					 */
					if (config.lcd.pin0 === null && config.lcd.pin1=== null && config.lcd.pin2 === null && config.lcd.pin3 === null)
						sb.append('''LiquidCrystal «config.lcd.name»(«Util.arduinoPinToString(config.lcd.rs)», «Util.arduinoPinToString(config.lcd.enable)», «Util.arduinoPinToString(config.lcd.pin4)», «Util.arduinoPinToString(config.lcd.pin5)», «Util.arduinoPinToString(config.lcd.pin6)», «Util.arduinoPinToString(config.lcd.pin7)»);''')
					else
						sb.append('''LiquidCrystal «config.lcd.name»(«Util.arduinoPinToString(config.lcd.rs)», «Util.arduinoPinToString(config.lcd.enable)», «Util.arduinoPinToString(config.lcd.pin0)», «Util.arduinoPinToString(config.lcd.pin1)», «Util.arduinoPinToString(config.lcd.pin2)», «Util.arduinoPinToString(config.lcd.pin3)», «Util.arduinoPinToString(config.lcd.pin4)», «Util.arduinoPinToString(config.lcd.pin5)», «Util.arduinoPinToString(config.lcd.pin6)», «Util.arduinoPinToString(config.lcd.pin7)»);''')
					
				else
					if (config.lcd.pin0 === null && config.lcd.pin1=== null && config.lcd.pin2 === null && config.lcd.pin3 === null)
						sb.append('''LiquidCrystal «config.lcd.name»(«Util.arduinoPinToString(config.lcd.rs)», «Util.arduinoPinToString(config.lcd.rw)», «Util.arduinoPinToString(config.lcd.enable)», «Util.arduinoPinToString(config.lcd.pin4)», «Util.arduinoPinToString(config.lcd.pin5)», «Util.arduinoPinToString(config.lcd.pin6)», «Util.arduinoPinToString(config.lcd.pin7)»);''')
					else
						sb.append('''LiquidCrystal «config.lcd.name»(«Util.arduinoPinToString(config.lcd.rs)», «Util.arduinoPinToString(config.lcd.rw)»,«Util.arduinoPinToString(config.lcd.enable)», «Util.arduinoPinToString(config.lcd.pin0)», «Util.arduinoPinToString(config.lcd.pin1)», «Util.arduinoPinToString(config.lcd.pin2)», «Util.arduinoPinToString(config.lcd.pin3)», «Util.arduinoPinToString(config.lcd.pin4)», «Util.arduinoPinToString(config.lcd.pin5)», «Util.arduinoPinToString(config.lcd.pin6)», «Util.arduinoPinToString(config.lcd.pin7)»);''')
												
				sb.append(System.lineSeparator)
				sb.append(System.lineSeparator)
			}
		}	

		return sb.toString
	}
	
	override doGenerate(Resource input, IFileSystemAccess fsa) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
