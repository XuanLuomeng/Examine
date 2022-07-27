package MenuGongneng;

import java.util.Scanner;
import member.member;
import Gongneng2.Gongneng2;

public class MenuGongneng extends member implements Gongneng2
{
	Scanner reader = new Scanner(System.in);
	Scanner reader1 = new Scanner(System.in);
	Scanner reader2 = new Scanner(System.in);
	public void Shucai(int x,int y)//购买蔬菜
	{
		int k = 0,dian,queding = 0;
		double xv,kg = 0,fei = 0;
		for(k = 0; k < veg4; k++)//打印菜单
			System.out.println(k+":菜名："+vegetables[k]+"   价格："+veg1[k]+"元/kg   剩余："+veg2[k]+"kg   能量："+veg3[k]+"卡路里/kg");
		System.out.println("请点餐(>="+veg4+"为返回,请勿输入负数！)"+"：");
		dian = reader.nextInt();
		if(veg4==0)
			System.out.println("该类无菜品，可联系食堂员工添加菜品！");
		else if(dian>=veg4)
			System.out.println("");
		else
		{
			System.out.print("所需卡路里：");
			xv = reader1.nextDouble();
			kg = xv/veg3[dian];
			if(kg>veg2[dian])
			{
				System.out.println("存量不足,现已通知后厨烹饪中,请稍等哟");
				veg2[dian]+=100;
			}
			else
			{
				fei = kg*veg1[dian];
				String fe = String.format("%.2f", fei);
				System.out.println("费用为"+fe+"元，是否购买？1:是  2:否");
				queding = reader2.nextInt();
				if(queding==1)
				{
					if(x==1)
					{
						if((qian2[y]-fei)>=0)
						{
							qian2[y]-=fei;
							veg2[dian]-=kg;
						}
						else
							System.out.println("余额不足！");
					}
					else
					{
						if((qian1[y]-fei)>=0)
						{
							qian1[y]-=fei;
							veg2[dian]-=kg;
						}
						else
							System.out.println("余额不足！");
					}
				}
				else if(queding==2)
					System.out.println("");
				else
					System.out.println("无效操作");
			}
		}
	}
	public void Roulei(int x,int y)//购买肉类
	{
		int k1 = 0,dian1,queding1 = 0;
		double xv1,kg1 = 0,fei1 = 0;
		for(k1 = 0; k1 < mea4; k1++)//打印菜单
			System.out.println(k1+":菜名："+meat[k1]+"   价格："+mea1[k1]+"元/kg   剩余："+mea2[k1]+"kg   能量："+mea3[k1]+"卡路里/kg");
		System.out.println("请点餐(>="+mea4+"为返回，请勿输入负数！)"+"：");
		dian1 = reader.nextInt();
		if(mea4==0)
			System.out.println("该类无菜品，可联系食堂员工添加菜品！");
		else if(dian1>=mea4)
			System.out.println("");
		else
		{
			System.out.print("所需卡路里：");
			xv1 = reader1.nextDouble();
			kg1 = xv1/mea3[dian1];
			if(kg1>mea2[dian1])
			{
				System.out.println("存量不足,现已通知后厨烹饪中,请稍等哟");
				mea2[dian1]+=100;
			}
			else
			{
				fei1 = kg1*mea1[dian1];
				String fe1 = String.format("%.2f", fei1);
				System.out.print("费用为"+fe1+"元，是否购买？1:是  2:否\n指令：");
				queding1 = reader2.nextInt();
				if(queding1==1)
				{
					if(x==1)
					{
						if((qian2[y]-fei1)>=0)
						{
							qian2[y]-=fei1;
							mea2[dian1]-=kg1;
						}
						else
							System.out.println("余额不足！");
					}
					else
					{
						if((qian1[y]-fei1)>=0)
						{
							qian1[y]-=fei1;
							mea2[dian1]-=kg1;
						}
						else
							System.out.println("余额不足！");
					}
				}
				else if(queding1==2)
					System.out.println("");
				else
					System.out.println("无效操作");
			}
		}
	}
	public void Tanglei(int x,int y)//购买汤类
	{
		int k2 = 0,dian2,queding2 = 0, xv2;
		for(k2 = 0; k2 < sou4; k2++)//打印菜单
			System.out.println(k2+":菜名："+soup[k2]+"   价格："+sou1[k2]+"元/碗   剩余："+sou2[k2]+"碗   能量："+sou3[k2]+"卡路里/碗");
		System.out.println("请点餐(>="+sou4+"为返回,请勿输入负数！)"+"：");
		dian2 = reader.nextInt();
		if(veg4==0)
			System.out.println("该类无菜品，可联系食堂员工添加菜品！");
		else if(dian2>=sou4)
			System.out.println("");
		else
		{
			System.out.print("所需数量：");
			xv2 = reader1.nextInt();
			if(xv2>sou2[dian2])
			{
				System.out.println("存量不足,现已通知后厨烹饪中,请稍等哟");
				sou2[dian2]+=10;
			}
			else
			{
				String fe2 = String.format("%.2f", xv2*sou1[dian2]);
				System.out.print("费用为"+fe2+"元，是否购买？1:是  2:否\n指令：");
				queding2 = reader2.nextInt();
				if(queding2==1)
				{
					if(x==1)
					{
						if((qian2[y]-xv2*sou1[dian2])>=0)
						{
							qian2[y]-=xv2*sou1[dian2];
							sou2[dian2]-=xv2;
						}
						else
							System.out.println("余额不足！");
					}
					else
					{
						if((qian1[y]-xv2*sou1[dian2])>=0)
						{
							qian1[y]-=xv2*sou1[dian2];
							sou2[dian2]-=xv2;
						}
						else
							System.out.println("余额不足！");
					}
				}
				else if(queding2==2)
					System.out.println("");
				else
					System.out.println("无效操作");
			}
		}
	}
	public void Qitalei(int x,int y)//购买其他类
	{
		int k3 = 0,dian3,queding3 = 0;
		double xv3,kg3 = 0,fei3 = 0;
		for(k3 = 0; k3 < oth4; k3++)//打印菜单
			System.out.println(k3+":菜名："+other[k3]+"   价格："+oth1[k3]+"元/kg   剩余："+oth2[k3]+"kg   能量："+oth3[k3]+"卡路里/kg");
		System.out.println("请点餐(>="+oth4+"为返回，请勿输入负数！)"+"：");
		dian3 = reader.nextInt();
		if(veg4==0)
			System.out.println("该类无菜品，可联系食堂员工添加菜品！");
		else if(dian3>=oth4)
			System.out.println("");
		else
		{
			System.out.print("所需卡路里：");
			xv3 = reader1.nextDouble();
			kg3 = xv3/oth3[dian3];
			if(kg3>oth2[dian3])
			{
				System.out.println("存量不足,现已通知后厨烹饪中,请稍等哟");
				oth2[dian3]+=100;
			}
			else
			{
				fei3 = kg3*oth1[dian3];
				String fe3 = String.format("%.2f",fei3);
				System.out.print("费用为"+fe3+"元，是否购买？1:是  2:否\n指令：");
				queding3 = reader2.nextInt();
				if(queding3==1)
				{
					if(x==1)
					{
						if((qian2[y]-fei3)>=0)
						{
							qian2[y]-=fei3;
							oth2[dian3]-=kg3;
						}
						else
							System.out.println("余额不足！");
					}
					else
					{
						if((qian1[y]-fei3)>=0)
						{
							qian1[y]-=fei3;
							oth2[dian3]-=kg3;
						}
						else
							System.out.println("余额不足！");
					}
				}
				else if(queding3==2)
					System.out.println("");
				else
					System.out.println("无效操作");
			}
		}
	}
	public void Mifan(int x,int y)//购买米饭
	{
		int dian4;
		System.out.print("1.小份：0.6元   2.中份：0.8元   3.大份：1元   4.返回\n指令：");//打印菜单
		dian4 = reader.nextInt();
		switch(dian4)
		{
		case 1:
			if(x==1)
			{
				if((qian2[y]-0.6)>=0)
					qian2[y]-=0.6;
				else
					System.out.println("余额不足！");
			}
			else
			{
				if((qian1[y]-0.6)>=0)
					qian1[y]-=0.6;
				else
					System.out.println("余额不足！");
			}
			break;
		case 2:
			if(x==1)
			{
				if((qian2[y]-0.8)>=0)
					qian2[y]-=0.8;
				else
					System.out.println("余额不足！");
			}
			else
			{
				if((qian1[y]-0.8)>=0)
					qian1[y]-=0.8;
				else
					System.out.println("余额不足！");
			}
			break;
		case 3:
			if(x==1)
			{
				if((qian2[y]-1)>=0)
					qian2[y]-=1;
				else
					System.out.println("余额不足！");
			}
			else
			{
				if((qian1[y]-1)>=0)
					qian1[y]-=1;
				else
					System.out.println("余额不足！");
			}
			break;
		case 4:
			break;
		default:
			System.out.println("无效指令");
		}
	}
}
