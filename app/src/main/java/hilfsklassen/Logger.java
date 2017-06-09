package hilfsklassen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	
	public final static int severe  = 4;
	public final static int warning = 3;
	public final static int debug   = 2;
	public final static int info    = 1;
	public final static int all     = 0;
	
	private static String[] levelNames = { "all", "info", "debug", "warning", "severe" };
	
	private static int logLevel = info;

	public static final String LOG_FILE_NAME = "logfile.txt";
	private static boolean logFileCreated = false;
	private static boolean fileLoggingPossible = true;
	
	public static void setLogLevel(int level) {
		logLevel = level;
	}

	public static void log(java.lang.Throwable e) {
		log(Logger.severe, "", "", e);
	}
	
	public static void log (int level, String logMessage, Class<?> klasse) {
		log(level, logMessage, klasse.getSimpleName());
	}
	
	public static void log (int level, String logMessage, String className) {
		log(level, logMessage, className, null);
	}
	
	public static void log(int level, String logMessage, Class<?> className, java.lang.Throwable e) {
		log(level, logMessage, className.getSimpleName(), e);
	}
	
	public static void log(int level, String logMessage, String className, java.lang.Throwable e) {
		if(level < 0) return;
		if(level > severe) return;
		if(level < logLevel) return; 
			
		String logLine = "LOGGER(" + levelNames[level] + ")" + "(" + className + ")" + ": " + logMessage;
		System.out.println(logLine);
		if(e != null) e.printStackTrace();

		fileLogging(logLine, e);
	}

	private static void fileLogging(String logLine, java.lang.Throwable e) {
		if(!fileLoggingPossible) return;
		
		if(!logFileCreated) createLogFile();
		
		writeLogFile(logLine, e);
	}

	private static void createLogFile() {
		try {
			FileWriter fw = new FileWriter(LOG_FILE_NAME, false);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw);
		    long yourmilliseconds = System.currentTimeMillis();
		    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");    
		    Date resultdate = new Date(yourmilliseconds);
		    out.println("Logger started: " + sdf.format(resultdate));
		    out.close();
		} catch (IOException e) {
			fileLoggingPossible = false;
			logFileCreated = false;
		}
		logFileCreated = true;
	}


	private static void writeLogFile(String logLine, java.lang.Throwable m) {
		try {
			FileWriter fw = new FileWriter(LOG_FILE_NAME, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw);
		    out.println(logLine);
		    if(m != null) m.printStackTrace(out);
		    out.close();
		} catch (IOException e) {
			fileLoggingPossible = false;
		}
	}



}
