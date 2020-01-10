# StudyDay
Children Study Tools

# StudyDay for RN
在RN分支上，增加RN（在已有Android项目中增加React Native）步骤如下：
#动态添加ReactNative
###第一步：初始化package.json文件：
在工程根目录下的CMD中输入npm init，然后会生成package.json文件
这里name不能使用大写，如上动图所示，填写完相应的信息后会在根目录中生成相应的package.json文件，里面内容如下：
{
  "name": "com.darly.std",
  "version": "1.0.0",
  "description": "在RN分支上，增加RN（在已有Android项目中增加React Native)",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "repository": {
    "type": "git",
    "url": "git+https://github.com/Darlyyuhui/StudyDay.git"
  },
  "author": "Darlyyuhui",
  "license": "ISC",
  "bugs": {
    "url": "https://github.com/Darlyyuhui/StudyDay/issues"
  },
  "homepage": "https://github.com/Darlyyuhui/StudyDay#readme"
}

###第二步：在package.json文件中添加启动脚本：
"start": "node node_modules/react-native/local-cli/cli.js start"

###第三步：添加react和react-native 模块：
在根目录执行如下代码：
npm install --save react react-native
执行完成后会在项目中出现node_modules
查看项目中有node_modules，说明react和react native 安装完成,如果没有说明安装失败，需要重新安装

###第四步：添加index.android.js文件到项目中：

import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';

class HelloWorldApp extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.hello}>Hello world! I am from ReactNattive!!</Text>
      </View>
    )
  }
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

AppRegistry.registerComponent('StudyDay', () => HelloWorldApp);

注意：这里的HelloWorldApp 必须和创建的init项目名称一致
AppRegistry.registerComponent(‘ReactNativeApp’, () => ReactNativeApp);
里面的名称 必须和你的工程名一致，对这个文件不熟悉的童鞋可以看本人之前的代码或者官网：


###第五步：添加ReactNative相关依赖：
1.在app的build.gradle文件中添加react-native依赖库
compile "com.facebook.react:react-native:+"
2.在project的build.gradle文件中添加react-native路径
 maven{ url "$rootDir/../node_modules/react-native/android"}

###第六步：添加相关权限：
在AndroidManifest.xml中添加如下代码：
<uses-permission android:name="android.permission.INTERNET" />


###第七步：添加reactnative组件：
添加com.facebook.react.ReactRootView 组件 布局代码如下

<com.facebook.react.ReactRootView
        android:id="@+id/react_root_view"
        android:layout_width="300dp"
        android:layout_height="300dp"/>
react_root_view = (ReactRootView) findViewById(R.id.react_root_view);

mReactInstanceManager =ReactInstanceManager.builder()
        .setApplication(getApplication())
        .setBundleAssetName("index.android.bundle")
        .setJSMainModuleName("index.android")
        .addPackage(new MainReactPackage())
        .setUseDeveloperSupport(BuildConfig.DEBUG)
        .setInitialLifecycleState(LifecycleState.RESUMED)
        .build();

//ReactNativeApp 是项目名，需要和index.adnroid.js中的保持一致
react_root_view.startReactApplication(mReactInstanceManager, "ReactNativeApp", null);


###第八步：添加DevSettingsActivity配置
将DevSettingsActivity配置加入到AndroidManifest.xml文件中


###第九步：实现ReactApplication
我们需要自定义Application然后去实现ReactApplication接口中的方法。
private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage()
            );
        }
    };
