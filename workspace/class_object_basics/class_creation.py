
class Car(object):
    def __init__(self, make, model):
        self.carmake = make
        self.model = model


c1 = Car("bmw", '550i')
print(c1.carmake)
print(c1.model)

class Car1(object) :

    def __init__(self, make):
        self.make = make


    def info(self):
        print("The make of car is " + self.make)

c3 = Car1("bmw")
c3.info()
