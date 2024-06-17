
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class cover extends JFrame implements ActionListener{
	
	JButton login=new JButton();
	
	JButton login1=new JButton();
	
	public cover() {
		//初始化界面的方法调用
		initFrame();
		//初始化view
		initView() ;
		//初始化界面的图片
		initImage();
		this.setVisible(true);
	}
	private void initFrame() {
		//初始化界面
		this.setTitle("开始");
		this.setSize(715, 745);
		this.setLayout(null);
				
	}
	private void initImage() {
	//背景图
		
		JLabel Jbg=new JLabel(new ImageIcon("src\\image\\选择log-in或sign-up.png"));
		Jbg.setBounds(0, 0,700,700);
		this.getContentPane().add(Jbg);
	}
	private void initView() {
		login.setBounds(235,382,231,67);
		login.setIcon(new ImageIcon("src\\image\\log-in  bottom (1).png"));
		login.setBorderPainted(false);
		login.setContentAreaFilled(false);
		this.getContentPane().add(login);
		//给button加动作监听
		//这里需要后端自己在loginpage这个类中加在什么情况跳转到home
		login.addActionListener(this);
		
		
		
		login1.setBounds(235,475, 231, 67);
		login1.setIcon(new ImageIcon("src\\image\\sign-up bottom.png"));
		login1.setBorderPainted(false);
		login1.setContentAreaFilled(false);
		this.getContentPane().add(login1);
		//给button加动作监听
		//这里需要后端自己在registerpage这个类中加在什么情况跳转到home
		login1.addActionListener(this);
		
	}
	
	
	 /** --------------------------------------- **/
    /** DO NOT CHANGE ANYTHING IN THESE METHODS **/
    /** --------------------------------------- **/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//当前被操作的按钮对象
		Object source=arg0.getSource();
		if(source==login) new login();	
			
		else if(source==login1) new register();
		
		this.setVisible(false);
		
	}
	

}
