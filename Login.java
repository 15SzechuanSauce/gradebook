import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Login extends JPanel {

  ArrayList<User> users = new ArrayList<User>();
  //kdfdkfj
  JButton picB; //picture
  JPanel panelStart,panelEnd;
  JButton clearpwdButton1,clearpwdButton2;
  JButton button1, button2, button3;
  JTabbedPane pane;
  JLabel label1,label2,label3,label4,label5,label6,label7,label8;
  JLabel label33, label44,reminderL;
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
    label1=new JLabel("Teacher Account",JLabel.CENTER);
    label2=new JLabel("Teacher Password",JLabel.CENTER);
    label3=new JLabel("forget password",JLabel.CENTER);
    label3.setFont(new Font("Serif",Font.PLAIN,16));
    label3.setForeground(Color.black);
    label33=new JLabel("forget password",JLabel.CENTER);
    label4 =new JLabel("<html><a href='www.qq.com'>Apply to protect password</a>");
    label4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    label44 =new JLabel("<html><a href='www.qq.com'>Apply to protect password</a>");
    label44.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    label7=new JLabel("Student Account",JLabel.CENTER);
    label8=new JLabel("Student Password",JLabel.CENTER);
    label7.setFont(new Font("Times New Roman",Font.PLAIN,15));
    label8.setFont(new Font("Times New Roman",Font.PLAIN,15));
    text=new JTextField();
    text1=new JTextField();
    text2=new JTextField();
    pwd=new JPasswordField();
    pwd1=new JPasswordField();
    pwd2=new JPasswordField();
    clearpwdButton1=new JButton("Clear Password");
    clearpwdButton2=new JButton("Clear Password");
    pane=new JTabbedPane();
    panel1=new JPanel();
    panel2=new JPanel();

    pane.add("Teacher",panel1);
    pane.add("Student",panel2);

    panel1.setLayout(new GridLayout(3,3));
    panel2.setLayout(new GridLayout(3,3));

    panel1.add(label1); panel1.add(text); panel1.add(clearpwdButton1);
    panel1.add(label2); panel1.add(pwd);panel1.add(label3);
    panel1.add(label4);

    panel2.add(label7); panel2.add(text1); panel2.add(clearpwdButton2);
    panel2.add(label8); panel2.add(pwd1);
    panel2.add(label33);panel2.add(label44);

    content.add(pane,BorderLayout.CENTER);

    //PAGE_END
    panelEnd=new JPanel();
    button1=new JButton("Log in");
    button2=new JButton("Clear");
    button3=new JButton("Register");
    reminderL=new JLabel("");
    panelEnd.add(button1);
    panelEnd.add(button2);
    panelEnd.add(button3);
    panelEnd.add(reminderL);
    content.add(panelEnd,BorderLayout.PAGE_END);

  
 
    //log in button
    //check whether the account name and password are matched
    button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
          int accountselect = pane.getSelectedIndex();
          boolean match = false;
          String pwdText = pwd.getText();
          int qqPwd = Integer.parseInt(pwdText);
          for(User u:users){
            if(u.getqqAccount().equals(text.getText())&&(u.getqqPwd()==(qqPwd))){
              reminderL.setText("Success!!!");
              match=true;
              break;
            }
          }
          if(!match){
            reminderL.setText("Account name and password are not matched. Please enter again!");
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

    //register button
    //add the user information
    button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
        String pwdText = pwd.getText();
        int qqPwd = Integer.parseInt(pwdText);
        User u = new User(text.getText(),qqPwd);
        reminderL.setText("Welcome "+u.getqqAccount());
        users.add(u);
			}
		});

    clearpwdButton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pwd.setText("");
			}
		});

    clearpwdButton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pwd.setText("");
			}
		});

  }

  public static class User{
    public String qqAccount;
    public int qqPwd;
    public String getqqAccount(){
      return qqAccount;
    }
    public int getqqPwd(){
      return qqPwd;
    }
    public void setqqAccount(String qqAccount){
      this.qqAccount=qqAccount;
    }
    public void setqqPwd(int qqPwd){
      this.qqPwd=qqPwd;
    }
    public User(String qqAccount, int qqPwd){
      this.qqAccount = qqAccount;
      this.qqPwd = qqPwd;
    }

    public String toString(){
      return "";
    }
  }
  private static void createAndShowGUI() {
      //Create and set up the window.
      JFrame frame = new JFrame("QQ");
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
