package Administrator;

import java.util.Scanner;
import AdministratorGongneng.AdministratorGongneng;
import member.member;

public class Administrator extends member//管理员模式（增加学生/员工）
{
	Scanner reader = new Scanner(System.in);
	Scanner reader1 = new Scanner(System.in);
	public static int mi = 123456789; //密码
	public Administrator(){}
	public void page()
	{
		int yu = 0, ai;
		do {
		System.out.print("1.修改密码\n2.增加学生\n3.增加老师\n4.退出\n指令：");
		ai = reader.nextInt();
		AdministratorGongneng a = new AdministratorGongneng();
		switch(ai)
		{
		case 1://改密码
			a.GMima();
			break;
		case 2://添加学生
			a.Txuesheng();
			break;
		case 3://添加老师
			a.Tlaoshi();
			break;
		case 4://退出
			yu = 1;
			break;
		default:
			System.out.println("该指令不存在！请重新输入。");
		}
		}while(yu == 0);
	}
}