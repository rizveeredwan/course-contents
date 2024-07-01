from math import floor

def binary_search(arr, sr):
    # Given an array, find the index after which sr will be placed
    st, en = 0, len(arr)-1
    while st<en:
        if (en-st) <= 1:
            if en<sr:
                return en+1
            if st<sr:
                return st+1
        mid = floor((st+en)/2)
        if sr < arr[mid]:
            en = mid-1
        else:
            st = mid


array = [ 1, 5, 7, 10, 17, 29, 35, 47, 49, 51, 53, 107, 125, 137]
sr=108
print(binary_search(array, sr))
"""
11
"""
