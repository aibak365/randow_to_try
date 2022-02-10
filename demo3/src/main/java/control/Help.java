/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * this for help the users
 *version jdk 17
 * @author ai365ak
 */
public class Help extends HttpServlet{

    /**
     *
     * @param request this resnsiple of request
     * @param response this resbonsible of response 
     * @throws IOException if IOE error happen
     */
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        out.print("pls the size should be less than 11 and bigger than 0 and intger type");
        }
}
