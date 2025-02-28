/*
 * Inversão de String - Crie um método iterativo que recebe 
 * uma string como parâmetro e retorna a string invertida. 
 * Na saída padrão, para cada linha de entrada, escreva uma 
 * linha de saída com a string invertida. Por exemplo, se a 
 * entrada for “abcde”, a saída deve ser “edcba”.
 */

 public class tp01q07 {
    public static String sentenceInverter (String sentence) {
        /*
         * A String function that takes a sentence,
         * inverts it, and returns it.
         */

        String invertedSentence = "";

        for (int index = sentence.length() - 1; index >= 0; index--) {
            invertedSentence += sentence.charAt(index);
        }

        return invertedSentence;
    }

    public static void main(String[] args) {
        /*
         * A main function that reads input
         * lines until reads "FIM", calls the
         * inverter for each line, and returns
         * the inverted line readed.
         */

        String line = MyIO.readLine();

        while (!"FIM".equals(line)) {
            MyIO.println(sentenceInverter(line));

            line = MyIO.readLine();
        }
    }
 }