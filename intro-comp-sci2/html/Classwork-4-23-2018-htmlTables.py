import math
print "<!DOCTYPE html>"
print '<html>'
print '<body>'
print '<table>'

def htmlTableSquare():
    for x in range(3001):
        print "<tr> <th> "+ str(x)+"</th> <th> "+str(x*x)+"</th> </tr>"
print htmlTableSquare()
print '</table>'
def isPrime(a):
    counter = math.sqrt(a) - (math.sqrt(a) % 1)
    if counter % 2 == 0:
        counter += 1
    if a < 2:
        return False
    if a == 2:
        return True
    if a % 2 == 0:
        return False
    while counter >= 3:
        if a % counter > 0:
            counter -= 2
        else:
            return False
    return True
"""
print isPrime(15),False
print isPrime(3),True
print isPrime(45),False
print isPrime(47),True
print isPrime(17),True
print isPrime(49),False
"""
print "<table>"
def primeNumberGenerator(a):
    test = 2
    val = []
    counter = 0
    while counter < a:
        if isPrime(test):
            val.append(test)
            counter += 1
        test += 1
    return val
def htmlTablePrimeNum():
    for x in range(3000):
        print "<tr> <th> "+ str(x + 1) + " </th> <th> " + str(primeNumberGenerator(3000)[x]) + " </th> </tr>"

print htmlTablePrimeNum()
print "</table>"
print '</body>'
print '</html>'
