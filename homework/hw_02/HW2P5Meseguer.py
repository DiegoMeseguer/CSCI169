chessboardSize = 8
solutions = list()

pares = [even for even in range(1, chessboardSize + 1) if even % 2 == 0]
impares = [odd for odd in range(1, chessboardSize + 1) if odd % 2 != 0]

# Swap 1 and 3 in the odd list
temp = impares[0]
impares[0] = impares[1]
impares[1] = temp

# Move 5 to the end of the odd list    
fiveIndex = impares.index(5)
impares.append(impares.pop(fiveIndex))

# Combine the two lists
solutions = pares + impares

for row in reversed(range(1, chessboardSize + 1)):  # From 8 to 1
    for column in range(chessboardSize):            # From a to h
        if row == solutions[column]:
            print("Qu\t", end=" ")
        else:
            print("[]\t", end=" ")
    print("\n")
        


