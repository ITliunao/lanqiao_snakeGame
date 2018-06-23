package project1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
public class SnakeLogin extends JFrame{
    //定义用户名输入框，密码框，登录按钮，重置按钮
	private JTextField tfuserName;
	private JPasswordField tfPwd;
	private JButton buttonLogin;
	private JButton buttonReset;
	public SnakeLogin() {
	    setBounds((Global.Screen_w-650)/2,(Global.Screen_h-360)/2,650,360);
        //设置窗体关闭
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
        //将图片放置在标签中
		Image imageBackground = new ImageIcon("snake.jpg").getImage();
		JLabel lblBgLabel = new JLabel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(imageBackground, 0, 0,this.getWidth(),this.getHeight(), this);
			}
		};
		lblBgLabel.setSize(650,360);
        //实例化放置内容组件的面板
		JPanel jframePanel = (JPanel) getContentPane();
        //将这个内容面板设置为透明
		jframePanel.setOpaque(false);
        //将lblBgLabel设置为底层面板的DEFAULT_LAYER
		getLayeredPane().add(lblBgLabel,JLayeredPane.DEFAULT_LAYER);
        //实例化放置用户名输入框，密码框的信息面板，并且将这些组件加入到该面板
		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(220, 25, 375, 123);
		panelInfo.setLayout(null);
		JLabel userNameLabel = new JLabel("用户名：");
		userNameLabel.setBounds(37, 24, 54, 15);
		panelInfo.add(userNameLabel);
		tfuserName = new JTextField();
		tfuserName.setBounds(86, 21, 180, 21);
		panelInfo.add(tfuserName);
		JLabel pwdLabel = new JLabel("密码：");
		pwdLabel.setBounds(37, 71, 54, 15);
		panelInfo.add(pwdLabel);
		tfPwd = new JPasswordField();
		tfPwd.setBounds(86, 68, 180, 21);
		panelInfo.add(tfPwd);
        //将信息面板设置为透明
		panelInfo.setOpaque(false);
        //将信息面板设置为底层面板的MODAL_LAYER
		getLayeredPane().add(panelInfo,JLayeredPane.MODAL_LAYER);
        //定义并且实例化按钮面板，在面板里面添加按钮组件
		JPanel paneButton = new JPanel();
		paneButton.setBounds(247, 268, 401, 23);	
		paneButton.setLayout(null);		
		buttonLogin = new JButton("登录");
		buttonLogin.setBounds(10, 0, 93, 23);
		paneButton.add(buttonLogin);		
		buttonReset = new JButton("重置");
		buttonReset.setBounds(258, 0, 93, 23);
		paneButton.add(buttonReset);
        //将按钮面板设置为透明
		paneButton.setOpaque(false);
        //将按钮面板设置为底层面板的MODAL_LAYER
		getLayeredPane().add(paneButton,JLayeredPane.MODAL_LAYER);
        //按钮事件监听，如果用户名是："刘闹"，密码是："123456"，那么就跳转至游戏开始界面
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = tfuserName.getText();
				String pwd = tfPwd.getText();

				/*if(userName.equals("liunao") && pwd.equals("123456")){
                    //使当前窗体丢弃
					dispose();
                    //重新进入另一个窗体
					new SnakeLaunch(tfuserName);
				}*/	
				dispose();
                //重新进入另一个窗体
				new SnakeLaunch(tfuserName);			

			}
		});
        //按钮事件监听，使输入内容清空
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfuserName.setText("");
				tfPwd.setText("");
			}
		});
	}
	public static void main(String[] args) {
		new SnakeLogin();
	}
}
