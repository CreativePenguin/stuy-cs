#include <stdio.h>
int main() {
    int ARR_SIZE = 10;
    int ARR2_SIZE = 10;
    int arr[ARR_SIZE];
    int arr2[ARR2_SIZE];
    int poi = arr;
    int poi2 = arr2;
    int i;
    for(i = 0; i < ARR_SIZE; i = i + 1) {
        arr[i] = srand(time(NULL));
        printf("Random value for %d, is %d", i, arr[i]);
    }
    arr[ARR_SIZE - 2] = 0;
    for(i = 0; i < ARR_SIZE; i = i + 1) {
        *(poi2 + i) = *(poi + i);
        printf("Random value for %d, is %d", i, );
    }
    return 0;
}

