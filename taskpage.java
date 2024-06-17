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

public class taskpage extends JFrame implements ActionListener{
	
	JButton ddl=new JButton();
	JButton back=new JButton();
	JTextField blank1=new JTextField();
    JTextField blank2=new JTextField();
	JTextField blank3=new JTextField();
	JTextField blank4=new JTextField();
	
	public taskpage()
	{
		initFrame();
		initView();
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
		
		
			JLabel Jbg=new JLabel(new ImageIcon("src\\image\\输入task的名称等（蓝）-删除组件.png"));
			Jbg.setBounds(0, 0,700,700);
			this.getContentPane().add(Jbg);
		}
	private void initView() {
		    //DISCRIPTION
	     	blank1.setBounds(190,563, 312, 40);
		    this.getContentPane().add(blank1);
		    //TITLE
		   
			blank2.setBounds(190,493, 312, 40);
			this.getContentPane().add(blank2);
			
			
			//添加total time
		  
			blank4.setBounds(348,440, 154, 30);
			this.getContentPane().add(blank4);
			
			
			
			//添加ddl
//			    String s="hhhhhhh";
				ddl.setBounds(190,440, 154, 30);		
//				ddl.setBorderPainted(false);
//				ddl.setContentAreaFilled(false);
				this.getContentPane().add(ddl);
				ddl.addActionListener(this);
				ddl.setText(add_ddl.YEAR+"/"+add_ddl.MONTH+"/"+add_ddl.DAY);
			
				
				//PRIORITY
				blank3.setBounds(190,635, 200, 40);
				this.getContentPane().add(blank3);
				//添加确定按钮
				
				back.setBounds(516, 630, 42, 42);
				back.setIcon(new ImageIcon("src\\image\\确认图标（sign-up和log-in公用） 1.png"));
				back.setBorderPainted(false);
				back.setContentAreaFilled(false);
				this.getContentPane().add(back);
				back.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object ob = arg0.getSource();
		String discription = blank1.getText(); 
		String title = blank2.getText();
		String priority = blank3.getText();
		String duration = blank4.getText();
		if(ob==back) {
			try {
				OutputStream os1 = new FileOutputStream("D://"+login.NAME,true);
				String content = "TITLE: "+title+"\n"+"PRIORITY: "+priority+"\n"+"DETAILS: "+discription+"\n"+"DURATION: "+duration+"\n"+"-----------------------------";
				byte[] bytes = content.getBytes();
				os1.write("\r\n".getBytes());
				os1.write(bytes);
				
				os1.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new home();
			this.setVisible(false);	
		}else if(ob==ddl) {
			new add_ddl();
		}
		
		
	}

}
