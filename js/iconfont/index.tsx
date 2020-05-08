/* tslint:disable */
/* eslint-disable */

import React, { FunctionComponent } from 'react';
import { ViewProps } from 'react-native';
import { GProps } from 'react-native-svg';
import IconKaishi from './IconKaishi';
import IconLocation from './IconLocation';
import IconJieshu from './IconJieshu';
import IconYuandian from './IconYuandian';
import IconIconfontLeft from './IconIconfontLeft';

export type IconNames = 'kaishi' | 'location' | 'jieshu' | 'yuandian' | 'iconfont-left';

interface Props extends GProps, ViewProps {
  name: IconNames;
  size?: number;
  color?: string | string[];
}

const IconFont: FunctionComponent<Props> = ({ name, ...rest }) => {
  switch (name) {
    case 'kaishi':
      return <IconKaishi {...rest} />;
    case 'location':
      return <IconLocation {...rest} />;
    case 'jieshu':
      return <IconJieshu {...rest} />;
    case 'yuandian':
      return <IconYuandian {...rest} />;
    case 'iconfont-left':
      return <IconIconfontLeft {...rest} />;
  }

  return null;
};

export default IconFont;
