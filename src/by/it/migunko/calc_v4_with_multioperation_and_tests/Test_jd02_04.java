package by.it.migunko.calc_v4_with_multioperation_and_tests;
import org.junit.Test;

import static org.junit.Assert.*;
public class Test_jd02_04 {

    @Test
    public void Task_A() throws Exception{
        Parser parser=new Parser();
        String actual=parser.calc("A=2+5.3");
        assertEquals("Error","7.3",actual);

        actual=parser.calc("B=A*3.5");
        assertEquals("Error","25.55",actual);

        actual=parser.calc("B1=B+0.11*-5");
        assertEquals("Error","25.0",actual);

        actual=parser.calc("B2=A/2-1");
        assertEquals("Error","2.65",actual);
    }

    
    @Test
    public void Task_B() throws Exception{
        Parser parser=new Parser();
        String actual=parser.calc("C=B+(A*2)");
        assertEquals("Error","40.15",actual);

        actual=parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("Error","10.0",actual);

        actual=parser.calc("E={2,3}*(D/2)");
        assertEquals("Error","{10.0, 15.0}",actual);
    }

}
