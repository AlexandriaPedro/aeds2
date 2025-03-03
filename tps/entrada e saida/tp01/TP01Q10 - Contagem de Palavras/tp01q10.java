
import java.util.Scanner;

/*
 * Contagem de Palavras - Crie um método iterativo que 
 * recebe uma string como parâmetro e retorna o número 
 * de palavras na string. Uma palavra  ́e definida como 
 * uma sequência de caracteres separada por espaços. 
 * Na saída padrão, para cada linha de entrada, escreva 
 * uma linha de saída com o número de palavras. 
 * Por exemplo, se a entrada for “Hello world”, 
 * a saída deve ser 2.
 */

public class tp01q10 {
    public static int wordsCounter (String sentence) {
        /*
         * An Int function that takes a sentence
         * and counts how many words have in it.
         */

        String[] sentenceArray = sentence.split(" ");

        int sentenceArrayLength = sentenceArray.length;

        return sentenceArrayLength;
    }

    public static void main(String[] args) {
        /*
         * A Main function that reads a line from 
         * the input, and calls the words counter
         * function for it.
         */

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("FIM")) {
            System.out.println(wordsCounter(line));

            line = scanner.nextLine();
        }

        scanner.close();
    }
}