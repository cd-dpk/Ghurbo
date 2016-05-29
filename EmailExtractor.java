package email;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EmailExtractor {
	File inputFile, outputFile;
	List<String> emailStringList;

	public void extractEmailFromInputFile(String inputFileString, String outputFileString) {
		emailStringList = new ArrayList<String>();
		inputFile = new File(inputFileString);
		outputFile = new File(outputFileString);
		long line = 1;
		try {
			FileWriter fileWriter = new FileWriter(outputFile);
			Scanner inputFileScanner = new Scanner(inputFile);
			while (inputFileScanner.hasNext()) {
				String nextLine = inputFileScanner.nextLine();
				System.out.print(line + ":");
				if (nextLine.indexOf(EmailExtractorConstant.emailIndicatorCharacter) != -1) {
					StringTokenizer stringTokenizer = new StringTokenizer(nextLine,
							EmailExtractorConstant.emailDelimitersString, false);
					while (stringTokenizer.hasMoreTokens()) {
						String token = stringTokenizer.nextToken();
						token = token.toLowerCase();
						if (token.indexOf(EmailExtractorConstant.emailIndicatorCharacter) != -1
								&& hasEmailInEmailList(token) == false) {
							emailStringList.add(token);
							fileWriter.write(token + "\n");
						}
					}
					nextLine += " ";
					System.out.print(nextLine);
				}
				System.out.println();
				line++;
			}
			inputFileScanner.close();
			fileWriter.close();
			System.out.println("OKAY");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean hasEmailInEmailList(String emailString) {
		for (String email : emailStringList) {
			if (email.equals(emailString)) {
				return true;
			}
		}
		return false;
	}

}
