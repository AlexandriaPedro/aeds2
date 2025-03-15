/*
 * Verificação de Anagrama - Crie um método iterativo que 
 * recebe duas strings como parâmetros e retorna true se as
 * strings são anagramas uma da outra, ou false caso contrário. 
 * Na saída padrão, para cada par de strings de entrada, escreva
 * uma linha de saída com SIM/NÃO indicando se as strings 
 * são anagramas. Por exemplo, se as entradas forem “listen” e 
 * “silent”, a saída deve ser SIM.
 */

import java.util.Scanner;

public class tp01q09 {
    public static boolean anagramValidator(String firstSentence, String secondSentence) {
        /*
         * A Boolean function that takes two Strings and checks
         * if one is the anagram of the other. Then, returns
         * true of false for it.
         */

        firstSentence = firstSentence.toLowerCase();
        secondSentence = secondSentence.toLowerCase();

        if (firstSentence.length() != secondSentence.length()) {
            return false;
        }

        for (int index = 0; index < secondSentence.length(); index++) {
            char secondSentenceCharactere = secondSentence.charAt(index);
            String secondSentenceCharactereString = Character.toString(secondSentenceCharactere);

            if (!firstSentence.contains(secondSentenceCharactereString)) {
                //System.out.println(secondSentenceCharactere);

                return false;
            }

            //System.out.println(firstSentence);

            firstSentence = firstOccurenceRemove(firstSentence, secondSentenceCharactere);
        }

        return firstSentence.isEmpty();
    }

    public static String firstOccurenceRemove(String firstSentence, char secondSentenceCharactere) {
        int charactereIndex = firstSentence.indexOf(secondSentenceCharactere);

        if (charactereIndex == -1) {
            return firstSentence;
        }

        String firstSentenceChanged = firstSentence.substring(0, charactereIndex) + firstSentence.substring(charactereIndex + 1);

        return firstSentenceChanged;
    }

    public static void main(String[] args) {
        /*
         * A Main function that reads a line, split it in two, and
         * calls the anagram validator for it, passing the two sentences.
         */

        Scanner scanner = new Scanner(System.in);
        String line =  scanner.nextLine();

        while (!line.equals("FIM")) {
            String[] lineParts = line.split(" - ");
            String linePartOne = lineParts[0]; 
            String linePartTwo = lineParts[1];

            //MyIO.println(linePartOne);
            //MyIO.println(linePartTwo);

            MyIO.println(anagramValidator(linePartOne, linePartTwo) ? "SIM" : "NÃO");

            line = scanner.nextLine();
        }

        scanner.close();
    }
}