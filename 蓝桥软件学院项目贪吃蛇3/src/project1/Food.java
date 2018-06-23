package project1;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
public class Food extends JPanel{
	int foodX;
	int foodY;
	SnakeLaunch launch;
	Random random = new Random();
	Color color = new Color(144, 177, 89);
	//食物类，构造方法中初始化食物出现位置
	public Food(SnakeLaunch launch){
		this.launch = launch;
		Random random = new Random();
		//食物横向位置范围为5——30

		foodX = random.nextInt(25)+1;
	    //食物纵向位置范围为20——34
	    foodY = random.nextInt(10)+1;
	}
	public void create(){
		Random random = new Random();
		foodX = random.nextInt(25)+1;
	    //食物纵向位置范围为20——34
	    foodY = random.nextInt(10)+1;

		repaint();
	}
}
