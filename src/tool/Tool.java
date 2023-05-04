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
 题目二：学生信息管理程序
设计要点：使用文本命令行界面设计学生信息管理程序；用文件形式存储班上学生的信息表；
能实现对学生信息增、删、改、查等功能。
关键技术分析：建立文件操作类、界面显示类及相关接口类，用文件读写实现。

 */
public class Tool {
	
	public Tool()
	{
		
	}
    public static void main(String[] args) throws IOException {
        //创建集合对象
        ArrayList<Student> array = new ArrayList<Student>();
        //定义文件路径
        String fileName = "student.txt";
      
      
    }

    //删除学生信息方法
    public static void removeStudent(String fileName,String id) throws IOException{
     
        //创建集合对象
    	
        ArrayList<Student> array = new ArrayList<Student>();
        //从文件中读取学生信息到集合中
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
			JOptionPane.showMessageDialog(null, "你要删除的学生信息不存在，请重新输入！","提示",JOptionPane.PLAIN_MESSAGE);
        }else{
            array.remove(index);
            //把集合中的学生信息写到文件中
            writeFile(fileName,array);
			JOptionPane.showMessageDialog(null, "删除成功！","提示",JOptionPane.PLAIN_MESSAGE);
        } 
    }
    //从文件读取数据到集合
    public static void readFile(String fileName,ArrayList<Student> array) throws IOException{
        //创建输入缓冲流对象
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
        //释放资源
        br.close();
    }

    //把集合中的数据写到文件
    public static void writeFile(String fileName,ArrayList<Student> array) throws IOException{
        //创建输出缓冲流
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
        //释放资源
        bw.close();
    }
	
}


