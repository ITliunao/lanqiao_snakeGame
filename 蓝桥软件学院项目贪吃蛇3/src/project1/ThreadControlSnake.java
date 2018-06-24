package project1;
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//�ö��߳̿����߶�����
public class ThreadControlSnake extends JPanel implements Runnable {
	SnakeLaunch launch;
	static SnakeNode n;
	Food food;
	JTextField user;

	public ThreadControlSnake(SnakeLaunch launch, SnakeNode snakeNode, Food food, JTextField user) {
		this.food = food;
		n = snakeNode;
		this.user = user;
		this.launch = launch;
		launch.requestFocus();
		// ��ʼ�߳�
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		while(true){
			System.out.println();
			if(Global.RUN == 1){
				for(int j = n.len;j >0 ; j--){
					n.snakeX[j] = n.snakeX[j-1];
					n.snakeY[j] = n.snakeY[j-1];
				}
				//���ƶ�ʱ����ʱ��ǰ������*�ߵĳ��ȣ������൱��ÿһ����ǰ���ƶ���һλ��
			
				if(Global.DIRECTION == 1){
					//�����ǰ�������ϣ���ô��ͷ�����ƶ���
						n.snakeY[0]--;
					//�����ͷ�˶���ʳ��λ�ã���ô�������ӣ�ʳ�����³��֣����ߵ�ǰ���峤�ȴ������
					if(n.snakeY[0] == food.foodY&& n.snakeX[0] == food.foodX){
						food.create();
						n.len++;
						launch.Score.setText("score:" + (n.len-2));
						n.snakeY[n.len] = n.snakeY[n.len-1];
						n.snakeX[n.len] = n.snakeX[n.len-1];
					}
				}
				else if(Global.DIRECTION == 2){
					
					n.snakeY[0] ++;
					
					if(n.snakeY[0] == food.foodY&& n.snakeX[0] == food.foodX){
						food.create();
						n.len++;
						launch.Score.setText("score:" + (n.len-2));
						n.snakeY[n.len] = n.snakeY[n.len-1];
						n.snakeX[n.len] = n.snakeX[n.len-1];
					}
				}
				else if(Global.DIRECTION == 3){
					
					n.snakeX[0]--;
					
					if(n.snakeY[0] == food.foodY&& n.snakeX[0] == food.foodX){
						food.create();
						n.len++;
						launch.Score.setText("score:" + (n.len-2));
						n.snakeY[n.len] = n.snakeY[n.len-1];
						n.snakeX[n.len] = n.snakeX[n.len-1];
					}
				}
				else{
					
					n.snakeX[0]++;
					
					if(n.snakeY[0] == food.foodY&& n.snakeX[0] == food.foodX){
						food.create();
						n.len++;
						launch.Score.setText("score:" + (n.len-2));
						n.snakeY[n.len] = n.snakeY[n.len-1];
						n.snakeX[n.len] = n.snakeX[n.len-1];
					}
				}
				int i = 1;
				for(;i <= n.len; i++){
					//����ߵ�ͷ�����ߵ������κ�һ���ֳ�����ͬһλ�ã���Ϸ��������ͷ����ǽ�ڣ���ϷҲ����
					if(Global.map == 1){
						
						if( n.snakeY[0]  > 21  ||(n.snakeX[0] == n.snakeX[i] && n.snakeY[0] == n.snakeY[i] ) ){
							
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.scores[Global.j++] = n.len-2;
							Global.failed = 1;
							break;
						}else if(n.snakeY[0]  < 1 || (n.snakeX[0] == n.snakeX[i] && n.snakeY[0] == n.snakeY[i])){
							System.out.println(Global.DIRECTION);
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}
						else if( n.snakeX[0]  < 1 || (n.snakeX[0] == n.snakeX[i] &&  n.snakeY[0] == n.snakeY[i])){
							System.out.println(Global.DIRECTION);
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}else if( n.snakeX[0]  >37||(n.snakeX[0] == n.snakeX[i] &&  n.snakeY[0] == n.snakeY[i] )){
							System.out.println(Global.DIRECTION);
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}
					}
					if(Global.map == 2){
						if( n.snakeX[0] < 2 || (n.snakeX[0] == n.snakeX[i] &&  n.snakeY[0] == n.snakeY[i])){
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}else if( n.snakeX[0] >36||(n.snakeX[0] == n.snakeX[i] &&  n.snakeY[0] == n.snakeY[i])){
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}
						
						if( n.snakeY[0]  > 20){
							n.snakeY[0] = 0;
						}else if(n.snakeY[0]  < 0 ){
							n.snakeY[0] = 20;
						}
					}
					if(Global.map == 3){
						if( n.snakeY[0]  > 20||(n.snakeX[0] == n.snakeX[i] && n.snakeY[0] == n.snakeY[i])){
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}else if(n.snakeY[0] < 2 || (n.snakeX[0] == n.snakeX[i] && n.snakeY[0] == n.snakeY[i])){
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}
						if( n.snakeX[0]  > 38){
							n.snakeX[0] = 0;
						}else if(n.snakeX[0]  < 0 ){
							n.snakeX[0] = 38;
						}						
					}
				}
				if(Global.failed == 1){
					Global.RUN = 0;
					Global.DIRECTION = 4;
					SnakeNode n =new SnakeNode();
					n.len = 2;
					launch.Score.setText("score:0" );
					food.create();
				}
				try{
					if(n.len > 3){
						Thread.sleep(140);
					}else{
						Thread.sleep(160);
					}
				}catch(Exception e){

				}
				launch.repaint();
			}
	}
}
		
	}

