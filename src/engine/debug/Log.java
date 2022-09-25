package engine.debug;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	public static final String LOG_FOLDER = "/logs/";
	
	public enum OUTPUTTYPE {
		TEXT, ERROR, EXCEPTION, DEBUG
	}
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-hh:mm:ss");
	private static DateFormat dateFormatCritical = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
	
	public static void print(String text) {
		print(text, OUTPUTTYPE.TEXT);
	}
	public static void print(String text, OUTPUTTYPE type) {
		Date date = new Date();

		switch(type){ 
        case TEXT: 
        	System.out.println(dateFormat.format(date) + " >> " + text);
        	break;
        case ERROR: 
        	System.err.println(text);
        	saveToErrorFile(dateFormat.format(date) + " >> " + text);
        	break;
        case DEBUG: 
        	if (Debug.enabled) {
        		System.err.println(text);
        	}
        	break;
        case EXCEPTION:
        	System.err.println(text);
        	saveToCritivalEventFile(dateFormat.format(date) + " >> " + text);
        	System.exit(-1);
        	throw new RuntimeException(text);
		}
	}
	
	private static void saveToErrorFile(String line) {
		String filePath = new String(System.getProperty("user.dir") + LOG_FOLDER).replace("/", "\\") + "\\ErrorLog.txt";
		File errorFile = new File(filePath);
		
		if (!errorFile.exists()) {
			try {
				errorFile.createNewFile();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
		
		BufferedWriter output = null;
		
        try {
            output = new BufferedWriter(new FileWriter(errorFile));
            output.write(line);
            output.newLine();
        } catch (Exception ex) {
        	throw new RuntimeException(ex);
        } finally {
          if ( output != null ) {
            try {
				output.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
          }
        }
	}
	
	private static void saveToCritivalEventFile(String text) {
		Date date = new Date();
		String filePath = new String(System.getProperty("user.dir") + LOG_FOLDER).replace("/", "\\") + "\\CriticalEvent_" + dateFormatCritical.format(date) + ".txt";
		File errorFile = new File(filePath);
		
		if (!errorFile.exists()) {
			try {
				errorFile.createNewFile();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
		
		BufferedWriter output = null;
		
        try {
            output = new BufferedWriter(new FileWriter(errorFile));
            output.write(text);
        } catch (Exception ex) {
        	throw new RuntimeException(ex);
        } finally {
          if ( output != null ) {
            try {
				output.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
          }
        }
	}
}
