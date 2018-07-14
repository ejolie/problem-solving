#include <iostream>
using namespace std;

int main()
{
	int s1, s2, s3, s4, sum;
	cin >> s1 >> s2 >> s3 >> s4;

	sum = s1 + s2 + s3 + s4;
	
	cout << sum / 60 << '\n';
	cout << sum % 60 << '\n';

	return 0;
}