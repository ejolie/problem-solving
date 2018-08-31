#include <cstdio>
#include <iostream>
#include <cmath>
using namespace std;

int findIndex(int data[], int n) {
  int x = 0;
  int sum = 0;

  for (int i = 0 ; i < n ; i++) {
    sum += data[i];
  }

  int avg = sum/n;
  int dx, di;
  for (int i = 0 ; i < n ; i++) {
    dx = abs(data[x] - avg); // i까지의 원소들 중 평균과의 최소거리
    di = abs(data[i] - avg); // 현재 원소와 평균과의 거리

    if (di < dx) {
      x = i;
    }
  }

  return x+1;
}

int main() {
  int n;
  int * data;

  scanf("%d", &n);
  data = new int[n];

  for (int i = 0 ; i < n ; i++) {
    scanf("%d", &data[i]);
  }

  int answer = findIndex(data, n);
  printf("%d %d\n", answer, data[answer-1]);

  delete[] data;

  return 0;
}
