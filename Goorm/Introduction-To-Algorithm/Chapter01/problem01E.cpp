#include <cstdio>
#include <iostream>
using namespace std;

void solve(int data[], int n, int p, int q) {
  int count = 0;
  int sum = 0;

  for (int i = 0 ; i < n ; i++) {
    if (data[i] <= p) {
      count++;
      sum += data[i];
    }
  }

  printf("%d %d\n", count, sum);
  sum < q ? printf("YES") : printf("NO");

}

int main() {
  int n, p, q;
  int * data;

  scanf("%d %d %d", &n, &p, &q);
  data = new int[n];

  for (int i = 0 ; i < n ; i++) {
    scanf("%d", data[i]);
  }

  solve(data, n, p, q);

  delete[] data;
  return 0;
}
