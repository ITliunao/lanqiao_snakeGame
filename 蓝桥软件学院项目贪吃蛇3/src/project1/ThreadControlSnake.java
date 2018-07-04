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
			//System.out.println();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(Global.RUN == 1){
				for(int j = n.len;j >0 ; j--){
					n.snakeX.set(j, n.snakeX.get(j-1));
					n.snakeY.set(j, n.snakeY.get(j-1));
				}
				//���ƶ�ʱ����ʱ��ǰ������*�ߵĳ��ȣ������൱��ÿһ����ǰ���ƶ���һλ��
			
				if(Global.DIRECTION == 1){
					//�����ǰ�������ϣ���ô��ͷ�����ƶ���
						n.snakeY.set(0, n.snakeY.get(0)-1);
					//�����ͷ�˶���ʳ��λ�ã���ô�������ӣ�ʳ�����³��֣����ߵ�ǰ���峤�ȴ������
					if(n.snakeY.get(0) == food.foodY&& n.snakeX.get(0) == food.foodX){
						food.create();
						n.len++;
						launch.num.setText("score:" + (n.len-2));
						n.snakeY.add(n.len, n.snakeY.get(n.len-1)) ;
						n.snakeX.add(n.len, n.snakeX.get(n.len-1));
					}
				}
				else if(Global.DIRECTION == 2){
					
					n.snakeY.set(0, n.snakeY.get(0)+1);
					
					if(n.snakeY.get(0) == food.foodY&& n.snakeX.get(0) == food.foodX){
						food.create();
						n.len++;
						launch.num.setText("score:" + (n.len-2));
						n.snakeY.add(n.len, n.snakeY.get(n.len-1)) ;
						n.snakeX.add(n.len, n.snakeX.get(n.len-1));
					}
				}
				else if(Global.DIRECTION == 3){
					
					n.snakeX.set(0, n.snakeX.get(0)-1);
					
					if(n.snakeY.get(0) == food.foodY&& n.snakeX.get(0) == food.foodX){
						food.create();
						n.len++;
						launch.num.setText("score:" + (n.len-2));
						n.snakeY.add(n.len, n.snakeY.get(n.len-1)) ;
						n.snakeX.add(n.len, n.snakeX.get(n.len-1));
					}
				}
				else{
					
					n.snakeX.set(0, n.snakeX.get(0)+1);
					
					if(n.snakeY.get(0) == food.foodY&& n.snakeX.get(0) == food.foodX){
						food.create();
						n.len++;
						launch.num.setText("score:" + (n.len-2));
						n.snakeY.add(n.len, n.snakeY.get(n.len-1)) ;
						n.snakeX.add(n.len, n.snakeX.get(n.len-1));
					}
				}
				int i = 1;
				for(;i <= n.len; i++){
					//����ߵ�ͷ�����ߵ������κ�һ���ֳ�����ͬһλ�ã���Ϸ��������ͷ����ǽ�ڣ���ϷҲ����
					if(Global.map == 1){
						
						if( n.snakeY.get(0)  > 21&&Global.DIRECTION==2  ||(n.snakeX.get(0) == n.snakeX.get(i) && n.snakeY.get(0) == n.snakeY.get(i) ) ){
							
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.scores[Global.j++] = n.len-2;
							Global.failed = 1;
							break;
						}else if(n.snakeY.get(0)  < 1 || (n.snakeX.get(0) == n.snakeX.get(i) && n.snakeY.get(0) == n.snakeY.get(i) )){
							
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}
						else if( n.snakeX.get(0)  < 1 || (n.snakeX.get(0) == n.snakeX.get(i) && n.snakeY.get(0) == n.snakeY.get(i) )){
							
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}else if( n.snakeX.get(0)  >37||(n.snakeX.get(0) == n.snakeX.get(i) && n.snakeY.get(0) == n.snakeY.get(i) ) ){
							
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}
					}
					if(Global.map == 2){
						if( n.snakeX.get(0) < 2 || (n.snakeX.get(0) == n.snakeX.get(i) && n.snakeY.get(0) == n.snakeY.get(i) )){
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}else if(  n.snakeX.get(0) >36||(n.snakeX.get(0) == n.snakeX.get(i) && n.snakeY.get(0) == n.snakeY.get(i))){
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}
						
						if( n.snakeY.get(0)  > 20){
							n.snakeY.set(0,0);
						}else if(n.snakeY.get(0)  < 0 ){
							n.snakeY.set(0,20);
						}
					}
					if(Global.map == 3){
						if(  n.snakeY.get(0)  > 20||(n.snakeX.get(0) == n.snakeX.get(i) && n.snakeY.get(0) == n.snakeY.get(i))){
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}else if( n.snakeY.get(0) < 2 || (n.snakeX.get(0) == n.snakeX.get(i) && n.snakeY.get(0) == n.snakeY.get(i))){
							JOptionPane.showMessageDialog(null,"��Ϸʧ�ܣ�" + "�𾴵��û���"+user.getText().toString()+"�����ĵ÷���" + (n.len-2)+"��");
							Global.failed = 1;
							Global.scores[Global.j++] = n.len-2;
							break;
						}
						if( n.snakeX.get(0)  > 38){
							n.snakeX.set(0,0) ;
						}else if(n.snakeX.get(0)  < 0 ){
							n.snakeX.set(0, 38);
						}						
					}
				}
				if(Global.failed == 1){
					Global.RUN = 0;
					Global.DIRECTION = 4;
					SnakeNode n =new SnakeNode();
					n.len = 2;
					launch.num.setText("score:0" );
					food.create();
				}
				try{
					Thread.sleep(Global.speed);
				}catch(Exception e){

				}
				launch.repaint();
			}
	}
}
		
	}

