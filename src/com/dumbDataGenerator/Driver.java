package com.dumbDataGenerator;

import java.io.FileNotFoundException;
import java.util.*;

public class Driver {

	public static String testPath = "Test.csv";
	public static String slotsPath = "C:\\Users\\carrilloc.YGA\\Desktop\\BCSlotAnalyticsReport.csv";
	public static void main(String[] args) {

        
        
		View view = new View();
		ReadCSV reader = new ReadCSV();
		WriteCSV writer = new WriteCSV();
		Shifter shifter = new Shifter();
		Controller controller = new Controller(view, reader, writer, shifter);
    }
}
