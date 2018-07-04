package project1;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ObjectInputStream.GetField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//键盘控制类
public class KeyControlSnake extends JPanel{
	SnakeLaunch launch ;
	JLabel jlRock;
	public KeyControlSnake(SnakeLaunch launch,JLabel jlRock){
		this.launch = launch;
		this.jlRock = jlRock;
		//使窗体获取焦点
		launch.requestFocus();
		launch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				//判断如果点击向上按钮而且当前方向不是向下的，则方向改变为向上
				if(e.getKeyCode() == KeyEvent.VK_UP && Global.DIRECTION != 2){
					Global.DIRECTION = 1;
				
				//判断如果点击向下按钮而且当前方向不是向上的，则方向改变为向下
				}else if(e.getKeyCode() == KeyEvent.VK_DOWN && Global.DIRECTION != 1){
					Global.DIRECTION = 2;
				
				//判断如果点击向左按钮而且当前方向不是向右的，则方向改变为向左
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT && Global.DIRECTION != 4){
					Global.DIRECTION = 3;
					
				//判断如果点击向右按钮而且当前方向不是向左的，则方向改变为向右
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT && Global.DIRECTION != 3){
					Global.DIRECTION = 4;
					
				//使蛇开始动
				}else if(e.getKeyCode() == KeyEvent.VK_S){
					Global.speed -= 10;
					
				//使蛇开始动
				}else if(e.getKeyCode() == KeyEvent.VK_D){
					Global.speed += 10;
					
				//使蛇开始动
				}
			}
		});
	}
}
