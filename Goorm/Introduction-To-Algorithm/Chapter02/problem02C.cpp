#include <cstdio>
#include <iostream>
using namespace std;

int getElementTypeCount(int data[], int n) {
  int countType = 0;

  for (int i = 0; i < n; i++) {
    if (i == 0 || data[i-1] != data[i])
      countType++;
  }
  
  return countType;
}

int main() {
  int n;
	int* data;

	scanf("%d", &n);
	data = new int[n];

	for (int i = 0; i < n; i++) {
		scanf("%d", &data[i]);
	}

	int answer = getElementTypeCount(data, n);

	printf("%d\n", answer);

	delete[] data;
	return 0;
}
