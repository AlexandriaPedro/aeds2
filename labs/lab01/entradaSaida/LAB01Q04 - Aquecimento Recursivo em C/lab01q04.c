/*
 * Aquecimento Iterativo - Crie um método iterativo em Java que receba 
 * como parâmetro uma string e retorne seu número de caracteres maiúsculos. 
 * Em seguida, teste o método anterior usando redirecionamento de entrada e saída. 
 * A entrada padrão ́e composta por várias linhas sendo que a ́ultima contém a palavra FIM.
 * A saída padrão contém um número inteiro para cada linha de entrada.
 * 
 * MESMO ALGORITMO SÓ QUE RECURSIVO
 */

#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>
#include <locale.h>
#include <wchar.h>

int howManyUpperCasesRecursive (int index, int upperCasesQuantity, char sentence[]) {
    if (index == strlen(sentence)) {
        return upperCasesQuantity;
    }

    char character = sentence[index];

    if (isupper(character)) {
        upperCasesQuantity ++;
    }

    index ++;

    return howManyUpperCasesRecursive(index, upperCasesQuantity, sentence);
}

int main () {
    char line[1000];

    while (fgets(line, sizeof(line), stdin) != NULL) {
        line[strcspn(line, "\n")] = '\0';

        if (strcmp(line, "FIM") == 0) {
            break;
        }

        printf("%d\n", howManyUpperCasesRecursive(0, 0, line));
    }

    return 0;
}