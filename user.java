import java.util.*;

public class user {
  private long CountNumber;
  private String PassWord;
  private String UserName;

  user(long c, String p, String u) {
    this.CountNumber = c;
    this.PassWord = p;
    this.UserName = u;
  }

  user(long c, String p) {
    this.CountNumber = c;
    this.PassWord = p;
  }

  public long getCountNumber() {
    return CountNumber;
  }

  public String getPassWord() {
    return PassWord;
  }

  public String getUserName() {
    return UserName;
  }

  public void setCountNumber(long countNumber) {
    this.CountNumber = countNumber;
  }

  public void setPassWord(String passWord) {
    this.PassWord = passWord; // WARNING: 实际应用中应使用加密存储
  }

  public void setUserName(String userName) {
    this.UserName = userName;
  }
}
