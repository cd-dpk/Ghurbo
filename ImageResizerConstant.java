package image;

import email.Utils;

public class ImageResizerConstant {
	public static  String FILE_PATH_SEPARATOR ="//" ;
	
	public static  String WORK_DIRECTORY=Utils.getFilePathStringFromFilePathStringInWindowsConvention("‪D://Ghurbo//IMAGE_RESIZE");
	public static  String MAIN_IMAGE_DIRECTORY = Utils.getFilePathStringFromFilePathStringInWindowsConvention("D://Ghurbo//IMAGE_RESIZE"+FILE_PATH_SEPARATOR+"IMG");
	public static  String RESIZED_IMAGE_DIRECTORY =Utils.getFilePathStringFromFilePathStringInWindowsConvention("D://Ghurbo//IMAGE_RESIZE"+FILE_PATH_SEPARATOR+"IMG_1");
	
	public static int scaled_width=840;
	public static int scaled_height=0;
	
}
