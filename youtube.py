from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium import webdriver
import time
driver = webdriver.Chrome()
driver.implicitly_wait(5)

driver.get('https://www.youtube.com/')

print('Enter your desired course: ')
course = input()
course += ' course'

search_input = driver.find_element(By.XPATH, '//input[@id="search"]')
search_input.send_keys(course)

search_button = driver.find_element(By.XPATH, '//button[@id="search-icon-legacy"]')
search_button.click()

driver.find_element(By.XPATH, '//*[@id="filter-button"]/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]').click()

playlist = driver.find_element(By.XPATH, '/html/body/ytd-app/ytd-popup-container/tp-yt-paper-dialog/ytd-search-filter-options-dialog-renderer/div[2]/ytd-search-filter-group-renderer[2]/ytd-search-filter-renderer[3]/a')
link = playlist.get_attribute('href')
driver.get(link)
top_playlist = driver.find_element(By.XPATH, '//*[@id="content"]/a[1]')
link = top_playlist.get_attribute('href')
driver.get(link)
time.sleep(10)
