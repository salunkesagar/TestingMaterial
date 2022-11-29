def calNetIncome(gross, state) :
    """
    Calculate net income  after feeral and state tax
    :param gross:
    :param state:
    :return:
    """
    statetax = {'MH':10,'MP':12,'PB':15}
    net = gross -(gross*0.10)
    if state in statetax :
        net = net -(gross * statetax[state]/100)
        print('your net income' + str(net))
        return net
    else:
        print('state is not in list')
        return None

calNetIncome(100000,'PB')


