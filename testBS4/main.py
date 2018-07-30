from bs4 import BeautifulSoup
from selenium import webdriver
import requests as req


url = 'https://datalab.naver.com/keyword/realtimeList.naver?datetime=2018-07-30T09:00:00'

driver = webdriver.Firefox(executable_path='./geckodriver')

driver.get(url)

html = driver.page_source

soup = BeautifulSoup(html)

print(soup.prettify())


'''
html = req.get(url)

soup = BeautifulSoup(html.text)

print(soup.prettify())
'''

