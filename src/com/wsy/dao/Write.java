package com.wsy.dao;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import com.wsy.iframe.*;

public class Write {
	String data = null;

	public void write() {
		data += "\r\n";
		try {
			File file = new File("javaio-appendfile.txt");
			
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			} 

			// true = append file
			FileWriter fileWritter = new FileWriter(file.getName(), true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(data);
			bufferWritter.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}