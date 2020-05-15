/* tslint:disable */
/* eslint-disable */

import React, { FunctionComponent } from 'react';
import { ViewProps } from 'react-native';
import { GProps } from 'react-native-svg';
import IconXuexihuodong from './IconXuexihuodong';
import IconGongzuotai from './IconGongzuotai';
import IconArea from './IconArea';
import IconShouye from './IconShouye';
import IconSolidPerson from './IconSolidPerson';
import IconKaishi from './IconKaishi';
import IconLocation from './IconLocation';
import IconJieshu from './IconJieshu';
import IconYuandian from './IconYuandian';
import IconIconfontLeft from './IconIconfontLeft';

export type IconNames = 'xuexihuodong-' | 'gongzuotai' | 'area' | 'shouye' | 'solid-person' | 'kaishi' | 'location' | 'jieshu' | 'yuandian' | 'iconfont-left';

interface Props extends GProps, ViewProps {
  name: IconNames;
  size?: number;
  color?: string | string[];
}

const IconFont: FunctionComponent<Props> = ({ name, ...rest }) => {
  switch (name) {
    case 'xuexihuodong-':
      return <IconXuexihuodong {...rest} />;
    case 'gongzuotai':
      return <IconGongzuotai {...rest} />;
    case 'area':
      return <IconArea {...rest} />;
    case 'shouye':
      return <IconShouye {...rest} />;
    case 'solid-person':
      return <IconSolidPerson {...rest} />;
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
