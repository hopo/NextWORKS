from bs4 import BeautifulSoup
from selenium import webdriver
import requests
import lxml
import time


url = 'https://datalab.naver.com/keyword/realtimeList.naver?datetime=2018-07-30T09:00:00'

'''
driver = webdriver.Firefox(executable_path='./geckodriver')

driver.get(url)

html = driver.page_source
'''

html = requests.get(url, "lxml")

time.sleep(10)

soup = BeautifulSoup(html.text)

print(soup.prettify())

