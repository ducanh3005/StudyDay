/*
    地图界面
 */


import React from 'react';
import {  View, requireNativeComponent} from 'react-native';
import R from '../../../Global/values';

export interface PropsInterface {
    navigation:any
}

interface IState {
}
export default class MapScreem extends React.Component<PropsInterface,IState> {
    MapView:any =null
    constructor(props:PropsInterface){
        super(props)
        if (!this.MapView){
            this.MapView = requireNativeComponent("LbsMapManager");
        }
    }

    render(){
        return(
            <View style={{ flex: 1}}>
                <this.MapView style={R.styles.map}/>
            </View>
        );
    }
}