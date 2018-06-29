#include <iostream>
using namespace std;

int main()
{
	int n, copy, cnt = 0;
	int x, y, z;
	cin >> n;
	copy = n;

	do {
		cnt++;
		
		x = n/10;
		y = n%10;
		z = (x+y)%10;

		n = y*10 + z;
	} while (n != copy);

	cout << cnt;

	return 0;
}