package project1;
import java.awt.Toolkit;
//�������г�������
public class Global {
	//ǽ������������������39���ϰ���
	static final int WIDTH = 39;
	//ǽ�������������������39���ϰ���
	static final int HEIGHT = 23;
	//ǽ��ÿ��Ϊ�����Σ��߳�Ϊ20
	static final int SZIE = 20;
	//����Ĭ�Ϸ���Ϊ�ҡ�1����>�ϣ�2����>�£�3����>��4����>��
	static int DIRECTION = 4;
	//���������Ƿ񶯣���δʵ�֣�
	static int RUN = 0;
	static int DRAW = 0;
	static int failed = 0;
	static int start = 0;
	static int map = 1;
	//ǽ������
	static int[][] border = new int[Global.WIDTH][Global.HEIGHT];
	static int Screen_w = Toolkit.getDefaultToolkit().getScreenSize().width;
	static int Screen_h  = Toolkit.getDefaultToolkit().getScreenSize().height;

	static int[] scores = new int[1000];
	static int j = 0;
	static int pre_dre = 4;
	static int speed = 160;
}
