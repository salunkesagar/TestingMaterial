class Car(object):
    def __init__(self):
        print('This is parent class')
    def drive(self):
        print('This is parent method')

class BMW(Car):
    def __init__(self):
        print("This is child Class")

    def drive(self):
        super().drive()
        print('This is child method')

c1 = Car()
c1.drive()

b1 =BMW()
b1.drive()