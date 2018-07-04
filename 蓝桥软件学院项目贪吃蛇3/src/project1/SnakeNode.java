package project1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//定义蛇身的节点
public class SnakeNode {
	static List<Integer>snakeX = new ArrayList<Integer>();
	static List<Integer>snakeY = new ArrayList<Integer>();
	int len;
	public SnakeNode(){
		//初始化蛇，蛇头为snakeX[0]，snakeY[0]蛇身为snakeX[1]，snakeY[1]；snakeX[2] = 1，snakeY[2] = 12;蛇身体长为3
		snakeX.add(0, 7);
		snakeX.add(1, 6);
		snakeX.add(2, 5);
		snakeY.add(0, 12);
		snakeY.add(1, 12);
		snakeY.add(2, 12);
		len = 2;
	}
}
