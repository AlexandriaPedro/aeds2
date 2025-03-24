/*Implemente um programa denominado Combinador, que recebe duas strings e deve combiná-las,
alternando as letras de cada string, começando com a primeira letra da primeira string, 
seguido pela primeira letra da segunda string, em seguida pela segunda letra da primeira string, 
e assim sucessivamente. As letras restantes da cadeia mais longa devem ser adicionadas ao fim da 
string resultante e retornada.*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>
#include <locale.h>
#include <wchar.h>
#include <string.h>

void stringCombinator(char sentence[], char newSentence[]) {
    char* word1 = strtok(sentence, " ");
    char* word2 = strtok(NULL, " ");
    
    int smallerSentenceLength = strlen(word1);
    if (smallerSentenceLength > strlen(word2)) {
        smallerSentenceLength = strlen(word2);
    }

    int indexAuxiliar = 0;
    for (int index = 0; index < smallerSentenceLength; index ++) {
        newSentence[indexAuxiliar++] = word1[index];
        newSentence[indexAuxiliar++] = word2[index];
    }

    if (strlen(word1) > strlen(word2)) {
        for (int index = smallerSentenceLength; index < strlen(word1); index ++) {
            newSentence[indexAuxiliar++] = word1[index];
        }
    } else if (strlen(word1) < strlen(word2)) {
        for (int index = smallerSentenceLength; index < strlen(word2); index ++) {
            newSentence[indexAuxiliar++] = word2[index];
        }
    }

    newSentence[indexAuxiliar] = '\0';
}

int main() {
    char line[1000];
    char newSentence[1000];

    while(fgets(line, sizeof(line), stdin) != NULL) {
        line[strcspn(line, "\n")] = '\0';

        if (strlen(line) == 0) {
            break;
        }

        stringCombinator(line, newSentence);

        printf("%s\n", newSentence);
    }

    return 0;
}