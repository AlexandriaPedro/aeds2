/*
 * Inversão de String - Crie um método iterativo que recebe 
 * uma string como parâmetro e retorna a string invertida. 
 * Na saída padrão, para cada linha de entrada, escreva uma 
 * linha de saída com a string invertida. Por exemplo, se a 
 * entrada for “abcde”, a saída deve ser “edcba”.
 * 
 * MESMO ALGORTIMO SÓ  QUE RECURSIVO
 */

#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#include <locale.h>
#include <wchar.h>

char* sentenceInverterRecursive(char sentence[], int index, char invertedSentence[]) {
    /*
    * A String function that takes a sentence,
    * inverts it, and returns it.
    */

    //base case:
    if (index == strlen(sentence)) {
        //printf("Entrei aq no IF");
        invertedSentence[index]  = '\0';
        return invertedSentence;
    }

    char charactere = sentence[strlen(sentence) - 1 - index];

    invertedSentence[index] = charactere;

    index++;
    //printf("Segui o fluxo em %d", index);

    return sentenceInverterRecursive(sentence, index, invertedSentence);
}

int main() {
    /*
    * A main function that reads input
    * lines until reads "FIM", calls the
    * inverter for each line, and returns
    * the inverted line readed.
    */

    char line[1000];
    scanf("%s", line);

    while (strcmp(line, "FIM") != 0) {
        char invertedSentence[1000];

        line[strcspn(line, "\n")] = '\0';

        if (strcmp(line, "FIM") == 0) break;

        printf("%s\n", sentenceInverterRecursive(line, 0, invertedSentence));

        scanf("%s", line);
    }

    return 0;
}