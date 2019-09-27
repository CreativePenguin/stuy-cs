#include <stdio.h>
int lcm(int min, int max, int multipleI, int factorI) {
  if(factorI == max) return multipleI;
  if(multipleI % factorI != 0) return lcm(min, max, multipleI + 1, min);
  return lcm(min, max, multipleI, factorI + 1);
}

int main() {
  printf("The min value is %d", lcm(1, 20, 20, 1));
  return 0;
}

