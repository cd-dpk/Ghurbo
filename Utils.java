package email;

import java.io.File;

public class Utils {

	public static String getFileExtension(File file){
		String fileName = file.getName();
		String extesion = fileName.substring(fileName.lastIndexOf('.')+1);
		return extesion;
	}
	
	public static String getFilePathStringFromFilePathStringInWindowsConvention(String filePathStringInWindowsConvention){
		String filePath="";
		for (int i = 0; i < filePathStringInWindowsConvention.length(); i++) {
			char ch= filePathStringInWindowsConvention.charAt(i);
			if (ch == EmailExtractorConstant.genericFilePathSeparator) {
				ch = EmailExtractorConstant.genericFilePathSeparator;
				i++;
			}
			filePath += ch;  
		}
		return filePath;
	}
	
}
