from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium import webdriver
import pandas as pd

driver = webdriver.Chrome()
driver.get('https://services.india.gov.in/service/listing?cat_id=66&ln=en')

scholarships = {}

names = WebDriverWait(driver, 10).until(
    EC.presence_of_all_elements_located((By.XPATH, "//div[@class='edu-lern-con']"))
)



for i in names:
    name = i.find_element(by=By.CLASS_NAME, value='ext-link')
    desc = i.find_element(by=By.XPATH, value='.//p').text
    link = name.get_attribute('href')
    lst = [desc, link]
    scholarships[name.text] = lst


for key, val in scholarships.items():
    print('key:', key, '\nvalue:', val, '\n')

df = pd.DataFrame.from_dict(scholarships, orient='index')
print(df.head())
#df.to_csv('scholarships.csv')