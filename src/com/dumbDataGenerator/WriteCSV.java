package com.dumbDataGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteCSV {
	
	public void writeCSV(String outputPath, List<List<String>> inputData) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(outputPath));
			
			//inputDa
			
			for (List<String> l : inputData) {
				for (String s : l) {
					pw.print(s);
					pw.print(",");
				}
				pw.println();
				
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
