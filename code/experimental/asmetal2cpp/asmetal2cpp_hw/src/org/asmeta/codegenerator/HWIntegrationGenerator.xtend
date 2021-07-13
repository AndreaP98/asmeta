package org.asmeta.codegenerator

import asmeta.structure.Asm
import java.nio.file.Files
import java.nio.file.Paths
import org.asmeta.codegenerator.configuration.HWConfiguration
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import java.util.List
import java.io.File
import java.io.FileNotFoundException
import org.asmeta.parser.ASMParser
import asmeta.AsmCollection
import asmeta.definitions.MonitoredFunction
import java.util.Iterator
import org.asmeta.asm2code.main.TranslatorOptions

/**
 * This class generates the cpp file reading inputs and setting outputs
 * format: <filename>_hw.cpp
 */
class HWIntegrationGenerator implements IGenerator {
	public static String Ext = "_hw.cpp"
	InputFunctionCreator input
	OutputFunctionCreator output
	HWConfiguration config
	String inputResult 
	String outputResult 
	TranslatorOptions options

	new(HWConfiguration config) {
		this(config, new TranslatorOptions(true, true, true, true))
		
	}

	new(HWConfiguration config, TranslatorOptions options) {
		this.config = config
		this.options = options
		input = new InputFunctionCreator(config)
		output = new OutputFunctionCreator(config, this.options)
		inputResult = ""
		outputResult = ""
	}

	def void setHWConfiguration(HWConfiguration config) {
		this.config = config
	}

	def generate(Asm model, String path) {
		Files.write(Paths.get(path), compile(model).getBytes())
		
	}
	
	def generate(AsmCollection asmCol,String path){
		Files.write(Paths.get(path), compileCollection(asmCol).getBytes())
	}
	 
	def String compile(Asm asm) {
		return '''
			#include "�asm.name�.h"
			
			bool firstStep = true;
			
			�externalLCD�
			
			void �asm.name�::getInputs(){
				�input.getInputFunction(asm, options)�
			}
								
			void �asm.name�::setOutputs(){
				�output.getOutputFunction(asm)�
				if (firstStep) firstStep = false;
			}
		'''
	}

	def String compileCollection(AsmCollection asmCol){
		getInputOutputFunction(asmCol)
		var StringBuffer sb = new StringBuffer
		
		sb.append('''
			#include "�asmCol.main.name�.h"
			bool firstStep = true;
			''')
			
		if (options.useLCD) /*TODO controlla options */
			sb.append(''' �externalLCD� ''')
			
		if (options.useMillis) {
			sb.append('''
				long startTime = millis();
			''')
			}
		sb.append('''
			void �asmCol.main.name�::getInputs(){
				�inputResult�
			}
								
			void �asmCol.main.name�::setOutputs(){
				�outputResult�
				if (firstStep) firstStep = false;
			}
		''')
		
		return sb.toString();
		
	}
	
	def getInputOutputFunction(AsmCollection asmCol){
		var String ir = ""
		var String or = ""
		inputResult += input.getInputFunction(asmCol.main, options)
		outputResult += output.getOutputFunction(asmCol.main)
		for(a : asmCol){
			if(!a.name.contains("StandardLibrary")){
			ir = input.getInputFunction(a, options)
			if(!inputResult.contains(ir)) inputResult += ir
			or = output.getOutputFunction(a)
			if(!outputResult.contains(or)) outputResult += or
			}
		}
		}
	
	def externalLCD() {
		if (config.lcd !== null)
		{
			if (config.lcd.isi2c)
			{
				return '''
					extern LiquidCrystal_I2C �config.lcd.name�;
				'''
			}
			else
			{
				return '''
					extern LiquidCrystal �config.lcd.name�;
				'''
			}
		}
	}
	
	override doGenerate(Resource input, IFileSystemAccess fsa) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
