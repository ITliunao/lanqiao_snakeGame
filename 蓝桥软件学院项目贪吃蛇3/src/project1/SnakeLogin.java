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
    //�����û������������򣬵�¼��ť�����ð�ť
	private JTextField tfuserName;
	private JPasswordField tfPwd;
	private JButton buttonLogin;
	private JButton buttonReset;
	public SnakeLogin() {
	    setBounds((Global.Screen_w-650)/2,(Global.Screen_h-360)/2,650,360);
        //���ô���ر�
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
        //��ͼƬ�����ڱ�ǩ��
		Image imageBackground = new ImageIcon("snake.jpg").getImage();
		JLabel lblBgLabel = new JLabel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(imageBackground, 0, 0,this.getWidth(),this.getHeight(), this);
			}
		};
		lblBgLabel.setSize(650,360);
        //ʵ��������������������
		JPanel jframePanel = (JPanel) getContentPane();
        //����������������Ϊ͸��
		jframePanel.setOpaque(false);
        //��lblBgLabel����Ϊ�ײ�����DEFAULT_LAYER
		getLayeredPane().add(lblBgLabel,JLayeredPane.DEFAULT_LAYER);
        //ʵ���������û����������������Ϣ��壬���ҽ���Щ������뵽�����
		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(220, 25, 375, 123);
		panelInfo.setLayout(null);
		JLabel userNameLabel = new JLabel("�û�����");
		userNameLabel.setBounds(37, 24, 54, 15);
		panelInfo.add(userNameLabel);
		tfuserName = new JTextField();
		tfuserName.setBounds(86, 21, 180, 21);
		panelInfo.add(tfuserName);
		JLabel pwdLabel = new JLabel("���룺");
		pwdLabel.setBounds(37, 71, 54, 15);
		panelInfo.add(pwdLabel);
		tfPwd = new JPasswordField();
		tfPwd.setBounds(86, 68, 180, 21);
		panelInfo.add(tfPwd);
        //����Ϣ�������Ϊ͸��
		panelInfo.setOpaque(false);
        //����Ϣ�������Ϊ�ײ�����MODAL_LAYER
		getLayeredPane().add(panelInfo,JLayeredPane.MODAL_LAYER);
        //���岢��ʵ������ť��壬�����������Ӱ�ť���
		JPanel paneButton = new JPanel();
		paneButton.setBounds(247, 268, 401, 23);	
		paneButton.setLayout(null);		
		buttonLogin = new JButton("��¼");
		buttonLogin.setBounds(10, 0, 93, 23);
		paneButton.add(buttonLogin);		
		buttonReset = new JButton("����");
		buttonReset.setBounds(258, 0, 93, 23);
		paneButton.add(buttonReset);
        //����ť�������Ϊ͸��
		paneButton.setOpaque(false);
        //����ť�������Ϊ�ײ�����MODAL_LAYER
		getLayeredPane().add(paneButton,JLayeredPane.MODAL_LAYER);
        //��ť�¼�����������û����ǣ�"����"�������ǣ�"123456"����ô����ת����Ϸ��ʼ����
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = tfuserName.getText();
				String pwd = tfPwd.getText();

				/*if(userName.equals("liunao") && pwd.equals("123456")){
                    //ʹ��ǰ���嶪��
					dispose();
                    //���½�����һ������
					new SnakeLaunch(tfuserName);
				}*/	
				dispose();
                //���½�����һ������
				new SnakeLaunch(tfuserName);			

			}
		});
        //��ť�¼�������ʹ�����������
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
