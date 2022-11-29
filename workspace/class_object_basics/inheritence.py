class Car(object):
    def __init__(self):
        print('Car class create')
    def drive(self):
        print('Car Started')
    def stop(self):
        print('Car Stopped')
class BMW(Car):
    def __init__(self):
        print('BMW created')
c1 =Car()
c1.drive()
c1.stop()
c2 = BMW()
c2.drive()
c2.stop()
