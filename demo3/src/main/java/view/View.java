package view;
import java.util.*;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import control.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *this the view is like interface
 * @author ai365ak
 * @version JDK 17
 */
public class View extends javax.swing.JFrame  {
    /**
     * menubar this the mebubar
     */
    private JMenuBar menubar;
    /**
     * data this the data for history
     */
    private String[][] data= new String[100][100];
    /**
     * columName this the colum for the history
     */
    private String[] columName={"operation","size"};
    /**
     * historyCnt1 this the history counter
     */
    private int historyCnt1=0;
    /**
     * menu is the menu
     */
    private JMenu menu;
    /**
     * history is the menu iteam
     */
    private JMenuItem history;
    /**
     * cnt1 is the counter1
     */
    private int cnt1=0;
    /**
     * cnt2 is the counter 2
     */
    private int cnt2=0;
    /**
     * row11 is the row1
     */
    private int row11=0;
    /**
     * colum11 is the colum 1
     */
    private int colum11=0;
    /**
     * row22 is the row 2
     */
    private int row22=0;
    /**
     * colum22 is the colum 2
     */
    private int colum22=0;
    /**
     * matrix11 is the matrix 1
     */
    ArrayList<Integer> matrix11 = new ArrayList<>();
    /**
     * matrix22 is the matrix 2
     */
    ArrayList<Integer> matrix22 = new ArrayList<>();
    /**
     * JButton1 is the button 1
     */
    private javax.swing.JButton jButton1;
    /**
     * JButton2 is the button 2
     */
    private javax.swing.JButton jButton2;
    /**
     * JButton3 is the button 3
     */
    private javax.swing.JButton jButton3;
    /**
     * JButton4 is the button 4
     */
    private javax.swing.JButton jButton4;
    /**
     * JButton5 is the button 5
     */
    private javax.swing.JButton jButton5;
    /**
     * JButton6 is the button 6
     */
    private javax.swing.JButton jButton6;
    /**
     * jPanel1 is the panel 1
     */
    private javax.swing.JPanel jPanel1;
    /**
     * jPanel1 is the panel 2
     */
    private javax.swing.JPanel jPanel2;
    /**
     * jTabbedPane1 is the tapped panel
     */
    private javax.swing.JTabbedPane jTabbedPane1;
    /**
     * jTextField1 is the filed 1
     */
    private javax.swing.JTextField jTextField1;
    /**
     * jTextField2 is the filed 2
     */
    private javax.swing.JTextField jTextField2;
    /**
     * jTextField5 is the filed 5
     */
    private javax.swing.JTextField jTextField5;
    /**
     * jTextField6 is the filed 6
     */
    private javax.swing.JTextField jTextField6;
    /**
     * jTextField7 is the filed 7
     */
    private javax.swing.JTextField jTextField7;
    /**
     * jTextField8 is the filed 8
     */
    private javax.swing.JTextField jTextField8;



    /**
     * declare row1
     */
    private int row1;
    /**
     * declare row2
     */
    private int row2;
    /**
     * declare colum1
     */
    private int colum1;
    /**
     * declare colum2
     */
    private int colum2;
    /**
     * declare val
     */
    private int val;
    /**
     * declare matrix1
     */
    ArrayList<ArrayList<Integer> > matrix1= new ArrayList< >();
    /**
     * declare matrix2
     */
    ArrayList<ArrayList<Integer> > matrix2= new ArrayList< >();
    /**
     * declare choice
     */
    private int choice;
    /**
     * declare isNum
     */
    private boolean isNum;
    /**
     * create an object of scanner
     */
    private Scanner myObj= new Scanner(System.in);
    /**
     * constructor of View
     */
    private Control controll;

