public class Teacher{
  public String loginName;
  public int pwd;

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
  public Teacher(String loginName, int pwd){
    this.loginName=loginName;
    this.pwd=pwd;
  }

  public String toString(){
    return "";
  }
}
