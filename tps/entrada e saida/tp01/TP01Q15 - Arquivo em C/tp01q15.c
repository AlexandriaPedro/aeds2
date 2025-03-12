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

#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void fileWriter(int realNumberAmount, char fileName[]) {
    /*
         * A Void Function that takes the number of times that it
         * needs to read some real numbers and write them into the file.
         * Next, it closes the file. 
     */
    
    FILE *file;

    char realNumberString[100];

    file = fopen(fileName, "w");

    float realNumber;

    for (int index = 0; index < realNumberAmount; index ++) {
        fgets(realNumberString, sizeof(realNumberString), stdin);

        fprintf(file, "%s\n", realNumberString);
        //scanf("%f", &realNumber);
        //fprintf(file, "%f\n", realNumber);

        //printf("Colocando pra dentro o... %f\n", realNumber);
        //printf("Colocando pra dentro o... %s\n", realNumberString);
    }

    fclose(file);
}

void fileReader(int realNumberAmount, char fileName[]) {
    /*
         * A Void Function that takes the number of times that it
         * needs to read some real numbers, which means now: lines. 
         * And print them, from the bottom to top, for us.
         * Next, it closes the file. 
     */
    
    FILE *file;

    file = fopen(fileName, "r");

    char fileRealNumbers[realNumberAmount][1000];

    for(int index = 0; index < realNumberAmount; index++) {
        fscanf(file, "%s\n", &fileRealNumbers[index]);
    }

    for(int index = realNumberAmount - 1; index >= 0; index--) {
        char numberString[1000];
        strcpy(numberString,  fileRealNumbers[index]);

        double number = strtod(numberString, NULL);
        
        if (number == (int) number) {
            //printf("Vendo de dentro o... %d\n", (int) number);
            printf("%d\n", (int) number);
        } else {
            float numberWithG = number;
            //printf("Vendo de dentro o... %g\n", number);
            printf("%g\n", number);
        }
    }

    fclose(file);
}

int main() {
     /*
         * A Void Function that reads how many real numbers will
         * enter in the file, and calls the other void functions
         * the will fill the file and read it.
    */

    char line[1000];

    while(fgets(line, sizeof(line), stdin) != NULL) {
        line[strcspn(line, "\n")] = '\0';

        if (strcmp(line, "") == 0) {
            break;
        }

        int realNumberAmount = atoi(line);

        char fileName[] = "file.txt";
        
        //printf("Quantidade de numeros reais: %d\n", realNumberAmount);


        fileWriter(realNumberAmount, fileName);
        fileReader(realNumberAmount, fileName);
    }

    return 0;
}