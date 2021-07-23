package org.asmeta.asm2code.main;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.asmeta.asm2code.main.CppGenerator;
import org.asmeta.asm2code.main.HeaderGenerator;
import org.asmeta.asm2code.main.TranslatorOptions.CompilerType;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.asmeta.asm2code.compiler.CompileResult;
import org.asmeta.asm2code.compiler.CppCompiler;
import org.asmeta.parser.ASMParser;
import org.junit.Test;

import asmeta.AsmCollection;

// to test with MVM 
public class GeneratorCompilerTestMVM extends GeneratorCompilerTest2 {

	
	@Test
	public void testTimer() throws IOException, Exception {
		TranslatorOptions options= new TranslatorOptions(false, true, true, true);
		Logger.getLogger(CppCompiler.class).setLevel(Level.ALL);
		
		//options.compilerType = CompilerType.DesktopCompiler;
		options.compilerType = CompilerType.ArduinoCompiler;
		CppCompiler.setCompiler("g++");
		String asmspec = "..\\..\\..\\..\\..\\mvm-asmeta\\VentilatoreASM_NewTime\\TimeLibrary.asm";
		if (!test(asmspec,options).success)
			fail();
	}

	
	@Test
	public void testMVM() throws IOException, Exception {
		TranslatorOptions options= new TranslatorOptions(false, true, true, true);
		Logger.getLogger(CppCompiler.class).setLevel(Level.ALL);
		
		//options.compilerType = CompilerType.DesktopCompiler;
		options.compilerType = CompilerType.ArduinoCompiler;
		CppCompiler.setCompiler("g++");
		String asmspec = "..\\..\\..\\..\\..\\mvm-asmeta\\VentilatoreASM_NewTime\\Ventilatore3.asm";
		if (!test(asmspec,options).success)
			fail();
	}
	
	@Test
	public void testMVMKP() throws IOException, Exception {
		TranslatorOptions options= new TranslatorOptions(false, true, true, true);
		Logger.getLogger(CppCompiler.class).setLevel(Level.ALL);
		
		//options.compilerType = CompilerType.DesktopCompiler;
		options.compilerType = CompilerType.ArduinoCompiler;
		CppCompiler.setCompiler("g++");
		String asmspec = "..\\..\\..\\..\\..\\mvm-asmeta\\VentilatoreASM_NewTime\\Ventilatore3KP.asm";
		if (!test(asmspec,options).success)
			fail();
	}
	
	@Test
	public void testMVMAppFM() throws IOException, Exception {
		TranslatorOptions options= new TranslatorOptions(false, true, true, true);
		Logger.getLogger(CppCompiler.class).setLevel(Level.ALL);
		
		//options.compilerType = CompilerType.DesktopCompiler;
		options.compilerType = CompilerType.ArduinoCompiler;
		CppCompiler.setCompiler("g++");
		String asmspec = "..\\..\\..\\..\\..\\mvm-asmeta\\asm_models\\MVM APPFM\\Arduino\\MVMcontroller04SingleButton.asm";
		if (!test(asmspec,options).success)
			fail();
	}
	
	@Test
	public void testMVMAppFM2() throws IOException, Exception {
		TranslatorOptions options= new TranslatorOptions(false, true, true, true);
		Logger.getLogger(CppCompiler.class).setLevel(Level.ALL);
		
		options.compilerType = CompilerType.DesktopCompiler;
		//options.compilerType = CompilerType.ArduinoCompiler;
		CppCompiler.setCompiler("g++");
		String asmspec = "..\\..\\..\\..\\..\\mvm-asmeta\\asm_models\\MVM APPFM\\MVMcontroller03.asm";
		if (!test(asmspec,options).success)
			fail();
	}
	
	@Test
	public void testTimerAppFM() throws IOException, Exception {
		TranslatorOptions options= new TranslatorOptions(false, true, true, true);
		Logger.getLogger(CppCompiler.class).setLevel(Level.ALL);
		
		//options.compilerType = CompilerType.DesktopCompiler;
		options.compilerType = CompilerType.ArduinoCompiler;
		CppCompiler.setCompiler("g++");
		String asmspec = "..\\..\\..\\..\\..\\mvm-asmeta\\asm_models\\MVM APPFM\\Arduino\\TimeLibrary.asm";
		if (!test(asmspec,options).success)
			fail();
	}
	
	@Test
	public void testTimerAppFM2() throws IOException, Exception {
		TranslatorOptions options= new TranslatorOptions(false, true, true, true);
		Logger.getLogger(CppCompiler.class).setLevel(Level.ALL);
		
		options.compilerType = CompilerType.DesktopCompiler;
		//options.compilerType = CompilerType.ArduinoCompiler;
		CppCompiler.setCompiler("g++");
		String asmspec = "..\\..\\..\\..\\..\\mvm-asmeta\\asm_models\\MVM APPFM\\TimeLibrary.asm";
		if (!test(asmspec,options).success)
			fail();
	}
}
