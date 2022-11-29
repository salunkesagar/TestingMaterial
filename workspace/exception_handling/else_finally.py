def exceptionHandling():
    try:
        a = 10
        b = 0
        c = a/b
        print(c)

    except:
        print('This is an exception')

    else:
        print('This is executed when no exception is there')
    finally:
        print('This is finally block')

exceptionHandling() 