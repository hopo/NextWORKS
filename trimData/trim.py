import re

with open('urlsmapped.txt') as f:
    read_data = f.read()

# print(read_data)

m = re.split(r'\"\{\[', read_data)

ls = list()

for e in m:
    x = re.split(r'\]\}\"', e)
    ls.append(x[0])

for e in range(3, len(ls)):
    print('urls.put("","{}");'.format(ls[e]))
