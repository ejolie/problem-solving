#include <cstdio>

int code_counter = 0;

void code(int x) {
  code_counter++;
  printf("[%03d] 현재 x는 %d 입니다.\n", code_counter, x);
}

int main() {
  int l = 0;
  int r = 100;
  int step = 1;

  for(int i=l ; i<=r ; i+=step) {
    code(i);
  }

  return 0;
}
