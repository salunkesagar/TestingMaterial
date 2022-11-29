cars=['kia','audi','honda','bmw']
print(cars)
cars.append('benz')
print(cars)
print(len(cars))
cars.insert(1,'ford')
print(cars)
cars.pop()
print(cars)
cars.remove('bmw')
print(cars)

cars.sort()
print(cars)

l = [1,2,3,3,3]
print(l.count(3))