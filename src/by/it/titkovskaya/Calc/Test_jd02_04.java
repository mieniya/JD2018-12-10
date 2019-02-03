package by.it.titkovskaya.Calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test_jd02_04 {
    @Test
    public void scalar_add() throws Exception {
        Parser parser=new Parser();
        //тут ваши выражения
        String actualA = parser.calc("A=2+5.3");
        assertEquals("7.3",actualA);
    }

    @Test
    public void scalar_mul() throws Exception {
        Parser parser=new Parser();
        //тут ваши выражения
        String actualB = parser.calc("B=A*3.5");
        assertEquals("25.55",actualB);
    }

    // .... etc
    // .... etc
    // .... etc


}