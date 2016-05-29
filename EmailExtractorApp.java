package email;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EmailExtractorApp  extends JFrame{
	
	/**
	 * auto generated
	 */
	private static final long serialVersionUID = 1L;
	
	JButton chooseInputFileButton;
	JButton selectOutputDirectoryButton;
	JLabel chosenInputFilePathLabel;
	JLabel selectedOutputDirectoryPathLabel;
	JFileChooser fileChooser;
	JButton extractButton;
	
	public EmailExtractorApp() {
		super("EmailExtractor");
		setLayout(new GridLayout(3, 2));
		chosenInputFilePathLabel = new JLabel("Choose text File");
		add(chosenInputFilePathLabel);
		chooseInputFileButton = new JButton("Browse");
		add(chooseInputFileButton);
		selectedOutputDirectoryPathLabel = new JLabel(EmailExtractorConstant.outputDirectoryPathString); 
		add(selectedOutputDirectoryPathLabel);
		selectOutputDirectoryButton = new JButton("Browse");
		add(selectOutputDirectoryButton);
		extractButton = new JButton("Extract");
		add(extractButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 100);
		setVisible(true);
		
		chooseInputFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setFileFilter(new TextFileFilter());
				int returnValue =fileChooser.showOpenDialog(EmailExtractorApp.this);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File choosenFile = fileChooser.getSelectedFile();
					EmailExtractorConstant.inputFilePathString = choosenFile.getAbsolutePath();
					chosenInputFilePathLabel.setText(EmailExtractorConstant.inputFilePathString);
				}
			}
		});
		selectOutputDirectoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setFileFilter(new TextFileFilter());
				int returnValue =fileChooser.showOpenDialog(EmailExtractorApp.this);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File choosenFile = fileChooser.getSelectedFile();
					EmailExtractorConstant.outputDirectoryPathString = choosenFile.getAbsolutePath();
					selectedOutputDirectoryPathLabel.setText(EmailExtractorConstant.outputDirectoryPathString);
				}
			}
		});
		extractButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (EmailExtractorConstant.inputFilePathString.equals(EmailExtractorConstant.initialInputFilePathString)) {
					JOptionPane.showMessageDialog(EmailExtractorApp.this, "Please Choose an input file");
				}
				else{
					new EmailExtractor().extractEmailFromInputFile(EmailExtractorConstant.inputFilePathString, EmailExtractorConstant.outputFilePathString);
				}
			}
		});
	}

	public static void main(String[] args) {
		 new EmailExtractorApp();
	}
}
