# /bin/python3

import os


"""
 variables declation
"""
homePath = os.environ["HOME"]
gdrivePath = homePath + "/.gdrive"
gdrive = gdrivePath + "/gdrive"
token = gdrivePath + "/token2.json" # ;check file name


"""
 gdrive directory check
"""
isGdrivePath = os.path.exists(gdrivePath) # dir or file
if not isGdrivePath:
    os.mkdir(gdrivePath)
    print(">> Make Directory: ", gdrivePath)
else:
    print(">> Gdrive Path: ", gdrivePath)


"""
 gdrive file check
"""
isGdrive = os.path.exists(gdrive)
if not isGdrive:
    print(">> gdrive file NOT exist")
    print(">> START gdrive install")

    """ install gdrive """
    url = '192.168.20.14/repository/gdrive'
    os.system("wget {} -P {}".format(url, gdrivePath))
    os.chmod(gdrive, 755)
else:
    print(">> gdrive file exist: " + gdrive)


"""
 gdrive token file check
"""
isToken = os.path.exists(token)
if not isToken:
    print(">> token file NOT exist")
    print(">> GET Authetication")

    os.system('{} about'.format(gdrive))
else:
    print(">> token file exist" + token)


'''
"""
 make properties file
"""
f = open(gdrivePath+"/config.properties", 'w')
f.write("homePath=" + homePath + "\n")
f.write("gdrivePath=" + gdrivePath + "\n")
f.write("gdrive=" + gdrive + "\n")
f.close()
'''

