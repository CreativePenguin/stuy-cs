#include <stdio.h>
#include <string.h>

int main() {
    char rust[256] = "rust is better";
    char dust[256] = "dust is better";
    strcpy(dust, rust);
    printf("strcpy: %s\n", dust); //prints rust is better

    char school[256] = "hell";
    char *owl = "o";
    strcat(school, owl);
    printf("strcat: %s\n", school); //prints hello
}

