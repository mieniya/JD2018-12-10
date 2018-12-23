package by.it.akhmelev.jd01_02;

public class TaskC {

    static int[][] step3(int[][] mas) {
        boolean[] delCol = new boolean[mas[0].length];
        boolean[] delRow = new boolean[mas.length];
        //find max
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > max)
                    max = mas[i][j];
            }
        }
        //mark deleted position
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    delCol[j] = true;
                    delRow[i] = true;
                }
            }
        }
        //calc size
        int rowCount = 0;
        for (boolean value : delRow) if (!value) rowCount++;
        int colCount = 0;
        for (boolean value : delCol) if (!value) colCount++;
        //create result
        int[][] res = new int[rowCount][colCount];

        //fill result
        int ir=0;
        int jr=0;
        for (int i = 0; i < mas.length; i++) {
            if (!delRow[i]) {
                for (int j = 0; j < mas[i].length; j++) {
                    if (!delCol[j]) {
                        res[ir][jr++]=mas[i][j];
                    }
                }
                ir++;
                jr=0;
            }
        }
        //complete result
        return res;
    }
}
