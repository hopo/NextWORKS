import math


def multi(a, b):
    if a > b:
        a, b = b, a
    return a * b


if __name__ == '__main__':
    print(multi(2, 5))
