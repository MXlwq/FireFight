package com.wsy.dao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.wsy.iframe.*;

import org.jfree.ui.RefineryUtilities;

public class Read {
	/**
	 * 功能：Java读取txt文件的内容 步骤：1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	 * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
	 * 
	 * @param filePath
	 */
	public static float[] S = new float[20];

	public static void readTxtFile(String filePath) {
		try {

			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;

				int j = 1;
				while (j < 20) {
					lineTxt = bufferedReader.readLine();
					if (lineTxt != null) {

						float f = Float.parseFloat(lineTxt);
						if (f == S[0]) {
							lineTxt = bufferedReader.readLine();
							String lineTxt2 = bufferedReader.readLine();
							S[j] = Float.parseFloat(lineTxt);
							System.out.println("S[j]=========="+S[j]);
							S[++j] = Float.parseFloat(lineTxt2);
							System.out.println("S[++j]=========="+S[j]);
							j++;
						} 
						else{
							bufferedReader.readLine();
							bufferedReader.readLine();
						}
							
					} 
					else{
						S[j] = 0;
						j++;
					}
				}
				read.close();
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

	}

}