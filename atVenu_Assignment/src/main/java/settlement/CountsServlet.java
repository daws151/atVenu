/* Author: Brett Dawson
 * Abandoned servlet that was going to handle GET and POST method overrides.
 */
package settlement;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "countsServlet", value = "/counts-servlet")
public class CountsServlet extends HttpServlet {
    // I ran out of time to fully implement the doPost() method override below. This is incomplete and won't do anything.
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String prodId = req.getParameter("Prod_Id");
        }


    }
/*public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        try {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Counts</title></head><body>");
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/atvenu", "brett", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from units where Prod_Id = 1");
            ResultSetMetaData rsmd = rs.getMetaData();
            out.println("<table border='1'>");
            while (rs.next()){

                for (int i=1;i< rsmd.getColumnCount();i++){
                    out.println("<tr>");
                    out.println("<th>" + rsmd.getColumnName(i)+"</th>");
                    out.println("<td>" + rs.getString(i)+"</td>");
                    out.println("</tr>");
                }
            }
            conn.close();
            out.println("</table>");
            out.println("</body></html>");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }*/
