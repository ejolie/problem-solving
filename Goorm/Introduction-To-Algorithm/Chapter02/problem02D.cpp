#include <cstdio>
#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
using namespace std;

const int MAX_LENGTH = 100000;

class MyString {
  private:
    char * characters;
    int length;

  public:
    MyString(const char * str) {
      this->length = strnlen(str, MAX_LENGTH);
      this->characters = new char[this->length];
      for (int i = 0; i < this->length; i+=1) {
        this->characters[i] = str[i];
      }
    }

    MyString(const string & original) {
      this->length = original.length();
      this->characters = new char[this->length];
      for (int i = 0; i < this->length ; i+=1) {
        this->characters[i] = original[i];
      }
    }

    ~MyString() {
      delete[] characters;
    }

    bool operator < (const MyString & o) const {
      int n = min(this->length, o.length);
    }

    bool operator == (const MyString & o) const {

    }
};

int main() {
  string s1;
  string s2;

  cin >> s1 >> s2;

  MyString mys1(s1);
  MyString mys2(s2);

  if (mys1 < mys2)
    printf("-1");
  else if (mys1 > mys2)
    printf("1");
  else
    printf("0");

  return 0;
}
