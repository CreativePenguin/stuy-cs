def hanoi(n,start,temp,end):
    if n == 1:
        print "move from " + start + " to " + end
    else:
        hanoi(n - 1,start,end,temp)
        print "move from " + start + " to " + end
        hanoi(n - 1,temp,start,end)
hanoi(2,"A","B","C")
print "fin"
hanoi(3,"X","temp","Y")
