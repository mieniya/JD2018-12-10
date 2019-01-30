package by.it.skosirskiy.jd01_15;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.Iterator;

/*В программе создайте хотя бы 5 разных комментариев: 2 однострочных, 2 многострочных и 1 JavaDoc
 Программа должна прочитать свой собственный текст в переменную типа StringBuilder.
*/
public class TaskB {
    static String src = System.getProperty("user.dir")+"\\src\\by\\it\\skosirskiy\\";
    static String fileOutTxt = src+"jd01_15\\TaskB.txt";
    static String fileInTxt = src+"jd01_15\\TaskB.java";
    public static void main(String[] args) {

        /*asdxzc
         */

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(fileInTxt)
                     );
             PrintWriter printer = new PrintWriter(new FileWriter(fileOutTxt)))
        {

            StringBuilder sb = new StringBuilder();
            String line;
            //xzcvvs

            while ((line = reader.readLine())!=null){
                sb.append(line+"\n");
            }

            while (!(sb.indexOf("/*")==-1)){
                sb.replace(sb.indexOf("/*"), sb.indexOf("*/")+2,"");
            }

            while (!(sb.indexOf("//")==-1)){
                sb.replace(sb.indexOf("//"), sb.indexOf("\n", sb.indexOf("//")),"");
            }


            printer.println(sb);

            /*
             */

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
