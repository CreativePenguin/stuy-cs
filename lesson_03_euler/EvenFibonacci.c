int main() {
  return 0;
}

int fibonacci(int i1, int i2, int counter, int max, int output[max]) {
  if(counter >= max) return output;
  if(counter % 2 == 0) {
    output[counter] = i1;
    fibonacci(i1 + i2, i2, counter + 1, output, max);
  }
  else {
    output[counter] = i2;
    fibonacci(i1, i1 + i2, counter + 1, output, max);
  }
}
  
