#include <string.h>

int main() {
    char rust[256] = "rust is better";
    char *dust = "dust is better";
    char scopy;
    strcpy(rust, dust);
