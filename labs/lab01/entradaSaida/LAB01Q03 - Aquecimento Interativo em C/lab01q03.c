/*
 * Aquecimento Iterativo - Crie um método iterativo em Java que receba 
 * como parâmetro uma string e retorne seu número de caracteres maiúsculos. 
 * Em seguida, teste o método anterior usando redirecionamento de entrada e saída. 
 * A entrada padrão ́e composta por várias linhas sendo que a ́ultima contém a palavra FIM.
 * A saída padrão contém um número inteiro para cada linha de entrada.
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>
#include <string.h>
#include <locale.h>
#include <wchar.h>

int howManyUpperCases (char sentence[]) {
    int upperCasesQuantity = 0;

    for (int index = 0; index < strlen(sentence); index ++) {
        char character = sentence[index];

        if (isupper(character)) {
            upperCasesQuantity ++;
        }
    }

    return upperCasesQuantity;
}

int main() {
    char line[1000];

    while (fgets(line, sizeof(line), stdin) != NULL) {
        line[strcspn(line, "\n")] = '\0';

        if (strcmp(line, "FIM") == 0) {
            break;
        }

        printf("%d\n", howManyUpperCases(line));
    }

    return 0;
}