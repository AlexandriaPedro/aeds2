/*
 * Arquivo em Java: Faça um programa que leia um número inteiro n
 * indicando o número de valores reais que devem ser lidos e salvos
 * sequencialmente em um arquivo texto. Após a leitura dos valores, 
 * devemos fechar o arquivo. Em seguida, reabri-lo e fazer a leitura
 * de trás para frente usando os métodos getFilePointer e seek da classe
 * RandomAccessFile e mostre todos os valores lidos na tela. Nessa questão, 
 * você não pode usar, arrays, strings ou qualquer estrutura de dados.
 * A entrada padrão ́e composta por um número inteiro n e mais n números reais. 
 * A saída padrão corresponde a n números reais mostrados um por linha de saída.
 */

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class tp01q14 {
    public static void fileWriter (int realNumberAmount, Scanner scanner, String fileName) throws IOException {
        /*
         * A Void Function that takes the number of times that it
         * needs to read some real numbers and write them into the file.
         * Next, it closes the file. 
         */

        FileWriter file = new FileWriter(fileName);
        PrintWriter writer = new PrintWriter(file);

        float realNumber;

        for (int index = 0; index < realNumberAmount; index ++) {
            realNumber = scanner.nextFloat();

            writer.println(realNumber);
        }
        
        file.close();
    }

    public static void fileReader (int realNumberAmount, String fileName) throws FileNotFoundException, IOException, NoSuchElementException {
        /*
         * A Void Function that takes the number of times that it
         * needs to read some real numbers, which means now: lines. 
         * And print them, from the bottom to top, for us.
         * Next, it closes the file. 
         */

        RandomAccessFile file = new RandomAccessFile(fileName, "r");
        
        List <Double> fileRealNumbers = new ArrayList<>();

        String lineRealNumber;

        for (int index = 0; index < realNumberAmount; index ++) {
                    lineRealNumber = file.readLine();
                    
                    fileRealNumbers.add(Double.valueOf(lineRealNumber));
        }

        for (int index = realNumberAmount - 1; index >= 0; index --) {
            double number = fileRealNumbers.get(index);

            if (number == (int) number) {
                System.out.println((int) number);
            } else {
                System.out.println(number);
            }
        }

        file.close();
    }

    public static void main(String[] args) throws IOException {
         /*
         * A Void Function that reads how many real numbers will
         * enter in the file, and calls the other void functions
         * the will fill the file and read it.
         */

        Scanner scanner = new Scanner(System.in);

        scanner.useLocale(Locale.US);

        String fileName = "file.txt";
        String line = scanner.nextLine();

        
        while (!line.isEmpty()) {
            int realNumberAmount = Integer.parseInt(line);

            fileWriter(realNumberAmount, scanner, fileName);
            fileReader(realNumberAmount, fileName);

            line = scanner.nextLine();
        }
    }
}