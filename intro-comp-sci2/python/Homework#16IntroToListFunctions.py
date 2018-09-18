#sum13
def sum13(nums):
    if nums == []:
        return 0
    i = 0
    value = 0
    while i < len(nums):
        if not nums[i] == 13:
            value += nums[i]
        elif i < len(nums) - 1:
            nums[i+1] = 0
        i += 1
    return value
#sum67
def sum67(nums):
    if nums == []:
        return 0
    i = 0
    value = 0
    while i < len(nums):
        if nums[i] == 6:
            while not nums[i] == 7:
                i += 1
            nums[i] = 0
        value += nums[i]
        i += 1
    return value
#has22
def has22(nums):
    i = 0
    while i < len(nums) - 1:
        if nums[i] == 2 and nums[i + 1] == 2:
            return True
        i += 1
    return False
