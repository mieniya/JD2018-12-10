package by.it.zagurskaya.jd01_03;

    public class InOut {
        /**
         * Input string or vector
         * @param line line
         * @return one-dimensional array
         */
        static double[] getArray(String line) {
            //1 2 3 4 5 6 99 89__
            line=line.trim();
            String[] strArr= line.split(" ");
            double [] res= new double[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                res[i]=Double.parseDouble(strArr[i]);
            }
            return res;
        }

        /**
         * Print array
         * @param arr one-dimensional array
         */
        static void printArray (double[] arr) {
            for (double element : arr) {
                System.out.print(element+" ");
            }
            System.out.println();
        }

        /**
         * Print one-dimensional array with name and number of columns
         * @param arr one-dimensional array
         * @param name name one-dimensional array
         * @param columnCount count one-dimensional array
         */
        static void printArray(double[ ] arr, String name, int columnCount) {
            for (int i = 0; i <arr.length; i++) {
                System.out.printf("%s[%-3d]=%-7.3f",name,i,arr[i]);
                if ((i+1)%columnCount == 0 || i==arr.length-1)
                    System.out.println();
            }
        }
    }

