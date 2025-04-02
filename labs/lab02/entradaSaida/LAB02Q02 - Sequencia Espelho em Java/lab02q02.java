
import java.util.Scanner;

/*
 * Sequência Espelho em Java - Imprimir números em sequência ́e uma tarefa 
 * relativamente simples. Mas, e quando se trata de uma sequência espelho? 
 * Trata-se de uma sequência que possui um número de início e um número
 * de fim, e todos os números entre estes, inclusive estes, são dispostos 
 * em uma sequência crescente, sem espaços e, em seguida, esta sequência
 * é projetadade forma invertida, como um reflexo no espelho. Por exemplo,
 * se a sequência for de 7 a 12, o resultado ficaria 789101112211101987.
 */

public class lab02q02 {
    public static String numberInverter(int number) {
        String numberString = Integer.toString(number);
        String invertedNumber = "";

        for (int index = numberString.length() - 1; index >= 0; index--) {
            invertedNumber += numberString.charAt(index);
        }

        return invertedNumber;
    }
    

    public static String mirrorSequenceMaker(String sentence) {
        String[] sentenceArray = sentence.split(" ");

        String mirrorSequence = "";

        int number1 = Integer.parseInt(sentenceArray[0]);
        int number2 = Integer.parseInt(sentenceArray[1]);

        for (int index = number1; index <= number2; index++) {
            mirrorSequence += index;
        }

        for (int index = number2; index >= number1; index--) {
            if (index >= 10) {
                mirrorSequence += numberInverter(index);
            } else {
                mirrorSequence += index;
            }
        }

        return mirrorSequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            System.out.println(mirrorSequenceMaker(line));
        }

        scanner.close();
    }
}