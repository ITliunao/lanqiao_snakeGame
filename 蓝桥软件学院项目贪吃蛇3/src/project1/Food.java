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
	//ʳ���࣬���췽���г�ʼ��ʳ�����λ��
	public Food(SnakeLaunch launch){
		this.launch = launch;
		Random random = new Random();
		//ʳ�����λ�÷�ΧΪ5����30

		foodX = random.nextInt(25)+1;
	    //ʳ������λ�÷�ΧΪ20����34
	    foodY = random.nextInt(18)+1;
	}
	public void create(){
		Random random = new Random();
		foodX = random.nextInt(25)+1;
	    //ʳ������λ�÷�ΧΪ20����34
	    foodY = random.nextInt(18)+1;
	    for(int i = 0;i < launch.snakeNode.snakeX.size();i++){
	    	for(int j =0 ;j< launch.snakeNode.snakeY.size();j++){
	    		if(launch.snakeNode.snakeX.get(i) == foodX && launch.snakeNode.snakeY.get(j) == foodY){
	    			Random random2 = new Random();
	    			foodX = random2.nextInt(25)+1;
	    		    //ʳ������λ�÷�ΧΪ20����34
	    		    foodY = random2.nextInt(18)+1;
	    		}
	    	}
	    }
		repaint();
	}
}
