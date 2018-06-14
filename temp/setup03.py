# python3

import os


# variable
homePath = os.environ["HOME"]
gdrivePath = homePath + "/.gdrive"
gdrive = gdrivePath + "/gdrive"


# gdrive exist?
isGdrive = os.path.exists(gdrivePath) # dir or file
if not isGdrive:
    os.mkdir(gdrivePath)
    downUrl = '192.168.20.14/repository/gdrive'
    os.system("wget {} -P {}".format(downUrl, gdrivePath))
    print(">> Make Directory: ", gdrivePath)
else:
    print(">> Gdrive Directory: ", gdrivePath)

os.chmod(gdrive, 755)


# make properties file
f = open(gdrivePath+"/config.properties", 'w')
f.write("homePath=" + homePath + "\n")
f.write("gdrivePath=" + gdrivePath + "\n")
f.write("gdrive=" + gdrive + "\n")
f.close()


# connect gd and local
os.system("{} about".format(gdrive))

