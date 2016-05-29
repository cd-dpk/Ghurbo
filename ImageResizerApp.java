package image;

import java.io.File;
import java.io.IOException;

public class ImageResizerApp {
	public static void resizeImages(){
			try {
				File mainImageFolder = new File(ImageResizerConstant.MAIN_IMAGE_DIRECTORY);
				File [] files = mainImageFolder.listFiles();
				for (File file : files) {
					System.out.println(file.getName()+" is resizing...");
					String inputImagePath = ImageResizerConstant.MAIN_IMAGE_DIRECTORY+ImageResizerConstant.FILE_PATH_SEPARATOR+file.getName();
					String outputImagePath = ImageResizerConstant.RESIZED_IMAGE_DIRECTORY+ImageResizerConstant.FILE_PATH_SEPARATOR+file.getName();
					ImageResizer.resizeImageByWidth(inputImagePath, outputImagePath,ImageResizerConstant.scaled_width);
				}
				System.out.println("ALL IMAGES RESIZED SUCCESSFULLY!");
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		resizeImages();
	}
	
}
