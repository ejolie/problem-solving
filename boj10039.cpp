#include <iostream>
using namespace std;

int main()
{
	int arr[5];
	int avg = 0;

	for (int i = 0 ; i < 5 ; i++) {
		cin >> arr[i];
		if (arr[i] < 40)
			arr[i] = 40;
		avg += arr[i];
	}

	cout << avg/5 << endl;

	return 0;
}