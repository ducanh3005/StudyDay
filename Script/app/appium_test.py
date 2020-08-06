import time
from time import sleep
from appium import webdriver


##以下代码可以操控手机app
class Action():
    
# """
# 真机
#         self.desired_caps = {
#         "platformName": "Android",
#         "deviceName": "GM1910",
#         "platformVersion":"9",  # 安卓版本
#         "app": 'E:\pro\\roboter\\config\\autohome.apk',  # 此处测试需要下载app路径
#         'autoGrantPermissions':True,
#     }
# 模拟器使用路径
#     self.desired_caps = {
#         "platformName": "Android",
#         "deviceName": "MuMu",
#         "platformVersion": "6.0.1",  # 安卓版本
#         "app": 'E:\pro\\roboter\\config\\autohome.apk',  # 此处测试需要下载app路径
#         'autoGrantPermissions':True,
#     }
# """

    def __init__(self):
        # 初始化配置，设置Desired Capabilities参数
        self.desired_caps = {
            "platformName": "Android",
            "deviceName": "MuMu",
            "platformVersion": "6.0.1",  # 安卓版本
            'appActivity':'.MainActivity',
            'appPackage':'com.rkhd.ingage.app'
        }
        # 指定Appium Server
        self.server = 'http://localhost:4723/wd/hub'
        # 新建一个Session
        self.driver = webdriver.Remote(self.server, self.desired_caps)
        # self.driver = webdriver.Remote(webdriver_remote, sys_pras)

    def main(self):
        print("程序开始")
        # 获取屏幕的高
        x = self.driver.get_window_size()['width']
        # 获取屏幕宽
        y = self.driver.get_window_size()['height']
        # 向下滑动
        print ("APP_page向下滑动===========》")
        time.sleep(10)
        # # 设置延时等待
        self.driver.swipe(0.5 * x, 0.75 * y, 0.5 * x, 0.25 * y, 1000)
        sleep(3)
        self.driver.swipe(0.5 * x, 0.75 * y, 0.5 * x, 0.25 * y, 1000)
        sleep(3)
        i=0
        while True:
            try:
                print ("进入详情页面")
                self.driver.find_element_by_xpath("//android.widget.ListView/android.widget.LinearLayout[1]").click()
                time.sleep(3)
                print ("打印详情页HTML")
                print (self.driver.page_source)
            except Exception as e:
                print (e)
            # self.scroll(x,y)
            print ("点击返回......")
            xpathlist = ['//*[@resource-id="com.autohome.main.article:id/article_nav_left"]',
                         '//*[@resource-id="com.autohome.main.article:id/action_back"]',
                         '//android.widget.ImageView[@clickable="true" and @bounds="[33,107][120,194]"]',
                         '//android.widget.ImageView[@clickable="true" and @bounds="[15,47][58,90]"]',
                         '//android.widget.ImageView[@resource-id="com.autohome.main.car:id/tv_back"]',
                         '//android.widget.ImageView[@resource-id="com.cubic.autohome:id/ahlib_close_activity"]',
                         '//android.widget.ImageView[@resource-id="com.autohome.plugin.koubei:id/main_return"]',
                         '//android.widget.ImageView[@resource-id="com.autohome.plugin.uchuang:id/final_page_nav_left_icon"]']
            for xx in xpathlist:
                try:
                    self.driver.find_element_by_xpath(xx).click()
                    time.sleep(5)
                except:
                    continue


            time.sleep(3)
            print ("APP 第{}次刷新".format(i))
            self.driver.swipe(0.5 * x, 0.75 * y, 0.5 * x, 0.25 * y, 1000)
            sleep(5)
            i = i+1

if __name__ == '__main__':
    action = Action()
    action.main()
