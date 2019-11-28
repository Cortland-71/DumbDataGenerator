package com.dumbDataGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.*;

public class Controller implements ActionListener {
	
	private View view;
	private ReadCSV read;
	private WriteCSV write;
	private String originalFieldText;
	private String dummyFieldText;
	private Shifter shifter;
	private boolean headerSelected;
	private boolean stringSelected;
	private boolean numberSelected;
	
	public Controller(View view, ReadCSV read, WriteCSV write, Shifter shifter) {
		this.view = view;
		this.read = read;
		this.write = write;
		this.shifter = shifter;
		this.view.generateButtonListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		originalFieldText = view.getOriginalFieldText();
		dummyFieldText = view.getDummyFieldText();
		headerSelected = view.getHeaderCheckBoxChecked();
		stringSelected = view.getStringCheckBoxChecked();
		numberSelected = view.getNumbersCheckBoxChecked();
		
		List<List<String>> originalData = getOriginalData();
		originalData.forEach(System.out::println);
		
		List<List<String>> shiftedLists = shifter.getShiftedLists(originalData, 
				Arrays.asList(stringSelected, numberSelected, headerSelected));
		shiftedLists.forEach(System.out::println);
		
		write.writeCSV(dummyFieldText, shiftedLists);
	}
	
	private List<List<String>> getOriginalData() {
		List<List<String>> list = new ArrayList<>();
		try {
			list = read.readCSV(originalFieldText);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

}
