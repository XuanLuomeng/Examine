package AdministratorGongneng;

import java.util.Scanner;
import Administrator.Administrator;
import member.member;
import Gongneng3.Gongneng3;

public class AdministratorGongneng extends member implements Gongneng3
{
	Scanner reader = new Scanner(System.in);
	Scanner reader1 = new Scanner(System.in);
	public void GMima()
	{
		System.out.print("新密码（注意：员工模式密码固定为987654321，请勿改为此密码以免系统错误！）：");
		Administrator.mi = reader.nextInt();
	}
	public void Txuesheng()
	{
		if(man1<100)
		{
			System.out.print("学号：");
			nember1[man1] = reader.nextInt();
			System.out.print("姓名：");
			name1[man1] = reader1.nextLine();
			qian1[man1] = 0;
			man1+=1;
		}
		else
			System.out.println("超过系统存储人数上限，请更新设备！");
	}
	public void Tlaoshi()
	{
		if(man2<10)
		{
			System.out.print("工号：");
			nember2[man2] = reader.nextInt();
			System.out.print("姓名：");
			name2[man2] = reader1.nextLine();
			qian2[man2] = 0;
			man2+=1;
		}
		else
			System.out.println("超过系统存储人数上限，请更新设备！");
	}
}
