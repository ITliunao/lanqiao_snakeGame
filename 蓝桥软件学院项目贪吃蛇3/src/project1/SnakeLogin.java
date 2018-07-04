package project1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
public class SnakeLogin extends JFrame{
    //定义用户名输入框，密码框，登录按钮，重置按钮
	private JTextField tfuserName;
	private JPasswordField tfPwd;
	private JButton buttonLogin = new JButton();
	private JButton buttonReset = new JButton();
	public SnakeLogin() {
	    setBounds((Global.Screen_w-460)/2,(Global.Screen_h-600)/2,460,600);
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
		lblBgLabel.setSize(460,600);
        //实例化放置内容组件的面板
		JPanel jframePanel = (JPanel) getContentPane();
        //将这个内容面板设置为透明
		jframePanel.setOpaque(false);
        //将lblBgLabel设置为底层面板的DEFAULT_LAYER
		getLayeredPane().add(lblBgLabel,JLayeredPane.DEFAULT_LAYER);
        //实例化放置用户名输入框，密码框的信息面板，并且将这些组件加入到该面板
		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(50, 25, 375, 123);
		panelInfo.setLayout(null);
		JLabel userNameLabel = new JLabel("用户名：");
		userNameLabel.setForeground(Color.red);
		userNameLabel.setFont(new Font("宋体", Font.BOLD, 20));
		userNameLabel.setBounds(0, 24, 500, 20);
		panelInfo.add(userNameLabel);
		tfuserName = new JTextField();
		tfuserName.setBounds(86, 21, 180, 21);
		panelInfo.add(tfuserName);
		JLabel pwdLabel = new JLabel("密码：");
		pwdLabel.setForeground(Color.red);
		pwdLabel.setFont(new Font("宋体", Font.BOLD, 20));
		pwdLabel.setBounds(0, 71,500, 20);
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
		paneButton.setBounds(60, 525, 401, 32);	
		paneButton.setLayout(null);		
	
		
		
		ImageIcon login =  new ImageIcon("login.jpg");
		buttonLogin.setIcon(login);
		buttonLogin.setBounds(10, 0, 93, 32);
		paneButton.add(buttonLogin);
		ImageIcon reset =  new ImageIcon("reset.jpg");
		buttonReset.setIcon(reset);
		buttonReset.setBounds(258, 0, 93, 32);
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

				if(!(userName.equals("") )&& pwd.length()>=6){
                    //使当前窗体丢弃
					dispose();
                    //重新进入另一个窗体
					new SnakeLaunch(tfuserName);
				}else{
					JOptionPane.showMessageDialog(null, "您的用户名不能为空，而且必须设置六位以上密码");
				}	
				
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
