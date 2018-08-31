#include <stdio.h>
#include <iostream>
using namespace std;

int getMax(int data[], int n) {
  int answer = data[0];
  for(int i=1 ; i<n ; i++) {
    if (data[i] > answer)
      answer = data[i];
  }
  return answer;
}

int main() {
  int n;
  int * data;

  scanf("%d", &n);
  data = new int[n];

  for(int i=0 ; i<n ; i++) {
    scanf("%d", &data[i]);
  }

  int answer = getMax(data, n);
  printf("%d\n", answer);

  delete[] data;

  return 0;
}
