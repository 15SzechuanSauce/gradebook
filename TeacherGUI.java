import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class TeacherGUI extends JPanel {


  public TeacherGUI(Teacher t){
    super();
    JPanel content = this;
    content.setLayout(new BorderLayout());

    JLabel welcome = new JLabel("<html><h1>Welcome</h1></html>");
    content.add(welcome,BorderLayout.PAGE_START);

    JPanel input = new JPanel();
    input.setLayout(new GridLayout(0,2));

    JLabel name = new JLabel("Name");
    JTextField nametf = new JTextField("");
    input.add(name);
    input.add(nametf);

    JLabel grade = new JLabel("Grade");
    JTextField gradetf = new JTextField("");
    input.add(grade);
    input.add(gradetf);

    content.add(input,BorderLayout.CENTER);

    JPanel right = new JPanel();
    right.setLayout(new GridLayout(0,1));
    JButton addg = new JButton("Add");
    JButton calc = new JButton("Calc Avg");
    right.add(addg);
    right.add(calc);

    JLabel average = new JLabel("Avg: ");
    JTextField averagetf = new JTextField("");
    right.add(average);
    right.add(averagetf);

    content.add(right,BorderLayout.LINE_END);

    JPanel below = new JPanel();
    below.setLayout(new FlowLayout());

    JButton save = new JButton("Save Gradebook");
    below.add(save);
    JTextArea log = new JTextArea("");
    below.add(log);
    content.add(below,BorderLayout.PAGE_END);

    addg.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
          String name = nametf.getText();
          double grade = Double.parseDouble(gradetf.getText());
          t.addGrade(name,grade);
     }
    });

     calc.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent event){
           double averageScore = t.calcAverage();
           averagetf.setText(""+averageScore);
      }
     });

     save.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent event){
           log.setText(t.gradebookString());
           try {
              PrintWriter writer = new PrintWriter("grades.txt", "UTF-8");
              writer.println(t.gradebookString());
              writer.close();
            } catch (Exception e){
              System.out.println("Problem writing to file: "+e);
            }
      }
     });


  }


  public static void createAndShowGUI(Teacher t) {
      //Create and set up the window.
      JFrame frame = new JFrame("Teacher Page");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      //Create and set up the content pane.
      JComponent newContentPane = new TeacherGUI(t);
      newContentPane.setOpaque(true); //content panes must be opaque
      frame.setContentPane(newContentPane);


      //Display the window.
      frame.pack();
      frame.setSize(400,300);
      frame.setVisible(true);
  }


}
