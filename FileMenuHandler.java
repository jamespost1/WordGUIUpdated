
/**
 * This FileMenuHandler implements ActionListener to perform actions from the WordGUI menu. 
 * @author James Post
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class FileMenuHandler implements ActionListener {
   WordGUI jframe;
   String paragraph = new String();

   /**
    * One argument constructor
    * 
    * @param jf The jframe to be created
    */
   public FileMenuHandler(WordGUI jf) {
      jframe = jf;
   }

   /**
    * This method performs actions according to the menu item's name
    */
   public void actionPerformed(ActionEvent event) {
      String menuName;
      menuName = event.getActionCommand();
      if (menuName.equals("Open"))
         openFile();
      else if (menuName.equals("Quit"))
         System.exit(0);
      else
         readVowel(menuName);
   }

   /**
    * This method will open a file directory and allow the user to open a file from
    * their local storage
    */
   private void openFile() {
      int status;
      JFileChooser chooser = new JFileChooser();
      status = chooser.showOpenDialog(null);
      if (status == JFileChooser.APPROVE_OPTION)
         readSource(chooser.getSelectedFile());
      else
         JOptionPane.showMessageDialog(null, "Open File dialog cancelled");
   }

   /**
    * This method will read in text from a selected file, split it and store it in
    * an array, and display the text with line numbers in a JFrame
    * 
    * @param chosenFile The file chosen by the user
    */
   private void readSource(File chosenFile) {
      TextFileInput inFile = new TextFileInput(chosenFile.getAbsolutePath());
      String line;
      int subscript = 1;
      line = inFile.readLine();
      // store lines while the current line is not null
      while (line != null) {
         paragraph += subscript + "\t" + line + "\n";
         // split the line into words and store it in an array
         String[] wordArray = line.split(" ");
         for (int j = 0; j < wordArray.length; j++) {
            jframe.words.add(new WordLine(wordArray[j], subscript));
         }
         subscript++;
         line = inFile.readLine();
      }
      // display the text in a JFrame
      Container myContentPane = jframe.getContentPane();
      TextArea text = new TextArea(paragraph);
      myContentPane.add(text);
      jframe.setVisible(true);
   }

   /**
    * This method reads in words beginning with the vowel in the parameter, and
    * sorts them in alphabetical order, storing them in a WordLine object and
    * displaying them in a JFrame
    * 
    * @param vowel The chosen vowel
    */
   private void readVowel(String vowel) {
      ArrayList<WordLine> vWords = new ArrayList<>();
      for (int i = 0; i < jframe.words.size(); i++) {
         WordLine current = jframe.words.get(i);
         if (current.word.length() == 0)
            continue;
         String firstLetter = current.word.charAt(0) + "";
         // condition to check for vowel
         if (firstLetter.equalsIgnoreCase(vowel)) {
            if (vWords.size() == 0) {
               vWords.add(current);
               continue;
            }
            // sorts the vowelWords
            for (int j = 0; j < vWords.size(); j++) {
               String vwCurrent = vWords.get(j).word;
               if (current.word.compareTo(vwCurrent) < 0) {
                  vWords.add(j, current);
                  break;
               }
            }
         }
      }
      // displays the sorted list in a JFrame
      Container myContentPane = jframe.getContentPane();
      TextArea vowels = new TextArea();
      for (int i = 0; i < vWords.size(); i++) {
         WordLine current = vWords.get(i);
         vowels.append(current.number + "\t" + current.word + "\n");
      }
      myContentPane.add(vowels);
      jframe.setVisible(true);
   }
}