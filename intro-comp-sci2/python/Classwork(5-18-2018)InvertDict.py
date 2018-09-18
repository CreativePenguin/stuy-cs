def invertDict(d):
    keys = []
    vals = []
    val = {}
    counter = 0
    for i in d.keys():
        keys.append(i)
    #return keys
    for i in d.keys():
        vals.append(d[i])
    #return vals
    while counter < len(d.keys()):
        if vals[counter] in val.keys():
            val[vals[counter]].append(keys[counter])
        else:
            val[vals[counter]] = [keys[counter]]
        counter += 1
    return val
print invertDict({ 1:2 , 3:4, 9:13})
print invertDict({'Donald':'Trump','Eric':'Trump',})
