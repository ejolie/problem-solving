#include <cstdio>
#include <iostream>
using namespace std;

int getRangeSumFromOne(int i) {
  int sum = (1+i)*i/2;
  return sum;
}

long long getAnswer(int N) {
  long long answer = 0;

  for (int i = 1 ; i <= N ; i++) {
    answer += getRangeSumFromOne(i);
  }

  return answer;
}

int main() {
  int n;
  scanf("%d", &n);

  long long answer = getAnswer(n);
  printf("%lld\n", answer);

  return 0;
}
