package cn.hl.client;

import java.util.Scanner;

import cn.hl.bean.Relation;
import cn.hl.bean.User;
import cn.hl.dao.RelationDao;
import cn.hl.dao.StudentDao;
import cn.hl.dao.impl.RelationDaoImpl;
import cn.hl.dao.impl.StudentDaoImpl;
import cn.hl.dao.impl.UserDaoImpl;

/**
 * 练习要求： 1、系统中可以存储学生信息。包含：姓名、性别、年龄、所属班级、家庭住址、联系电话、家庭成员信息 2、系统需要满足如下要求：
 * 1）、可以向系统内添加任意的学生信息 2）、可以按照班级名称查询所有该班的学生列表并显示
 * 3）、系统内可以存储每名学生的多位家庭成员信息（姓名、关系、联系电话） 4）、可以按照学号查询指定学生的信息及家庭成员信息 5）、可以按照学号修改学生信息
 * 6）、按照学生的学号可以查询当前学生的状态(在读、休学、毕业) 7）、使用上述功能前需要进行登录验证
 * 
 * @author Lens
 * 
 */
public class StudentSys {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// 定义计数器存储输入次数
		int times = 0;
		// 验证用户登陆
		do {
			// 提示并接收用户输入的用户名和密码
			System.out.println("account:");
			String account = input.next();
			System.out.println("pwd:");
			String pwd = input.next();
			// 实例化Dao对象
			UserDaoImpl dao = new UserDaoImpl();
			// 通过Dao对象进行登陆验证
			User user = dao.getByAccount(account, pwd);

			// 验证登陆是否成功
			if (user == null) {
				if (++times < 3) {
					System.out
							.println("用户名或密码错误 ！还有" + (3 - times) + "次机会，请重试");
				} else {
					System.err.println("您已输入错误3次，系统将退出，请稍后重试");
					System.exit(0);
				}
			} else {
				System.out.println(user.getUserName() + ",欢迎您使用学生管理系统");
				break;
			}

		} while (times < 3);
		// 用户登录成功
		while (true) {
			// 1.输出系统菜单
			switch (chooseMenuItem()) {
			case 3:
				addRelation();
				break;
			case 7:
				System.out.println("感谢使用学生管理系统");
				System.exit(0);
			default:
				System.out.println("您的选择有误，请重新选择");
				break;

			}
		}
	}

	/**
	 * 添加家庭成员信息
	 * 
	 * 业务逻辑
	 * 
	 */
	private static void addRelation() {
		StudentDao dao = new StudentDaoImpl();
		while (true) {
			// 1.获取需要添加家庭成员的学生学号
			System.out.println("请输入学生学号：");
			int stuNo = input.nextInt();
			// 2.验证学生学号是否有效，（在Students中存在学生信息则有效，否则表示学生信息不存在）
			// 学生信息存储在数据库中，所以需要通过数据库进行验证
			if (dao.getById(stuNo) == null) {
				System.out.println("学生信息不存在，请重新输入\n");
				continue;
			}

			boolean isFinish = false;
			do {
				// 3.如果有效则获取家庭成员信息
				Relation relation = new Relation(stuNo);
				System.out.println("成员姓名：");
				relation.setName(input.next());
				System.out.println("关系：");
				relation.setRelation(input.next());
				System.out.println("联系电话：");
				relation.setTel(input.next());
				// 4.验证成员信息在数据表中是否已经存在，如果存在会提示用户
				RelationDao relDao = new RelationDaoImpl();
				if (relDao.checkRelation(stuNo, relation.getName(),
						relation.getRelation())) {
					System.out.println("家庭成员信息已经存在，是否填写其他成员信息(y/n)");
					char choose = input.next().charAt(0);
					isFinish = (choose == 'y' || choose == 'Y');
					// 如果出现错误则处理后续的执行
					if (isFinish)
						continue;
					else
						break;
				}

				// 5.信息添加到数据库中
				if (relDao.add(relation) > 0) {
					System.out.print("家庭成员添加成功");
				} else {
					System.out.print("家庭成员添加失败");
					
					System.out.print("是否填写其他成员信息(y/n)");
					char choose = input.next().charAt(0);
					isFinish = (choose == 'y' || choose == 'Y');
					
				}
			} while (isFinish);
		}

	}

	/**
	 * 生成系统菜单并提示接收用户的选择
	 * 
	 * @return
	 */
	private static int chooseMenuItem() {
		System.out.println("--------------欢迎使用学生管理系统------------");
		System.out.println("1.添加班级信息");
		System.out.println("2.添加学生信息");
		System.out.println("3.修改学生信息");
		System.out.println("4.添加家庭成员信息");
		System.out.println("5.查询学生信息");
		System.out.println("6.学员转（退、休）学管理");
		System.out.println("7.退出系统");
		System.out.println("------------------------------------------");
		System.out.println("请选择功能项（1~7）：");
		return input.nextInt();
	}

}
