#include <iostream>
using namespace std;

int main()
{
	int n, i, j, k;
	cin >> n;

	for (i = 0 ; i < n ; i++) {
		for (k = 0 ; k < i ; k++) {
			cout << ' ';
		}
		for (j = 0 ; j < n-i ; j++) {
			cout << '*';
		}
		cout << '\n';
	}

	return 0;
}