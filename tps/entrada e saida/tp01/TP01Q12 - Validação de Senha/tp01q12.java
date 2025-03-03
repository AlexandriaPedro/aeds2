
import java.util.Scanner;

/*
 * Validaçãoo de Senha - Crie um método iterativo que 
 * recebe uma string como parâmetro e retorna true se 
 * a string ́e uma senha válida, ou false caso contrário. 
 * Uma senha ́e considerada válida se contém pelo menos 8 caracteres,
 * incluindo pelo menos uma letra maiúscula, uma letra minúscula, 
 * um número e um caractere especial (por exemplo, !, @, #, etc.). 
 * Na saída padrão, para cada linha de entrada, escreva uma linha 
 * de saída com SIM/NÃO indicando se a senha é válida. Por exemplo, 
 * se a entrada for “Senha123!”, a saída deve ser SIM.
 */

 public class tp01q12 {
    public static boolean passwordValidator (String sentence) {
        /*
         * A Boolean function that takes a sentence
         * and checks if it is valid password according
         * to our rules. Then, returns if it is or not.
         */

        int upperCaseCounter = 0;
        int lowerCaseCounter = 0;
        int intCharacterCounter = 0;
        int specialCharacterCounter = 0;

        if (sentence.length() < 8) {
            return false;
        }

        for (int index = 0; index < sentence.length(); index++) {
            if (Character.isUpperCase(sentence.charAt(index))) {
                //System.out.println("Upper case Character: " + sentence.charAt(index));

                upperCaseCounter ++;
            }
            if (Character.isLowerCase(sentence.charAt(index))) {
                //System.out.println("Lower case Character: " + sentence.charAt(index));

                lowerCaseCounter ++;
            }
            if (Character.isDigit(sentence.charAt(index))) {
                //System.out.println("Int Character: " + sentence.charAt(index));

                intCharacterCounter ++;
            }
            if (sentence.substring(index, index + 1).matches("[^a-zA-Z0-9 ]")) {
                //System.out.println("Special Character: " + sentence.substring(index, index + 1));

                specialCharacterCounter ++;
            }
        }

        //System.out.println("Upper cases: " + upperCaseCounter);
        //System.out.println("Lower cases: " + lowerCaseCounter);
        //System.out.println("Int cases: " + intCharacterCounter);
        //System.out.println("Special cases: " + specialCharacterCounter);

        return !(upperCaseCounter == 0 || lowerCaseCounter == 0 || 
        intCharacterCounter == 0 || specialCharacterCounter == 0);
    }

    public static void main(String[] args) {
        /*
         * A Main function that reads a line
         * in the input, calls the password
         * validator, and returns the answer
         * of the function called.
         */

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("FIM")) {
            MyIO.println(passwordValidator(line) ? "SIM" : "NÃO");

            line = scanner.nextLine();
        }

        scanner.close();
    }
 }