def execute_command():
  global s
  args = [item for item in input().split()]
  if args[0] == 'pop':
    s.pop()
  elif args[0] == 'discard':
    s.discard(int(args[1]))
  elif args[0] == 'remove':
    s.remove(int(args[1]))

if __name__ == '__main__':
  n = int(input()) # number of elements in s
  s = set(map(int, input().split()))
  cn = int(input()) # number of commands

  for i in range(cn):
    execute_command()
  print(sum(s))