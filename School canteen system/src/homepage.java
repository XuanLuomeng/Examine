import Recognition.Recognition;
import order.order;

public class homepage
{
	public static void main(String[] args)
	{
		System.out.println("*学校饭堂系统*");
		int po = 0, c = 0, b = 0, ti = 0, jkl = 0;
		do {//死循环
		do {//识别
		Recognition a = new Recognition();//识别人员
		c = a.a();
		po = Recognition.ji;
		ti = Recognition.ki;//获取学生或老师身份
		}while(c == 0);
		do {//功能服务
		order vi = new order(ti,po);
		b = vi.ok;
		}while(b == 0);
		po = 0;//重新定义有关变量使死循环正常进行
		c = 0; 
		b = 0; 
		ti = 0;
		}while(jkl == 0);
	}
}