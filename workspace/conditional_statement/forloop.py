a= 'abcaefa'
for c in a:
    if c == 'a':
        print('A', end='')
    else:
        print(c, end='')

nums=[1,23,45]
for n in nums :
     print(n*10)

d={'one':1, 'two':2, 'three':3}
for k in d :
    print(k +" "+str(d[k]))
for k1,v1, in d.items():
    print(k1)
    print(v1)
