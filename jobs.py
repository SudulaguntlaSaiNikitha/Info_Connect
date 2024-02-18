from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium import webdriver

driver = webdriver.Chrome()
driver.implicitly_wait(5)
print('Enter Job Role:')
job = input()

websites = ['https://in.indeed.com/', 'https://www.naukri.com/', 'https://unstop.com/jobs','https://www.timesjobs.com/','https://apna.co/']
urls = []
driver.get(websites[0])
driver.find_element(By.XPATH,'//*[@id="text-input-what"]').send_keys(job)
driver.find_element(By.XPATH, '//*[@id="jobsearch"]/div/div[2]/button').click()
urls.append(driver.current_url)

driver.get(websites[1])
driver.find_element(By.XPATH,'//*[@id="root"]/div[7]/div/div/div[1]/div/div/div/div[1]/div/input').send_keys(job)
driver.find_element(By.XPATH, '//*[@id="root"]/div[7]/div/div/div[6]').click()
urls.append(driver.current_url)

driver.get(websites[2])
try:
    if driver.find_element(By.XPATH, '//*[@id="s_menu"]/app-root/app-login-modal/app-login/section/div[2]/div/em'):
        driver.find_element(By.XPATH,'//*[@id="s_menu"]/app-root/app-login-modal/app-login/section/div[2]/div/em').click()
    driver.find_element(By.XPATH, '//*[@id="input_search_mobile"]').send_keys(job)
    urls.append(driver.current_url)
except:
    pass



driver.get(websites[3])
driver.find_element(By.XPATH, '//*[@id="txtKeywords"]').send_keys(job)
driver.find_element(By.XPATH, '//*[@id="quickSearchBean"]/button').click()
urls.append(driver.current_url)

driver.get(websites[4])
search_box_xpath = '//*[@id="__next"]/div[3]/div[4]/div/div/input'
try:
    search_box = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.XPATH, search_box_xpath))
    )
    search_box.send_keys(job, Keys.ENTER)
    urls.append(driver.current_url)
except Exception as e:
    pass

print(urls)