import java.util.*;

public class Teacher{
  public String loginName;
  public int pwd;
  public HashMap<String,Double> gradebook;

  public Teacher(String loginName, int pwd){
    this.loginName=loginName;
    this.pwd=pwd;
    this.gradebook = new HashMap<String,Double>();
  }
  public double getGrade(String name)
  {
    return gradebook.get(name);
  }
  public String getLoginName(){
    return loginName;
  }
  public int getPwd(){
    return pwd;
  }
  public void setLoginName(String loginName){
    this.loginName=loginName;
  }
  public void setPwd(int pwd){
    this.pwd=pwd;
  }

  public void addGrade(String name,double grade){
    this.gradebook.put(name,grade);
  }

  public void changeGrade(String name,double grade){
    this.gradebook.replace(name,grade);
  }

  public double calcAverage(){
    if (gradebook.containsKey("average")){
      gradebook.remove("average");
    }
    double sum = 0;
    for (Map.Entry<String,Double> entry : gradebook.entrySet()) {
		    sum+=entry.getValue();
    }
    double average = (double) (sum/gradebook.size());
    gradebook.put("average",average);
    return average;
  }

  public String toString(){
    return "";
  }
}
