/*
 * Is - Crie um método iterativo que recebe uma string e 
 * retorna true se a mesma é composta somente por vogais. 
 * Crie outro método iterativo que recebe uma string e retorna
 * true se a mesma ́e composta somente por consoantes. 
 * Crie um terceiro método iterativo que recebe uma string e
 * retorna true se a mesma corresponde a um número inteiro. 
 * Crie um quarto método iterativo que recebe uma string e retorna
 * true se a mesma corresponde a um número real. Na saída padrão, 
 * para cada linha de entrada, escreva outra de saída da seguinte 
 * forma X1 X2 X3 X4 onde cada Xi é um booleano indicando se a 
 * entrada ́e: composta somente por vogais (X1); composta somente 
 * somente por consoantes (X2); um número inteiro (X3); um número
 * real (X4). Se Xi for verdadeiro, seu valor ser ́a SIM, 
 * caso contrário, NÃO.
 */

public class tp01q06 {
    public static boolean isVowel (String sentence) {
        /*
         * A Boolean function that takes a sentence
         * and says if it's compose only by vowels.
         */

        String sentenceLowerCase = sentence.toLowerCase();

        for(char character : sentenceLowerCase.toCharArray()) {
            if (!"aeiou".contains(String.valueOf(character))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isConsonant (String sentence) {
        /*
         * A Boolean function that takes a sentence
         * and says if it's compose only by consonants.
         */

        String sentenceLowerCase = sentence.toLowerCase();

        for (char character : sentenceLowerCase.toCharArray()) {
            if ("aeiou".contains(String.valueOf(character)) || !Character.isLetter(character)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isInteger (String sentence) {
        /*
         * A Boolean function that takes a sentence
         * and says if its a Integer number.
         */

        return sentence.matches("-?\\d+");
    }

    public static boolean isReal (String sentence) {
        /*
         * A Boolean function that takes a sentence
         * and says if its a Real number.
         */

        //return sentence.matches("-?\\d+?\\.?\\,?(\\.\\d+)?(\\,\\d+)?");
        //return sentence.matches("-?\\d+?\\.?\\,?\\d+?");
        return sentence.matches("-?(\\d+\\.?\\d*|\\.\\d+|,\\d+|\\d+,?\\d*)");
    }

    public static void main(String[] args) {
        /*
         * A Main Function that takes a input
         * and calls the four functions that
         * we made, plus answers in one line
         * ouput if the sentece is an thing
         * or another, in sequence of calls.
         */

        String line = MyIO.readLine();

        while (!line.equals("FIM")) {
            String x1 = isVowel(line) ? "SIM" : "NAO";
            String x2 = isConsonant(line) ? "SIM" : "NAO";
            String x3 = isInteger(line) ? "SIM" : "NAO";
            String x4 = isReal(line) ? "SIM" : "NAO";

            MyIO.println(x1 + " " + x2 + " " + x3 + " " + x4);

            line = MyIO.readLine();
        }
    }
}