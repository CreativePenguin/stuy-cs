#include <stdio.h>

int avg(int *arr) {
  const int LEN = (int) (sizeof(arr) / sizeof(arr[0]));
  int i; int sum = 0;
  for(i = 0; i < LEN; i++) {
    sum += arr[i];
  }
  return sum;
}

void arrcpy(int *dest, int *src) {
  *dest = *src;
}

int len(int* arr) {
  int i = 0; int* poi = arr;
  while(1) {
    if(*(poi + i) == NULL) return i;
    i++;
  }
  return 0;
}

