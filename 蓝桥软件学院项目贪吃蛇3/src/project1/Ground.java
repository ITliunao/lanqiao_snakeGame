package project1;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JLabel;
//ǽ����
public class Ground {
	public Ground(){
		for(int i = 0; i < Global.HEIGHT; i++){
			//�ڵ�һ�к����һ������ǽ��
			Global.border[0][i] = 1;
			Global.border[Global.WIDTH-1][i] = 1;
		}
		for(int i = 0; i < Global.WIDTH; i++){
			//�ڵ�һ�к����һ������ǽ��
			Global.border[i][0] = 1;
			Global.border[i][Global.HEIGHT-1] = 1;
		}
	}
	public static void drawMap1(){
		for(int i = 0; i < Global.HEIGHT; i++){
			//�ڵ�һ�к����һ������ǽ��
			Global.border[0][i] = 1;
			Global.border[Global.WIDTH-1][i] = 1;
		}
		for(int i = 0; i < Global.WIDTH; i++){
			//�ڵ�һ�к����һ������ǽ��
			Global.border[i][0] = 1;
			Global.border[i][Global.HEIGHT-1] = 1;
		}
	}
	public static void drawMap2(){
		for(int i = 0; i < Global.HEIGHT; i++){
			//�ڵ�һ�к����һ������ǽ��
			Global.border[0][i] = 1;
			Global.border[Global.WIDTH-1][i] = 1;
		}	
	}
	public static void drawMap3(){
		for(int i = 0; i < Global.WIDTH; i++){
			//�ڵ�һ�к����һ������ǽ��
			Global.border[i][0] = 1;
			Global.border[i][Global.HEIGHT-1] = 1;
		}
	}	
}
