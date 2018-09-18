def myCapitalize(s):
    counter = 0
    while counter < len(s):
        a = s[counter]
        if a == "0" or a == "1" or a == "2" or a == "3" or a == "4" or a == "5":
            counter += 1
        elif a == "6" or a == "7" or a == "8" or a == "9":
            counter += 1
    sliceS = s[counter + 1:len(s)]
    return a.upper() + len(s)
