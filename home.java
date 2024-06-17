import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class home extends JFrame implements ActionListener{
	
	
	JButton con=new JButton();
	JButton con2=new JButton();
	JButton con3=new JButton();
	JButton nextpage=new JButton();
	
	public home()
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
			JLabel Jbg=new JLabel(new ImageIcon("src\\image\\输入task 界面 （去除组件）.png"));
			Jbg.setBounds(0, 0,700,700);
			this.getContentPane().add(Jbg);
			
		}
	private void initView() {
				//添加add
				
				con.setBounds(213, 464, 275, 42);
				con.setIcon(new ImageIcon("src\\image\\输入task组件-add.png"));
				con.setBorderPainted(false);
				con.setContentAreaFilled(false);
				this.getContentPane().add(con);
				con.addActionListener(this);
				//添加show
				
				con2.setBounds(213, 524, 275, 42);
				con2.setIcon(new ImageIcon("src\\image\\输入task组件-show.png"));
				con2.setBorderPainted(false);
				con2.setContentAreaFilled(false);
				this.getContentPane().add(con2);
				con2.addActionListener(this);

				//添加optimizing
				
				con3.setBounds(213, 592, 275, 42);
				con3.setIcon(new ImageIcon("src\\image\\输入task组件-OPTIMIZING.png"));
				con3.setBorderPainted(false);
				con3.setContentAreaFilled(false);
				this.getContentPane().add(con3);
				con3.addActionListener(this);
			
		
	}
	
	
	
	
	 /** --------------------------------------- **/
    /** DO NOT CHANGE ANYTHING IN THESE METHODS **/
    /** --------------------------------------- **/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object source=arg0.getSource();
		File filePath = new File("D://"+login.NAME);
		if(source==con) {
			new taskpage();
			this.setVisible(false);
		}else if(source ==con2) {
			Desktop deskTop= Desktop.getDesktop();
			try {
				deskTop.open(filePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(source==con3) {
			//添加调用优化工具类
			
			 /** --------------------------------------- **/
			 /** --------------------------------------- **/
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
			Date d=new Date(0L);
			String s=sdf.format(d);
			Newbetter nb=new Newbetter();
			String a[]=nb.wordsReader("D://"+login.NAME);
			Newbetter [] n=new Newbetter[(a.length-1)/6];
			for(int i=1;i<a.length;i++) {
				if(i%6==1) {
					n[i/6]=new Newbetter();
					n[i/6].setDeadline(a[i].split(": | \\(can not finish\\)")[1]);
					String s2=sdf.format(System.currentTimeMillis());
					n[i/6].setResttime(Integer.parseInt(n[i/6].getDeadline().split("/")[2])-Integer.parseInt(s2.split("/")[2])+30*(Integer.parseInt(n[i/6].getDeadline().split("/")[1])-Integer.parseInt(s2.split("/")[1]))+365*(Integer.parseInt(n[i/6].getDeadline().split("/")[0])-Integer.parseInt(s2.split("/")[0])));
					
				}
				else if(i%6==2) {
					n[i/6].setName(a[i].split(": ")[1]);
				}
				else if(i%6==3) {
					n[i/6].setPriority(Integer.parseInt(a[i].split(": ")[1]));
				}
				else if(i%6==4&&a[i]!="DETAILS: ") {
     				n[i/6].setDetails(a[i].split(": ")[1]);
				}
				else if(i%6==5) {
					n[i/6].setNeedtime(Integer.parseInt(a[i].split(": |DAYS")[1]));
				}
				}
			for(int i=0;i<(a.length-1)/6;i++) {
				int c=0;
				if(n[i].getNeedtime()/20==0) {
					c=1;
				}
				else if(n[i].getNeedtime()/40==0){
					c=2;
				}
				else if(n[i].getNeedtime()/60==0){
					c=3;
				}
				else {
					c=5;
				}
				n[i].setCounttime((c*n[i].getPriority())/((double)n[i].getResttime()*(double)n[i].getResttime()));
			}
			for(int i=0;i<(a.length-1)/6;i++) {
				for(int t=0;t<(a.length-1)/6-1-i;t++) {
					
					if(n[t].getCounttime()<n[t+1].getCounttime()) {
						nb=n[t];
						n[t]=n[t+1];
						n[t+1]=nb;
					}
				}
				}
			String [] af=new String[(a.length-1)/6+1];
			for(int i=0;i<(a.length-1)/6+1;i++) {
				af[0]=a[0];
				if(i>0&&n[i-1].getResttime()<=n[i-1].getNeedtime()) {
				n[i-1].setDeadline(n[i-1].getDeadline()+" (can not finish)");
				}
			}
			for(int i=1;i<af.length;i++) {
				af[i]=n[i-1].tostring();
			}

			try {
				//File file0=new File ("D://"+login.NAME);
				File file0=new File ("D://"+login.NAME);
				PrintWriter writer = new PrintWriter(file0);
				OutputStream os2 = new FileOutputStream("D://"+login.NAME,true);
				for (int i=0;i<af.length;i++) {
					String content = af[i];
					if(i!=0)   os2.write("\n".getBytes());
					byte[] bytes = content.getBytes();
					os2.write(bytes);
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			 /** --------------------------------------- **/
			 /** --------------------------------------- **/
			
			JDialog tanchuang=new JDialog();
			tanchuang.setSize(200,150);
			tanchuang.setAlwaysOnTop(true);
			tanchuang.setLocationRelativeTo(null);
			tanchuang.setModal(true);
			JLabel warning=new JLabel("优化完成");
			warning.setBounds(0,0,200,150);
			tanchuang.getContentPane().add(warning);
//			这个显示弹窗的条件记得自己加啊
			
			tanchuang.setVisible(true);
		}
		
	}

}
