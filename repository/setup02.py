import os

homePath = os.environ["HOME"]
print(">> jhomePath: ",homePath)

gdrivePath = homePath + "/.gdrive"
print(">> gdrivePath: ", gdrivePath)

isGdrive = os.path.exists(gdrivePath) # dir or file

# gdrive exist
if not isGdrive:
    os.mkdir(gdrivePath)
    downUrl = '192.168.20.14/repository/gdrive'
    os.system("wget {} -P {}".format(downUrl, gdrivePath))
    print(">> Make Directory: ", gdrivePath)
else:
    print(">> Gdrive Directory: ", gdrivePath)

gdrive = gdrivePath + "/gdrive"

os.chmod(gdrive, 755)
os.system("{} help".format(gdrive))
    

