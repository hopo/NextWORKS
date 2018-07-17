import os

pwd = os.chdir('/home/pc33/NextWORKS/lecture-Front/jsstudy/')
cwd = os.getcwd()

weeks = []
for e in os.listdir(cwd):
    if e[:4] == 'Week':
        weeks.append(e)


weeks.sort()
print(weeks)



path = '/home/pc33/NextWORKS/lecture-Front/jsstudy/'
ls = os.listdir(path + weeks[8])

for e in ls:
    if e[-4:] == 'html':
        print(e)
