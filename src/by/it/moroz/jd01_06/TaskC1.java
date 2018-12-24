package by.it.moroz.jd01_06;


public class TaskC1 {

    public static void main(String[] args) {

        String text = Poem.text;
        String[] wordArray = text.split("[\n]+");

        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = wordArray[i].trim();
        }
        int max = findMax(wordArray);
        char ch = ' ';

        for (int i = 1; i < wordArray.length; i++) {
            StringBuilder sb = new StringBuilder(wordArray[i]);
            //while (sb.length() != max) {
                for (int j = 1; j < sb.length()-1; j++) {
                    if(sb.charAt(j)==ch ){
                        sb.insert(j+1, ' ');
                    }
                   // else if (sb.charAt(j+1)==ch && sb.charAt(j+2)!=ch){
                    //    sb.insert(j+2, ' ');
                    //    j++;
                   // }
                   // else sb.insert(j+3, ' ');
                    //j=j+2;
                }

           // }

        }
        for (int i = 0; i < wordArray.length; i++) {
            System.out.println(wordArray[i]);
        }

    }


    static int findMax(String[] arr) {
        if (0 == arr.length) {
            return arr[0].length();
        } else {
            int max = arr[0].length();
            for (int i = 1; i < arr.length; i++) {
                if (max < arr[i].length()) max = arr[i].length();
            }
            return max;
        }
    }
}
