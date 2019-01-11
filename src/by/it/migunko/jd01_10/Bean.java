package by.it.migunko.jd01_10;

public class Bean {

    @Param(a=10, b=20)
    double sum(int x, int y){
        return x+y;
    }
    @Param(a=10, b=5)
    double max(int d, int z){
        return d>z ? d:z;
    }
    double min(int a1, int a2){
        return a1<a2?a1:a2;
    }

}

