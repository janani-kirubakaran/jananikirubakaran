package stmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.Conn;

import beann.Beann;
import impl.Interr;

public class Stmt implements Interr{

	Connection con=null;
	 Conn c=new Conn();
	PreparedStatement st=null;
	public int i;
	
	public ResultSet login(Beann bean) {
		i = 0;
		ResultSet rs=null;
		try {
			con=c.con();
			st=con.prepareStatement("SELECT * FROM student.stddetail  where rollno='"+bean.getRollno()+"'"+" and DOB='"+bean.getDob()+"'");
				
		rs=st.executeQuery();
		i=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return rs ;
	
				
	}

	@Override
	public int register(Beann bean)  {
		int i=0;
		try {
			con=c.con();
			st=con.prepareStatement("INSERT INTO student.stddetail(rollno,name,DOB) VALUES(?,?,?)");
			st.setString(1, bean.getRollno());
			st.setString(2,bean.getName() );
			st.setString(3, bean.getDob());
			i=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return i ;
	}

	@Override
	public int update(Beann bean) {
		int i=0;
		try {
			con=c.con();
			System.out.println(bean.getRollno());
			st=con.prepareStatement("UPDATE student.stddetail s SET TOC=?,PCD=?,EFFA=? where rollno='"+bean.getRollno()+"'");
			
			st.setInt(1,bean.getTOC());
			st.setInt(2,bean.getPCD());
			st.setInt(3,bean.getEFFA());
			
			i=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return i ;
		
	}
	public int stafflogin(Beann bean)
	{
		int re=0,i=0;
		try {
			con=c.con();
			
			st=con.prepareStatement("INSERT INTO student.staffdetail VALUES(?,?,?)");
			st.setString(1, bean.getSid());
			st.setString(2,bean.getSname() );
			st.setString(3, bean.getPassword());
			
			i=st.executeUpdate();
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return i ;
	
	}
	}
