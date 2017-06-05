package com.gitile.chinalife.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtils {
	
	public static void saveStringToFile(String filePath, String fileName, String text) {
		File file=new File(filePath);
		FileWriter fw;
		try {
			if(!file.exists()&&!file.isDirectory()) {
				file.mkdir();
			}
			fw = new FileWriter(filePath+fileName, true);
			BufferedWriter buffw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(buffw);
			pw.println(text);
			pw.close();
			buffw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
