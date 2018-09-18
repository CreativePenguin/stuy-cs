#Lists Without Loops

#make_pi
def make_pi():
    return [3,1,4]
#same_first_last
def same_first_last(nums):
    return not nums == [] and nums[0] == nums[len(nums) - 1]
#common_end
def common_end(a,b):
    return a[len(a) - 1] == b[len(b) - 1] or a[0] == b[0]
#has23
def has23(nums):
    return nums[0] == 2 or nums[0] == 3 or nums[1] == 2 or nums[1] == 3
#Lists With Loops
#count_evens
def count_evens(nums):
    i = 0
    value = 0
    while i < len(nums):
        if nums[i] % 2 == 0:
            value += 1
        i += 1
    return value

#big_diff
def big_diff(nums):
    i = 0
    lmin = nums[0]
    lmax = nums[0]
    while i < len(nums):
        if nums[i] > lmax:
            lmax = nums[i]
        if nums[i] < lmin:
            lmin = nums[i]
        i += 1
    return lmax - lmin

#centered_average
def max_min(nums,isMax):
    i = 0
    lmin = nums[0]
    lmax = nums[0]
    while i < len(nums):
        if nums[i] > lmax:
            lmax = nums[i]
        if nums[i] < lmin:
            lmin = nums[i]
        i += 1
    if isMax:
        return lmax
    return lmin
def average(nums):
    i = 0
    value = 0
    while i < len(nums):
        value += nums[i]
        i += 1
    return value / (len(nums) - 2)
def centered_average(nums):
    lmax = max_min(nums,True)
    lmin = max_min(nums,False)
    newNums = nums
    newNums[nums.index(lmax)] = 0
    newNums[nums.index(lmin)] = 0
    return average(newNums)
