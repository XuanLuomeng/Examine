package menu;

import java.util.Scanner;
import MenuGongneng.MenuGongneng;
import member.member;

public class menu extends member//菜单
{
	public menu() {}
	@SuppressWarnings("resource")
	public menu(int x, int y)//区别老师数组(1)还是学生数组(0)，以及判断所属数组下标
	{
		Scanner reader = new Scanner(System.in);
		int cai5,xi5 = 0;
		do {
		System.out.print("菜类：\n1.蔬菜类\n2.肉类\n3.汤类\n4.其他类\n5.米饭\n6.返回\n指令：");
		cai5 = reader.nextInt();
		MenuGongneng a = new MenuGongneng();
		switch(cai5)
		{
		case 1://蔬菜点餐
			a.Shucai(x, y);
			break;
		case 2://肉类点餐
			a.Roulei(x, y);
			break;
		case 3://汤类点餐
			a.Tanglei(x, y);
			break;
		case 4://其他类点餐
			a.Qitalei(x, y);
			break;
		case 5://米饭点餐
			a.Mifan(x, y);
			break;
		case 6://退出
			xi5 = 1;
			break;
		default:
			System.out.println("该指令不存在！请重新输入。");
		}
		}while(xi5==0);
	}
}