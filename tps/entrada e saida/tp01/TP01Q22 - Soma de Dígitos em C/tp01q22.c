/*
 * Soma de Dígitos - Crie um método recursivo que
 * recebe um número inteiro como parâmetro e retorna
 * a soma de seus dígitos. Na saída padrão, para cada
 * linha de entrada, escreva uma linha de saída com o
 * resultado da soma dos dígitos. Por exemplo, se a 
 * entrada for 12345, a saída deve ser 15.
 */

#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include <wchar.h>

int adder(int integerNumber) {
    /*
    * A Recursive Int function that takes a integer
    * number and added each number on it with each other.
    */

    if (integerNumber < 10) {
        return integerNumber;
    }

    return (integerNumber % 10) + adder(integerNumber / 10);
}

int main() {
    /*
    * A Main function that reads integer
    * number as input, calls the added for it,
    * and returns the added number as output.
    */
    
    char line[1000];

    while(fgets(line, sizeof(line), stdin) != NULL) {
        line[strcspn(line, "\n")] == '\0';

        if (strcmp(line, "FIM") == 0) break;

        int number = atoi(line);

        printf("%d\n", adder(number));
    }

    return 0;
}