from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import pandas as pd
from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.implicitly_wait(5)
driver.get('https://www.google.com/search?q=news&rlz=1C1RXQR_enIN927IN927&oq=news&gs_lcrp=EgZjaHJvbWUqEggAEEUYOxiDARixAxjJAxiABDISCAAQRRg7GIMBGLEDGMkDGIAEMgYIARBFGEAyDQgCEAAYgwEYsQMYgAQyBwgDEAAYgAQyCggEEAAYsQMYgAQyBggFEEUYPTIGCAYQRRg9MgYIBxBFGD3SAQg1Mzc1ajBqN6gCALACAA&sourceid=chrome&ie=UTF-8')

card_elements = driver.find_elements(By.XPATH, '//*[@id="rso"]/div[1]/div/g-section-with-header/div[2]/div/div/div/div')

data = {
    'time': [],
    'frm': [],
    'headlines': [],
    'sublines': [],
    'lnk': []
}

for card in card_elements:
    text = card.text
    news_origin = text.split('\n')[0]
    heading_line = text.split('\n')[1]
    if ':' in heading_line:
        heading = heading_line.split(':')[0]
        sub = heading_line.split(':')[1]
    else:
        heading = heading_line
        sub = ""
    tim = text.split('\n')[2]
    link = card.find_element(By.XPATH, './/div/div[1]')

    data['time'].append(tim)
    data['frm'].append(news_origin)
    data['headlines'].append(heading)
    data['sublines'].append(sub)
    data['lnk'].append(link)

df = pd.DataFrame(data)
print(df.head())
