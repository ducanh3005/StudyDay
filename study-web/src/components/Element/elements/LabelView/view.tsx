/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import * as React from "react";
import { IProps } from "./type/propsTyping";
import { IState } from "./type/stateTyping";
import { defaultProps } from "./type/defaultProps";

export default class View extends React.Component<IProps, IState> {
  constructor(props: IProps) {
    super(props);
  }
  render() {
    const { name, value, style, objectKey } = this.props;
    return (
      <div
        className={objectKey || defaultProps.objectKey}
        style={style?.LabelView?.container || defaultProps.style.container}
      >
        <span style={style?.LabelView?.label || defaultProps.style.label}>
          {name || defaultProps.name}
        </span>
        <label style={defaultProps.style.border}></label>
        <span style={style?.LabelView?.label || defaultProps.style.label}>
          {value || defaultProps.defaultValue}
        </span>
      </div>
    );
  }
}
