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

const IconXuexihuodong: FunctionComponent<Props> = ({ size, color, ...rest }) => {
  return (
    <Svg viewBox="0 0 1024 1024" width={size} height={size} {...rest}>
      <Path
        d="M768 51.2a764.928 764.928 0 0 0-256 44.544A764.928 764.928 0 0 0 256 51.2a764.928 764.928 0 0 0-256 44.544V972.8a764.928 764.928 0 0 1 256-44.544 764.928 764.928 0 0 1 256 44.544 756.224 756.224 0 0 1 512 0V95.744A764.928 764.928 0 0 0 768 51.2z m153.6 788.48a852.992 852.992 0 0 0-153.6-13.824 863.232 863.232 0 0 0-256 38.912V204.8l34.304-12.288A665.6 665.6 0 0 1 768 153.6a652.8 652.8 0 0 1 153.6 18.432z"
        fill={getIconColor(color, 0, '#333333')}
      />
    </Svg>
  );
};

IconXuexihuodong.defaultProps = {
  size: 18,
};

export default IconXuexihuodong;
