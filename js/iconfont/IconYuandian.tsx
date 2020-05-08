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

const IconYuandian: FunctionComponent<Props> = ({ size, color, ...rest }) => {
  return (
    <Svg viewBox="0 0 1024 1024" width={size} height={size} {...rest}>
      <Path
        d="M512.5 512.5m-402.7 0a402.7 402.7 0 1 0 805.4 0 402.7 402.7 0 1 0-805.4 0Z"
        fill={getIconColor(color, 0, '#F5F8FA')}
      />
      <Path
        d="M510.7 958.7c-60.3 0-118.9-11.8-174-35.1-53.2-22.5-101.1-54.8-142.1-95.8-41.1-41.1-73.3-88.9-95.8-142.1-23.3-55.1-35.1-113.7-35.1-174s11.8-118.9 35.1-174c22.5-53.2 54.8-101.1 95.8-142.1 41.1-41.1 88.9-73.3 142.1-95.8 55.1-23.3 113.7-35.1 174-35.1s118.9 11.8 174 35.1c53.2 22.5 101.1 54.8 142.1 95.8 41.1 41.1 73.3 88.9 95.8 142.1 23.3 55.1 35.1 113.7 35.1 174s-11.8 118.9-35.1 174c-22.5 53.2-54.8 101.1-95.8 142.1-41.1 41.1-88.9 73.3-142.1 95.8-55.1 23.3-113.7 35.1-174 35.1z m0-830.2c-211.2 0-383.1 171.9-383.1 383.1 0 211.2 171.9 383.1 383.1 383.1s383.1-171.9 383.1-383.1c0-211.3-171.9-383.1-383.1-383.1z"
        fill={getIconColor(color, 1, '#40C4F4')}
      />
      <Path
        d="M510.7 511.6m-191.6 0a191.6 191.6 0 1 0 383.2 0 191.6 191.6 0 1 0-383.2 0Z"
        fill={getIconColor(color, 2, '#40C4F4')}
      />
    </Svg>
  );
};

IconYuandian.defaultProps = {
  size: 18,
};

export default IconYuandian;
