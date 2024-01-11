x = 10  #global variable
c=10   # global variable

def spam ():
    c=14         # inside spam() scope
    bbeans = 15  # inside spam() scope
    def inner ():
        c="funtimes!"  # inside inner() scope
        def innerinner():
            global a  # this creates global variable a
            a=54
            nonlocal c # this modifies the c of inner()
            c=54
            nonlocal bbeans # this creates bbeans in inner() scope
            bbeans=68
        innerinner()
        print(c) # This is the third print we see, prints 54
                 # because the nonlocal c created inside innerinner()
                 # modified the local c of inner()
        return bbeans # This is the fourth and last print we see,
                      # prints 68 which was created as nonlocal inside
                      # innerinner()
    print(x) # This is the first print we see, prints global x so 10
    print(c) # This is the second print we see, prints local c inside 
             # spam() scope so 14
    return inner() # calls inner(), which prints the third and fourth lines

print(spam())

# The outputs is 
# 10
# 14
# 54
# 68
# The 10 comes from the print(x) which prints the global variable x
# The 14 comes from the last print(c) which prints the c in the scope
# of spam()
# The 54 comes from the c in the scope of inner() which was modified by i# innerinner()
# the 68 comes from the return value of spam() which returns the variable
# bbeans which was created inside the scope of inner() by innerinner() using nonlocal


