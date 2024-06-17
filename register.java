import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class register extends JFrame implements ActionListener{
	        //添加用户名输入框
			JTextField usename=new JTextField();
			//添加密码输入框
			JTextField password=new JTextField();
			//添加确认密码输入框
			JTextField passwordagain=new JTextField();
	public register() {
		//初始化界面的方法调用
				initFrame();
				initView();
				//初始化界面的图片
				initImage();
							
				this.setVisible(true);
	}
	private void initFrame() {
		//初始化界面
				this.setSize(715,740);
				this.setLayout(null);
				
	}
	private void initImage() {
		//背景图
			
			JLabel Jbg=new JLabel(new ImageIcon("src\\image\\sign-up界面 (去除组件）.png"));
			Jbg.setBounds(0, 0,700,700);
			this.getContentPane().add(Jbg);
			
			
			
		}
	private void initView() {
		//添加用户名文字
//		JLabel usenameText = new JLabel(new ImageIcon("") );
//		usenameText.setBounds();
//		this.getContentPane().add(usenameText);
		
		usename.setBounds(291, 452, 248, 31);
		this.getContentPane().add(usename);
		
		//添加密码文字
//		JLabel passwordText = new JLabel(new ImageIcon("") );
//		passwordText.setBounds();
//		this.getContentPane().add(passwordText);
		
		password.setBounds(291, 507,248,31);
		this.getContentPane().add(password);
		
		passwordagain.setBounds(291,562,248, 31);
		this.getContentPane().add(passwordagain);
		//添加登录按钮
		JButton login=new JButton();
		login.setBounds(337,615, 42,42);
		login.setIcon(new ImageIcon("src\\image\\确认图标（sign-up和log-in公用） 1.png"));
		login.setBorderPainted(false);
		login.setContentAreaFilled(false);
		this.getContentPane().add(login);
		//给button加动作监听
		//这里需要后端自己在MyActionListener这个类中加在什么情况跳转到home
		login.addActionListener(this);
		
		
	}
	private void showJDialog(String  content)
	{
		JDialog tanchuang=new JDialog();
		tanchuang.setSize(200,150);
		tanchuang.setAlwaysOnTop(true);
		tanchuang.setLocationRelativeTo(null);
		tanchuang.setModal(true);
		JLabel warning=new JLabel(content);
		warning.setBounds(0,0,200,150);
		tanchuang.getContentPane().add(warning);
//		这个显示弹窗的条件记得自己加啊
		
		tanchuang.setVisible(true);
		
	}
	
	
	
	
	
	 /** --------------------------------------- **/
    /** DO NOT CHANGE ANYTHING IN THESE METHODS **/
    /** --------------------------------------- **/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		File file = new File("D://"+usename.getText());
		
		//判断是否存在
		if(file.exists()) {
			showJDialog("账号已存在");
			new login();
			this.setVisible(false);
		}
		
		else {
			try {
				file.createNewFile();
				OutputStream os =new FileOutputStream("D://"+usename.getText(),true);
				os.write(Integer.toString(hashCode(password.getText())).getBytes());
				//os.write("\r\n".getBytes());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new login();
			this.setVisible(false);
			
		}
		
	}
	
	
	public int hashCode(String s0) {
		int result = 17;
		for(int i =0;i<s0.length();i++ ) {
			result=31*result+s0.charAt(i);
		}
		return result;
	}
	
	
	
}
