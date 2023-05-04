package model;

public class Person {
	private String ID; 		//学号，工号
	private String Sname; 	//姓名
	private String Age;	 	//年龄	
	private String Cname;	//学院
//	private String Clsname;	//班级
	private String Pls;		//政治面貌
	private String Num;		//联系方式
	public Person()
	{
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getPls() {
		return Pls;
	}
	public void setPls(String pls) {
		Pls = pls;
	}
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		Num = num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
