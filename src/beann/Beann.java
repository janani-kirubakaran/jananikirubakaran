package beann;

public class Beann {
	private String name,rollno,dob,sid,sname,password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTOC() {
		return TOC;
	}
	public void setTOC(int tOC) {
		TOC = tOC;
	}
	public int getPCD() {
		return PCD;
	}
	public void setPCD(int pCD) {
		PCD = pCD;
	}
	public int getEFFA() {
		return EFFA;
	}
	public void setEFFA(int eFFA) {
		EFFA = eFFA;
	}
	private int TOC,PCD,EFFA;

}
