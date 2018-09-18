nums = [
[1,2,3],
[4,5,6],
[3,-1,8] ]
	
def sumOfLists(data):
	val = 0
	for x in data:
		for result in x:
			val += result
	return val

