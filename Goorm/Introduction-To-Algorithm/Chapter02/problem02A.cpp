#include <cstdio>
#include <iostream>
using namespace std;

int getMaximumHeight(int height[], int month[], int n, int m) {
  int answer = -1;

  for (int i = n-1; i >= 0; i--) {
    if (month[i] == m) {
      answer = height[i];
      break;
    }
  }

  return answer;
}

int main() {
  int n, m;
  int * height;
  int * month;

  scanf("%d", &n);
  height = int new[n];
  month = int new[n];

  for (int i = 0; i < n; i++) {
    scanf("%d", &height[i]);
  }

  for (int i = 0; i < n; i++) {
    scanf("%d", &month[i]);
  }

  scanf("%d", &m);

  int answer = getMaximumHeight(height, month, n, m);
  printf("%d\n", answer);

  delete[] height;
  delete[] month;

  return 0;
}
