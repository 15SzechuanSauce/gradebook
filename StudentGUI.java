import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class StudentGUI extends JPanel {


  public StudentGUI(Teacher t,String name){
    super();
    JPanel content = this;
    content.setLayout(new FlowLayout());
    JLabel labelName  = new JLabel(name);
    content.add(labelName);

    JLabel labelGrade;
    if (t.getGrade(name)==-1){
        labelGrade  = new JLabel("N/A");
    } else {
        labelGrade  = new JLabel(String.valueOf(t.getGrade(name)));
    }
    content.add(labelGrade);

    JLabel labelAverage;
    if (t.getGrade("average")==-1){
        labelAverage = new JLabel("N/A");
    } else {
        labelAverage = new JLabel(String.valueOf(t.getGrade("average")));
    }
    content.add(labelAverage);


  }


  public static void createAndShowGUI(Teacher t,String name) {
      //Create and set up the window.
      JFrame frame = new JFrame("Student Page");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Create and set up the content pane.
      JComponent newContentPane = new StudentGUI(t,name);
      newContentPane.setOpaque(true); //content panes must be opaque
      frame.setContentPane(newContentPane);


      //Display the window.
      frame.pack();
      frame.setSize(500,500);
      frame.setVisible(true);
  }

}
