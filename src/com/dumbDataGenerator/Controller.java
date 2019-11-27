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
	
	public Controller(View view, ReadCSV read, WriteCSV write) {
		this.view = view;
		this.read = read;
		this.write = write;
		this.view.generateButtonListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		originalFieldText = view.getOriginalFieldText();
		dummyFieldText = view.getDummyFieldText();
		write.writeCSV(dummyFieldText, getOriginalData());
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
