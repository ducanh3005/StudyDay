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

const IconJieshu: FunctionComponent<Props> = ({ size, color, ...rest }) => {
  return (
    <Svg viewBox="0 0 1024 1024" width={size} height={size} {...rest}>
      <Path
        d="M512 512m-512 0a512 512 0 1 0 1024 0 512 512 0 1 0-1024 0Z"
        fill={getIconColor(color, 0, '#97c1e8')}
      />
      <Path
        d="M358.4 358.4h307.2v307.2H358.4z"
        fill={getIconColor(color, 1, '#F9F9F9')}
      />
    </Svg>
  );
};

IconJieshu.defaultProps = {
  size: 18,
};

export default IconJieshu;
