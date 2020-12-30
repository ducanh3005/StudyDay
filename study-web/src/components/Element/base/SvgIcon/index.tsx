/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import React, { Suspense } from "react";
import * as Icons from "../svg/lazyIndex";
import { IProps } from "./type/propsTyping";

export default class ImageIcon extends React.Component<IProps> {
  constructor(props: IProps) {
    super(props);
  }

  render() {
    const { icon, size, color } = this.props;
    const SvgComponent = Icons[icon];
    return (
      <Suspense fallback="">
        <SvgComponent
          height={size}
          width={size}
          {...this.props}
          color={color}
        />
      </Suspense>
    );
  }
}
