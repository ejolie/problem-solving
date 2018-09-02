#include <cstdio>
#include <iostream>
using namespace std;

bool isOrdered(int data[], int n) {
  bool answer = true;

  for (int i = 0; i < n-1; i++) {
    if (data[i] > data[i+1]) {
      answer = false;
      break;
    }
  }

  return answer;
}

int main() {
  int n;
  int * data;
  scanf("%d", &n);

  for (int i = 0; i < n; i++) {
    scanf("%d", &data[i]);
  }

  bool result = isOrdered(data, n);
  result == true ? printf("YES") : printf("NO");

  delete[] data;

  return 0;
}
