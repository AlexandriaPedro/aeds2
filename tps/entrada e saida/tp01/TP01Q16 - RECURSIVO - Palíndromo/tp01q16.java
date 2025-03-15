
/*
 * Palíndromo - Crie um método iterativo que recebe uma string 
 * como parâmetro e retorna true se essa ́e um “Palíndromo”. 
 * Na saída padrão, para cada linha de entrada, escreva uma linha
 * de saída com SIM/NÃO indicando se a linha ́e um palíndromo. 
 * Destaca-se que uma linha de entrada pode ter caracteres não letras.
 * 
 * FAZER O MESMO ALGORITMO SÓ QUE AGORA RECURSIVO
 */

 import java.util.Scanner;
 
 
 public class tp01q16 {
    public static boolean isPalindromeRecursive(String sentence, int index) {
         /*
          * A boolean function that calculates if a 
          * sentence is a palindrome or not.
          */
        
        //base case
        if (index == sentence.length() / 2) {
            return true;
        }
        if (sentence.charAt(index) != sentence.charAt(sentence.length() - 1 - index)) {
            return false;
        }

        index++;

        return isPalindromeRecursive(sentence, index);
    }
 
    public static void main(String[] args) {
         /*
          * Main fuction that calls isPalindrome function,
          * and returns "SIM" if the sentence sent is a palindrome.
          */
        
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("FIM")) {
            System.out.println(((isPalindromeRecursive(line, 0)) ? "SIM" : "NAO"));

            line = scanner.nextLine();
        }
    }
 }