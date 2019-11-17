package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

// TODO: this class should extends something to be a usable servlet.
// TODO: add an annotation here to map your servlet on an URL.
@WebServlet("/bag")
public class BagServlet extends HttpServlet{
	
	Bag myBag = new Bag();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		res.setContentType( "text/html" );
		PrintWriter out = res.getWriter();
		
		// TODO : print a html form using printwriter.
		
		out.println( "<HTML>" );
		out.println( "<HEAD>");
		out.println( "<TITLE>Page generee par une servlet</TITLE>" );
		out.println( "</HEAD>" );
		out.println( "<BODY>" );
		out.println( "<H1>Bonjour</H1>" );
		out.println("<form action=\"\" method=\"post\">");
		out.println("<label for=\"ref\">Reference \t : </label>");
		out.println("<input type=\"text\" name=\"ref\" id=\"ref\">");
		out.println("<br/><br/>");
		out.println("<label for=\"qty\">Quantity \t : </label>");
		out.println("<input type=\"text\" name=\"qty\" id=\"qty\">");
		out.println("<br/><br/>");
		out.println("<input type=\"submit\" value=\"Subscribe!\">");
		out.println("</form>");
		out.println( "</BODY>" );
		out.println( "</HTML>" );
		
	}

	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		res.setContentType( "text/html" );
		PrintWriter out = res.getWriter();
		
		String reference = req.getParameter("ref");
		String quantity = req.getParameter("qty");
		
		// TODO : Get parameters, check null
		if(reference == null || quantity == null || reference.equals("") || quantity.equals("") || !isNumeric(quantity)) {
			res.setStatus(400);
		}else{
			// TODO : print reference and quantity
			out.println("<p>"+reference+"</p>");
			out.println("<p>"+quantity+"</p>");
		}
	}
	
	public static boolean isNumeric(final String str) {

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;

    }
	
	
	

}
