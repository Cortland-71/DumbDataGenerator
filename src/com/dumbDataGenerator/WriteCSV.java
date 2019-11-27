package com.dumbDataGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteCSV {
	
	private static PrintWriter pw;
	
	public void writeCSV(String outputPath, List<List<String>> inputData) {
		try {
			pw = new PrintWriter(new FileWriter(outputPath));
			
			inputData.stream().forEach(e-> {
					e.forEach(l-> {pw.print(l); pw.print(",");}); 
					pw.println();
				});
			
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
