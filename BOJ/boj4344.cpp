#include <iostream>
using namespace std;

int main()
{
	int c, n, i;
	int sum, cnt;
	double avg;
	cin >> c;

	while (c--) {
		cin >> n;

		int scores[n];
		sum = 0, cnt = 0, avg = 0.0;

		for (i = 0 ; i < n ; i++) {
			cin >> scores[i];
			sum += scores[i];
		}
		avg = (double) sum / n;

		for (i = 0 ; i < n ; i++) {
			if (scores[i] > avg) 
				cnt++;
		}

		cout.setf(ios::fixed);
		cout.precision(3);
		cout << (double) cnt / n * 100 << '%' << '\n';
	}

	return 0;
}