

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Operations
 */
@WebServlet("/Operations")
public class Operations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String usr = request.getParameter("username");
		String psw = request.getParameter("password");
		int status=0;

		Bean b = new Bean();
		b.setUsername(usr);
		b.setPassword(psw);
		Dao d = new Dao();
		try {
			status = d.checkAuthentication(b);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		System.out.println(status);
		if(status == 1) {
			
			request.setAttribute("usr",usr);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			
		}
//		
	}

}

