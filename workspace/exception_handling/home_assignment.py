def homeAssignment():
    try:
        car ={'make':'bmw','model':'550i','year':2022}
        a = car['color']
        print(a)
    except:
        print('This is an exception')
    finally:
        print('This will execute everyday')

homeAssignment()

