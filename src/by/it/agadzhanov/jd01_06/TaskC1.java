package by.it.agadzhanov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern newline = Pattern.compile(".+");
        Matcher matcherNewline1 = newline.matcher(sb);
        int maxLineLength = 0;
        Pattern oneSpace = Pattern.compile(" {1}");
        Pattern twoSpaces = Pattern.compile(" {2}");
        Pattern threeSpaces = Pattern.compile(" {3}");
        Pattern fourSpaces = Pattern.compile(" {4}");
        Pattern fiveSpaces = Pattern.compile(" {5}");
        Pattern sixSpaces = Pattern.compile(" {6}");
        Pattern sevenSpaces = Pattern.compile(" {7}");
        Pattern eightSpaces = Pattern.compile(" {8}");
        Pattern nineSpaces = Pattern.compile(" {9}");
        Pattern tenSpaces = Pattern.compile(" {10}");


        //finding maximum line length
        while (matcherNewline1.find()) {
            if (matcherNewline1.group().length() > maxLineLength)
                maxLineLength = matcherNewline1.group().length();
        }

        Matcher matcherNewline2 = newline.matcher(sb);
        //justifying the poem
        while (matcherNewline2.find()) {
            String line = matcherNewline2.group();
            Matcher matcherOneSpace = oneSpace.matcher(line);
            int start1 = 0;
            while (matcherOneSpace.find(start1) && line.length() < maxLineLength) {
                line = line.replace(matcherOneSpace.group(), "  ");
                start1 = matcherOneSpace.end()+1;
            }
            if (line.length() == maxLineLength)
                continue;

            Matcher matcherTwoSpaces = twoSpaces.matcher(line);
            int start2 = 0;
            while (matcherTwoSpaces.find(start2) && matcherNewline2.group().length() < maxLineLength) {
                line = line.replaceFirst(" {2}", "   ");
                start2 = matcherTwoSpaces.end()+1;
            }
            if (line.length() == maxLineLength)
                continue;

            Matcher matcherThreeSpaces = threeSpaces.matcher(line);
            int start3 = 0;
            while (matcherThreeSpaces.find(start3) && matcherNewline2.group().length() < maxLineLength) {
                line = line.replaceFirst(" {3}", "    ");
                start3 = matcherThreeSpaces.end()+1;
            }
            if (line.length() == maxLineLength)
                continue;

            Matcher matcherFourSpaces = fourSpaces.matcher(line);
            int start4 = 0;
            while (matcherFourSpaces.find(start4) && matcherNewline2.group().length() < maxLineLength) {
                line = line.replaceFirst(" {4}", "     ");
                start4 = matcherFourSpaces.end()+1;
            }
            if (line.length() == maxLineLength)
                continue;

            Matcher matcherFiveSpaces = fiveSpaces.matcher(line);
            int start5 = 0;
            while (matcherFiveSpaces.find(start5) && matcherNewline2.group().length() < maxLineLength) {
                line = line.replaceFirst(" {5}", "      ");
                start5 = matcherFiveSpaces.end()+1;
            }
            if (line.length() == maxLineLength)
                continue;

            Matcher matcherSixSpaces = sixSpaces.matcher(line);
            int start6 = 0;
            while (matcherSixSpaces.find(start6) && matcherNewline2.group().length() < maxLineLength) {
                line = line.replaceFirst(" {6}", "       ");
                start6 = matcherSixSpaces.end()+1;
            }
            if (line.length() == maxLineLength)
                continue;

            Matcher matcherSevenSpaces = sevenSpaces.matcher(line);
            int start7 = 0;
            while (matcherSevenSpaces.find(start7) && matcherNewline2.group().length() < maxLineLength) {
                line = line.replaceFirst(" {7}", "        ");
                start7 = matcherSevenSpaces.end()+1;
            }
            if (line.length() == maxLineLength)
                continue;

            Matcher matcherEightSpaces = eightSpaces.matcher(line);
            int start8 = 0;
            while (matcherEightSpaces.find(start8) && matcherNewline2.group().length() < maxLineLength) {
                line = line.replaceFirst(" {8}", "         ");
                start8 = matcherEightSpaces.end()+1;
            }
            if (line.length() == maxLineLength)
                continue;

            Matcher matcherNineSpaces = nineSpaces.matcher(line);
            int start9 = 0;
            while (matcherNineSpaces.find(start9) && matcherNewline2.group().length() < maxLineLength) {
                line = line.replaceFirst(" {9}", "          ");
                start9 = matcherNineSpaces.end()+1;
            }
            if (line.length() == maxLineLength)
                continue;

            Matcher matcherTenSpaces = tenSpaces.matcher(line);
            int start10 = 0;
            while (matcherTenSpaces.find(start10) && matcherNewline2.group().length() < maxLineLength) {
                line = line.replaceFirst(" {10}", "           ");
                start10 = matcherTenSpaces.end()+1;
            }
            System.out.println(line);
        }
    }
}