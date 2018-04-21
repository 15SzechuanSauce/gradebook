public class Student{
  public String loginName;
  public String name;
  public int pwd;

  public Student(String loginName, String name, int pwd){
    this.loginName=loginName;
    this.name=name;
    this.pwd=pwd;
  }

  public String getName(){
    return name;
  }
  public String getLoginName(){
    return loginName;
  }
  public int getPwd(){
    return pwd;
  }
  public void setName(String name){
    this.name=name;
  }
  public void setLoginName(String loginName){
    this.loginName=loginName;
  }
  public void setPwd(int pwd){
    this.pwd=pwd;
  }


  public String toString(){
    return "";
  }
}
