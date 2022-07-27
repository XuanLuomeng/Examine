package Gongneng;

public interface Gongneng
{
	public abstract void xuan1();//选择加哪一类菜单
	public abstract void xuan2();//选择改哪一类价格
	public abstract void xuan3();//选择改哪一类存量
	public abstract void xuan4();//选择改哪一类卡路里
	public abstract void xuan5();//选择改哪一类菜名
	public abstract void Vegetables();//添加蔬菜
	public abstract void Meat();//添加肉类
	public abstract void Soup();//添加汤类
	public abstract void Other();//添加其他类
	public abstract void dayincaiming(int x);//打印菜单
	public abstract void jiage(int x);//改价格
	public abstract void cunliang(int x);//改存量
	public abstract void kaluli(int x);//改卡路里
	public abstract void caiming(int x);//改菜名
}