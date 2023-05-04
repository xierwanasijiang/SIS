package ui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.Color;
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("\u6B22\u8FCE\u6765\u5230\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		label.setBounds(182, 13, 334, 73);
		label.setBackground(Color.ORANGE);
		label.setFont(new Font("华文行楷", Font.PLAIN, 40));
		label.setForeground(Color.BLACK);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 387, 664, -342);
		contentPane.add(scrollPane);
		
		JLabel label_1 = new JLabel("\u8D26\u53F7");
		label_1.setIcon(new ImageIcon(login.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("华文行楷", Font.PLAIN, 25));
		label_1.setBounds(182, 122, 77, 29);
		contentPane.add(label_1);
		
		user = new JTextField();
		
		user.setForeground(Color.BLACK);
		user.setFont(new Font("华文楷体", Font.PLAIN, 25));
		user.setBounds(272, 118, 198, 30);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel label_1_1 = new JLabel("\u5BC6\u7801");
		label_1_1.setIcon(new ImageIcon(login.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		label_1_1.setForeground(Color.BLACK);
		label_1_1.setFont(new Font("华文行楷", Font.PLAIN, 25));
		label_1_1.setBounds(182, 160, 83, 34);
		contentPane.add(label_1_1);
		
		pw = new JPasswordField();
		pw.setFont(new Font("宋体", Font.PLAIN, 25));
		pw.setForeground(Color.BLACK);
		pw.setBounds(272, 161, 198, 29);
		contentPane.add(pw);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}

			
		});
		button.setBounds(283, 214, 83, 27);
		contentPane.add(button);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private void login(ActionEvent e) throws IOException {
		String uname=user.getText().toString();
		String pwd=pw.getText().toString();
		if(!user.getText().isEmpty()&&!pw.getText().isEmpty())
		{
			if(uname.equals("li")&&pwd.equals("123"))//设置账号密码
			{
				index in=new index();
				in.setVisible(true);//密码正确，跳转到主界面
				this.setVisible(false);//当前界面消失
			}else {
				JOptionPane.showMessageDialog(null, "登录名或密码错误，请重新登录","提示",JOptionPane.ERROR_MESSAGE);
			}
		}else if(user.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "请输入用户名","提示",JOptionPane.PLAIN_MESSAGE);

		}else if(pw.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "请输入密码","提示",JOptionPane.PLAIN_MESSAGE);

		}
	
		
	}
}
