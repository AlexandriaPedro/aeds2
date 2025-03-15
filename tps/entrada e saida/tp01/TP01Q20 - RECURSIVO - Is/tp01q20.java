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
 * 
 * MESMO ALGORITMO SÓ QUE RECURSIVO
 */

 public class tp01q20 {
    public static boolean isVowelRecursive (String sentence, int index, String substring) {
        /*
         * A Boolean function that takes a sentence
         * and says if it's compose only by vowels.
         */

        String sentenceLowerCase = sentence.toLowerCase();
        char character = sentenceLowerCase.charAt(index);

        //base case
        if (!"aeiou".contains(String.valueOf(character))) {
            return false;
        }

        if (index == sentence.length() - 1) {
            return true;
        }

        index ++;
        substring = sentenceLowerCase.substring(index);

        return isVowelRecursive(sentence, index, substring);
    }

    public static boolean isConsonantRecursive (String sentence, int index, String substring) {
        /*
         * A Boolean function that takes a sentence
         * and says if it's compose only by consonants.
         */

        String sentenceLowerCase = sentence.toLowerCase();
        char character = sentenceLowerCase.charAt(index);

        //base case
        if ("aeiou".contains(String.valueOf(character)) || !Character.isLetter(character)) {
            return false;
        }

        if (index == sentence.length() - 1) {
            return true;
        }

        index ++;

        substring = sentence.substring(index);

        return isConsonantRecursive(sentence, index, substring);
    }

    public static boolean isIntegerRecursive (String sentence, int index) {
        /*
         * A Boolean function that takes a sentence
         * and says if its a Integer number.
         */

        if (index == 1) {
            return sentence.matches("-?\\d+");
        } else {
            index ++;

            return isIntegerRecursive(sentence, index);
        }
    }

    public static boolean isRealRecursive (String sentence, int index) {
        /*
         * A Boolean function that takes a sentence
         * and says if its a Real number.
         */

        //return sentence.matches("-?\\d+?\\.?\\,?(\\.\\d+)?(\\,\\d+)?");
        //return sentence.matches("-?\\d+?\\.?\\,?\\d+?");

        if (index == 1) {
            return sentence.matches("-?(\\d+\\.?\\d*|\\.\\d+|,\\d+|\\d+,?\\d*)");
        } else {
            index++;

            return isRealRecursive(sentence, index);
        }
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
            String x1 = isVowelRecursive(line, 0, "") ? "SIM" : "NAO";
            String x2 = isConsonantRecursive(line, 0, "") ? "SIM" : "NAO";
            String x3 = isIntegerRecursive(line, 0) ? "SIM" : "NAO";
            String x4 = isRealRecursive(line, 0) ? "SIM" : "NAO";

            MyIO.println(x1 + " " + x2 + " " + x3 + " " + x4);

            line = MyIO.readLine();
        }
    }
}