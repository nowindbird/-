import java.util.*; // 导入Java工具包，包含集合类和Scanner等

public class app {
  private static List<user> users = new ArrayList<>(); // 创建一个存储user对象的列表

  static {
    // NOTE: 初始化时添加预置用户
    user user1 = new user(520, "520"); // 创建一个预置用户，账号和密码都是520
    users.add(user1); // 将预置用户添加到用户列表中
  }

  public static void start() {
    System.out.println("欢迎来到user系统"); // 打印欢迎信息
    System.out.println("请选择操作：1.登录 2.注册"); // NOTE: 新增注册功能选项
    System.out.println("请输入选项:");

    Scanner sc = new Scanner(System.in); // 创建Scanner对象用于接收用户输入
    try {
      int choice = sc.nextInt(); // 读取用户选择
      sc.nextLine(); // NOTE: 消耗换行符

      switch (choice) {
        case 1:
          login(sc);
          break;
        case 2:
          register(sc);
          break;
        default:
          System.out.println("无效选项");
      }
    } finally {
      sc.close(); // 确保Scanner资源被释放
    }
  }

  private static void login(Scanner sc) {
    System.out.println("请输入账号:"); // 提示用户输入账号
    long CountNumber = sc.nextLong(); // 读取用户输入的账号
    System.out.println("请输入密码:"); // 提示用户输入密码
    String Password = sc.next(); // 读取用户输入的密码

    user user = new user(CountNumber, Password); // 用输入的账号密码创建临时用户对象

    boolean userFound = false; // 标志位：是否找到匹配的用户
    boolean passwordCorrect = false; // 标志位：密码是否正确

    // 遍历用户列表进行验证
    for (user u : users) {
      if (UService.isSame(u.getCountNumber(), user.getCountNumber())) {
        userFound = true; // 找到账号匹配的用户
        if (UService.isSame(u.getPassWord(), user.getPassWord())) {
          passwordCorrect = true; // 密码也匹配
        }
        break; // 找到用户后退出循环
      }
    }

    // 根据验证结果输出不同信息
    if (!userFound) {
      System.out.println("未找到该用户"); // 账号不存在
    } else if (!passwordCorrect) {
      System.out.println("密码错误"); // 账号存在但密码错误
    } else {
      System.out.println("密码正确，欢迎用户"); // 验证通过
    }
  }

  private static void register(Scanner sc) {
    System.out.println("请输入新账号:"); // NOTE: 注册新账号
    long newCountNumber = sc.nextLong();
    System.out.println("请输入密码:");
    String newPassword = sc.next();

    // NOTE: 检查账号是否已存在
    boolean exists =
        users.stream().anyMatch(u -> UService.isSame(u.getCountNumber(), newCountNumber));

    if (exists) {
      System.out.println("账号已存在");
    } else {
      users.add(new user(newCountNumber, newPassword));
      System.out.println("注册成功");
    }
  }
}
