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
	        //����û��������
			JTextField usename=new JTextField();
			//������������
			JTextField password=new JTextField();
			//���ȷ�����������
			JTextField passwordagain=new JTextField();
	public register() {
		//��ʼ������ķ�������
				initFrame();
				initView();
				//��ʼ�������ͼƬ
				initImage();
							
				this.setVisible(true);
	}
	private void initFrame() {
		//��ʼ������
				this.setSize(715,740);
				this.setLayout(null);
				
	}
	private void initImage() {
		//����ͼ
			
			JLabel Jbg=new JLabel(new ImageIcon("src\\image\\sign-up���� (ȥ�������.png"));
			Jbg.setBounds(0, 0,700,700);
			this.getContentPane().add(Jbg);
			
			
			
		}
	private void initView() {
		//����û�������
//		JLabel usenameText = new JLabel(new ImageIcon("") );
//		usenameText.setBounds();
//		this.getContentPane().add(usenameText);
		
		usename.setBounds(291, 452, 248, 31);
		this.getContentPane().add(usename);
		
		//�����������
//		JLabel passwordText = new JLabel(new ImageIcon("") );
//		passwordText.setBounds();
//		this.getContentPane().add(passwordText);
		
		password.setBounds(291, 507,248,31);
		this.getContentPane().add(password);
		
		passwordagain.setBounds(291,562,248, 31);
		this.getContentPane().add(passwordagain);
		//��ӵ�¼��ť
		JButton login=new JButton();
		login.setBounds(337,615, 42,42);
		login.setIcon(new ImageIcon("src\\image\\ȷ��ͼ�꣨sign-up��log-in���ã� 1.png"));
		login.setBorderPainted(false);
		login.setContentAreaFilled(false);
		this.getContentPane().add(login);
		//��button�Ӷ�������
		//������Ҫ����Լ���MyActionListener������м���ʲô�����ת��home
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
//		�����ʾ�����������ǵ��Լ��Ӱ�
		
		tanchuang.setVisible(true);
		
	}
	
	
	
	
	
	 /** --------------------------------------- **/
    /** DO NOT CHANGE ANYTHING IN THESE METHODS **/
    /** --------------------------------------- **/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		File file = new File("D://"+usename.getText());
		
		//�ж��Ƿ����
		if(file.exists()) {
			showJDialog("�˺��Ѵ���");
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
