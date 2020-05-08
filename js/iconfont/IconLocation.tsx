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

const IconLocation: FunctionComponent<Props> = ({ size, color, ...rest }) => {
  return (
    <Svg viewBox="0 0 1024 1024" width={size} height={size} {...rest}>
      <Path
        d="M796.779037 737.604038L569.398126 965.005663l0.352143 0.352143-58.662908 58.642194-0.352143-0.352143-0.352143 0.352143-57.337193-57.316478 0.352143-0.352143-240.285922-240.285922 0.435001-0.435001a423.938938 423.938938 0 1 1 583.231933 11.993582z m-283.78596-649.64199A339.71458 339.71458 0 0 0 272.25144 667.713978l175.781581 175.760866 64.214341 64.214341 64.338627-64.317913h-0.559286l78.113639-77.63721 97.087941-97.067226 0.352143 0.352143A339.031008 339.031008 0 0 0 513.075934 87.962048z m-1.63643 510.794013a171.265862 171.265862 0 1 1 171.286577-171.245148 171.286577 171.286577 0 0 1-171.20372 171.245148z m-0.621429-256.339508a84.47293 84.47293 0 1 0 84.47293 84.472931 84.47293 84.47293 0 0 0-84.390073-84.472931z"
        fill={getIconColor(color, 0, '#338CFA')}
      />
    </Svg>
  );
};

IconLocation.defaultProps = {
  size: 18,
};

export default IconLocation;
