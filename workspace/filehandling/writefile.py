l1 = [1, 2, 3]
f1 = open("myfile.txt",'w')

for items in l1:
    f1.write(str(items) + '\n')
f1.close()