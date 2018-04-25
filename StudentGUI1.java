import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class StudentGUI extends JPanel {


  public StudentGUI(Teacher t,String name){
    super();


    //use the parsed in name to find in Teacher.gradeBook
    //display the name, grade, and average grade
    //average grade is saved in Teacher.gradebook under "average" if the teacher has finished grading
    //if average grade returns null, or student grade returns null
    //show "teacher hasn't finshed grading" etc.

  }


  public static void createAndShowGUI(Teacher t,String name) {
      //Create and set up the window.
      JFrame frame = new JFrame("Student Page");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Create and set up the content pane.
      JComponent newContentPane = new StudentGUI(t,name);
      newContentPane.setOpaque(true); //content panes must be opaque
      frame.setContentPane(newContentPane);

      JLabel labelName  = new JLabel("", JLabel.CENTER);
      labelName.setText(name);
      labelName.setOpaque(true);
      //labelName.setBackground(Color.GRAY);
      //labelName.setForeground(Color.WHITE);
      newContentPane.add(labelName);

      JLabel labelGrade  = new JLabel("", JLabel.CENTER);
      labelGrade.setText(String.valueOf(t.getGrade(name)));
      labelGrade.setOpaque(true);
      //labelGrade.setBackground(Color.GRAY);
      //labelGrade.setForeground(Color.WHITE);
      newContentPane.add(labelGrade);

      JLabel labelAverage  = new JLabel("", JLabel.CENTER);
      labelAverage.setText(String.valueOf(t.getGrade("average")));
      labelAverage.setOpaque(true);
      //labelAverage.setBackground(Color.GRAY);
      //labelAverage.setForeground(Color.WHITE);
      newContentPane.add(labelAverage);

      //Display the window.
      frame.pack();
      frame.setVisible(true);
  }

}
