import java.util.*;

public class app {
  public static void start() {
    List<user> users = new ArrayList<>();
    // 这是一个测试函数将在测试完成后作为注释在这里
    user user1 = new user(520, "520");
    users.add(user1);
    // 输入账户密码，页面显示
    System.out.println("欢迎来到user系统");
    System.out.println("请输入账号:");
    Scanner sc = new Scanner(System.in);
    long CountNumber = sc.nextLong();
    System.out.println("请输入密码:");
    Scanner sc2 = new Scanner(System.in);
    String Password = sc2.nextLine();
    sc2.close();
    // 账户密码代入
    user user = new user(CountNumber, Password);
    // 验证账户密码(分类有问题)
    for (int i = 0; i < users.size(); i++)
      if (UService.isSame(users.get(i).getCountNumber(), user.getCountNumber())) {
        if (UService.isSame(users.get(i).getPassWord(), user.getPassWord())) {
          System.out.println("密码正确，欢迎用户");
          break;
        } else {
          System.out.println("密码错误");
        }

      } else {
        System.out.println("未找到改账户");
      }
    ;
  }
}
