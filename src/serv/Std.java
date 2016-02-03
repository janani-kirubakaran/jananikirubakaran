package serv;

import impl.Interr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stmt.Stmt;

import beann.Beann;

/**
 * Servlet implementation class Std
 */
@WebServlet("/Std")
public class Std extends HttpServlet {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor. 
     */
    public Std() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		Beann bean=new Beann();
		Interr inter=new Stmt();
		int i=0;
		ResultSet rs=null;


		PrintWriter out=res.getWriter();
	    String status=req.getParameter("status");
	    if(status.contentEquals("register"))
	    {
		String name=req.getParameter("name");
		String rollno=req.getParameter("rollno");
		String dob=req.getParameter("dob");
		bean.setName(name);
		bean.setRollno(rollno);
		bean.setDob(dob);
		i=inter.register(bean);
		if(i==1)
		{
		res.sendRedirect("login.html");
		}
		else
		{
		out.print("Error occured");
		}
		}
	    else if(status.contentEquals("login"))
	    {
	 
			String dob=req.getParameter("dob");
			String name = null;
			int TOC=0,PCD=0,EFFA=0;
			String rollno=req.getParameter("rollno");
			bean.setRollno(rollno);
			bean.setDob(dob);
			rs=inter.login(bean);
	
			try {
				while(rs.next())
				{
				name=rs.getString(2);
				TOC=rs.getInt(4);
				PCD=rs.getInt(5)	;
				EFFA=rs.getInt(6);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print("<html>");
			out.print("<head>Mark List</head>");
			out.print("<body>");
			out.print("<center><font color=purple>Mark List</font>");
			out.print("<table >");
			out.print("<tr bgcolor=red ><th>ROLLNO</th><th>NAME</th><th>DOB</th><th>TOC</th><th>PCD</th><th>EFFA</th>");
			out.print("<tr bgcolor=yellow><td>"+rollno+"</td><td>"+name+"</td><td>"+dob+"</td><td>"+TOC+"</td><td>"+PCD+"</td><td>"+EFFA+"</td></tr>");
			out.print("</table></center>");
			out.print("</body>");
			out.print("</html>");
			}
	    else if(status.contentEquals("stafflogin"))
	    {
	    	String sid=req.getParameter("sid");
	    	String sname=req.getParameter("sname");
	    	String password=req.getParameter("pswd");
			String rollno=req.getParameter("rollno");
	    	bean.setSid(sid);
	    	bean.setSname(sname);
	    	bean.setPassword(password);
	    	
	    	 i=inter.stafflogin(bean);
	    	 if(i==1)
	    	 {
	    		 res.sendRedirect("update.html");
	    	 }
	    	 else
	    	 {
	    		 out.print("error occured");
	    	 }
	    	 
	    }
	    
	    else if(status.contentEquals("update"))
   	 {
                int tOC=Integer.parseInt(req.getParameter("TOC"));
                int pCD=Integer.parseInt(req.getParameter("PCD"));
                int eFFA=Integer.parseInt(req.getParameter("EFFA"));
        		String rollno=req.getParameter("rollno");
   			    bean.setTOC(tOC);
   			    bean.setPCD(pCD);
   			    bean.setEFFA(eFFA);
   			   bean.setRollno(rollno);
   			    i=inter.update(bean);  		
   			    if(i==1)
   			    {
   			    res.sendRedirect("stafflogin.html");
   			    
   			    }
   			    else
   			    {
   			    	out.print("error occured during update");
   			    }
   			 
   		 }	 
	    	 
	    	 
	    	 
	    	   		 
	    	 }
	    
	
			}
	
	    

	        
		
	


