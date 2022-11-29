car = {'name':'abc','age':10,'address':'wakad','city':'pune'}
print(car.keys())
print(car.values())
print(car.items())
cpy = car.copy()
print(cpy)
car.pop('city')
print(car)