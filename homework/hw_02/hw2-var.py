def foo(x):
    x[0]=55
    x=11
    return x
def bar(xs):
    xs=[1, 2, 3]
    xs[0]="squeegee"
    return xs
ys=[[1, 2, 3], 2, 3]
print(foo(ys))
print(ys)
print(bar(ys))
print(ys)
zs=range(0, 10)
print(foo(zs))
print(zs)
print(bar(zs))
print(zs)

