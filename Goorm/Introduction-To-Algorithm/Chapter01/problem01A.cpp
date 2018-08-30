#include <stdio.h>
#include <iostream>
using namespace std;

int get_Max(int a, int b) {
  return a>b ? a : b;
}

int main() {
  int p, q;
  scanf("%d %d", &p, &q);

  int answer = getMax(p, q);
  printf("%d\n", answer);

  return 0;
}
