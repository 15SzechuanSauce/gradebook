import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Login extends JPanel {

  ArrayList<Teacher> teachers = new ArrayList<Teacher>();
  ArrayList<Student> students = new ArrayList<Student>();

  JButton picB; //picture
  JPanel panelStart,panelEnd;
  JButton clearpwdButton1,clearpwdButton2;
  JButton button1, button2, button3,button4;
  JTabbedPane pane;
  JLabel label1,label2,label3,label4,label5,reminderL,reminderL1;
  JTextField text,text1,text2;
  JPasswordField pwd,pwd1,pwd2;
  JPanel panel1,panel2,panel3;


  public Login(){
    super();
		JPanel content = this;
    content.setLayout(new BorderLayout());

    //PAGE_START
    panelStart=new JPanel();
    panelStart.setLayout(new GridLayout(1,3));
    picB=new JButton(new ImageIcon("1.jpg"));
    panelStart.add(picB);
    content.add(panelStart,BorderLayout.PAGE_START);

    //CENTER
    label1=new JLabel("Account",JLabel.CENTER);
    label2=new JLabel("Password",JLabel.CENTER);
    label3=new JLabel("Account",JLabel.CENTER);
    label4=new JLabel("Password",JLabel.CENTER);
    label5=new JLabel("Your name",JLabel.CENTER);
    reminderL = new JLabel("");
    reminderL1 = new JLabel("");
    text=new JTextField();
    pwd=new JPasswordField();
    text1=new JTextField();
    text2=new JTextField();
    pwd1=new JPasswordField();
    clearpwdButton1=new JButton("Clear Password");
    clearpwdButton2=new JButton("Clear Password");
    pane=new JTabbedPane();
    panel1=new JPanel();
    panel2=new JPanel();
    button1=new JButton("Log in");
    button2=new JButton("Clear");
    button3=new JButton("Register");
    button4=new JButton("Clear");
    String[] identity = {"Teacher","Student"};
    JComboBox choice = new JComboBox(identity);
    JComboBox choice1 = new JComboBox(identity);

    pane.add("Register",panel1);
    pane.add("Log in",panel2);

    panel1.setLayout(new GridLayout(0,2));
    panel2.setLayout(new GridLayout(0,2));

    panel1.add(choice); panel1.add(reminderL); panel1.add(label1); panel1.add(text);panel1.add(label5);panel1.add(text2);
    panel1.add(label2); panel1.add(pwd); panel1.add(button3);panel1.add(button2);

    panel2.add(choice1); panel2.add(reminderL1); panel2.add(label3); panel2.add(text1);
    panel2.add(label4); panel2.add(pwd1); panel2.add(button1);panel2.add(button4);

    content.add(pane,BorderLayout.CENTER);


    //log in button
    //check whether the account name and password are matched
    button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
          int accountselect = choice1.getSelectedIndex();
          boolean match = false;
          String pwdText = pwd.getText();
          int pwdN = Integer.parseInt(pwdText);
          for(Teacher t:teachers){
            if(t.getLoginName().equals(text1.getText())&&(t.getPwd()==(pwdN))){
              reminderL1.setText("Success!!!");
              TeacherGUI.createAndShowGUI();
              match=true;
              break;
            }
          }
          for(Student s:students){
            if(s.getLoginName().equals(text1.getText())&&(s.getPwd()==(pwdN))){
              String studentName = s.getName();
              StudentGUI.createAndShowGUI(studentName);
              reminderL1.setText("Success!!!");
              match=true;
              break;
            }
          }
          if(!match){
            reminderL1.setText("Account name and password are not matched. Please enter again!");
            text.setText("");
            pwd.setText("");
          }

			}
		});

    //clear button
    button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
        text.setText("");
				pwd.setText("");
			}
		});

    button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
        text.setText("");
				pwd.setText("");
			}
		});

    //register button
    //add the user information
    button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
        String pwdText = pwd.getText();
        int pwdN = Integer.parseInt(pwdText);
        if(choice.getSelectedIndex()==0){ //enter teacher
          Teacher t = new Teacher(text.getText(),pwdN);
          reminderL.setText("Welcome "+t.getLoginName());
          teachers.add(t);
        }else if(choice.getSelectedIndex()==1){ //enter student
          Student s = new Student(text.getText(),text2.getText(),pwdN);
          reminderL.setText("Welcome "+s.getLoginName());
          students.add(s);
        }else{
          reminderL.setText("Please choose whether you are teacher or student!");
        }
			}
		});

  }


  private static void createAndShowGUI() {
      //Create and set up the window.
      JFrame frame = new JFrame("GradeBook");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Create and set up the content pane.
      JComponent newContentPane = new Login();
      newContentPane.setOpaque(true); //content panes must be opaque
      frame.setContentPane(newContentPane);

      //Display the window.
      frame.pack();
      frame.setVisible(true);
  }

  public static void main(String[] args) {
      //Schedule a job for the event-dispatching thread:
      //creating and showing this application's GUI.
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              createAndShowGUI();
          }
      });
  }
}
