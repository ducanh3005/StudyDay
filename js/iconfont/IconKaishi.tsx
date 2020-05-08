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

const IconKaishi: FunctionComponent<Props> = ({ size, color, ...rest }) => {
  return (
    <Svg viewBox="0 0 1024 1024" width={size} height={size} {...rest}>
      <Path
        d="M512 157.866667c-192 0-354.133333 157.866667-354.133333 354.133333s157.866667 354.133333 354.133333 354.133333c192 0 354.133333-157.866667 354.133333-354.133333 0-196.266667-162.133333-354.133333-354.133333-354.133333"
        fill={getIconColor(color, 0, '#76C8FD')}
      />
      <Path
        d="M439.466667 669.866667v-320l213.333333 162.133333z"
        fill={getIconColor(color, 1, '#FFFFFF')}
      />
    </Svg>
  );
};

IconKaishi.defaultProps = {
  size: 18,
};

export default IconKaishi;
