package member;
public class member//成员
{
	public static int nem;//学生或者老师在系统中的序号
	protected static int[]nember1 = new int[100];//学生学号
	protected static int man1 = 0;//记录已有学生人数
	protected static String[]name1 = new String[100];//学生姓名
	protected static double[]qian1 = new double[100];//学生账号余额
	protected static int[]nember2 = new int[10];//老师工号
	protected static int man2 = 0;//记录已有老师人数
	protected static String[]name2 = new String[10];//老师姓名
	protected static double[]qian2 = new double[10];//老师账号余额
	protected static int nem1;//菜单序号
	protected static String[]vegetables = new String[10];//蔬菜类菜单
	protected static double[]veg1 = new double[10];//蔬菜价格
	protected static double[]veg2 = new double[10];//蔬菜的存量
	protected static double[]veg3 = new double[10];//蔬菜卡路里
	protected static int veg4 = 0;//记录已有蔬菜菜单数
	protected static String[]meat = new String[10]; //肉类菜单
	protected static double[]mea1 = new double[10];//肉类价格
	protected static double[]mea2 = new double[10];//肉类存量
	protected static double[]mea3 = new double[10];//肉类卡路里
	protected static int mea4 = 0;//记录已有肉类菜单数
	protected static String[]soup = new String[5];//汤类菜单
	protected static double[]sou1 = new double[10];//汤类价格
	protected static int[]sou2 = new int[10];//汤类存量
	protected static double[]sou3 = new double[10];//汤类卡路里
	protected static int sou4 = 0;//记录已有汤类菜单数
	protected static String[]other = new String[5];//其他类菜单
	protected static double[]oth1 = new double[10];//其他类价格
	protected static double[]oth2 = new double[10];//其他类存量
	protected static double[]oth3 = new double[10];//其他类卡路里
	protected static int oth4 = 0;//记录已有其他类菜单数
	public member() {}
	public member(int x)
	{
		member.nem = x;
	}
	public member(int x,int y)
	{
		member.nem1 = x;
	}
}