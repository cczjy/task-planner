import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
public class login extends JFrame implements ActionListener{
	
	
	        //����û��������
	        static JTextField usename=new JTextField();
			//������������
			JTextField password=new JTextField();
			
			//����name����
		
			public static String NAME ;
			public static String PASSWORD ;
			
	    public login() {
		//��ʼ������ķ�������
		initFrame();
		//��ʼ�������ͼƬ
		initView();
		initImage();
		
		
		
		
		this.setVisible(true);
	}
	    
	 
	 
	private void initFrame() {
		//��ʼ������
		this.setTitle("��¼");
		this.setSize(715,740);
		this.setLayout(null);
				
	}
	private void initImage() {
	//����ͼ
		
		JLabel Jbg=new JLabel(new ImageIcon("src\\image\\log-in���� (��ȥ�����.png"));
		Jbg.setBounds(0, 0,700,700);
		this.getContentPane().add(Jbg);
	}
	private void initView() {
		//����û�������
//		JLabel usenameText = new JLabel(new ImageIcon("") );
//		usenameText.setBounds();
//		this.getContentPane().add(usenameText);
		
		
		usename.setBounds(291, 491, 248, 31);
		this.getContentPane().add(usename);
		
		//�����������
//		JLabel passwordText = new JLabel(new ImageIcon("") );
//		passwordText.setBounds();
//		this.getContentPane().add(passwordText);
		password.setBounds(291, 564, 248, 31);
		this.getContentPane().add(password);
		
		
		//��ӵ�¼����
		JButton login=new JButton();
		login.setBounds(337, 615, 42, 42);
		login.setIcon(new ImageIcon("src\\image\\ȷ��ͼ�꣨sign-up��log-in���ã� 1.png"));
		login.setBorderPainted(false);
		login.setContentAreaFilled(false);
		this.getContentPane().add(login);
		//��button�Ӷ�������
		//������Ҫ����Լ���MyActionListener������м���ʲô�����ת��ȷ��
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//��ȡ����
		NAME = usename.getText();
		String name = usename.getText();
		PASSWORD=password.getText();
		//�ж��Ƿ����
		boolean b =checkExistance(name);
		System.out.print(hashCode(PASSWORD));
		if(b) {
			//�������û��Ƿ�ƥ��
			String s0 ="D://"+name;
			String firstLine="";
				
					FileInputStream is = null;
					try {
						is = new FileInputStream(s0);
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						is = new FileInputStream(s0);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
				
					BufferedReader reader =br;
						
						try {
							firstLine = br.readLine();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					
				
				if(firstLine.equals(Integer.toString(hashCode(PASSWORD))))  {
					new home();
					this.setVisible(false);
				}
				else {
					showJDialog("��������");
					new login();
					this.setVisible(false);
				}
			
		}else {
			new register();
			this.setVisible(false);
		}
	}
	
	 public static boolean checkExistance(String name){
	        File f1 = new File("D://"+name);
	        return f1.exists();
	 }
	 
	 

public int hashCode(String s0) {
	int result = 17;
	for(int i =0;i<s0.length();i++ ) {
		result=31*result+s0.charAt(i);
	}
	return result;
}
	 
	 
	 
	 
}
