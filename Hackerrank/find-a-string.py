def count_substring(string, sub_string):
  return string.count(sub_string)

if __name__ == '__main__':
  string = input()
  sub_string = input()
  print(count_substring(string, sub_string))