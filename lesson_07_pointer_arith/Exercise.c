#include <stdio.h>

int main() {
    unsigned int i = 261;
    int *p = &i;
    char *c = &i;
    printf("i = %u or %x, p = %d, c = %d\n", i, i, p, c);
    loop(c, i, 0);
}

void loop(char *c, int orig, int i) {
    if(i >= 1) return;
    printf("byte %d of %d is %d", i, orig, c);
    loop(c++, orig, i++);
}
