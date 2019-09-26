#include <stdio.h>
int main() {
  const int SIZE = 10;
  int arr[SIZE], arr2[SIZE];
  int* poi = arr;
  int* poi2 = arr2;
  for(int i = 0; i < SIZE; i++) {
    *(poi + i) = rand();
    printf("%d : %d \n", i, *(poi + i));
  }
  for(int i = 0; i < SIZE; i++) {
    *(poi2 + i) = *(poi + i);
    printf("%d : %d \n", i, *(poi2 + i));
  }
}

