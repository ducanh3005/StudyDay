module.exports = {
/*  prettier的配置 */
"prettier.printWidth": 120, // 超过最大值换行
"prettier.tabWidth": 2, // 缩进字节数
"prettier.useTabs": false, // 缩进不使用tab，使用空格
"prettier.semi": false, // 句尾添加分号
"prettier.singleQuote": true, // 使用单引号代替双引号
"prettier.proseWrap": "preserve", // 默认值。因为使用了一些折行敏感型的渲染器（如GitHub comment）而按照markdown文本样式进行折行
"prettier.arrowParens": "always", //  (x) => {} 箭头函数参数只有一个时是否要有小括号。avoid：省略括号
"prettier.endOfLine": "auto", // 结尾是 \n \r \n\r auto
"prettier.jsxBracketSameLine": false, // 在jsx中把'>' 是否单独放一行
"prettier.jsxSingleQuote": false, // 在jsx中使用单引号代替双引号
"prettier.requireConfig": false, // Require a 'prettierconfig' to format prettier
"prettier.stylelintIntegration": false, //不让prettier使用stylelint的代码格式进行校验
"prettier.trailingComma": "es5", // 在对象或数组最后一个元素后面是否加逗号（在ES5中加尾逗号）
"prettier.tslintIntegration": false // 不让prettier使用tslint的代码格式进行校验
}