    /**
     *this the constructor
     * @param control this a control object
     */
    public View(Control control)
    {

        controll=control;
        initComponents();

        this.row1=row1;

        this.row2=row2;

        this.colum1=colum1;

        this.colum2=colum2;

        this.val=val;

        for(int i=0;i<10;i++)
        {

            this.matrix1.add(new ArrayList<>());

            this.matrix2.add(new ArrayList<>());
        }

        this.isNum=false;
    }
    /**
     * set method here i insert the input from the user
     * @param rowSize1 is the rowsize of matrix1
     * @param rowSize2 is the rowsize of matrix2
     * @param columSize1 is the rowsize of matrix1
     * @param columSize2 is the rowsize of matrix2
     */
    public void set(int rowSize1,int rowSize2,int columSize1,int columSize2)
    {

        row1=rowSize1;

        row2=rowSize2;

        colum1=columSize1;

        colum2=columSize2;

        isNum=false;

        System.out.println("pls insert the your choice:1-add 2-sub 3-mult 4-break ");

        do
        {

            if(myObj.hasNextInt())
            {

                choice=myObj.nextInt();

                isNum=true;
            }

            else
            {

                System.out.println("pls insert the your choice:1-add 2-sub 3-mult ~~Again~~ ");

                isNum=false;

                myObj.next();
            }
        }while((!isNum));

        isNum=false;

        System.out.println("pls insert the elments for matrix1");

        isNum=false;

        for(int i=0;i<row1;i++)
        {

            for(int o=0;o<colum1;o++)
            {


                do
                {

                    if(myObj.hasNextInt())
                    {

                        val=myObj.nextInt();

                        matrix1.get(i).add(o,val);

                        isNum=true;
                    }

                    else
                    {

                        System.out.println("pls insert this elment correctly");

                        myObj.next();

                        isNum=false;
                    }
                }
                while((!isNum));

            }
        }

        System.out.println("pls insert the elments for matrix2");

        isNum=false;

        for(int i=0;i<row2;i++)
        {

            for(int o=0;o<colum2;o++)
            {

                do
                {

                    if(myObj.hasNextInt())
                    {

                        val=myObj.nextInt();

                        matrix2.get(i).add(o,val);

                        isNum=true;
                    }

                    else
                    {

                        System.out.println("pls insert this elment correctly");

                        myObj.next();

                        isNum=false;
                    }
                }
                while((!isNum));

            }
        }
    }
    /**
     * this just return the value for row1
     * @return the num of rows  for matrix 1
     */
    public int getNoRow1()
    {
        return row1;
    }
    /**
     * this just return the value for row2
     * @return the number of rows for matrix 2
     */
    public int getNoRow2()
    {
        return row2;
    }
    /**
     * this just return the value for colucolum1
     * @return the number of colums for matrix 1
     */
    public int getNoColucolum1()
    {
        return colum1;
    }
    /**
     * this just return the value for colum2
     * @return the number of colums for matrix 2
     */
    public int getNocolum2()
    {
        return colum2;
    }
    /**
     * this return the matrix1
     * @return the matrix 1
     */
    public ArrayList<ArrayList<Integer>> getMatrix1()
    {
        return matrix1;
    }
    /**
     * this return the matrix2
     * @return the matrix 2
     */
    public ArrayList<ArrayList<Integer>> getMatrix2()
    {
        return matrix2;
    }
    /**
     * this return the choice
     * @return the choice
     */
    public int getChoice()
    {
        return choice;
    }
    /**
     * this print the notice to the user
     */
    public void sizeOfMatrix()
    {
        System.out.println("pls isnert the size less than 10");
    }
    /**
     * print undefine
     */
    public void printUndefine()
    {
        System.out.println("the result of sum and sub is undefine");
    }
    /**
     * print the matrix can`t multiply
     */
    public void printUnMult()
    {
        System.out.println("the matrix can`t multiply");
    }
    /**
     * print the result of add
     * @param matrix is the matrix
     */
    public void printAdd(ArrayList<ArrayList<Integer>> matrix)
    {
        for(int i=0;i<row1;i++)
        {
            for(int o=0;o<colum1;o++)
            {
                System.out.print(matrix.get(i).get(o));
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    /**
     * print the result of sub
     * @param matrix is the matrix
     */
    public void printSub(ArrayList<ArrayList<Integer>> matrix)
    {
        for(int i=0;i<row1;i++)
        {
            for(int o=0;o<colum1;o++)
            {
                System.out.print(matrix.get(i).get(o));
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    /**
     * print the result of mult
     * @param matrix1 is the matrix
     */
    public void printMult(ArrayList<ArrayList<Integer>> matrix1)
    {

        for (int i=0;i<row1;i++)
        {

            for(int o=0;o<colum2;o++)
            {

                System.out.print(matrix1.get(i).get(o));

                System.out.print(" ");
            }

            System.out.println("");
        }
    }
    /**
     * print wrong to the user
     */
    public void printWrong()
    {
        System.out.println("you enter a wrong size or wrong type");
    }
    /**
     * this method for init the componets for gui
     */
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        history=new JMenuItem("history");
        menubar=new JMenuBar();
        menu=new JMenu("menu");
        menu.add(history);
        menubar.add(menu);
        ActionListener action=(ActionEvent e) -> {
            JFrame frame=new JFrame();
            JTable jt=new JTable(data,columName);
            JScrollPane sp=new JScrollPane(jt);
            frame.add(sp);
            frame.setVisible(true);
        };
        history.addActionListener(action);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jTextField6.addActionListener((java.awt.event.ActionEvent evt) -> {
            jTextField6ActionPerformed(evt);
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });

        jButton3.setText("Enter2");
        jButton3.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton3ActionPerformed(evt);
        });

        jButton4.setText("Enter1");
        jButton4.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton4ActionPerformed(evt);
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Size", jPanel1);

        jTextField1.addActionListener((java.awt.event.ActionEvent evt) -> {
            jTextField1ActionPerformed(evt);
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jButton1.setText("enter1");
        jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton1ActionPerformed(evt);
        });

        jButton2.setText("enter2");
        jButton2.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton2ActionPerformed(evt);
        });

        jButton5.setText("reset");
        jButton5.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButton5ActionPerformed(evt);
        });

