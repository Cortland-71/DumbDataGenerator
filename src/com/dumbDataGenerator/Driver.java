package com.dumbDataGenerator;

import java.io.FileNotFoundException;
import java.util.*;

public class Driver {
	public static void main(String[] args) {

        //String slotsPath = "C:\\Users\\carrilloc.YGA\\Desktop\\BCSlotAnalyticsReport.csv";
        String testPath = "test.csv";

        View view = new View();
        ReadCSV reader = new ReadCSV(testPath);

    }

    private static void getOriginalData(ReadCSV reader) {
        try {
            List<List<String>> rows = reader.readCSV();
            rows.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
