/*
 * Aquecimento Iterativo - Crie um método iterativo em Java que receba 
 * como parâmetro uma string e retorne seu número de caracteres maiúsculos. 
 * Em seguida, teste o método anterior usando redirecionamento de entrada e saída. 
 * A entrada padrão ́e composta por várias linhas sendo que a ́ultima contém a palavra FIM.
 * A saída padrão contém um número inteiro para cada linha de entrada.
 */

import java.util.Scanner;

public class lab01q01 {
    public static int howManyUpperCases(String sentence) {
        int upperCasesQuantity = 0;

        for (int index = 0; index < sentence.length(); index ++) {
            char character = sentence.charAt(index);

            if (Character.isUpperCase(character)) {
                upperCasesQuantity ++;
            }
        }

        return upperCasesQuantity;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("FIM")) {
            System.out.println(howManyUpperCases(line));

            line = scanner.nextLine();
        }

        scanner.close();
    }
}