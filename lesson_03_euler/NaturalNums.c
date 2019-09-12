#include <stdio.h>

int naturalnums(int counter, int sum) {
  if(counter < 3) return sum;
  if(counter % 3 == 0 || counter % 5 == 0) return naturalnums(counter - 1, sum + counter);
  else return naturalnums(counter - 1, sum);
}

int main() {
  printf("The sum of the multiples of 3 and 5 up to 1000 are %d", naturalnums(1000,0));
  return 0;
}


