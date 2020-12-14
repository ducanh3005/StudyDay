import React, { Component } from 'react';
import '../Button/Button.css'; // 告诉 Webpack Button.js 使用这些样式

class Button extends Component {
  render() {
    // 你可以将它们用作常规 CSS 样式
    return <div className="Button" />;
  }
}