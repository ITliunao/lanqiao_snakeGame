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
	    foodY = random.nextInt(10)+1;
	}
	public void create(){
		Random random = new Random();
		foodX = random.nextInt(25)+1;
	    //ʳ������λ�÷�ΧΪ20����34
	    foodY = random.nextInt(10)+1;

		repaint();
	}
}
