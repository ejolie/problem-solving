#include <iostream>
using namespace std;

int main()
{
	int x, n, cmp;
	cin >> n >> x;

	for (int i = 0 ; i < n ; i++) {
		cin >> cmp;
		if (cmp < x)
			cout << cmp << " ";
	}

	return 0;
}