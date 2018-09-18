def triangle(n):
    if n == 0:
        return 0
    else:
        return triangle(n-1) + n
"""
print triangle(10)
print triangle(67)
print triangle(3)
print triangle(0)
print triangle(1)
"""
def powerN(base,n):
    if n == 0:
        return 1
    else:
        return base * powerN(base,n - 1)
"""
print powerN(100,3)
print powerN(3,1)
print powerN(3,2)
print powerN(3,3)
"""
def changexy(idk):
    if idk == "":
        return ""
    elif idk[0] == "x":
        return "y" + changexy(idk[1:])
    else:
        return idk[0] + changexy(idk[1:])
"""
print changeXY("codex")
print changeXY("xxhixx")
print changeXY("xhixhix")
"""
def array11(array,index):
    if index > len(array) - 1:
        return 0
    if array[index] == 11:
        return 1 + array11(array,index + 1)
    else:
        return array11(array,index + 1)
print array11([4],0),0
print array11([11],0),1
print array11([11,11,3],0),2
print array11([11,11,3],1),1
print array11([3,11,44],0),1
