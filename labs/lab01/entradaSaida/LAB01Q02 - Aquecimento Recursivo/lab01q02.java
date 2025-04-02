/*
 * Aquecimento Iterativo - Crie um método iterativo em Java que receba 
 * como parâmetro uma string e retorne seu número de caracteres maiúsculos. 
 * Em seguida, teste o método anterior usando redirecionamento de entrada e saída. 
 * A entrada padrão ́e composta por várias linhas sendo que a ́ultima contém a palavra FIM.
 * A saída padrão contém um número inteiro para cada linha de entrada.
 * 
 * MESMO ALGORTIMO SÓ QUE RECURSIVO
 */

import java.util.Scanner;

public class lab01q02 {
    public static int howManyUpperCasesRecursive(int howManyUpperCases, String sentence, int index) {
        if (index == sentence.length()) {
            return howManyUpperCases;
        }

        char character = sentence.charAt(index);

        if (Character.isUpperCase(character)) {
            howManyUpperCases ++;
        }

        index ++;

        return howManyUpperCasesRecursive(howManyUpperCases, sentence, index);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("FIM")) {
            System.out.println(howManyUpperCasesRecursive(0, line, 0));

            line = scanner.nextLine();
        }
        
        scanner.nextLine();
    }
}
