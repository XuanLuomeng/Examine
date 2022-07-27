package Recognition;//识别人员

import java.util.Scanner;
import Administrator.Administrator;
import member.member;
import shitangyuangong.shitangyuangong;

public class Recognition extends member
{
	Scanner reader = new Scanner(System.in);
	private int j = 0;
	public static int ji = 0;//获取所属数组下标
	public static int ki = 0;//区别老师还是学生
	public Recognition()
	{
		System.out.print("请输入你的学号/工号：");
		int i = 0;
		int a = reader.nextInt();
		new member(a);
		Administrator c = new Administrator();
		shitangyuangong d = new shitangyuangong();
		if(member.nem == Administrator.mi)//识别是否是管理员
			c.page();
		else if(member.nem == shitangyuangong.mi1)
			d.pag();
		else//识别非管理员则开始识别学生或老师
		{
			for(;i < 100;i++)
			{
				if(i<10)
				{
					if(member.nem==member.nember1[i])//识别是否是系统名单序号0-9的学生
					{
						System.out.println("欢迎 "+member.name1[i]+" 同学!");
						Recognition.ki = 0;
						this.j = 1;
						break;
					}
					else if(member.nem==member.nember2[i])//识别是否是系统名单序号0-9的老师
					{
						System.out.println("欢迎 "+member.name2[i]+" 老师!");
						Recognition.ki = 1;
						this.j = 1;
						break;
					}
					else
						this.j = 0;
				}
				else//识别是否是系统名单序号10-99的学生
				{
					if(member.nem==member.nember1[i])
					{
						System.out.println("欢迎"+member.name1[i]+"同学!");
						Recognition.ki = 0;
						this.j = 1;
						break;
					}
					else
						this.j = 0;
				}
			}
		}
		if(i==100)//完全识别完系统所有老师与学生序号之后仍无法找到对应学号或工号后
			System.out.println("系统中不存在该学号/工号，如有疑问请前往饭堂前台询问！");
		else//将老师或学生序号传给ji方便后续操作
			ji = i;
	}
	public int a()
	{
		if(this.j ==1)
			return 1;
		else
			return 0;
	}
}