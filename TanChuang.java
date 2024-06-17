import javax.swing.JDialog;
import javax.swing.JLabel;

public class TanChuang {
	
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

}
