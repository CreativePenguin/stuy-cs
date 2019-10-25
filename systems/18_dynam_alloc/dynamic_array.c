#include <stdio.h>
#include <stdlib.h>

int main() {
  int *p;
  p = malloc(5 * sizeof(int));
  p = malloc(7 * sizeof(int));

  printf("p: %p sizeof p:%lu\n", p, sizeof(p));
  p[0] = 89723;
  printf("p[0]: %d\n", p[0]);

  free(p);
  p = NULL; //This will cause a segfault, so you can't modify it anymore
  printf("p: %p sizeof p:%lu\n", p, sizeof(p));
  printf("p[0]: %d\n", p[0]);

  return 0;
}
