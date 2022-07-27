package shitangyuangong;
import shitanggongneng.shitanggongneng;
import java.util.Scanner;

import member.member;

public class shitangyuangong extends member//食堂员工模式（修改菜单）
{
	Scanner reader = new Scanner(System.in);
	Scanner reader1 = new Scanner(System.in);
	Scanner reader2 = new Scanner(System.in);
	Scanner reader3 = new Scanner(System.in);
	public static int mi1 = 987654321; //密码固定，如果需要修改需要找管理员
	public shitangyuangong(){}
	public void pag()
	{
		int yi = 0, bi;
		do {
			shitanggongneng a = new shitanggongneng();
			System.out.print("1.添加菜品\n2.修改价格\n3.修改存量\n4.修改卡路里\n5.修改菜名\n6.退出\n指令：");
			bi = reader.nextInt();
			switch(bi)
			{
			case 1://添加菜品
				a.xuan1();
				break;
			case 2://改价格
				a.xuan2();
				break;
			case 3://改存量
				a.xuan3();
				break;
			case 4://改卡路里
				a.xuan4();
				break;
			case 5://修改菜名
				a.xuan5();
				break;
			case 6://退出员工模式
				yi = 1;
				break;
			default:
				System.out.println("该指令不存在！请重新输入。");
			}
		}while(yi==0);
	}
}