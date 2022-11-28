/**
 * @author James Post
 * This WordGUI extends JFrame and creates a GUI with two menus, file and list, with several menu items in each of them.
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WordGUI extends JFrame{
   ArrayList<WordLine> words = new ArrayList<>();
   /**
    * Three argument constructor that creates a WordGUI with title, height, and width
    * @param title The title
    * @param height The height
    * @param width The width
    */
   public WordGUI(String title, int height, int width) {
      setTitle(title);
      setSize(height,width);
      setLocation(100,100);
      setLayout(new GridLayout(1,2));
      createMenu();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }
   /**
    * This method will create the menubar, menus, and menuitems, and uses the FileMenuHandler to handle the events/actions
    */
   private void createMenu() {
      JMenuBar menuBar = new JMenuBar();
      JMenu fileMenu = new JMenu("File");
      JMenu listMenu = new JMenu("List");
      JMenuItem item;
      FileMenuHandler fmh = new FileMenuHandler(this);
      FileMenuHandler lmh = new FileMenuHandler(this);
      item = new JMenuItem("Open");
      item.addActionListener(fmh);
      fileMenu.add(item);
      fileMenu.addSeparator();
      item = new JMenuItem("Quit");
      item.addActionListener(fmh);
      fileMenu.add(item);
      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
      
      item = new JMenuItem("A");
      item.addActionListener(lmh);
      listMenu.add(item);
      listMenu.addSeparator();
      item = new JMenuItem("E");
      item.addActionListener(lmh);
      listMenu.add(item);
      listMenu.addSeparator();
      item = new JMenuItem("I");
      item.addActionListener(lmh);
      listMenu.add(item);
      listMenu.addSeparator();
      item = new JMenuItem("O");
      item.addActionListener(lmh);
      listMenu.add(item);
      listMenu.addSeparator();
      item = new JMenuItem("U");
      item.addActionListener(lmh);
      listMenu.add(item);
      setJMenuBar(menuBar);
      menuBar.add(listMenu);
   }
}
