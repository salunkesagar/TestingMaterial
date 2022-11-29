def exceptionHandling():
    try:
        a = 10
        b = 0
        c = a/b
        print(c)
    except:
        print('This is an exception')

exceptionHandling()