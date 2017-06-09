package filesReadAndWrite;

import android.content.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import hilfsklassen.Logger;

public class WriteAndReadFileUtil {
	public static int writeStringToFile(String settingsFileName, String inhalt, Context context) {
        // Logger.log(Logger.info, "WriteAndReadFileUtil.writeStringToFile: ", WriteAndReadFileUtil.class);

		String filePath = "";
		if(context!=null) filePath = context.getFilesDir().getPath().toString() + settingsFileName;
		else filePath = settingsFileName;

		File file = null;
		try {
			file = new File(filePath);
			//file = new File(settingsFileName);
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(inhalt);
			bw.close();
		} catch (IOException e){
			Logger.log(Logger.severe, "Error: File could not be written to: " + file.getAbsoluteFile(), WriteAndReadFileUtil.class, e);
			return -1;
		}
        // Logger.log(Logger.info, "Save content: " + inhalt, WriteAndReadFileUtil.class);

		return 0;
	}

	
	public static String readStringFromFile(String settingsFileName, Context context) {
        // Logger.log(Logger.info, "WriteAndReadFileUtil.readStringFromFile: ", WriteAndReadFileUtil.class);
		String text = null;

		String filePath = "";
		if(context!=null) filePath = context.getFilesDir().getPath().toString() + settingsFileName;
		else filePath = settingsFileName;

		try {
			Scanner read = new Scanner(new File(filePath));
			text = read.nextLine();
			read.close();
			
		} catch (FileNotFoundException e){
			Logger.log(Logger.severe, "file not found", WriteAndReadFileUtil.class, e);
			return null;
		}
		// Logger.log(Logger.info, "File Content: " + text, WriteAndReadFileUtil.class);
		return text;
	}
}
