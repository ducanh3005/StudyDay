/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import * as React from "react";
import { IProps } from "./type/propsTyping";
import { IState } from "./type/stateTyping";
import { defaultProps } from "./type/defaultProps";
import { StyledList } from "./type/styled";
import SvgImage from "../../base/SvgIcon";

export default class View extends React.Component<IProps, IState> {
  firstRender = true; //性能优化

  constructor(props: IProps) {
    super(props);
    this.state = {
      collapsed: !!this.props.collapsed,
    };
  }

  toggleSection = () => {
    this.firstRender = false;
    this.setState({
      collapsed: !this.state.collapsed,
    });
  };

  /**
   * 获取meta中传递的样式。
   */
  getStyle = () => {
    const { container, headLabel } =
      this.props.style || (defaultProps.style as any);
    return {
      container,
      headLabel,
    };
  };
  /**
   * 获取图片信息
   * @param props
   */
  indicatorIcon = (props: any) => {
    const { canToggle, icon, toggledOn, toggledOff } = props;
    const displayIcon = () => {
      if (canToggle) {
        return this.state.collapsed ? (
          <SvgImage size={24} icon={toggledOff} />
        ) : (
          <SvgImage size={24} icon={toggledOn} />
        );
      } else {
        return <SvgImage size={24} icon={icon} />;
      }
    };
    return displayIcon();
  };

  /**
   * 获取头部展示图片
   * @param headerIcon
   * @param newHeaderLabel
   */
  getRenderHeaderFC = (newHeaderLabel: string) => {
    const style = this.getStyle().headLabel;
    //点击bannder 收起/展开
    return (
      <div
        style={{ display: "flex", justifyContent: "space-between" }}
        onClick={this.toggleSection}
      >
        <div>
          <label style={style}>{newHeaderLabel}</label>
        </div>
        {this.indicatorIcon({
          canToggle: true,
          toggledOff: "expand_more_24",
          toggledOn: "expand_less_24",
        })}
      </div>
    );
  };

  render() {
    const { headerLabel, objectKey } = this.props;
    return (
      <StyledList
        className={objectKey || defaultProps.objectKey}
        renderHeader={() =>
          this.getRenderHeaderFC(headerLabel || defaultProps.headerLabel)
        }
      >
        {this.state.collapsed ? this.props.dataSource : null}
      </StyledList>
    );
  }
}
