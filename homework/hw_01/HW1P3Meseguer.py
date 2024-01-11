def partition(input, p, r):
    
    pivot = input[r]
    
    while p < r:
        while input[p] < pivot:
            p = p + 1
        while input[r] > pivot:
            r = r - 1
        if input[p] == input[r]:
            p = p + 1
        elif p < r:
            tmp = input[p]
            input[p] = input[r]
            input[r] = tmp
    return r

def quicksort(input, p, r):

    if p < r:
        j = partition(input, p, r)
        quicksort(input, p, j - 1)
        quicksort(input, j + 1, r)

input = [500, 700, 800, 100, 300, 200, 900, 400, 1000, 600]

print("Input:")
print(input)
quicksort(input, 0, 9)
print("Output:")
print(input)

input2 = [8943, 23, 111, 3, 900, 52, 0, 40]

print("Input:")
print(input2)
quicksort(input2, 0, 7)
print("Output:")
print(input2)


