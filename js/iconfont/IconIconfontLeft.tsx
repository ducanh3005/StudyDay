/* tslint:disable */
/* eslint-disable */

import React, { FunctionComponent } from 'react';
import { ViewProps } from 'react-native';
import { Svg, GProps, Path } from 'react-native-svg';
import { getIconColor } from './helper';

interface Props extends GProps, ViewProps {
  size?: number;
  color?: string | string[];
}

const IconIconfontLeft: FunctionComponent<Props> = ({ size, color, ...rest }) => {
  return (
    <Svg viewBox="0 0 1024 1024" width={size} height={size} {...rest}>
      <Path
        d="M663.7088 160.42026667c10.6048 0 21.0624 3.97653333 29.16373333 12.07786666 16.20053333 16.05546667 16.20053333 42.272 0 58.4736l-300.76586666 301.3536 300.91413334 301.50186667c16.05546667 16.20053333 16.05546667 42.272 0 58.4736-16.20053333 16.20053333-42.272 16.05546667-58.47360001 1e-8l-329.92959999-330.66560001c-16.05546667-16.20053333-16.05546667-42.272 0-58.32746667l329.92959999-330.66560001c8.10133332-8.24746667 18.55786667-12.22506667 29.16373333-12.22506665z"
        fill={getIconColor(color, 0, '#333333')}
      />
    </Svg>
  );
};

IconIconfontLeft.defaultProps = {
  size: 18,
};

export default IconIconfontLeft;
