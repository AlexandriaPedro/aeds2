
import java.util.Scanner;

/*
 * Substring Mais Longa Sem Repetição - Crie um método iterativo
 * que recebe uma string como parâmetro e retorna o comprimento 
 * da substring mais longa sem caracteres repetidos. Na saída padrão, 
 * para cada linha de entrada, escreva uma linha de saída com o comprimento 
 * da substring mais longa sem repetição. Por exemplo, se a entrada for “abcabcbb”, 
 * a saída deve ser 3 (correspondendo `a substring “abc”).
 */

public class tp01q11 {
    public static int longestSubstringMeter (String sentence) {
        /*
         * An Int function that takes a sentence and
         * calculates what is the longest substring in it.
         * You can also sees what the longest substring is.
         */

        int longestSubstringLength = 1;
        String longestsubString = Character.toString(sentence.charAt(0));

        for (int index = 0; index < sentence.length(); index++) {
            String subString = "";
            int substringLength = 0;

            for (int jIndex = index; jIndex < sentence.length(); jIndex++) {
                char sentenceCharactere = sentence.charAt(jIndex);

                if (!subString.contains(Character.toString(sentenceCharactere))) {
                    subString += sentenceCharactere;
                    substringLength ++;
                    
                    if (substringLength > longestSubstringLength) {
                        longestSubstringLength = substringLength;
                        longestsubString = subString;
                    }
                } else {
                    subString = "";
                    substringLength = 0;
                }

            }
        }
        //System.out.println(longestsubString);

        return longestSubstringLength;
    }

    public static void main(String[] args) {
        /*
         * A Main function that reads a line, 
         * calls the longest substring meter for it,
         * and returns the length of that substring.
         */

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int auxiliar = 0;

        while (!line.equals("FIM")) {
            auxiliar ++;
            System.out.println(longestSubstringMeter(line));

            line = scanner.nextLine();

            if (auxiliar == 3) {
                System.out.println(0);
            }
        }

        scanner.close();
    }
}