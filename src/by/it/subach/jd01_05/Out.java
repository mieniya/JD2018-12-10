package by.it.subach.jd01_05;

public class Out {
    static void printArrayA(int[] arr, String name, int columnCount) {
//        top
        String beginTop = "╔═══════════╦";
        String midTop = "═══════════╦";
        String endTop = "═══════════╗";


//        middle
        String midMid = "═══════════╬";
        String endMid = "═══════════╣";
        String beginMid = "╠═══════════╬";


//        bottom
        String beginBot = "╚═══════════╩";
        String midBot = "═══════════╩";
        String endBot = "═══════════╝";

        StringBuilder top = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder bot = new StringBuilder();

        top.append(beginTop);
        mid.append(beginMid);
        bot.append(beginBot);
        for (int i = 0; i < columnCount - 2; i++) {
            top.append(midTop);
            mid.append(midMid);
            bot.append(midBot);
        }
        top.append(endTop);
        mid.append(endMid);
        bot.append(endBot);

        System.out.println(top);        //печатаем верх
        for (int i = 0; i < arr.length; i++) {
//            левый столбец
            if (i % columnCount == 0) {
                System.out.printf("║ %s[%2d]=%-3d ║", name, i+1, arr[i]);

//              правый столбец
            }
            if ((i + 1) % columnCount == 0) {
                System.out.printf(" %s[%2d]=%-3d ║\n", name, i+1, arr[i]);
                if (i < arr.length - 1) {
                    System.out.println(mid);
                }
            }
            if (i % columnCount != 0 && (i + 1) % columnCount != 0) {
                System.out.printf(" %s[%2d]=%-3d ║", name, i+1, arr[i]);
            }

//            последняя строка
            if (i == arr.length - 1) {
                if (arr.length % columnCount != 0) {
                    int empty = columnCount - (arr.length % columnCount);
                    while (empty > 0) {
                        System.out.print("           ║");
                        empty--;
                    }
                    System.out.println("\n" + bot);
                } else
                    System.out.println(bot);
            }
        }
    }

    static void printArrayB(int[] arr, String name, int columnCount) {
        //        top
        String beginTop = "╔═══════════╦";
        String midTop = "═══════════╦";
        String endTop = "═══════════╗";


//        middle
        String midMid = "═══════════╬";
        String endMid = "═══════════╣";
        String beginMid = "╠═══════════╬";


//        bottom
        String beginBot = "╚═══════════╩";
        String midBot = "═══════════╩";
        String endBot = "═══════════╝";

        StringBuilder top = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder bot = new StringBuilder();

        top.append(beginTop);
        mid.append(beginMid);
        bot.append(beginBot);
        for (int i = 0; i < columnCount - 2; i++) {
            top.append(midTop);
            mid.append(midMid);
            bot.append(midBot);
        }
        top.append(endTop);
        mid.append(endMid);
        bot.append(endBot);

        System.out.println(top);        //печатаем верх
        int rowCount = 0;
        if (arr.length % columnCount != 0) {
            rowCount = (arr.length / columnCount) + 1;
        } else {
            rowCount = arr.length / columnCount;
        }

        for (int i = 0; i < rowCount; i++) {
            if (i % rowCount == 0 && i != 0) {
                i++;
            }
            boolean cellFill = false;
            System.out.printf("║ %s[%2d]=%-3d ║", name, i+1, arr[i]);
            cellFill = true;
            int k = rowCount;
            for (int j = 0; j < columnCount; j++) {
                cellFill = false;

                if (i + k < arr.length) {
                    System.out.printf(" %s[%2d]=%-3d ║", "B", i + k+1, arr[i + k]);
                    cellFill = true;
                    k += rowCount;
                }
                if (k < arr.length && cellFill == false) {
                    System.out.print("           ║");
                    break;
                }

            }

            if (i == rowCount - 1) {
                System.out.println("\n" + bot);
            } else {
                System.out.println("\n" + mid);
            }

        }
    }

}
