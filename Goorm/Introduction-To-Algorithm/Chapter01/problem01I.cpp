#include <cstdio>
#include <iostream>
using namespace std;

int getMinIndexInRange(int data[], int n, int begin, int end) {
  int minIndex = begin;

  for (int i = begin+1 ; i <= end ; i++) {
    if (data[minIndex] > data[i]) {
      minIndex = i;
    }
  }
  return minIndex;
}

void selectionSort(int data[], int n) {
  for (int i = 0 ; i < n ; i++) {
    // 주어진 범위에서 가장 작은 원소의 위치를 찾는다.
    int minIndex = getMinIndexInRange(data, n, i, n-1);

    // 두 숫자의 위치를 바꾼다.
    int temp = data[i];
    data[i] = data[minIndex];
    data[minIndex] = temp;
  }
}

int main() {
  int n;
  int * data;

  scanf("%d", &n);
  data = new int[n];

  for (int i = 0 ; i < n ; i++) {
    scanf("%d", &data[i]);
  }

  selectionSort(data, n);

  for (int i = 0 ; i < n ; i++) {
    if (i > 0) {
      printf(" ");
    }
    printf("%d", data[i]);
  }

  delete[] data;
  return 0;
}
