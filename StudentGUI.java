import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.sound.sampled.*;

public class StudentGUI extends JPanel {


  public StudentGUI(Teacher t,String name){
    super();
    JPanel content = this;
    content.setLayout(new GridLayout(0,2));
    JLabel namel = new JLabel("Name: ");
    JLabel labelName  = new JLabel(name);
    content.add(namel);
    content.add(labelName);

    JLabel labelGrade;
    if (t.getGrade(name)==-1){
        labelGrade  = new JLabel("N/A");
    } else {
        labelGrade  = new JLabel(String.valueOf(t.getGrade(name)));
    }
    JLabel gradel = new JLabel("Grade: ");
    content.add(gradel);
    content.add(labelGrade);

    JLabel labelAverage;
    if (t.getGrade("average")==-1){
        labelAverage = new JLabel("N/A");
    } else {
        labelAverage = new JLabel(String.valueOf(t.getGrade("average")));
    }
    JLabel avgl = new JLabel("Average: ");
    content.add(avgl);
    content.add(labelAverage);

    if (t.getGrade("average")!=-1&&t.getGrade(name)!=-1){
      if (t.getGrade(name)>=t.getGrade("average")){
        playGlorious();
      } else {
        playCheerful();
      }
    }


  }


  public static void createAndShowGUI(Teacher t,String name) {
      //Create and set up the window.
      JFrame frame = new JFrame("Student Page");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      //Create and set up the content pane.
      JComponent newContentPane = new StudentGUI(t,name);
      newContentPane.setOpaque(true); //content panes must be opaque
      frame.setContentPane(newContentPane);


      //Display the window.
      frame.pack();
      frame.setSize(200,200);
      frame.setVisible(true);
  }

  public static void playCheerful() {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("cheerful.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(0);
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }
	}

  public static void playGlorious() {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("glorious.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(0);
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }
	}



}
