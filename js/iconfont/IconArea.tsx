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

const IconArea: FunctionComponent<Props> = ({ size, color, ...rest }) => {
  return (
    <Svg viewBox="0 0 1024 1024" width={size} height={size} {...rest}>
      <Path
        d="M723.2 509.866667a298.496 298.496 0 0 0 79.274667-280.832l106.453333-45.653334a21.333333 21.333333 0 0 1 29.738667 19.626667V810.666667l-298.666667 128-256-128-268.928 115.242666a21.333333 21.333333 0 0 1-29.738667-19.626666V298.666667l133.504-57.216a298.368 298.368 0 0 0 81.962667 268.373333L512 721.066667l211.2-211.2z m-60.330667-60.330667L512 600.32l-150.869333-150.826667a213.333333 213.333333 0 1 1 301.738666 0z"
        fill={getIconColor(color, 0, '#333333')}
      />
    </Svg>
  );
};

IconArea.defaultProps = {
  size: 18,
};

export default IconArea;
