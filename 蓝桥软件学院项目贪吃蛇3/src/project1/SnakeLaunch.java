package project1;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
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
	// 定义按钮，标签等组件
	CircleButton buttonBack;
	CircleButton buttonStart;
	CircleButton buttonEnd;
	CircleButton buttonPause;
	JLabel Score;
	JLabel num;
	URI uri;
	URL url;
	ImageIcon imgup = new ImageIcon("up.png");
	ImageIcon imgdown = new ImageIcon("down.png");
	ImageIcon imgleft = new ImageIcon("left.png");
	ImageIcon imgright = new ImageIcon("right.png");
	ImageIcon imgbody = new ImageIcon("body.png");
	ImageIcon imgfood = new ImageIcon("food1.png");
	ImageIcon start = new ImageIcon("start.png");
	ImageIcon pause = new ImageIcon("pause.png");
	ImageIcon end =  new ImageIcon("end.png");
	ImageIcon rock =  new ImageIcon("brick.png");
	ImageIcon back =  new ImageIcon("back.png");
	ImageIcon score =  new ImageIcon("score.png");
	// 墙壁数组
	// 将设置好的墙壁赋值给rock数组
	// 初始化蛇，蛇身长度为3
	SnakeNode snakeNode = new SnakeNode();
	int len = snakeNode.len;
	// 初始化食物
	Food food = new Food(this);
	JFrame frame = new JFrame();
	Music music = new Music();
	// SnakeLaunch构造方法
	public SnakeLaunch(JTextField user) {	
		frame.getContentPane().add(this);
		this.setOpaque(false);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu menu_map = new JMenu("地图切换");
		JMenu menu_rank = new JMenu("历史用户成绩");
		JMenu menu_about = new JMenu("关于");
		JMenuItem item_map1 = new JMenuItem("地图1");
		JMenuItem item_map2 = new JMenuItem("地图2");
		JMenuItem item_map3 = new JMenuItem("地图3");
		JMenuItem tx = new JMenuItem("游戏说明");
		JMenuItem rank = new JMenuItem("历史用户成绩");
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
				// TODO Auto-generated method stub
				String s = "这是一个贪吃蛇游戏\n" 
						+ "已经实现的功能有：\n" 
						+ "1.障碍物选择\n"
						+ "2.分数记录\n"
						+ "3.随时停止与开始\n"
						+"4.背景音乐实现\n";
				JOptionPane.showMessageDialog(null,s);
			}			
		});
			
		rank.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileReader reader = null;
				BufferedReader br = null;
				String str = null;
				StringBuffer sb = null;
				try {
					// read file content from file
					sb = new StringBuffer("");
					reader = new FileReader("file_out.txt");
					br = new BufferedReader(reader);
					while ((str = br.readLine()) != null) {
						sb.append(str + "\r\n");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				} finally {
					try {
						JOptionPane.showMessageDialog(null, sb, "已经注册用户成绩", JOptionPane.PLAIN_MESSAGE);
						br.close();
						reader.close();
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
		// 定义面板，并在这个面板上画出添加按钮，标签
		JPanel paneButton = new JPanel();
		paneButton.setOpaque(false);
		jframePanel.add(paneButton);
		paneButton.setBounds(0, 477, 770, 67);
		paneButton.setLayout(null);
		
		buttonBack = new CircleButton();
		buttonBack.setOpaque(false);
		buttonBack.setBounds(0, 10, 54, 54);
		buttonBack.setIcon(back);
		SnakeLaunch launch = this;
		/*buttonBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Global.RUN = 0;
				launch.music.aau.stop();
				launch.requestFocus();
				frame.dispose();
				new SnakeLogin();
			}
		});
		*/
		//paneButton.add(buttonBack);
		
		
		
		buttonStart = new CircleButton();
		buttonStart.setBounds(260, 20,41, 41);
		buttonStart.setIcon(start);
		//SnakeLaunch launch = this;
		buttonStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Global.failed == 1){
					Global.speed = 160;
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
		buttonPause = new CircleButton();
		buttonPause.setIcon(pause);
		buttonPause.setBounds(360, 20, 40, 40);
		buttonPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Global.RUN = 0;
				launch.music.aau.stop();
				launch.requestFocus();
			}
		});
		paneButton.add(buttonPause);
		buttonEnd = new CircleButton();
		buttonEnd.setIcon(end);
		buttonEnd.setBounds(460, 20, 42, 42);
		paneButton.add(buttonEnd);
		buttonEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Global.RUN = 0;
				launch.music.aau.stop();
				launch.requestFocus();
				if(JOptionPane.showConfirmDialog(null,"exit?")==JOptionPane.OK_OPTION){
					Arrays.sort(Global.scores);
					JOptionPane.showMessageDialog(null, "尊敬的用户："+user.getText().toString()+"，您的最高分是" +Global.scores[Global.scores.length-1]+"分");
					File f = new File("file_out.txt");
					FileOutputStream fos = null;
					try {
						fos = new FileOutputStream(f,true);
						fos.write((user.getText()+"得分："+Global.scores[Global.scores.length-1]+"分;").getBytes());
						fos.write("\r\n".getBytes());// 写入一个换行  
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
		Score = new JLabel(score);
		/*Score.setFont(new Font("宋体", Font.BOLD, 20));
		Score.setForeground(Color.red);*/
		Score.setBounds(560, -10, 100, 100);
		paneButton.add(Score);
		
		num = new JLabel("score:0");
		num.setFont(new Font("宋体", Font.BOLD, 20));
		num.setForeground(Color.red);
		num.setBounds(670, 20, 150, 50);
		paneButton.add(num);
		frame.getLayeredPane().add(paneButton, JLayeredPane.MODAL_LAYER);
		// 在标签上画出障碍物
		JLabel jlRock = new JLabel();
		Ground snakeGround = new Ground();
		
		jlRock.setBounds(0, 0, 798, 600);
		frame.getLayeredPane().add(jlRock, JLayeredPane.MODAL_LAYER);
		jlRock.setOpaque(false);
		food.setOpaque(false);
		frame.getLayeredPane().add(food, JLayeredPane.MODAL_LAYER);
		jframePanel.add(food);
		KeyControlSnake keyControlSnake = new KeyControlSnake(this,jlRock);
		ThreadControlSnake panelSnake = new ThreadControlSnake(this, snakeNode, food,user);
		
		panelSnake.setOpaque(false);
		frame.getLayeredPane().add(panelSnake, JLayeredPane.MODAL_LAYER);
		jframePanel.add(panelSnake);		
	}
	public void paint(Graphics g) {
		super.paint(g);
		// 依次画出蛇的每一个节点
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
		if(Global.failed == 0 ){
				for (int i = 0; i <= n.len; i++) {
					if(i==0 &&Global.DIRECTION == 1){
						imgup.paintIcon(this, g, n.snakeX.get(i)*20, n.snakeY.get(i)*20);
					}else if(i==0 &&Global.DIRECTION == 2){
						imgdown.paintIcon(this, g, n.snakeX.get(i)*20, n.snakeY.get(i)*20);
					}else if(i==0 &&Global.DIRECTION == 3){
						imgleft.paintIcon(this, g, n.snakeX.get(i)*20, n.snakeY.get(i)*20);
					}else if(i==0 &&Global.DIRECTION == 4){
						imgright.paintIcon(this, g, n.snakeX.get(i)*20, n.snakeY.get(i)*20);
					}
					imgbody.paintIcon(this, g, n.snakeX.get(i)*20, n.snakeY.get(i)*20);
					
				}
				Global.start = 0;
			
		}else{
			for (int i = 0; i <= 2; i++) {
				if(i==0 &&Global.DIRECTION == 1){
					imgup.paintIcon(this, g, n.snakeX.get(i)*20, n.snakeY.get(i)*20);
				}else if(i==0 &&Global.DIRECTION == 2){
					imgdown.paintIcon(this, g, n.snakeX.get(i)*20, n.snakeY.get(i)*20);
				}else if(i==0 &&Global.DIRECTION == 3){
					imgleft.paintIcon(this, g, n.snakeX.get(i)*20, n.snakeY.get(i)*20);
				}else if(i==0 &&Global.DIRECTION == 4){
					imgright.paintIcon(this, g, n.snakeX.get(i)*20, n.snakeY.get(i)*20);
				}
				imgbody.paintIcon(this, g, n.snakeX.get(i)*20, n.snakeY.get(i)*20);
			}
		}
		
	}
}