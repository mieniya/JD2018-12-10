package by.it.naron.jd01_14;

import java.io.*;

public class TaskA {


    static File getTargetFile(String name) {
        File projDir = new File("");
        String path = projDir.getAbsolutePath();
        String pack = TaskA.class.getName();
        pack = pack.replaceAll("\\.", "/");
        String classPath = path + "/src/" + pack;
        File classDir = new File(classPath).getParentFile();
        String fullName = classDir + "/" + name;
        return new File(fullName);
    }


    private static String getPath(Class<?> clazz){
       String path = System.getProperty("user.dir")+File.separator+"src"+File.separator;
       String cdDir = clazz.getName().replace(clazz.getSimpleName(),"")
               .replace(".",File.separator);
       return path+cdDir;
    }


    public static void main(String[] args) {
        DataOutputStream dos = null;
        try  { dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream
                                (getPath(TaskA.class)+"dataTaskA.bin")));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int)(Math.random()*25));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (dos !=null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //////////////////////////////////////////////////

        try (DataInputStream inp = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream
                                (getPath(TaskA.class)+"dataTaskA.bin")));
             PrintWriter out2 = new PrintWriter(
                     new FileWriter(getPath(TaskA.class)+"resultTaskA.txt"))
        ){
            double sum = 0;
            double count = 0;
            while (inp.available()>0){
                int i = inp.readInt();
                System.out.print(i + " ");
                sum+=i;
                count++;
            }
            System.out.println("\navg="+sum/count);
            out2.print("\navg="+sum/count);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
