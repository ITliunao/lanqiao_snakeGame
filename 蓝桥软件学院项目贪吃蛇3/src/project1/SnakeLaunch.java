package project1;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JApplet;
import sun.audio.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
public class SnakeLaunch extends JPanel{
	// ���尴ť����ǩ�����
	JButton buttonStart;
	JButton buttonEnd;
	JButton buttonPause;
	JLabel Score;
	URI uri;
	URL url;
	ImageIcon imgup = new ImageIcon("up.png");
	ImageIcon imgdown = new ImageIcon("down.png");
	ImageIcon imgleft = new ImageIcon("left.png");
	ImageIcon imgright = new ImageIcon("right.png");
	ImageIcon imgbody = new ImageIcon("body.png");
	ImageIcon imgfood = new ImageIcon("food1.png");
	ImageIcon start = new ImageIcon("start2.jpg");
	ImageIcon pause = new ImageIcon("pause.png");
	ImageIcon end =  new ImageIcon("end.jpg");
	ImageIcon rock =  new ImageIcon("brick.png");
	// ǽ������
	// �����úõ�ǽ�ڸ�ֵ��rock����
	// ��ʼ���ߣ�������Ϊ3
	SnakeNode snakeNode = new SnakeNode();
	int len = snakeNode.len;
	// ��ʼ��ʳ��
	Food food = new Food(this);
	JFrame frame = new JFrame();
	Music music = new Music();
	// SnakeLaunch���췽��
	public SnakeLaunch(JTextField user) {
		
		frame.getContentPane().add(this);
		this.setOpaque(false);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu menu_map = new JMenu("��ͼ�л�");
		JMenu menu_rank = new JMenu("��ʷ�û��ɼ�");
		JMenu menu_about = new JMenu("����");
		JMenuItem item_map1 = new JMenuItem("��ͼ1");
		JMenuItem item_map2 = new JMenuItem("��ͼ2");
		JMenuItem item_map3 = new JMenuItem("��ͼ3");
		JMenuItem tx = new JMenuItem("��Ϸ˵��");
		JMenuItem rank = new JMenuItem("��ʷ�û��ɼ�");
		item_map1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < Global.border.length; i++){
					for(int j = 0; j < Global.border[i].length ; j++){
						Global.border[i][j] = 0;
					}
				}
				Ground.drawMap1();
				Global.map = 1;
				repaint();	
			}
		});
		item_map2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < Global.border.length; i++){
					for(int j = 0; j < Global.border[i].length ; j++){
						Global.border[i][j] = 0;
					}
				}
				Global.map = 2;
				Ground.drawMap2();
				repaint();	
			}
		});
		item_map3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < Global.border.length; i++){
					for(int j = 0; j < Global.border[i].length ; j++){
						Global.border[i][j] = 0;
					}
				}
				Global.map = 3;
				Ground.drawMap3();
				repaint();	
			}
		});
		tx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = "����һ��̰������Ϸ\n" 
						+ "�Ѿ�ʵ�ֵĹ����У�\n" 
						+ "1.�ϰ���ѡ��\n"
						+ "2.������¼\n"
						+ "3.��ʱֹͣ�뿪ʼ\n"
						+"4.��������ʵ��\n";
				JOptionPane.showMessageDialog(null, s,"��Ϸ˵��",JOptionPane.PLAIN_MESSAGE);
			}
		});
		rank.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File f = new File("file_out.txt");
				FileInputStream fis = null;
				String name = "";
				try {
					int len = 0;
					byte[] b = new byte[84];
					fis = new FileInputStream(f);
					while((len = fis.read(b))!=-1){
						name = new String(b);
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						JOptionPane.showMessageDialog(null, name,"�Ѿ�ע���û��ɼ�",JOptionPane.PLAIN_MESSAGE);
						fis.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
				
			}
		});
		menu_map.add(item_map1);
		menu_map.add(item_map2);
		menu_map.add(item_map3);
		menu_about.add(tx);
		menu_rank.add(rank);
		menuBar.add(menu_map);
		menuBar.add(menu_rank);
		menuBar.add(menu_about);
		this.setLayout(null);
		frame.setBounds((Global.Screen_w-798)/2, (Global.Screen_h-600)/2, 798, 600);
		this.setBounds((Global.Screen_w-798)/2, (Global.Screen_h-600)/2, 798, 600);
		frame.setVisible(true);		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);		
		Container jframePanel = (JPanel)frame.getContentPane();
		//((JComponent) jframePanel).setOpaque(false);		
		//JPanel panelbar =new JPanel();		
		Image imageBackground = new ImageIcon("snake_game.jpg").getImage();
		JLabel jlBackground = new JLabel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imageBackground, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		jlBackground.setSize(800, 600);
		((JComponent) jframePanel).setOpaque(false);
		frame.getLayeredPane().add(jlBackground, new Integer(Integer.MIN_VALUE));
		// ������壬�����������ϻ�����Ӱ�ť����ǩ
		JPanel paneButton = new JPanel();
		paneButton.setOpaque(false);
		jframePanel.add(paneButton);
		paneButton.setBounds(247, 477, 1000, 67);
		paneButton.setLayout(null);
		buttonStart = new JButton();
		buttonStart.setBounds(10, 22, 70, 23);
		buttonStart.setIcon(start);
		SnakeLaunch launch = this;
		buttonStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Global.failed == 1){
					Global.failed = 0;
					Global.start = 1;
					SnakeNode n = ThreadControlSnake.n;
					n.len = 2;
				}
				Global.RUN = 1;
				launch.music.aau.loop();
				Global.DRAW = 1;
				launch.requestFocus();
			}
		});
		paneButton.add(buttonStart);
		buttonPause = new JButton();
		buttonPause.setIcon(pause);
		buttonPause.setBounds(134, 22, 70, 23);
		buttonPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Global.RUN = 0;
				launch.music.aau.stop();
				launch.requestFocus();
			}
		});
		paneButton.add(buttonPause);
		buttonEnd = new JButton();
		buttonEnd.setIcon(end);
		buttonEnd.setBounds(258, 22, 70, 23);
		paneButton.add(buttonEnd);
		buttonEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Global.RUN = 0;
				launch.music.aau.stop();
				launch.requestFocus();
				if(JOptionPane.showConfirmDialog(null,"exit?")==JOptionPane.OK_OPTION){
					Arrays.sort(Global.scores);
					JOptionPane.showMessageDialog(null, "�𾴵��û���"+user.getText().toString()+"��������߷���" +Global.scores[Global.scores.length-1]+"��");
					File f = new File("file_out.txt");
					FileOutputStream fos = null;
					try {
						fos = new FileOutputStream(f,true);
						fos.write((user.getText()+"�÷֣�"+Global.scores[Global.scores.length-1]+"��;").getBytes());
						fos.write("\r\n".getBytes());// д��һ������  
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally {
						try {
							fos.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					System.exit(0);
				}	    
			}
		});
		frame.getLayeredPane().add(paneButton, JLayeredPane.MODAL_LAYER);
		Score = new JLabel("scores:0");
		Score.setFont(new Font("����", Font.BOLD, 20));
		Score.setForeground(Color.red);
		Score.setBounds(342, 22, 600, 23);
		paneButton.add(Score);
		frame.getLayeredPane().add(paneButton, JLayeredPane.MODAL_LAYER);
		// �ڱ�ǩ�ϻ����ϰ���
		JLabel jlRock = new JLabel();
		Ground snakeGround = new Ground();
		KeyControlSnake keyControlSnake = new KeyControlSnake(this,jlRock);
		jlRock.setBounds(0, 0, 798, 600);
		frame.getLayeredPane().add(jlRock, JLayeredPane.MODAL_LAYER);
		jlRock.setOpaque(false);
		food.setOpaque(false);
		frame.getLayeredPane().add(food, JLayeredPane.MODAL_LAYER);
		jframePanel.add(food);
		ThreadControlSnake panelSnake = new ThreadControlSnake(this, snakeNode, food,user);
		panelSnake.setOpaque(false);
		frame.getLayeredPane().add(panelSnake, JLayeredPane.MODAL_LAYER);
		jframePanel.add(panelSnake);		
	}
	public void paint(Graphics g) {
		super.paint(g);
		// ���λ����ߵ�ÿһ���ڵ�
		for (int i = 0; i < Global.WIDTH; i++) {
			for (int j = 0; j < Global.HEIGHT; j++) {
				if (Global.border[i][j] == 1) {
					/*g.setColor(new Color(192, 192, 192));
					g.fill3DRect(i * Global.SZIE, j * Global.SZIE, Global.SZIE, Global.SZIE, true);*/
					rock.paintIcon(this, g, i * Global.SZIE, j * Global.SZIE);
				}
			}
		}
		if (Global.DRAW == 1) {
			drawNode(g, snakeNode);
			imgfood.paintIcon(this, g, food.foodX*20, food.foodY*20);
		}
		
	}
	public void drawNode(Graphics g, SnakeNode n) {
		g.setColor(new Color(90, 189, 177));
		if(Global.failed == 0 ){
				for (int i = 0; i <= n.len; i++) {
					if(i==0 &&Global.DIRECTION == 1){
						imgup.paintIcon(this, g, n.snakeX[i]*20, n.snakeY[i]*20);
					}else if(i==0 &&Global.DIRECTION == 2){
						imgdown.paintIcon(this, g, n.snakeX[i]*20, n.snakeY[i]*20);
					}else if(i==0 &&Global.DIRECTION == 3){
						imgleft.paintIcon(this, g, n.snakeX[i]*20, n.snakeY[i]*20);
					}else if(i==0 &&Global.DIRECTION == 4){
						imgright.paintIcon(this, g, n.snakeX[i]*20, n.snakeY[i]*20);
					}
					imgbody.paintIcon(this, g, n.snakeX[i]*20, n.snakeY[i]*20);
					
				}
				Global.start = 0;
			
		}else{
			for (int i = 0; i <= 2; i++) {
				if(i==0 &&Global.DIRECTION == 1){
					imgup.paintIcon(this, g, n.snakeX[i]*20, n.snakeY[i]*20);
				}else if(i==0 &&Global.DIRECTION == 2){
					imgdown.paintIcon(this, g, n.snakeX[i]*20, n.snakeY[i]*20);
				}else if(i==0 &&Global.DIRECTION == 3){
					imgleft.paintIcon(this, g, n.snakeX[i]*20, n.snakeY[i]*20);
				}else if(i==0 &&Global.DIRECTION == 4){
					imgright.paintIcon(this, g, n.snakeX[i]*20, n.snakeY[i]*20);
				}
				imgbody.paintIcon(this, g, n.snakeX[i]*20, n.snakeY[i]*20);
			}
		}
		
	}
}