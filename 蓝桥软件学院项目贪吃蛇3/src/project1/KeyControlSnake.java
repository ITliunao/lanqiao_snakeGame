package project1;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ObjectInputStream.GetField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//���̿�����
public class KeyControlSnake extends JPanel{
	SnakeLaunch launch ;
	JLabel jlRock;
	public KeyControlSnake(SnakeLaunch launch,JLabel jlRock){
		this.launch = launch;
		this.jlRock = jlRock;
		//ʹ�����ȡ����
		launch.requestFocus();
		launch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				//�ж����������ϰ�ť���ҵ�ǰ���������µģ�����ı�Ϊ����
				if(e.getKeyCode() == KeyEvent.VK_UP && Global.DIRECTION != 2){
					Global.DIRECTION = 1;
				
				//�ж����������°�ť���ҵ�ǰ���������ϵģ�����ı�Ϊ����
				}else if(e.getKeyCode() == KeyEvent.VK_DOWN && Global.DIRECTION != 1){
					Global.DIRECTION = 2;
				
				//�ж�����������ť���ҵ�ǰ���������ҵģ�����ı�Ϊ����
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT && Global.DIRECTION != 4){
					Global.DIRECTION = 3;
					
				//�ж����������Ұ�ť���ҵ�ǰ����������ģ�����ı�Ϊ����
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT && Global.DIRECTION != 3){
					Global.DIRECTION = 4;
					
				//ʹ�߿�ʼ��
				}
			}
		});
	}
}
