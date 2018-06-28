#include <iostream>
using namespace std;

int main()
{
	int n, five = 0, three = 0;

	cin >> n;

	five = n/5;
	n %= 5;

	while (five >= 0) {
		if (n%3 == 0) {
			three = n/3;
			n %= 3;
			break;
		}
		five--;
		n += 5;
	}
	
	cout << (n == 0 ? five + three : -1);

	return 0;
}