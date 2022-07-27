package OrderGongneng;

import java.util.Scanner;
import Gongneng1.Gongneng1;
import member.member;

public class OrderGongneng extends member implements Gongneng1
{
	Scanner reader = new Scanner(System.in);
	public void chaxun1(int y)//学生查询余额
	{
		String qian3 = String.format("%.2f", qian1[y]);
		System.out.println("你的余额还有"+qian3+"元。");
	}
	public void chaxun2(int y)//老师查询余额
	{
		String qian4 = String.format("%.2f", qian2[y]);
		System.out.println("你的余额还有"+qian4+"元。");
	}
	public void chongzhi1(int y)//学生充值
	{
		System.out.println("请选择以下充值面额（为了大家方便，暂时不能自定义额度充值哟！！）");
		int wi,op = 0;
		System.out.print("1.15元\n2.50元\n3.100元\n4.200元\n5.500元\n6.返回\n指令：");
		wi = reader.nextInt();
		do {
		switch(wi)
		{
		case 1:
			qian1[y]+=15;
			op = 1;
			break;
		case 2:
			qian1[y]+=50;
			op = 1;
			break;
		case 3:
			qian1[y]+=100;
			op = 1;
			break;
		case 4:
			qian1[y]+=200;
			op = 1;
			break;
		case 5:
			qian1[y]+=500;
			op = 1;
			break;
		case 6:
			op = 1;
			break;
		default:
			System.out.println("输错指令了呀！！！再输入一次哟！");
		}
		}while(op == 0);
	}
	public void chongzhi2(int y)//老师充值
	{
		System.out.println("请选择以下充值面额（为了大家方便，暂时不能自定义额度充值哟！！）");
		int wi,op = 0;
		System.out.print("1.15元\n2.50元\n3.100元\n4.200元\n5.500元\n6.返回\n指令：");
		wi = reader.nextInt();
		do {
		switch(wi)
		{
		case 1:
			qian2[y]+=15;
			op = 1;
			break;
		case 2:
			qian2[y]+=50;
			op = 1;
			break;
		case 3:
			qian2[y]+=100;
			op = 1;
			break;
		case 4:
			qian2[y]+=200;
			op = 1;
			break;
		case 5:
			qian2[y]+=500;
			op = 1;
			break;
		case 6:
			op = 1;
			break;
		default:
			System.out.println("输错指令了呀！！！再输入一次哟！");
		}
		}while(op == 0);
	}
}
