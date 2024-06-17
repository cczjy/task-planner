//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//
//public class add extends JFrame{
//	public add() {
//		//初始化界面的方法调用
//		initFrame();
//		//初始化view
//		initView() ;
//		//初始化界面的图片
//		initImage();
//		this.setVisible(true);
//	}
//	private void initFrame() {
//		//初始化界面
//		this.setTitle("添加");
//		this.setSize(715, 745);
//		this.setLayout(null);
//				
//	}
//	private void initImage() {
//		//背景图
//			
//			JLabel Jbg=new JLabel(new ImageIcon("src/image/输入task的名称等（蓝）-删除组件.png"));
//			Jbg.setBounds(0, 0,700,700);
//			this.getContentPane().add(Jbg);
//		}
//	private void initView() {
//		//添加标题框
//		JTextField title=new JTextField();
//		
//		title.setBounds(193,433,316, 40);
//		this.getContentPane().add(title);
//		
//		//添加描述框
//        JTextField descrip=new JTextField();
//		
//        descrip.setBounds(193,524,316, 40);
//		this.getContentPane().add(descrip);
//		
//	}
//
//}
