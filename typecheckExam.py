
import math


x = math.pow(3, 3)

def void():
    y = 1+1

print("x:", x)

print("type(x):", type(x))
print("type(x) == type(0.0):", type(x) == type(0.0))

print("type(void()).__name__:", type(void()).__name__)
print("type(x).__name__: ", type(x).__name__)

print("x.__class__.__name__:", x.__class__.__name__)


print("math.pow(3, 3).__class__.__name__:", math.pow(3, 3).__class__.__name__)

