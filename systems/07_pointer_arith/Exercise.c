#include <stdio.h>

void loop(char *c, int orig, int i) {
    if(i >= 2) return;
    printf("byte %d of %d is %p\n", i, orig, c);
    loop(c++, orig, i + 1);
}

int main() {
    unsigned int i = 261;
    int *p = &i;
    char *c = &i;
    printf("i = %u or %x, p = %ls, c = %s\n", i, i, p, c);
    loop(c, i, 0);
}
