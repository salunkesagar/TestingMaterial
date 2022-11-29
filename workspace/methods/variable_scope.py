a = 10

def tes1(a) :
    print('value of global variable "a" inside method is ' + str(a))
    a = 2
    print('value of local variable "a" inside method is ' + str(a))
print('The value of global variable                                                                                                                                                                                                                          ' + str(a))
tes1(a)
print('The value of global variable is changed? '  + str(a))


b = 20
def test2() :
    global b
    print('The value of global variable ' + str(b))
    b = 4
    print('The value of local variable "b" is ' + str(b))


print('The global value of "b" is ' + str(b))
test2()
print("The value of 'b' is changed " + str(b))

