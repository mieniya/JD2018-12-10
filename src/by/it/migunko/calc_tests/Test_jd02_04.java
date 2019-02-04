package by.it.migunko.calc_tests;
import org.junit.Test;

import static org.junit.Assert.*;
public class Test_jd02_04 {
    @Test
    public void TaskA() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("A=2+5.3");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 7.3, res, 1e-20);


        var = parser.calc("B=A*3.5");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 25.55, res, 1e-20);

        var = parser.calc("B1=B+0.11*-5");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 25, res, 1e-20);

        var = parser.calc("B2=A/2-1");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 2.65, res, 1e-20);
    }

    @Test
    public void TaskB() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("C=B+(A*2)");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 40.15, res, 1e-20);

        var = parser.calc("D=((C-0.15)-20)/(7-5)");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 10, res, 1e-20);

        /*var = parser.calc("E={2,3}*(D/2)");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", "{10.0,15.0}", res);*/
    }

    @Test
    public void AddVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2,3}+1");
        assertEquals("Ошибка", "{3.0, 4.0}", var.toString());

        var = parser.calc("1+{2,3}");
        assertEquals("Ошибка", "{3.0, 4.0}", var.toString());

        var = parser.calc("{2,3}+{1,2}");
        assertEquals("Ошибка", "{3.0, 5.0}", var.toString());
    }

    @Test
    public void SubVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2,3}-1");
        assertEquals("Ошибка", "{1.0, 2.0}", var.toString());

        var = parser.calc("{2,3}-2");
        assertEquals("Ошибка", "{0.0, 1.0}", var.toString());

        var = parser.calc("{2,3}-{1,2}");
        assertEquals("Ошибка", "{1.0, 1.0}", var.toString());
    }

    @Test
    public void mulVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2,3}*1");
        assertEquals("Ошибка", "{2.0, 3.0}", var.toString());

        var = parser.calc("2*{2,3}");
        assertEquals("Ошибка", "{4.0, 6.0}", var.toString());

        var = parser.calc("{2,3}*{1,2}");
        assertEquals("Ошибка", "8.0", var.toString());
    }

    }


