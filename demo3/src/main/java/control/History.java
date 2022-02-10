/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import model.*;

/**
 * this for history
 *@version jdk17
 * @author ai365ak
 */
public class History extends HttpServlet {
    JpaCrud jpa=new JpaCrud();
    /**
     * this counter for count the visits
     */
    Integer counter=0;

    /**
     *
     * @param request this responsible of request
     * @param response this responsible of response
     * @throws IOException this if IOE error 
     */
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
            counter++;
            jpa.createRecord();
            Cookie cookie=new Cookie("numberOfVisits",counter.toString());
            response.addCookie(cookie);
            PrintWriter out=response.getWriter();
            response.setContentType("text/html; charset=utf-8");
    
            HttpSession session=request.getSession();
                for(int i=0;i<Another.operations;i++)
                {
                    out.println("<p>"+session.getAttribute("operation"+i)+"</p>");
                }
                Cookie cookies[]=request.getCookies();
                
                   if(counter==1)
                   {
                       out.print("<h1>this the first time :D "+"<br></h1>");
                       cookies[1].getValue();
                   }
                   else{
                out.print("<h1>the number of visit history is "+cookies[1].getValue()+"<br>"+"</h1>");
       }
                   
    }
}
