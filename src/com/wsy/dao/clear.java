package com.wsy.dao;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class clear {
	public void cl() {
		File file = new File("javaio-appendfile.txt");
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write("");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String argv[]) {
		clear c1 = new clear();
		c1.cl();
	}

}
