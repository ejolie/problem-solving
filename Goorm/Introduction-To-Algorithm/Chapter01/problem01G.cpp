#include <cstdio>
#include <iostream>
#include <string>
using namespace std;

void printIndexes(string school[], int n) {
  int first = -1;
  int last = -1;

  for (int i = 0 ; i < n ; i++) {
    if (school[i] == "AJOU") {
      if (first == -1) {
        first = i+1;
      }
      last = i+1;
    }
  }

  printf("%d %d\n", first, last);

}

int main() {
  int n;
  char buff[11];
  string * school;

  scanf("%d", &n);
  school = new string[n];

  for (int i = 1 ; i < n ; i++) {
    scanf("%s", buff);
    school[i] = buff;
  }

  printIndexes(school, n);

  delete[] school;

  return 0;
}
