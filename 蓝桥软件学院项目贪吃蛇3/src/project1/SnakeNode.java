package project1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//��������Ľڵ�
public class SnakeNode {
	static List<Integer>snakeX = new ArrayList<Integer>();
	static List<Integer>snakeY = new ArrayList<Integer>();
	int len;
	public SnakeNode(){
		//��ʼ���ߣ���ͷΪsnakeX[0]��snakeY[0]����ΪsnakeX[1]��snakeY[1]��snakeX[2] = 1��snakeY[2] = 12;�����峤Ϊ3
		snakeX.add(0, 7);
		snakeX.add(1, 6);
		snakeX.add(2, 5);
		snakeY.add(0, 12);
		snakeY.add(1, 12);
		snakeY.add(2, 12);
		len = 2;
	}
}
