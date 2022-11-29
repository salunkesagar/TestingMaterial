with open('f1.txt','w') as mywrite:
    mywrite.write('This is example of withas write/read')

with open('f1.txt','r') as myread:
    print(str(myread.read()))