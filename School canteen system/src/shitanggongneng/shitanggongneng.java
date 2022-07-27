package shitanggongneng;//员工功能的封装包

import java.util.Scanner;
import member.member;
import Gongneng.Gongneng;


public class shitanggongneng extends member implements Gongneng
{
	Scanner reader = new Scanner(System.in);
	Scanner reader1 = new Scanner(System.in);
	Scanner reader2 = new Scanner(System.in);
	Scanner reader3 = new Scanner(System.in);
	public void xuan1()//选择加哪一类菜单
	{
		int ui = 0, ci;
		do {
			System.out.print("1.蔬菜类\n2.肉类\n3.汤类\n4.其他类\n5.返回\n指令：");
			ci = reader.nextInt();
			switch(ci)
			{
			case 1:
				Vegetables();
				break;
			case 2:
				Meat();
				break;
			case 3:
				Soup();
				break;
			case 4:
				Other();
				break;
			case 5:
				ui = 1;
				break;
			default:
				System.out.println("该指令不存在！请重新输入。");
			}
		}while(ui==0);
	}
	public void xuan2()//选择改哪一类价格
	{
		int cai,xi = 0;
		do {
		System.out.print("所需修改价格的菜类：\n1.蔬菜类\n2.肉类\n3.汤类\n4.其他类\n5.返回\n指令：");
		cai = reader.nextInt();
		switch(cai)
		{
		case 1:
			jiage(1);
			break;
		case 2:
			jiage(2);
			break;
		case 3:
			jiage(3);
			break;
		case 4:
			jiage(4);
			break;
		case 5:
			xi = 1;
			break;
		default:
			System.out.println("该指令不存在！请重新输入。");
		}
		}while(xi==0);
	}
	public void xuan3()//选择改哪一类存量
	{
		int cai,xi = 0;
		do {
		System.out.print("所需修改存量的菜类：\n1.蔬菜类\n2.肉类\n3.汤类\n4.其他类\n5.返回\n指令：");
		cai = reader.nextInt();
		switch(cai)
		{
		case 1:
			cunliang(1);
			break;
		case 2:
			cunliang(2);
			break;
		case 3:
			cunliang(3);
			break;
		case 4:
			cunliang(4);
			break;
		case 5:
			xi = 1;
			break;
		default:
			System.out.println("该指令不存在！请重新输入。");
		}
		}while(xi==0);
	}
	public void xuan4()//选择改哪一类卡路里
	{
		int cai,xi = 0;
		do {
		System.out.print("所需修改卡路里的菜类：\n1.蔬菜类\n2.肉类\n3.汤类\n4.其他类\n5.返回\n指令：");
		cai = reader.nextInt();
		switch(cai)
		{
		case 1:
			kaluli(1);
			break;
		case 2:
			kaluli(2);
			break;
		case 3:
			kaluli(3);
			break;
		case 4:
			kaluli(4);
			break;
		case 5:
			xi = 1;
			break;
		default:
			System.out.println("该指令不存在！请重新输入。");
		}
		}while(xi==0);
	}
	public void xuan5()//选择改哪一类菜名
	{
		int cai,xi = 0;
		do {
		System.out.print("所需修改菜名的菜类：\n1.蔬菜类\n2.肉类\n3.汤类\n4.其他类\n5.返回\n指令：");
		cai = reader.nextInt();
		switch(cai)
		{
		case 1:
			caiming(1);
			break;
		case 2:
			caiming(2);
			break;
		case 3:
			caiming(3);
			break;
		case 4:
			caiming(4);
			break;
		case 5:
			xi = 1;
			break;
		default:
			System.out.println("该指令不存在！请重新输入。");
		}
		}while(xi==0);
	}
	public void Vegetables()//添加蔬菜
	{
		if(veg4<=9)
		{
			System.out.print("菜名：");
			vegetables[veg4] = reader.next();
			System.out.print("价格：");
			veg1[veg4] = reader1.nextDouble();
			System.out.print("存量：");
			veg2[veg4] = reader2.nextDouble();
			System.out.print("卡路里：");
			veg3[veg4] = reader3.nextDouble();
			veg4++;
		}
		else
			System.out.println("菜品达到上限，如有需求请联系有关部门");
	}
	public void Meat()//添加肉类
	{
		if(mea4<=9)
		{
			System.out.print("菜名：");
			meat[mea4] = reader.next();
			System.out.print("价格：");
			mea1[mea4] = reader1.nextDouble();
			System.out.print("存量：");
			mea2[mea4] = reader2.nextDouble();
			System.out.print("卡路里：");
			mea3[mea4] = reader3.nextDouble();
			mea4++;
		}
		else
			System.out.println("菜品达到上限，如有需求请联系有关部门");
	}
	public void Soup()//添加肉类
	{
		if(sou4<=9)
		{
			System.out.print("菜名：");
			soup[sou4] = reader.next();
			System.out.print("价格：");
			sou1[sou4] = reader1.nextDouble();
			System.out.print("存量：");
			sou2[sou4] = reader2.nextInt();
			System.out.print("卡路里：");
			sou3[sou4] = reader3.nextDouble();
			sou4++;
		}
		else
			System.out.println("菜品达到上限，如有需求请联系有关部门");
	}
	public void Other()//添加其他类
	{
		if(oth4<=9)
		{
			System.out.print("菜名：");
			other[oth4] = reader.next();
			System.out.print("价格：");
			oth1[oth4] = reader1.nextDouble();
			System.out.print("存量：");
			oth2[oth4] = reader2.nextDouble();
			System.out.print("卡路里：");
			oth3[oth4] = reader3.nextDouble();
			oth4++;
		}
		else
			System.out.println("菜品达到上限，如有需求请联系有关部门");
	}
	public void dayincaiming(int x)//打印菜名，打印的类别，获取寻找相同菜名数组的下标
	{
		if(x==1)
			for(int k1 = 0; k1 < veg4; k1++)
				System.out.println(k1+":菜名："+vegetables[k1]+"   价格："+veg1[k1]+"元/kg   剩余："+veg2[k1]+"kg   能量："+veg3[k1]+"卡路里/kg");
		else if(x==2)
			for(int k2 = 0; k2 < mea4; k2++)
				System.out.println(k2+":菜名："+meat[k2]+"   价格："+mea1[k2]+"元/kg   剩余："+mea2[k2]+"kg   能量："+mea3[k2]+"卡路里/kg");
		else if(x==3)
			for(int k3 = 0; k3 < sou4; k3++)
				System.out.println(k3+":菜名："+soup[k3]+"   价格："+sou1[k3]+"元/碗   剩余："+sou2[k3]+"碗   能量："+sou3[k3]+"卡路里/碗");
		else
			for(int k4 = 0; k4 < oth4; k4++)
				System.out.println(k4+":菜名："+other[k4]+"   价格："+oth1[k4]+"元/kg   剩余："+oth2[k4]+"kg   能量："+oth3[k4]+"卡路里/kg");
	}
	public void jiage(int x)//修改价格所需函数
	{
		int suo;
		dayincaiming(x);
		System.out.print("菜名序号：");
		suo = reader.nextInt();
		if(x==1)
		{
			if((suo>=0)&&(suo<veg4))
			{
				System.out.print("新价格：");
				veg1[suo] = reader1.nextDouble();
			}
			else
				System.out.print("查无此菜");
		}
		else if(x==2)
		{
			if((suo>=0)&&(suo<mea4))
			{
				System.out.print("新价格：");
				mea1[suo] = reader1.nextDouble();
			}
			else
				System.out.print("查无此菜");
		}
		else if(x==3)
		{
			if((suo>=0)&&(suo<sou4))
			{
				System.out.print("新价格：");
				sou1[suo] = reader1.nextDouble();
			}
			else
				System.out.print("查无此菜");
		}
		else
		{
			if((suo>=0)&&(suo<oth4))
			{
				System.out.print("新价格：");
				oth1[suo] = reader1.nextDouble();
			}
			else
				System.out.print("查无此菜");
		}
	}
	public void cunliang(int x)//修改存量所需函数
	{
		int suo;
		dayincaiming(x);
		System.out.print("菜名序号：");
		suo = reader.nextInt();
		if(x==1)
		{
			if((suo>=0)&&(suo<veg4))
			{
				System.out.print("新存量：");
				veg2[suo] = reader1.nextDouble();
			}
			else
				System.out.print("查无此菜");
		}
		else if(x==2)
		{
			if((suo>=0)&&(suo<mea4))
			{
				System.out.print("新存量：");
				mea2[suo] = reader1.nextDouble();
			}
			else
				System.out.print("查无此菜");
		}
		else if(x==3)
		{
			if((suo>=0)&&(suo<sou4))
			{
				System.out.print("新存量：");
				sou2[suo] = reader1.nextInt();
			}
			else
				System.out.print("查无此菜");
		}
		else
		{
			if((suo>=0)&&(suo<oth4))
			{
				System.out.print("新存量：");
				oth2[suo] = reader1.nextDouble();
			}
			else
				System.out.print("查无此菜");
		}
	}
	public void kaluli(int x)//修改卡路里所需函数
	{
		int suo;
		dayincaiming(x);
		System.out.print("菜名序号：");
		suo = reader.nextInt();
		if(x==1)
		{
			if((suo>=0)&&(suo<veg4))
			{
				System.out.print("新卡路里：");
				veg3[suo] = reader1.nextDouble();
			}
			else
				System.out.print("查无此菜");
		}
		else if(x==2)
		{
			if((suo>=0)&&(suo<mea4))
			{
				System.out.print("新卡路里：");
				mea3[suo] = reader1.nextDouble();
			}
			else
				System.out.print("查无此菜");
		}
		else if(x==3)
		{
			if((suo>=0)&&(suo<sou4))
			{
				System.out.print("新卡路里：");
				sou3[suo] = reader1.nextDouble();
			}
			else
				System.out.print("查无此菜");
		}
		else
		{
			if((suo>=0)&&(suo<oth4))
			{
				System.out.print("新卡路里：");
				oth3[suo] = reader1.nextDouble();
			}
			else
				System.out.print("查无此菜");
		}
	}
	public void caiming(int x)//修改菜名所需函数
	{
		int suo;
		dayincaiming(x);
		System.out.print("菜名序号：");
		suo = reader.nextInt();
		System.out.print("新菜名：");
		if(x==1)
		{
			if((suo>=0)&&(suo<veg4))
			{
				System.out.print("新菜名：");
				vegetables[suo] = reader1.next();
			}
			else
				System.out.print("查无此菜");
		}
		else if(x==2)
		{
			if((suo>=0)&&(suo<mea4))
			{
				System.out.print("新菜名：");
				meat[suo] = reader1.next();
			}
			else
				System.out.print("查无此菜");
		}
		else if(x==3)
		{
			if((suo>=0)&&(suo<sou4))
			{
				System.out.print("新菜名：");
				soup[suo] = reader1.next();
			}
			else
				System.out.print("查无此菜");
		}
		else
		{
			if((suo>=0)&&(suo<oth4))
			{
				System.out.print("新菜名：");
				other[suo] = reader1.next();
			}
			else
				System.out.print("查无此菜");
		}
	}
}
