package org.asmeta.asm2junit.formatter;

public class Formatter {

	public static String formatCode(String source ) {
		/*CodeFormatter codeFormatter = org.eclipse.cdt.core.ToolFactory.createDefaultCodeFormatter(null);
		TextEdit edit = codeFormatter.format(0, source, 0, source.length(), 0, null);
		IDocument document = new Document(source); 
		try {
			edit.apply(document);
		} catch (MalformedTreeException e) {
			System.err.println("error " + e.getMessage());
			return source;
		} catch (BadLocationException e) {
			System.err.println("error " + e.getMessage());
			return source;
		}
		String formattedSource = document.get();
		return formattedSource;*/
		return source;
	}
}
