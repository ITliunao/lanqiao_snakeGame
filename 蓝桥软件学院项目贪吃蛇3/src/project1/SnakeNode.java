package project1;
import java.util.LinkedList;
//定义蛇身的节点
public class SnakeNode {
	static int[] snakeX = new int[10000];
	static int[] snakeY = new int[10000];
	int len;
	public SnakeNode(){
		//初始化蛇，蛇头为snakeX[0]，snakeY[0]蛇身为snakeX[1]，snakeY[1]；snakeX[2] = 1，snakeY[2] = 12;蛇身体长为3
		snakeX[0] = 7;
		snakeX[1] = 6;
		snakeX[2] = 5;
		snakeY[0] = 12;
		snakeY[1] = 12;
		snakeY[2] = 12;
		len = 2;
	}
}
