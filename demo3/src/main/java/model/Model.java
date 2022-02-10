package model;
import java.util.*;
import control.*;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * this model class to mainpulate the data
 *@version JDK 17
 *@author aibak aljdadayah
 */
@Entity
@Table(name="MODEL")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String operation;
    /**
     * res is the result
     */
    @Transient
    private int res;
    /**
     * declare resAdd matrix
     */
    @Transient
    ArrayList<ArrayList<Integer> > resAdd= new ArrayList<ArrayList<Integer> >();
    /**
     * declare resSub matrix
     */
    @Transient
    ArrayList<ArrayList<Integer> > resSub= new ArrayList<ArrayList<Integer> >();
    /**
     * declare resMult matrix
     */
    @Transient
    ArrayList<ArrayList<Integer> > resMult= new ArrayList<ArrayList<Integer> >();
    /**
     * here is the constructer
     */
    public Model()
    {
        for(int i=0;i<10;i++)
        {

            this.resMult.add(new ArrayList<Integer>());

            this.resSub.add(new ArrayList<Integer>());

            this.resAdd.add(new ArrayList<Integer>());
        }

    }
    /**
     * here the addion operation
     * @param matrix1 is the matrix 1
     * @param matrix2  is the matrix 2
     * @param row1 is the num of rows in matrix 1
     * @param colum1 is the num of colus in matrix 2
     * @return resAdd the result of sum
     */
    public ArrayList<ArrayList<Integer>> add(ArrayList<ArrayList<Integer>> matrix1,ArrayList<ArrayList<Integer>> matrix2,int row1,int colum1)
    {



        for(int i=0;i<row1;i++)
        {

            for(int o=0;o<colum1;o++)
            {
                res=matrix1.get(i).get(o)+matrix2.get(i).get(o);


                resAdd.get(i).add(o,res);
            }
        }

        return resAdd;
    }
    /**
     * here the subtraction operation
     * @param matrix1  is the matrix 1
     * @param matrix2 is the matrix 2
     * @param row1 is the number of rows for matrix 1
     * @param colum1 is the colum1
     * @return resSub the result of subtraction
     */
    public ArrayList<ArrayList<Integer>> sub(ArrayList<ArrayList<Integer>> matrix1,ArrayList<ArrayList<Integer>> matrix2,int row1,int colum1)
    {
        

        for(int i=0;i<row1;i++)
        {

            for(int o=0;o<colum1;o++)
            {
                res=matrix1.get(i).get(o)-matrix2.get(i).get(o);

                resSub.get(i).add(o,res);
            }
        }

        return resSub;
    }
    /**
     * here the multipiaction operation
     * @param matrix1 is the matrix 1
     * @param matrix2 is the matrix 2
     * @param row1 is the num of row for matrix 1
     * @param row2 is the num of rows for matrix 2
     * @param colum1 is the num of colums for matrix 1
     * @param colum2 this the colum2
     * @return resMult the result of multi
     */
    public ArrayList<ArrayList<Integer>> mult(ArrayList<ArrayList<Integer>> matrix1,ArrayList<ArrayList<Integer>> matrix2,int row1,int row2,int colum1 ,int colum2)
    {

        for (int i=0;i<row1;i++)
        {

            for(int o=0;o<colum2;o++)
            {

                res=0;
                for(int e=0;e<row2;e++)
                {
                    res+=matrix1.get(i).get(e)*matrix2.get(e).get(o);


                }

                resMult.get(i).add(o,res);
            }
        }

        return resMult;
    }
    /**
     * check is a boolean variable to check
     */
    @Transient
    private boolean check;

    /**
     *this method for check the size of matrix
     * @param size is the size of the matrx
     * @return true to inform the size is correct
     * @throws Error if error happen
     */
    public boolean checkSize(int ...size) throws Error
    {
        for(int num:size){
            if(num<0 || num>10)
            {
                throw new Error();
            }
        }
        return true;

    }
    public void setAdd(ArrayList<ArrayList<Integer>> add)
    {
        resAdd=add;
    }
    public void setSub(ArrayList<ArrayList<Integer>> sub)
    {
        resAdd=sub;
    }
    public void setMult(ArrayList<ArrayList<Integer>> mult)
    {
        resMult=mult;
    }
    public ArrayList<ArrayList<Integer>> getAdd()
    {
        return resAdd;
    }
    public ArrayList<ArrayList<Integer>> getSub()
    {
        return resSub;
    }
    public ArrayList<ArrayList<Integer>> getMult()
    {
        return resMult;
    }
    public void setOperation(String operations)
    {
        operation=operations;
    }
    public String getOperations()
    {
        return "allOperationsHappend(mult+addition+sub)";
    }
}
