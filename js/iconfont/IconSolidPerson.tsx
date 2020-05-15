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

const IconSolidPerson: FunctionComponent<Props> = ({ size, color, ...rest }) => {
  return (
    <Svg viewBox="0 0 1024 1024" width={size} height={size} {...rest}>
      <Path
        d="M907.008 772.949333l-198.016-80.768c0 0-37.76-15.317333-52.437333-30.421333-9.429333-9.728-8.746667-32.597333-0.426667-61.781333s109.824-147.968 109.824-255.829333c0-166.613333-104.661333-301.653333-233.770667-301.653333-129.109333 0-233.770667 135.04-233.770667 301.653333 0 103.296 90.453333 226.517333 101.632 248.874667s8.448 56.490667-0.384 66.816c-13.269333 15.530667-61.610667 31.104-61.610667 31.104l-178.517333 83.242667c-41.728 15.658667-74.368 56.832-74.368 103.253333l0 22.016c0 50.688 39.338667 81.706667 87.68 81.706667l720.896 0c48.384 0 87.722667-31.018667 87.722667-81.706667l0-22.016C981.418667 831.061333 948.693333 788.608 907.008 772.949333z"
        fill={getIconColor(color, 0, '#333333')}
      />
    </Svg>
  );
};

IconSolidPerson.defaultProps = {
  size: 18,
};

export default IconSolidPerson;
