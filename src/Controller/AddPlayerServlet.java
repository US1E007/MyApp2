package Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bettercloud.vault.VaultException;

import DAO.PlayersDAOImpl;

public class AddPlayerServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,  
			HttpServletResponse response) 
			        throws ServletException, IOException {
		
		PlayersDAOImpl p = new PlayersDAOImpl();
		int id = Integer.parseInt(request.getParameter("playerId"));
		String name = request.getParameter("player");
		String team = request.getParameter("playerTeam");
		String status = request.getParameter("playerStatus");
		String sports = request.getParameter("playerSports");
		try {
			p.addPlayers(id, name, team, status, sports); 
		} catch (ClassNotFoundException | SQLException | InterruptedException | VaultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        PrintWriter out = response.getWriter(); 
        out.println("<html><body><b>Successfully Inserted"
                    + "</b></body></html>"); 
         
		
	}
}
