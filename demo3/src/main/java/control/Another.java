package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.http.*;
import model.*;

/**
 * this for insert the elments
 *@version jdk17
 * @author ai365ak
 */
public class Another extends HttpServlet{
   
   
    
   /**
    * create an object of Model
    */
   Model model=new Model();

    /**
     *
     */
    public static int operations=0;

    /**
     *
     * @param request it is respmsible for request
     * @param response it is respnsible for response 
     * @throws IOException if error happen in IOE
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
         ArrayList<ArrayList<Integer>> matrixInside1=new ArrayList<>();
         ArrayList<ArrayList<Integer>> answer=new ArrayList<>();
        ArrayList<ArrayList<Integer>> matrixInside2=new ArrayList<>();
        ArrayList<Integer>ma1=new ArrayList<>();
        ArrayList<Integer>ma2=new ArrayList<>();
       Integer columSize1=Control.columSize1;
    Integer columSize2=Control.columSize2;
    Integer rowSize1=Control.rowSize1;
    Integer rowSize2=Control.rowSize2;
       boolean check=true;
        
         ma1.clear();ma2.clear();
        matrixInside1.clear();
        matrixInside2.clear();
        int num;
        for(int i=0;i<rowSize1*columSize1+rowSize2*columSize2;i++)
        {
            try {
              
             num=Integer.parseInt(request.getParameter("cell"+i));
             if(i<rowSize1*columSize1)
             {
                 ma1.add(num);
             }
             else
             {
                 ma2.add(num);
             }
             
        }
        catch (NumberFormatException e)
        {
            if(check)
            {
              response.sendError(HttpServletResponse.SC_BAD_REQUEST,"this bad format ");
              check=false;
            }
            if(i<rowSize1*columSize1)
             {
                 ma1.add(0);
             }
             else
             {
                 ma2.add(0);
             }
          
        }
        }
       
          response.setContentType("text/html; charset=utf-8");
        HttpSession session=request.getSession();
        session.setAttribute("operation"+operations,"the user use matrix that has size "+rowSize1*columSize1+" for the matrix1 ||" +rowSize2*columSize2+" for the matrix2");
        operations++;
        PrintWriter out=response.getWriter();
        for(int i=0;i<40;i++)
        {
            matrixInside1.add(new ArrayList<>());
            matrixInside2.add(new ArrayList<>());
        }
        int cnt1=0;
        for(Integer i=0;i<rowSize1*columSize1;i++)
        {
            if(i%columSize1==0 && i!=0)
            {
                cnt1++;
            }
            matrixInside1.get(cnt1).add(i%columSize1,ma1.get(i));
            
        }
        int cnt2=0;
        for(Integer i=0;i<rowSize2*columSize2;i++)
        {
            if(i%columSize2==0 && i!=0)
            {
                cnt2++;
            }
            matrixInside2.get(cnt2).add(i%columSize2,ma2.get(i));
            
        }
        if(rowSize1==rowSize2 && columSize1==columSize2)
        {
                answer=model.add(matrixInside1, matrixInside2, rowSize1, columSize1);
                out.println("<p>");
                for(int i=0;i<rowSize1;i++)
                {
                    for(int e=0;e<columSize1;e++)
                    {
                        out.println(answer.get(i).get(e)+" ");
                    }
                    out.println("<br>");
                }
                out.println("</p>");
        }
        else
        {
             out =response.getWriter();
            out.println("the result for addition is undefined");
        }
        if(rowSize1==rowSize2 && columSize1==columSize2)
        {
                out =response.getWriter();
                out.println("<p>the result of sub</p>");
                answer=model.sub(matrixInside1, matrixInside2, rowSize1, columSize1);
                out.println("<p>");
                for(int i=0;i<rowSize1;i++)
                {
                    for(int e=0;e<columSize1;e++)
                    {
                        out.println(answer.get(i).get(e)+" ");
                    }
                    out.println("<br>");
                }
                out.println("</p>");
        }
        else
        {
             out =response.getWriter();
            out.println("the result for sub is undefined");
        }
        if((rowSize1==1 && columSize1==1) || (rowSize2==1  && columSize2==1))
        {
            out.println("pls your hand it`s easy :D <br>");
        }
        if(rowSize1==columSize2 && rowSize1!=1)
        {
            out =response.getWriter();
            out.println("<p>the result of mult</p>");
            answer=model.mult(matrixInside1, matrixInside2, rowSize1, rowSize2,columSize1,columSize2);
            out.println("<p>");
                for(int i=0;i<rowSize1;i++)
                {
                    for(int e=0;e<columSize1;e++)
                    {
                        out.println(answer.get(i).get(e)+" ");
                    }
                    out.println("<br>");
                }
                out.println("</p>");
        }
        else
        {
            out.println("</p>the matrix can`t multiply</p>");
        }
        
        out.println("<form action=\"Next2\" method=\"post\">"
                + "\n"
        +"<input type=\"submit\" value=\"History\"></form>");
    }
    

}
