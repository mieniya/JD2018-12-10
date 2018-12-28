package by.it.migunko.jd01_07;

class Vector extends Var{
    private double[] value;
    Vector(double[] value){
        this.value=value;
    }
    Vector(Vector vector){
        this.value=vector.value;
    }
    Vector(String str){
        String s=str.substring(1,str.length()-1);
        String[] strValues=s.split(",");
        this.value=new double[strValues.length];
        for (int i=0;i<strValues.length;i++){
            value[i]=Double.parseDouble(strValues[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimetr="";
        for (double element:value){
            sb.append(delimetr).append(element);
            delimetr=", ";

        }
     sb.append("}");
        return sb.toString();
    }
}
