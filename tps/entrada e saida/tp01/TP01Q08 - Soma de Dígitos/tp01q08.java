/*
 * Soma de Dígitos - Crie um método recursivo que
 * recebe um número inteiro como parâmetro e retorna
 * a soma de seus dígitos. Na saída padrão, para cada
 * linha de entrada, escreva uma linha de saída com o
 * resultado da soma dos dígitos. Por exemplo, se a 
 * entrada for 12345, a saída deve ser 15.
 */

 public class tp01q08 {
    public static int adder (int integerNumber) {
        /*
         * A Recursive Int function that takes a integer
         * number and added each number on it with each other.
         */

        if (integerNumber < 10) {
            return integerNumber;
        }

        return (integerNumber % 10) + adder(integerNumber / 10);
    }

    public static void main(String[] args) {
        /*
         * A Main function that reads integer
         * number as input, calls the added for it,
         * and returns the added number as output.
         */

        Integer number = MyIO.readInt();

        while (number instanceof Integer) {
            MyIO.println(adder(number));

            number = MyIO.readInt();
        }
    }
 }