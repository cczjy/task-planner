
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
		//��ʼ������ķ�������
		initFrame();
		//��ʼ��view
		initView() ;
		//��ʼ�������ͼƬ
		initImage();
		this.setVisible(true);
	}
	private void initFrame() {
		//��ʼ������
		this.setTitle("��ʼ");
		this.setSize(715, 745);
		this.setLayout(null);
				
	}
	private void initImage() {
	//����ͼ
		
		JLabel Jbg=new JLabel(new ImageIcon("src\\image\\ѡ��log-in��sign-up.png"));
		Jbg.setBounds(0, 0,700,700);
		this.getContentPane().add(Jbg);
	}
	private void initView() {
		login.setBounds(235,382,231,67);
		login.setIcon(new ImageIcon("src\\image\\log-in  bottom (1).png"));
		login.setBorderPainted(false);
		login.setContentAreaFilled(false);
		this.getContentPane().add(login);
		//��button�Ӷ�������
		//������Ҫ����Լ���loginpage������м���ʲô�����ת��home
		login.addActionListener(this);
		
		
		
		login1.setBounds(235,475, 231, 67);
		login1.setIcon(new ImageIcon("src\\image\\sign-up bottom.png"));
		login1.setBorderPainted(false);
		login1.setContentAreaFilled(false);
		this.getContentPane().add(login1);
		//��button�Ӷ�������
		//������Ҫ����Լ���registerpage������м���ʲô�����ת��home
		login1.addActionListener(this);
		
	}
	
	
	 /** --------------------------------------- **/
    /** DO NOT CHANGE ANYTHING IN THESE METHODS **/
    /** --------------------------------------- **/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//��ǰ�������İ�ť����
		Object source=arg0.getSource();
		if(source==login) new login();	
			
		else if(source==login1) new register();
		
		this.setVisible(false);
		
	}
	

}
