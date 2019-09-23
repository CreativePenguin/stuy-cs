int main() {
    int ARR_SIZE = 10;
    int arr[ARR_SIZE];
    int i;
    for(i = 0; i < ARR_SIZE; i = i + 1) {
        arr[i] = srand(time(NULL));
    }
    arr[ARR_SIZE - 2] = 0;
    return 0;
}
