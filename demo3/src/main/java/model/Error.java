package model;
import control.*;
/**
 *@version JDK 17
 * @author ai365ak
 */
public class Error extends Exception {
    /**
     * create a new object of control
     */
    Control control=new Control();

    /**
     * this the constructor
     */
    public Error()
    {
        control.wrongError();
    }

}
