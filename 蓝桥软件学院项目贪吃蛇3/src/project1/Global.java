package project1;
import java.awt.Toolkit;
//放置所有常亮的类
public class Global {
	//墙壁数组横向最多能容纳39个障碍物
	static final int WIDTH = 39;
	//墙壁数组纵向最多能容纳39个障碍物
	static final int HEIGHT = 23;
	//墙壁每块为正方形，边长为20
	static final int SZIE = 20;
	//蛇体默认方向为右。1——>上，2——>下，3——>左，4——>右
	static int DIRECTION = 4;
	//控制蛇体是否动（还未实现）
	static int RUN = 0;
	static int DRAW = 0;
	static int failed = 0;
	static int start = 0;
	static int map = 1;
	//墙壁数组
	static int[][] border = new int[Global.WIDTH][Global.HEIGHT];
	static int Screen_w = Toolkit.getDefaultToolkit().getScreenSize().width;
	static int Screen_h  = Toolkit.getDefaultToolkit().getScreenSize().height;

	static int[] scores = new int[1000];
	static int j = 0;
	static int pre_dre = 4;
	static int speed = 160;
}
