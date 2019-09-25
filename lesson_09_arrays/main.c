#include <stdio.h>
int main() {
    int ARR_SIZE = 10;
    int ARR2_SIZE = 10;
    int arr[ARR_SIZE];
    int arr2[ARR2_SIZE];
    int *poi = arr;
    printf("pointer to arr is %d\n", poi);
    int *poi2 = arr2;
    int i;
    srand(time(NULL));
    for(i = 0; i < ARR_SIZE; i = i + 1) {
        arr[i] = rand();
        printf("Random value for arr %d, is %f\n", i, arr[i]);
    }
    arr[ARR_SIZE - 2] = 0;
    for(i = 0; i < ARR_SIZE; i = i + 1) {
        poi2 = &(poi + i);
        printf("Random value for arr2 %d, is %d\n", i, );
    }
    return 0;
}

