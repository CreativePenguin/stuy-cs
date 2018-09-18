def double_char(s):
    i = 0
    value = ""
    while i < len(s):
        value += s[i] + s[i]
        i += 1
    return value

def count_hi(s):
    i = 0
    value = 0
    while i < len(s) - 1:
        if "hi" == s[i] + s[i + 1]:
            value += 1
        i += 1
    return value

def cat_dog(s):
    i = 0
    cvalue = 0
    dvalue = 0
    while i < len(s) - 2:
        if "dog" == s[i] + s[i + 1] + s[i + 2]:
            dvalue += 1
        if "cat" == s[i] + s[i + 1] + s[i + 2]:
            cvalue += 1
        i += 1
    return cvalue == dvalue

def count_code(s):
    i = 0
    value = 0
    while i < len(s) - 3:
        if "coe" == s[i] + s[i + 1] + s[i + 3]:
            value += 1
    return value

def end_other(a,b):
    a1 = a.lower()
    b1 = b.lower()
    isbLong = len(a1) < len(b1)
    if isbLong:
        return b1[len(b1) - len(a1):len(b1)] == a1
    else:
        return a1[len(a1) - len(b1):len(a1)] == b1

def xyz_there(s):
    i = 0
    while i < len(s) - 2:
        if "xyz" == s[i] + s[i + 1] + s[i + 2] and not s[i - 1] == ".":
            return True
        i += 1
    return False
