def fun(x, y):
    if isinstance(x, int) and isinstance(y, int):
        return x + y
    elif isinstance(x, str) and isinstance(y, str):
        return x + y
    else:
        print("Error")

# Test 1
print("Both inputs are numbers:")
a = 12
b = 20
print(a)
print(b)
print(fun(a, b))

# Test 2
print("Both inputs are strings:")
c = "quick"
d = "fox"
print(c)
print(d)
print(fun(c, d))


