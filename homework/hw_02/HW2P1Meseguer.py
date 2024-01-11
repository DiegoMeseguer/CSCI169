def scope_test():
    def do_local():
         spam = "local spam"
    def do_nonlocal():
        nonlocal spam
        spam = "nonlocal spam"
    def do_global():
        global spam
        spam = "global spam"
    spam = "test spam"
    do_local()
    print("After local assignment:", spam)
    do_nonlocal()
    print("After nonlocal assignment:", spam)
    do_global()
    print("After global assignment:", spam)
scope_test()
print("In global scope:", spam)

# We start by defining three inner functions inside scope_test()
# Then we create the variable spam with the value "test spam"
# Then we call the function do_local(), which inside its scope creates
# the local variable spam with the value "local spam"

# In Python only functions introduce a new scope, so in the first print 
# statement we print "test spam" because we are in the scope of 
# scope_test and the variable spam that was created inside do_local() is local
# to that function so it doesn't modify the spam in the outer function.

# Then we call the function do_nonlocal() which creates the variable spam
# with the value "nonlocal spam" and declares this variable as nonlocal
# Because of this, in the next print statement we see "nonlocal spam", because
# now we are modifying the spam variable in the outer function

# Next we call the function do_global which creates the variable spam with
# value "global spam" and declares this variable as global. Because of this,
# in the next print statement we still see "nonlocal spam", because we are now
# modifying the spam variable in the global scope which is outside the 
# outer function scope_test(). So spam remains with the value "nonlocal spam"
# since this spam is in the scope of scope_test() and not the global scope

# Finally, in the last print statement we are printing "global spam" since we are
# now outside the scope of scope_test() and we are accessing the global variable
# spam that we created when we called do_global()


