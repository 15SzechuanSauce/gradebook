import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class TeacherGUI extends JPanel {


  public TeacherGUI(Teacher t){
    super();

    //act upon the parsed in teacher object t
    //teacher can add grade and also modify gradebook (see teacher class methods)
    //see github issue for gui display and buttons
    //there should also be a calculation of average button
    //and a textarea left blank initially with a button to show all grades that's been inputed

  }


  public static void createAndShowGUI(Teacher t) {
      //Create and set up the window.
      JFrame frame = new JFrame("Teacher Page");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Create and set up the content pane.
      JComponent newContentPane = new TeacherGUI(t);
      newContentPane.setOpaque(true); //content panes must be opaque
      frame.setContentPane(newContentPane);

      //Display the window.
      frame.pack();
      frame.setVisible(true);
  }

}
