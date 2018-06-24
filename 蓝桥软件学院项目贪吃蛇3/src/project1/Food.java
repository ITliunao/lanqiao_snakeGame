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
	    for(int i = 0;i < launch.snakeNode.snakeX.length;i++){
	    	for(int j =0 ;j< launch.snakeNode.snakeY.length;j++){
	    		if(launch.snakeNode.snakeX[i] == foodX && launch.snakeNode.snakeY[i] == foodY){
	    			Random random2 = new Random();
	    			foodX = random2.nextInt(25)+1;
	    		    //食物纵向位置范围为20——34
	    		    foodY = random2.nextInt(10)+1;
	    		}
	    	}
	    }
		repaint();
	}
}
