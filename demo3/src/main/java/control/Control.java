package control;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.*;
import view.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * this for control the program
 *@version JDK 1.8
 * @author aibaak aljdadayah
 */
public class Control extends HttpServlet {

    /**
     *rowSize1 this size for row in the matrix1
     */
    public static int rowSize1=0,

    /**
     *rowSize this the size for the row in the matrix 2
     */
    rowSize2=0,

    /**
     *columSize1 this the size for the colum in matrix 1
     */
    columSize1=0,

    /**
     *columSize2 this the size for the colum in matrix 2
     */
    columSize2=0;
    /**
     * this the array 1
     */
    ArrayList<Integer> array1=new ArrayList<>();
    /**
     * this is the array 2
     */
    ArrayList<Integer> array2=new ArrayList<>();
    /**
     * this is the loop array
     */
    ArrayList<String> loop=new ArrayList<>();
    /**
     * this the array of Integer
     */
     ArrayList<Integer> integ=new ArrayList<>();

    /**
     *
     * @param request this respnsible of request
     * @param response this respnsible of response
     * @throws IOException this if IOE error happend
     */
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        loop.add("row1");loop.add("row2");loop.add("colum1");loop.add("colum2");
        for(int i=0;i<4;i++)
        {
            try
            {
                if(i==0)
                {
                    rowSize1=Integer.parseInt(request.getParameter(loop.get(i)));
                }
                else if(i==1)
                {
                     rowSize2=Integer.parseInt(request.getParameter(loop.get(i)));
                }
                else if(i==2)
                {
                    columSize1=Integer.parseInt(request.getParameter(loop.get(i)));
                }
                else
                {
                    columSize2=Integer.parseInt(request.getParameter(loop.get(i)));
                }
               
            }
            catch(NumberFormatException e)
            {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST,"this bad format :( ");
                rowSize1=0;rowSize2=0;columSize1=0;columSize2=0;
                break;
            }
        }
        
        try{model.checkSize(rowSize1,rowSize2,columSize1,columSize2);}
        catch (model.Error e)
        {
            
            RequestDispatcher rd=request.getRequestDispatcher("Help");
            rd.include(request, response);
            rowSize1=0;rowSize2=0;columSize1=0;columSize2=0;

        }
        PrintWriter out =response.getWriter();
            response.setContentType("text/html; charset=utf-8");
            for(int i=0;i<rowSize1*columSize1;i++)
            {
                String s="cell"+i;

                out.println("<form action=\"Next1\" method=\"post\">\n" +
                        "    Enter the element for matrix 1:  <input type=\"text\" name=\""+s+"\"><br>\n");
            }
           
            for(int i=rowSize1*columSize1;i<rowSize2*columSize2+rowSize1*columSize1;i++)
            {
                String s="cell"+i;
                out.println("<form action=\"Next1\" method=\"post\">\n" +
                        "    Enter the element for matrix 2:  <input type=\"text\" name=\""+s+"\"><br>\n");
            }
            out.println("<input type=\"submit\">"+"</form>");
            
        
    }
    /**
     * checkCondtioin this to check the condition 
     */
    private boolean checkCondition;
    /**
     * matrix 1 is the matrix 1
     */
    ArrayList<ArrayList<Integer> > matrix1= new ArrayList<ArrayList<Integer> >();
    /**
     * matrix2 is the matrix 2
     */
    ArrayList<ArrayList<Integer> > matrix2= new ArrayList<ArrayList<Integer> >();
    /**
     * row1 is the rows for matrix 1
     */
    private int row1;
    /**
     * colum1 is the colums for matrix 1
     */
    private int colum1;
    /**
     * row2 is the rows for matrix 1
     */
    private int row2;
    /**
     * colum2is the colus for matrix 2
     */
    private int colum2;
    /**
     * is the choice of user
     */
    private int choice;
    /**
     * refernce of View
     */
    private View view;
    /**
     * regerncve if Model
     */
    private Model model;

    /**
     * here the construction for controller and inti the variables
     */
    Control control;

    /**
     *control constructor
     */
    public Control()
    {

        for(int i=0;i<10;i++)
        {

            matrix1.add(new ArrayList<Integer>());

            matrix2.add(new ArrayList<Integer>());
        }



        view=new View(this);

        model=new Model();

        this.matrix1=view.getMatrix1();

        this.matrix2=view.getMatrix2();

        this.row1=view.getNoRow1();

        this.colum1=view.getNoColucolum1();

        this.choice=view.getChoice();

        this.row2=view.getNoRow2();

        this.colum2=view.getNocolum2();

        this.model=model;

        this.view=view;


    }
    /**
     * this method to tell the model to work and view also
     * @param rowSize1 is just the size of of row in matrix1
     * @param rowSize2 is just the size of of row in matrix2
     * @param columSize1 is just the size of of row in matrix1
     * @param columSize2 is just the size of of row in matrix2
     * @throws java.lang.Exception this throw when error happen
     */
    public void control(int rowSize1,int rowSize2,int columSize1,int columSize2) throws Exception
    {


        while(1==1)
        {
            if(!model.checkSize(rowSize1,rowSize2,columSize1,columSize2))
            {
                throw new model.Error();
            }

            view.set(rowSize1,rowSize2,columSize1,columSize2);


            choice=view.getChoice();

            matrix1=view.getMatrix1();

            matrix2=view.getMatrix2();

            row1=rowSize1;

            row2=rowSize2;

            colum1=columSize1;

            colum2=columSize2;








            if(choice==1 || choice==2)
            {

                if(row1==row2 && colum1==colum2)
                {

                    if(choice==1)
                    {
                        view.printAdd(model.add(matrix1,matrix2,row1,colum1));
                    }

                    if(choice==2)
                    {
                        view.printSub(model.sub(matrix1,matrix2,row1,colum1));
                    }
                }

                else
                {

                    view.printUndefine();
                }
            }

            if(choice==3)
            {

                if(row1==colum2|| (row1==1 && colum1==1 )|| (row2==1 &&colum2==1))
                {

                    view.printMult(model.mult(matrix1,matrix2,row1,row2,colum1,colum2));
                }
                else
                {

                    view.printUnMult();
                }
            }

            if (choice==4)
            {

                break;
            }





        }

    }
    /**
     * this method work when wrong happend in command line argument
     */
    public void wrong()
    {

        view.printWrong();

        System.exit(0);
    }

    /**
     * this method start when wrongHappend
     */
    public void wrongError()
    {

        view.printWrong();


    }

    /**
     * this for calculate the add
     * @param mat1 is the matrix1
     * @param mat2  is the matrix 2
     * @param row11 is the row1
     * @param colum11 is the colum 1
     * @return the result of addition
     */
    public ArrayList<ArrayList<Integer> > calculateAdd(ArrayList<ArrayList<Integer> > mat1,ArrayList<ArrayList<Integer> >mat2,int row11,int colum11)
    {
        return model.add(mat1,mat2,row11,colum11);
    }
    

    /**
     *this for calculate the sun
     * @param mat1 is the matrix1
     * @param mat2 is the matrix 2
     * @param row11 is the row1
     * @param colum11 is the colum 1
     * @return the result of addition
     */
    public ArrayList<ArrayList<Integer> > calculateSub(ArrayList<ArrayList<Integer> > mat1,ArrayList<ArrayList<Integer> >mat2,int row11,int colum11)
    {
        return model.sub(mat1,mat2,row11,colum11);
    }

    /**
     *this for calculate the mult
     * @param mat1 is the matrix1
     * @param mat2 is the matrix 2
     * @param row11 is the row1
     * @param row22 is the row2
     * @param colum11 is the colum 1
     * @param colum22 is the colum 2
     * @return the result of mult
     */
    public ArrayList<ArrayList<Integer> > calculateMult(ArrayList<ArrayList<Integer> > mat1,ArrayList<ArrayList<Integer> >mat2,int row11,int row22,int colum11,int colum22)
    {
        return model.mult(mat1,mat2,row11,row22,colum11,colum22);
    }
    



}
