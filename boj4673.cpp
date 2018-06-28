#include <iostream>
using namespace std;

bool arr[10001];

int dn(int n) 
{
	int sum = n;

	if (n >= 10000) {
		sum += n/10000;
		n %= 10000;
	}
	if (n >= 1000) {
		sum += n/1000;
		n %= 1000;
	}
	if (n >= 100) {
		sum += n/100;
		n %= 100;
	}
	if (n >= 10) {
		sum += n/10;
		n %= 10;
	}

	return sum += n;
}

int main()
{
	int res;
	for (int i = 1 ; i < 10001 ; i++) {
		res = dn(i);
		if (res <= 10000)
			arr[res] = true;
		if (!arr[i])
			cout << i << endl;
	}

	return 0;
}