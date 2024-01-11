sampleList = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]


print("Sample list: ")
print(sampleList)
result01 = [x for x in sampleList[1::3]] 
print(result01)



sampleList2  = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, "hello"]
print("Sample list: ")
print(sampleList2)

result02 = [str(x) for x in sampleList2 if type(x) == int]
print(result02)

 
