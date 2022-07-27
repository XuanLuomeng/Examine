package order;

import java.util.Scanner;

import OrderGongneng.OrderGongneng;
import member.member;
import menu.menu;

public class order extends member//充值点餐等功能
{
	Scanner reader = new Scanner(System.in);
	public int ok = 0;
	public order() {}
	public order(int x,int y)//区别老师(1)还是学生(0)，已经判断所属数组下标
	{
		System.out.print("1.查询余额\n2.充值\n3.点餐\n4.退出\n指令：");
		int ri;
		OrderGongneng a = new OrderGongneng();
		ri = reader.nextInt();
		if(x==0)//学生类账号
		{
			switch(ri)
			{
			case 1://查询余额
				a.chaxun1(y);
				break;
			case 2://充值
				a.chongzhi1(y);
				break;
			case 3://点餐
				new menu(x,y);
				break;
			case 4://退出
				this.ok = 1;
				break;
			default:
				System.out.println("指令错误了哟！");
			}
		}
		else//老师类账号
		{
			switch(ri)
			{
			case 1://查询余额
				a.chaxun2(y);
				break;
			case 2://充值
				a.chongzhi2(y);
				break;
			case 3://点餐
				new menu(x,y);
			case 4://退出
				this.ok = 1;
				break;
			default:
				System.out.println("指令错误了哟！");
			}
		}
	}
}