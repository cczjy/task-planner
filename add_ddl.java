import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class add_ddl extends JFrame implements ActionListener{
	 static JTextField blank1=new JTextField();
	 static JTextField blank2=new JTextField();
	 static JTextField blank3=new JTextField();
	 public static String YEAR;
	 public static String MONTH;
	 public static String  DAY;
	 
	public add_ddl()
	{
		initFrame();
		initView();
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
			
			JLabel Jbg=new JLabel(new ImageIcon("src\\image\\����task�����Ƶȣ����� -�������� .png"));
			Jbg.setBounds(0, 0,700,700);
			this.getContentPane().add(Jbg);
		}
	private void initView() {
		   
		    blank1.setBounds(164,457, 110, 60);
		    this.getContentPane().add(blank1);
	        
		    //��������
		   
			blank2.setBounds(295,457, 110, 60);
			this.getContentPane().add(blank2);
			
			//��������
		   
			blank3.setBounds(426,457, 110, 60);
			this.getContentPane().add(blank3);
			
			//���ȷ����ť
				JButton back=new JButton();
				back.setBounds(329, 592, 42, 42);
				back.setIcon(new ImageIcon("src\\image\\ȷ��ͼ�꣨sign-up��log-in���ã� 1.png"));
				back.setBorderPainted(false);
				back.setContentAreaFilled(false);
				this.getContentPane().add(back);
				back.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		try {
			  YEAR =blank1.getText();
			  MONTH=blank2.getText();
			  DAY = blank3.getText();
			OutputStream os = new FileOutputStream("D://"+login.NAME,true);
			os.write("\r\n".getBytes());
			String deadline = "DEADLINE: "+YEAR+"/"+MONTH+"/"+DAY;
			byte[] bytes = deadline.getBytes();
			os.write(bytes);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setVisible(false);
		new taskpage();
	}

}
