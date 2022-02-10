package main;

import control.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * main class
 * @author aibak aljdayah
 * @version JDK 17
 */
public class Main {


    /**
     * is the main
     * @param args this the command line arguments
     */
    public static void main(String[] args)  {

        int rowSize1;
        int rowSize2;
        int columSize1;
        int columSize2;
        try
        {
            rowSize1=Integer.parseInt(args[0]);
        }catch (NumberFormatException e)
        {
            rowSize1=0;
        }
        try
        {

            rowSize2=Integer.parseInt(args[1]);
        }catch (NumberFormatException e)
        {
            rowSize2=0;
        }
        try
        {

            columSize1=Integer.parseInt(args[2]);
        }catch(NumberFormatException e)
        {
            columSize1=0;
        }
        try
        {


            columSize2=Integer.parseInt(args[3]);
        }catch (NumberFormatException e)
        {
            columSize2=0;
        }

        Control control=new Control();


        if(args.length==4)
        {
            try
            {
                control.control(rowSize1,rowSize2,columSize1,columSize2);
            }
            catch(model.Error err)
            {
                System.exit(0);
            }    catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else
        {

            control.wrong();
        }

    }
}
