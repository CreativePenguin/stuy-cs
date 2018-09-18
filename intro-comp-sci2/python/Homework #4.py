def magicPair(a,b):
  if onesDigit(a) == onesDigit(b):
    return onesDigit(a) + onesDigit(b) == tensDigit(a) + tensDigit(b)
  if onesDigit(a) == tensDigit(b):
    return onesDigit(a) + tensDigit(b) == tensDigit(a) + onesDigit(b)
  if tensDigit(a) == tensDigit(b):
    return tensDigit(a) + tensDigit(b) == onesDigit(a) + onesDigit(b)
  if tensDigit(a) == onesDigit(b):
    return tensDigit(a) + onesDigit(b) == onesDigit(a) + tensDigit(b)
  else:
    return False
def onesDigit(a):
  return a % 10
def tensDigit(a):
  return ((a % 100) - (a % 10)) / 10
