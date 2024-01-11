x = 10
c=10

def spam ():
    c=14
    bbeans = 15
    def inner ():
        c="funtimes!"
        def innerinner():
            global a
            a=54
            nonlocal c
            c=54
            nonlocal bbeans
            bbeans=68
        innerinner()
        print(c)
        return bbeans
    print(x)
    print(c)
    return inner()

print(spam())
