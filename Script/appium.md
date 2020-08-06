Python+Appium实现APP自动化测试

WuAiPython
发布时间：03-2413:20

一、环境准备

1.脚本语言：Python3.x IDE：安装Pycharm

2.安装Java JDK 、Android SDK

3.adb环境，path添加E:\Software\Android_SDK\platform-tools

4.安装Appium for windows

点击下载按钮会到GitHub的下载页面，选择对应平台下载

安装完成后，启动Appium，host和port默认的即可，然后设置Android SDk和Java JDK

然后点下边那个保存并重启的按钮，然后点第一个Start Server按钮，将会看到

二、真机测试

1.连接手机

打开开发者模式，USB线连接手机和电脑，并且在开发者选项当中，开启USB调试

测试是否连接成功，可执行命令adb devices

出现上图就证明手机和电脑连接成功。。。

2.点击Start Inspector Session,

按如下配置Desired Capabilities

platformName ：声明是ios还是Android系统

platformVersion： Android内核版本号，可通过命令adb shell getprop ro.build.version.release查看

deviceName ：连接的设备名称，通过命令adb devices -l中model查看

appPackage：apk的包名

appActivity：apk的launcherActivity，通过命令adb shell dumpsys activity | findstr “mResume”查看（需先打开手机应用）

注意：Android 8.1之前应使用adb shell dumpsys activity | findstr “mFocus”

3.运行Start Session，选择元素

右侧 Selected Element 区域有三个按钮

Tap：执行选中元素的点击事件Send Keys：为文本框等对象传值如果是文本输入元素，就清除文本4.录制脚本

录制生成的python代码如下：

5.在pycharm中建立项目将代码粘入,在运行之前，还需通过pip命令安装pip install Appium-Python-Client依赖包

最后，记一个我在这些过程中遇到的问题（现已解决）

###配置信息
Start Inspector Session中增加配置信息。然后点击打开。
        {
            "platformName": "Android",
            "deviceName": "MuMu",
            "platformVersion": "6.0.1",  # 安卓版本
            'appActivity':'.MainActivity',
            'appPackage':'com.rkhd.ingage.app'
        }
