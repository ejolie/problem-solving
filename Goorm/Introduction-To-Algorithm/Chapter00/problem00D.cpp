#include <cstdio>
const int MAX_N = 1000;

int main() {
  int n;
  int data[MAX_N];
  scanf("%d", &n);

  for(int i=0 ; i<n ; i++) {
    scanf("%d", &data[i]);
  }

  for(int i=n-1 ; i>0 ; i--) {
    printf("%d ", data[i]);
  }
  printf("%d", data[0]);

  return 0;
}
