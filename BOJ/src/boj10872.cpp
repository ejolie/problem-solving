#include <iostream>
using namespace std;

long fact(int n)
{
	int i;
	long res = 1;

	if (n == 0 || n == 1)
		return res;
	else 
	{
		for (i = 2 ; i <= n ; i++) {
			res *= i;
		}
		return res;
	}
	return 0;
}

int main()
{
	int n;
	cin >> n;

	cout << fact(n) << '\n';

	return 0;
}