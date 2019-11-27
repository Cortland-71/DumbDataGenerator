package com.dumbDataGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class ReadCSV {

    private String path;

    ReadCSV(String path) {
        this.path = path;
    }

    List<List<String>> readCSV() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        List<String> list = new ArrayList<>();

        while(scanner.hasNext())
            list.add(scanner.nextLine());
        scanner.close();

        return parseRowsIntoLists(list);
    }

    private List<List<String>> parseRowsIntoLists(List<String> dataList) {
        List<List<String>> rowList = new ArrayList<>();

        for (String i : dataList)
            rowList.add(new ArrayList<String>(Arrays.asList(i.split(","))));

        return rowList;
    }
}
