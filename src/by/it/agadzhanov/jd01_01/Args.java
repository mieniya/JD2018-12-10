package by.it.agadzhanov.jd01_01;

class Args {
    private String[] args;

    Args(String[] args)  {  //конструктор класса
        this.args=args;
    }

    void printArgs()  {    //метод класса
        int i=1;
        for (String arg:args)  {
            i=i+1;
            System.out.println("Аргумент " + i + "=" + arg);
        }
    }
}
