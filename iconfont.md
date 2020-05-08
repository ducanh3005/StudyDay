Step 1

安装插件

# Yarn
yarn add react-native-svg
yarn add react-native-iconfont-cli --dev

# Npm
npm install react-native-svg
npm install react-native-iconfont-cli --save-dev

Step 2

静态链接。请注意您使用的React-Native版本号

# RN < 0.60
react-native link react-native-svg

# RN >= 0.60
cd ios && pod install

Step 3

生成配置文件

npx iconfont-init

此时项目根目录会生成一个iconfont.json的文件，内容如下：

{
    "symbol_url": "请参考README.md，复制官网提供的JS链接",
    "use_typescript": false,
    "save_dir": "./src/iconfont",
    "trim_icon_prefix": "icon",
    "default_icon_size": 18
}

配置参数说明：
symbol_url

请直接复制iconfont官网提供的项目链接。请务必看清是.js后缀而不是.css后缀。如果你现在还没有创建iconfont的仓库，那么可以填入这个链接去测试：http://at.alicdn.com/t/font_1373348_ghk94ooopqr.js

use_typescript

如果您的项目使用Typescript编写，请设置为true。这个选项将决定生成的图标组件是.tsx还是.js后缀。

当该值为false时，我们会为您的图标生成.js和.d.ts两种文件，以便您能享受到最好的开发体验。
save_dir

根据iconfont图标生成的组件存放的位置。每次生成组件之前，该文件夹都会被清空。
trim_icon_prefix

如果你的图标有通用的前缀，而你在使用的时候又不想重复去写，那么可以通过这种配置这个选项把前缀统一去掉。
default_icon_size

我们将为每个生成的图标组件加入默认的字体大小，当然，你也可以通过传入props的方式改变这个size值。
Step 4

开始生成React-Native标准组件

npx iconfont-rn

生成后查看您设置的保存目录中是否含有所有的图标，你可以参考snapshots目录的快照文件，以区分不同模式下的图标结构。
使用

现在我们提供了两种引入方式供您选择：

1、使用汇总Icon组件：

import IconFont from '../src/iconfont';

export const App = () => {
  return (
    <View>
      <IconFont name="alipay" size={20} />
      <IconFont name="wechat" />
    </View>
  );
};

2、使用单个图标。这样可以避免没用到的图标也打包进App：

import IconAlipay from '../src/iconfont/IconAlipay';
import IconWechat from '../src/iconfont/IconWechat';

export const App = () => {
  return (
    <View>
      <IconAlipay size={20} />
      <IconWechat />
    </View>
  );
};

图标尺寸

根据配置default_icon_size，每个图标都会有一个默认的尺寸，你可以随时覆盖。

<IconFont name="alipay" size={20} />

图标单色

单色图标，如果不指定颜色值，图标将渲染原本的颜色。如果你想设置为其他的颜色，那么设置一个你想要的颜色即可。

注意：如果你在props传入的color是字符串而不是数组，那么即使原本是多色彩的图标，也会变成单色图标。

<IconFont name="alipay" color="green" />

图标多色彩

多色彩的图标，如果不指定颜色值，图标将渲染原本的多色彩。如果你想设置为其他的颜色，那么设置一组你想要的颜色即可

<IconFont name="alipay" color={['green', 'orange']} />

颜色组的数量以及排序，需要根据当前图标的信息来确定。您需要进入图标组件中查看并得出结论。

更新图标

当您在iconfont.cn中的图标有变更时，只需更改配置symbol_url，然后再次执行Step 4即可生成最新的图标组件

# 修改 symbol_url 配置后执行：
npx iconfont-rn