        jButton6.setText("result");
        jButton6.addActionListener(this::jButton6ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(23, 23, 23))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Input", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        setVisible(true);
        pack();
    }
    /**
     * this method to prevent type and character except number and back_space
     * @param evt
     */
    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {
        char input=evt.getKeyChar();
        if(!(Character.isDigit(input)) ||  input==KeyEvent.VK_BACK_SPACE)
        {
            evt.consume();
        }
    }
    /**
     * this method to prevent type and character except number and back_space
     * @param evt
     */
    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {
        char input=evt.getKeyChar();
        if(!(Character.isDigit(input)) ||  input==KeyEvent.VK_BACK_SPACE)
        {
            evt.consume();
        }
    }
    /**
     * this method to prevent type and character except number and back_space
     * @param evt
     */
    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {
        char input=evt.getKeyChar();
        if(!(Character.isDigit(input)) ||  input==KeyEvent.VK_BACK_SPACE)
        {
            evt.consume();
        }
    }
    /**
     * this method to prevent type and character except number and back_space
     * @param evt
     */
    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {
        char input=evt.getKeyChar();
        if(!(Character.isDigit(input)) ||  input==KeyEvent.VK_BACK_SPACE)
        {
            evt.consume();
        }
    }
    /**
     * this method for the action when prees the button
     * @param evt
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {

        String text1=jTextField5.getText();
        String text2=jTextField6.getText();
        row11=Integer.parseInt(text1);
        colum11=Integer.parseInt(text2);
        if(row11<0 || colum11<0 || row11>10 || colum11>10)
        {
            JFrame frame =new JFrame();
            JOptionPane.showMessageDialog(frame ,"pls enter the correct size");
            System.exit(0);
        }
    }
    /**
     * this method for the action when prees the button
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        String text1=jTextField7.getText();
        String text2=jTextField8.getText();
        row22=Integer.parseInt(text1);
        colum22=Integer.parseInt(text2);
        if(row22<0 || colum22<0 || row22>10 || colum22>10)
        {
            JFrame frame =new JFrame();
            JOptionPane.showMessageDialog(frame ,"pls enter the correct size");
            System.exit(0);
        }
    }
    /**
     * this method to prevent type and character except number and back_space
     * @param evt
     */
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {
        char input=evt.getKeyChar();
        if(!(Character.isDigit(input)) ||  input==KeyEvent.VK_BACK_SPACE)
        {
            evt.consume();
        }
    }
    /**
     * this method to prevent type and character except number and back_space
     * @param evt
     */
    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {
        char input=evt.getKeyChar();
        if(!(Character.isDigit(input)) ||  input==KeyEvent.VK_BACK_SPACE)
        {
            evt.consume();
        }
    }
    /**
     * this method for the action when prees the button
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        if(cnt1<row11*colum11)
        {

            String text1=jTextField1.getText();
            int num=Integer.parseInt(text1);
            matrix11.add(num);
            cnt1++;
        }
        else
        {

            JFrame frame=new JFrame();
            JOptionPane.showMessageDialog(frame,"Pls it`s enough you insert like the size");
        }
    }
    /**
     * this method for the action when prees the button
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if(cnt2<row22*colum22)
        {

            String text1=jTextField2.getText();
            int num=Integer.parseInt(text1);
            matrix22.add(num);
            cnt2++;
        }
        else
        {
            JFrame frame=new JFrame();
            JOptionPane.showMessageDialog(frame,"Pls it`s enough you insert like the size");
        }
    }
    /**
     * this method for the action when prees the button
     * @param evt
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        cnt1=0;cnt2=0;
        matrix11.clear();matrix22.clear();
    }
    /**
     * this method for the action when prees the button
     * @param evt
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        //here
        ArrayList<ArrayList<Integer> > result= new ArrayList< >();
        ArrayList<ArrayList<Integer> > ma1= new ArrayList< >();
        ArrayList<ArrayList<Integer> > ma2= new ArrayList< >();
        String answer="";

        for(int i=0;i<30;i++)
        {
            ma1.add(new ArrayList<>());
            ma2.add(new ArrayList<>());
        }
        for(int i=0;i<row11;i++)
        {
            for(int o=0;o<colum11;o++)
            {
                ma1.get(i).add(o,matrix11.get(o));
            }

        }
        for(int i=0;i<row22;i++)
        {
            for(int o=0;o<colum22;o++)
            {
                ma2.get(i).add(o,matrix22.get(o));
            }

        }

        JFrame frame =new JFrame();
        answer="";
        answer+="Add\n";

        if(row11==row22 && colum11==colum22)
        {


            result=controll.calculateAdd(ma1, ma2, row11, colum11);
            for(int i=0;i<row11;i++ )
            {
                for(int o=0;o<colum11;o++)
                {
                    answer+=result.get(i).get(o)+" ";
                }
                answer+="\n";
            }
            JOptionPane.showMessageDialog(frame ,answer);
        }
        else
        {
            JOptionPane.showMessageDialog(frame ,"Add \n the answer is undefined");
        }

        answer="";
        answer+="Sub\n";

        if(row11==row22 && colum11==colum22)
        {
            result=controll.calculateSub(ma1, ma2, row11, colum11);
            for(int i=0;i<row11;i++ )
            {
                for(int o=0;o<colum11;o++)
                {
                    answer+=result.get(i).get(o)+" ";
                }
                answer+="\n";
            }
            JOptionPane.showMessageDialog(frame ,answer);
        }
        else
        {
            JOptionPane.showMessageDialog(frame ,"Sub \n the answer is undefined");
        }


        answer="";
        answer+="Mult\n";

        if(row11==colum22|| (row11==1 && colum11==1 )|| (row22==1 &&colum22==1))
        {
            result=controll.calculateMult(ma1, ma2, row11, row22,colum11,colum22);
            for(int i=0;i<row11;i++ )
            {
                for(int o=0;o<colum11;o++)
                {
                    answer+=result.get(i).get(o)+" ";
                }
                answer+="\n";
            }
            JOptionPane.showMessageDialog(frame ,answer);
        }
        else
        {
            JOptionPane.showMessageDialog(frame ,"Mult\n the answer is undefined");
        }

        data[historyCnt1][0]="All operation mult+sub+add";
        data[historyCnt1][1]="size for matrix1 and matrix 1"+"("+row11+","+colum11+")"+","+"("+row22+" "+colum22+")";
        historyCnt1++;
        //System.exit(0);


    }

    private void jTextField6ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void jTextField1ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }






}
