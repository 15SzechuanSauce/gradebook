import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class TeacherGUI extends JPanel {


  public TeacherGUI(Teacher t){
    super();
    JPanel content = this;
    content.setLayout(new GridLayout(0,2));

    JLabel name = new JLabel("Name"); JLabel grade = new JLabel("Grade");
    content.add(name); content.add(grade);

    JTextField s1 = new JTextField(""); JTextField g1 = new JTextField("");content.add(s1); content.add(g1);//t.addGrade(s1.getText(),Double.parseDouble(g1.getText()));
    JTextField s2 = new JTextField(""); JTextField g2 = new JTextField("");content.add(s2); content.add(g2);//t.addGrade(s2.getText(),Double.parseDouble(g2.getText()));
    JTextField s3 = new JTextField(""); JTextField g3 = new JTextField("");content.add(s3); content.add(g3);//t.addGrade(s3.getText(),Double.parseDouble(g3.getText()));
    JTextField s4 = new JTextField(""); JTextField g4 = new JTextField("");content.add(s4); content.add(g4);//t.addGrade(s4.getText(),Double.parseDouble(g4.getText()));
    JTextField s5 = new JTextField(""); JTextField g5 = new JTextField("");content.add(s5); content.add(g5);//t.addGrade(s5.getText(),Double.parseDouble(g5.getText()));
    JTextField s6 = new JTextField(""); JTextField g6 = new JTextField("");content.add(s6); content.add(g6);//t.addGrade(s6.getText(),Double.parseDouble(g6.getText()));
    JTextField s7 = new JTextField(""); JTextField g7 = new JTextField("");content.add(s7); content.add(g7);//t.addGrade(s7.getText(),Double.parseDouble(g7.getText()));
    JTextField s8 = new JTextField(""); JTextField g8 = new JTextField("");content.add(s8); content.add(g8);//t.addGrade(s8.getText(),Double.parseDouble(g8.getText()));

    JButton calc = new JButton("Calculate the Average"); JLabel average = new JLabel("");
    content.add(calc); content.add(average);

     calc.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent event){
           t.addGrade(s1.getText(),Double.parseDouble(g1.getText()));
           t.addGrade(s2.getText(),Double.parseDouble(g2.getText()));
           t.addGrade(s3.getText(),Double.parseDouble(g3.getText()));
           t.addGrade(s4.getText(),Double.parseDouble(g4.getText()));
           t.addGrade(s5.getText(),Double.parseDouble(g5.getText()));
           t.addGrade(s6.getText(),Double.parseDouble(g6.getText()));
           t.addGrade(s7.getText(),Double.parseDouble(g7.getText()));
           t.addGrade(s8.getText(),Double.parseDouble(g8.getText()));
           double averageScore = t.calcAverage();
           average.setText(""+averageScore);
      }
     });

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
      frame.setSize(500,500);
      frame.setVisible(true);
  }

}
