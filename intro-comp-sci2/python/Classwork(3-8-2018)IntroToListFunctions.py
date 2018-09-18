#sum function -- can only accept lists
def mySum(x):
    i = 0
    val = 0
    while i < len(x):
        val += x[i]
        i += 1
    return val

def myMax(x):
    i = 0
    val = 0
    while i < len(x):
        if val < x[i]:
            val = x[i]
        i += 1
    return val
