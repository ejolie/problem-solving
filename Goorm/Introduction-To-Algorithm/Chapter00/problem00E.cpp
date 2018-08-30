#include <cstdio>

void test_case() {
  int a, b, c;
  scanf("%d %d %d", &a, &b, &c);

  int sum = a+b+c;
  printf("%d\n", sum);
}

int main() {
  int tc;
  scanf("%d", &tc);

  for(int i=1 ; i<=tc ; i++) {
    printf("Case #%d\n", i);
    test_case();
  }

  return 0;
}
