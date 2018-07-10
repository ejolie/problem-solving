#include <iostream>
#include <string>
using namespace std;

void repeatString(int r, string str)
{
	int i, j;
	for (i = 0 ; i < str.size() ; i++) {
		for (j = 0 ; j < r ; j++) {
			cout << str.at(i);
		}
	}
	cout << '\n';
}

int main()
{
	int n, i;
	cin >> n;

	int r;
	string str;

	for (i = 0 ; i < n ; i++) {
		cin >> r >> str;
		repeatString(r, str);
	}

	return 0;
}