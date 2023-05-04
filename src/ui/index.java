package ui;

import java.awt.BorderLayout;
import tool.Tool;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Student;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class index extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField txt_ID;
	static boolean is=true;
	private JTextField txt_name;
	private JTextField txt_age;
	private JTextField txt_cname;
	private JTextField txt_pls;
	private JTextField txt_num;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public index() throws IOException {
		Object[] columnNames= {"���","ѧ��","����","����","ѧԺ","������ò","��ϵ��ʽ"};	
		Object data[][]=null;	
		DefaultTableModel m=new DefaultTableModel(data,columnNames);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 616);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		//���Ұ�ť
		JButton btn_check = new JButton("\u67E5\u627E");
		btn_check.setIcon(new ImageIcon(index.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		btn_check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					try {
						while(m.getRowCount()!=0)//�����Ϣ��Ϊ�գ��������
						{
							m.removeRow(0);
						}
						if(txt_ID.getText().equals(""))
						{
							
							index.check(m,"all");
						}else
						{
							index.check(m,txt_ID.getText());
						}
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		menuBar.add(btn_check);
		//ɾ����ť
		JButton btn_delete = new JButton("\u5220\u9664");
		btn_delete.setIcon(new ImageIcon(index.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		btn_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Tool.removeStudent("student.txt", txt_ID.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuBar.add(btn_delete);
		
		JButton btn_add = new JButton("\u6DFB\u52A0");
		btn_add.setIcon(new ImageIcon(index.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		//��Ӱ�ť
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					index in=new index();
					//�ж���д��Ϣ�Ƿ�Ϊ��
					if(txt_ID.getText().equals("")&&txt_name.getText().equals("")&&txt_age.getText().equals("")
							&&txt_cname.getText().equals("")&&txt_pls.getText().equals("")
							&&txt_num.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "�����Ϣ��������","��ʾ",JOptionPane.ERROR_MESSAGE);
					}else {
						in.add(txt_ID.getText(),txt_name.getText(),txt_age.getText(),txt_cname.getText(),txt_pls.getText(),txt_num.getText());
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuBar.add(btn_add);
		//�޸İ�ť
		JButton btn_udate = new JButton("\u4FEE\u6539");
		btn_udate.setIcon(new ImageIcon(index.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		
		btn_udate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(txt_ID.getText().equals("")&&txt_name.getText().equals("")&&txt_age.getText().equals("")
							&&txt_cname.getText().equals("")&&txt_pls.getText().equals("")
							&&txt_num.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "����������Ҫ�޸ĵ���Ϣ��","��ʾ",JOptionPane.PLAIN_MESSAGE);
					}else
					{
						index.update(txt_ID.getText(),txt_name.getText(),txt_age.getText(),txt_cname.getText(),txt_pls.getText(),txt_num.getText());
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuBar.add(btn_udate);
		
		JLabel lblNewLabel_1 = new JLabel("                     ");
		menuBar.add(lblNewLabel_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		table_1 = createJTable(m);
			
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(0, 0, 873, 463);
		contentPane.add(scrollPane);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(202, 478, 72, 18);
		contentPane.add(label_1);
		
		txt_name = new JTextField();
		txt_name.setBounds(288, 472, 86, 24);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5E74\u9F84\uFF1A");
		label_2.setBounds(391, 478, 72, 18);
		contentPane.add(label_2);
		
		txt_age = new JTextField();
		txt_age.setBounds(477, 475, 86, 24);
		contentPane.add(txt_age);
		txt_age.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u9662\uFF1A");
		lblNewLabel_2.setBounds(10, 511, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		txt_cname = new JTextField();
		txt_cname.setBounds(87, 508, 86, 24);
		contentPane.add(txt_cname);
		txt_cname.setColumns(10);
		
		JLabel label_3 = new JLabel("\u653F\u6CBB\u9762\u8C8C\uFF1A");
		label_3.setBounds(191, 511, 86, 18);
		contentPane.add(label_3);
		
		txt_pls = new JTextField();
		txt_pls.setBounds(291, 508, 86, 24);
		contentPane.add(txt_pls);
		txt_pls.setColumns(10);
		
		JLabel label_4 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_4.setBounds(385, 511, 78, 18);
		contentPane.add(label_4);
		
		txt_num = new JTextField();
		txt_num.setBounds(477, 508, 86, 24);
		contentPane.add(txt_num);
		txt_num.setColumns(10);
		
		txt_ID = new JTextField();
		txt_ID.setBounds(87, 473, 86, 22);
		contentPane.add(txt_ID);
		txt_ID.setText("");
		txt_ID.setColumns(2);
		
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		label.setBounds(10, 480, 72, 18);
		contentPane.add(label);
		
		JButton btn_reset = new JButton("\u91CD\u7F6E");
		btn_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_ID.setText("");
				txt_num.setText("");
				txt_pls.setText("");
				txt_cname.setText("");
				txt_age.setText("");
				txt_name.setText("");
			}
		});
		btn_reset.setBounds(605, 476, 113, 27);
		contentPane.add(btn_reset);
	
	}
	private JTable createJTable(DefaultTableModel m) throws IOException
	{  
		
		JTable table =new JTable() {
			public boolean isCellEditable(int row,int column)
			{
				return false;
			}
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				txt_ID.setText( table.getValueAt(row, 1).toString());
				txt_name.setText( table.getValueAt(row, 2).toString());
				txt_age.setText( table.getValueAt(row, 3).toString());
				txt_cname.setText( table.getValueAt(row, 4).toString());
				txt_pls.setText( table.getValueAt(row, 5).toString());
				txt_num.setText( table.getValueAt(row, 6).toString());
				
			}
		});
		table.setFont(new Font("����", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.setModel(m);
		
		return table;		
		
		}
		
	//����
	static	private void check(DefaultTableModel m,String id) throws IOException
	{ 	
		//if(is) {
		String fileName = "student.txt";
		Student student = new Student();
		ArrayList<Student> array = new ArrayList<Student>();
		Tool.readFile(fileName, array);
		boolean is=true;//�жϲ��ҵ�ѧ���Ƿ����
		if(id.equals("all")) {
			for(int i=0;i<array.size();i++)
			{	
				Object[] data2=new Object[7];
				student=array.get(i);
				data2[0]=i;
				data2[1]=student.getID();
				data2[2]=student.getSname();
				data2[3]=student.getAge();
				data2[4]=student.getCname();
				data2[5]=student.getPls();
				data2[6]=student.getNum();
				m.addRow(data2);
			}
 			JOptionPane.showMessageDialog(null, "�Ѳ��ҵ�ȫ����Ϣ��","��ʾ",JOptionPane.PLAIN_MESSAGE);

		}else {
			for(int i=0;i<array.size();i++)
			{	
				Object[] data2=new Object[7];
				student=array.get(i);
				if(student.getID().equals(id))
				{
					data2[0]=i;
					data2[1]=student.getID();
					data2[2]=student.getSname();
					data2[3]=student.getAge();
					data2[4]=student.getCname();
					data2[5]=student.getPls();
					data2[6]=student.getNum();
					m.addRow(data2);
					is=false;
	     		JOptionPane.showMessageDialog(null, "�Ѳ��ҵ�ѧ��Ϊ"+data2[1]+"��Ϣ��","��ʾ",JOptionPane.PLAIN_MESSAGE);
				}
			}
			if(is)
			{
			JOptionPane.showMessageDialog(null, "��ѧ�Ų����ڻ����������","��ʾ",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		//is=false;
	/*}else {
		for(int i=0;i<=m.getRowCount();i++)
		{
			m.removeRow(i);
		}
		is=true;
	}*/
	}
	
	//ɾ��
	static	private void  remove(DefaultTableModel m,int row) throws IOException
	{
		String fileName = "student.txt";
		String Id=(String)m.getValueAt(row, 1); //��ȡѧ�ţ�����ѧ��
		m.removeRow(row);
		Tool.removeStudent(fileName, Id);
	}
	
	//����
		private void add(String id0,String id1,String id2,String id3,String id4,String id5) throws IOException
	{
			String fileName = "student.txt";
			ArrayList<Student> array = new ArrayList<Student>();
	        //���ļ��ж�ȡѧ����Ϣ��������
			Tool.readFile(fileName,array);
	        String id;
	        boolean flag = false; //�ж�ѧ���Ƿ��ظ�
	        while(true){   
	            id = id0;
	            for(int i=0;i<array.size();i++){
	                Student student = array.get(i);
	                if(student.getID()==null)
	                {
	                	is=true;
	                	break;
	                }
	                if(student.getID().equals(id)){
	                    flag = true;
	                    break;
	                    //System.out.println("�������ѧ���Ѵ��ڣ����������룡");
	                }  
	            }
	             if(flag){
	     			JOptionPane.showMessageDialog(null, "�������ѧ���Ѵ������������룡","��ʾ",JOptionPane.PLAIN_MESSAGE);

	                break;
	            }else{
	                break;
	            }
	        } 
	       if(!flag)
	       {
	    	   String name =id1;
		        String age =id2;
		        String collage =id3;
		        String Politics =id4;
		        String number = id5;
		            
		        //����ѧ�������
		        Student student = new Student();
		        student.setID(id);
		        student.setSname(name);
		        student.setAge(age);
		        student.setCname(collage);
		        student.setPls(Politics);
		        student.setNum(number);
		        //��ӵ�������
		        array.add(student);
		        //�Ѽ�����ѧ����Ϣд���ļ���
		        Tool.writeFile(fileName,array);
     			JOptionPane.showMessageDialog(null, "��ӳɹ���","��ʾ",JOptionPane.PLAIN_MESSAGE);
	
	     }
	 }
	
	//�޸�
		static	private void update(String id0,String id1,String id2,String id3,String id4,String id5) throws IOException
	{
		String fileName = "student.txt";
        //�������϶���
        ArrayList<Student> array = new ArrayList<Student>();
        //���ļ��ж�ȡѧ����Ϣ��������
       Tool.readFile(fileName,array);
        String id = id0;
        int index = -1;
        for(int i=0;i<array.size();i++){
            Student student = array.get(i);
            if(student.getID().equals(id)){
                index = i;
                break;
            }
        }
        if(index==-1){
		JOptionPane.showMessageDialog(null, "��Ҫ�޸ĵ�ѧ����Ϣ�����ڣ����������룡","��ʾ",JOptionPane.ERROR_MESSAGE);
        }else{
            //����ѧ�������
            Student student = new Student();
            String name =id1;
	        String age =id2;
	        String collage =id3;
	        String Politics =id4;
	        String number = id5;     
            student.setID(id);
            student.setSname(name);
            student.setAge(age);
            student.setCname(collage);
            student.setPls(Politics);
            student.setNum(number);
            //�޸ĺ��ѧ����Ϣ��ӵ�������
            array.set(index,student);
            //�Ѽ����е�ѧ����Ϣд���ļ���
            Tool.writeFile(fileName,array);
			JOptionPane.showMessageDialog(null, "��ϲ�޸ĳɹ���","��ʾ",JOptionPane.PLAIN_MESSAGE);
        }
	}
}

