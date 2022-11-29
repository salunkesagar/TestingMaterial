class Fruit(object):
    def __init__(self):
        print('This is fruit class')

    def nutrition(self):
        print('This is nutrition Method of parent')

    def fruitShape(self):
        print('This is shape method')

class Mango(Fruit):
    def __init__(self):
        print('This is child class')
    def nutrition(self):
        super().nutrition()
        print('This is child method')

c1 = Fruit()
c1.nutrition()

c2 = Mango()
c2.nutrition()