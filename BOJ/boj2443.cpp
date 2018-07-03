#include <iostream>
using namespace std;

int main()
{
	int n, i, j, k;
	cin >> n;

	for (i = n ; i >= 1 ; i--) {
		for (j = 0 ; j < n-i ; j++) {
			cout << ' ';
		}
		for (k = 0 ; k < (2*i - 1) ; k++) {
			cout << '*';
		}
		cout << '\n';
	}

	return 0;
}