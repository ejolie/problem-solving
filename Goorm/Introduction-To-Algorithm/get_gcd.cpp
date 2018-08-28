#include <iostream>
using namespace std;

int get_gcd(int a, int b) // 두 자연수 a와 b에 대한 최대공약수를 계산한다
{
	int p = a; // 변수 p에 a를 저장한다
	int q = b; // 변수 q에 b를 저장한다
	int r = p % q; // 변수 r에 p를 q로 나눈 나머지를 계산하여 저장한다
	while (r) { // 변수 r의 값이 0이 되면 종료한다
		p = q;	// 변수 p를 변수 q에 저장된 값으로 덮어 쓴다.
		q = r;  // 변수 q를 변수 r에 저장된 값으로 덮어 쓴다.
		r = p % q; // 변수 r에 p를 q로 나눈 나머지를 계산하여 저장한다.
	}
	return q; // q에 저장된 값이 최대공약수이다.
}

int main()
{
	int a, b;
	cin >> a >> b;
	
	cout << get_gcd(a, b) << '\n';

	return 0;
}