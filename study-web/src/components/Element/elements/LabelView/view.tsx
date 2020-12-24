import * as React from "react";
import { IProps } from "./type/propsTyping";

export default class View extends React.Component<IProps> {
  render() {
    const { name, style } = this.props;
    return (
      <div>
        <label style={style.LabelView.label}>{name}</label>
      </div>
    );
  }
}
