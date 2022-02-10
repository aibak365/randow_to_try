package model;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * this is the test class
 * @author ai365ak
 * @version JDK 1.8
 */

public class ModelTest {
    /**
     * this to make a stream of number
     * @return Stream<Arguments> it a stream of number
     */
    static Stream<Arguments> provideSize() {
        return Stream.of(
                Arguments.of(2,-1 ,1)

        );
    }
    /**
     * this to make stream of matrix
     * @return Stream<Arguments> it return stream of matrix
     */
    static Stream<Arguments> provideMatrices() {

        List<List<Integer>> matrix1 = new ArrayList<>();

        List<List<Integer>> matrix2 = new ArrayList<>();

        matrix1.add(new ArrayList<>());

        matrix1.add(new ArrayList<>());

        matrix1.get(0).add(0,1);

        matrix1.get(0).add(1,1);

        matrix1.get(1).add(0,1);

        matrix1.get(1).add(1,1);

        matrix2.add(new ArrayList<>());

        matrix2.add(new ArrayList<>());

        matrix2.get(1).add(0,1);

        matrix2.get(1).add(1,1);

        matrix2.get(0).add(0,1);

        matrix2.get(0).add(1,1);

        return Stream.of(Arguments.of(matrix1),Arguments.of(matrix2));
    }
    /**
     * Test of add method, of class Model.
     * @param matrix11 is the matrix 1
     */
    @ParameterizedTest
    @MethodSource("provideMatrices")
    public void testAdd(ArrayList<ArrayList<Integer>> matrix11) {
        System.out.println("add");
        ArrayList<ArrayList<Integer>> matrix1 = new ArrayList<ArrayList<Integer>>();
        matrix1=matrix11;
        ArrayList<ArrayList<Integer>> matrix2 = new ArrayList<ArrayList<Integer>>();
        matrix2=matrix11;
        int row1 = 2;
        int colum1 = 2;
        Model instance = new Model();
        ArrayList<ArrayList<Integer>> expResult = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            expResult.add(new ArrayList<Integer>());
            matrix1.add(new ArrayList<Integer>());
            matrix2.add(new ArrayList<Integer>());
        }

        expResult.get(0).add(0, 2);
        expResult.get(0).add(1, 2);
        expResult.get(1).add(0, 2);
        expResult.get(1).add(1, 2);
        ArrayList<ArrayList<Integer>> result = instance.add(matrix1, matrix2, row1, colum1);
        assertEquals(expResult, result);
    }

    /**
     * Test of sub method, of class Model.
     * @param matrix11 is the matrix 1
     */
    @ParameterizedTest
    @MethodSource("provideMatrices")
    public void testSub(ArrayList<ArrayList<Integer>> matrix11) {
        System.out.println("sub");
        ArrayList<ArrayList<Integer>> matrix1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> matrix2 = new ArrayList<ArrayList<Integer>>();
        matrix1=matrix11;
        matrix2=matrix11;
        int row1 = 2;
        int colum1 = 2;
        Model instance = new Model();
        ArrayList<ArrayList<Integer>> expResult = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            expResult.add(new ArrayList<Integer>());
            matrix1.add(new ArrayList<Integer>());
            matrix2.add(new ArrayList<Integer>());
        }
        expResult.get(0).add(0, 0);
        expResult.get(0).add(1, 0);
        expResult.get(1).add(0, 0);
        expResult.get(1).add(1, 0);
        ArrayList<ArrayList<Integer>> result = instance.sub(matrix1, matrix2, row1, colum1);
        assertEquals(expResult, result);

    }

    /**
     * Test of mult method, of class Model.
     * @param matrix11 is the matrix 1
     */
    @ParameterizedTest
    @MethodSource("provideMatrices")
    public void testMult(ArrayList<ArrayList<Integer>> matrix11) {
        System.out.println("Mult");
        ArrayList<ArrayList<Integer>> matrix1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> matrix2 = new ArrayList<ArrayList<Integer>>();
        matrix1=matrix11;
        matrix2=matrix11;
        int row1 = 2;
        int colum1 = 2;
        int row2 = 2;
        int colum2 = 2;
        Model instance = new Model();
        ArrayList<ArrayList<Integer>> expResult = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            expResult.add(new ArrayList<Integer>());
            matrix1.add(new ArrayList<Integer>());
            matrix2.add(new ArrayList<Integer>());
        }

        expResult.get(0).add(0, 2);
        expResult.get(0).add(1, 2);
        expResult.get(1).add(0, 2);
        expResult.get(1).add(1, 2);
        ArrayList<ArrayList<Integer>> result = instance.mult(matrix1, matrix2, row1, colum1, row2, colum2);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkSize method, of class Model.
     * @param size this the correct size of matrix
     * @param incorectSize this the incorrect size
     * @param borderSize this the border size
     * @throws model.Error this throw when error happen
     */

    @ParameterizedTest
    @MethodSource("provideSize")
    public void testCheckSize(int size, int incorectSize, int borderSize) throws Error {
        System.out.println(size);
        Model instance = new Model();
        System.out.print(size);
        assertEquals(true, instance.checkSize(size));
        assertThrows(Error.class,() -> instance.checkSize(incorectSize));
        assertEquals(true, instance.checkSize(borderSize));

    }
}
