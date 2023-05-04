package tool;
import model.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


/*
 ��Ŀ����ѧ����Ϣ�������
���Ҫ�㣺ʹ���ı������н������ѧ����Ϣ����������ļ���ʽ�洢����ѧ������Ϣ��
��ʵ�ֶ�ѧ����Ϣ����ɾ���ġ���ȹ��ܡ�
�ؼ����������������ļ������ࡢ������ʾ�༰��ؽӿ��࣬���ļ���дʵ�֡�

 */
public class Tool {
	
	public Tool()
	{
		
	}
    public static void main(String[] args) throws IOException {
        //�������϶���
        ArrayList<Student> array = new ArrayList<Student>();
        //�����ļ�·��
        String fileName = "student.txt";
      
      
    }

    //ɾ��ѧ����Ϣ����
    public static void removeStudent(String fileName,String id) throws IOException{
     
        //�������϶���
    	
        ArrayList<Student> array = new ArrayList<Student>();
        //���ļ��ж�ȡѧ����Ϣ��������
        readFile(fileName,array);
        int index = -1;
        for(int i=0;i<array.size();i++){
            Student student = array.get(i);
            if(student.getID().equals(id)){
                index = i;
                break;
            }
        }
        if(index==-1){
			JOptionPane.showMessageDialog(null, "��Ҫɾ����ѧ����Ϣ�����ڣ����������룡","��ʾ",JOptionPane.PLAIN_MESSAGE);
        }else{
            array.remove(index);
            //�Ѽ����е�ѧ����Ϣд���ļ���
            writeFile(fileName,array);
			JOptionPane.showMessageDialog(null, "ɾ���ɹ���","��ʾ",JOptionPane.PLAIN_MESSAGE);
        } 
    }
    //���ļ���ȡ���ݵ�����
    public static void readFile(String fileName,ArrayList<Student> array) throws IOException{
        //�������뻺��������
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while((line=br.readLine()) != null){
            String[] datas = line.split(",");
            Student student = new Student();
            student.setID(datas[0]);
            student.setSname(datas[1]);
            student.setAge(datas[2]);
            student.setCname(datas[3]);
            student.setPls(datas[4]);
            student.setNum(datas[5]);
            array.add(student);
        }
        //�ͷ���Դ
        br.close();
    }

    //�Ѽ����е�����д���ļ�
    public static void writeFile(String fileName,ArrayList<Student> array) throws IOException{
        //�������������
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);

        for(int i=0;i<array.size();i++){
            Student student = array.get(i);
            StringBuilder sb = new StringBuilder();
           sb.append(student.getID()).append(",").append(student.getSname()).append(",").append(student.getAge()).append(",").append(student.getCname()).append(",").append(student.getPls()).append(",").append(student.getNum());
           
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        //�ͷ���Դ
        bw.close();
    }
	
}


