package email;

public class EmailExtractorConstant {
	public static final char genericFilePathSeparator ='/';
	public static final String windowsFilePathSeparator ="//";
	public static final char emailIndicatorCharacter = '@';
	public static final String emailDelimitersString = "; :=[],<>\\\"*";
	
	public static String initialInputFilePathString = "null";
	public static String initialOutputDirectoryPathString = Utils.getFilePathStringFromFilePathStringInWindowsConvention("C://Users//User//Documents");
	public static String inputFilePathString = initialInputFilePathString;
	public static String outputDirectoryPathString = initialOutputDirectoryPathString;
	public static String outputTextFileName = "email_output.txt";
	public static String outputFilePathString = Utils.getFilePathStringFromFilePathStringInWindowsConvention(outputDirectoryPathString + windowsFilePathSeparator + outputTextFileName);
}
