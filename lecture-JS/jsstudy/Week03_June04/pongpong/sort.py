
ls = [4,34,5,345,98,2,34,8,45,1]

for i in range(len(ls)):
    for j  in range(len(ls)):
        if ls[i] < ls[j]:
            ls[i], ls[j] = ls[j], ls[i]

print(ls)
