/**
 * 使用这种写法，完成子类导入
 */
import React from 'react';

import {
    requireNativeComponent,
    UIManager,
    findNodeHandle,
    Platform
  } from 'react-native';

export interface IProps{
    object:object,
}
export const findComponent = (ViewClass:any) => {

    class MapView extends React.Component<IProps> {

        nativeComponentRef: any;

        constructor(props:IProps) {
            super(props);
        }

        getNativeComponentName(){
            return 'MapView';
        }

        getNativeComponentRef() {
            return this.nativeComponentRef
          }

        render(){
            return<ViewClass
            {...this.props}
            ref = {(ref:any) => this.nativeComponentRef = ref}
            />
        }
    }
    return MapView
}
const ETCMapView = requireNativeComponent('MapView');
export default findComponent(ETCMapView);