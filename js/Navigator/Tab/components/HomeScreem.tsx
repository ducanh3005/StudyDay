/*
    设置界面
 */


import React from 'react';
import { Text, View,  Button, requireNativeComponent} from 'react-native';
import IconFont from '../../../iconfont';
import R from '../../../Global/values'


export interface PropsInterface {
    navigation:any
}

interface IState {
    dataSource: any,
    value:string,
}
let MapView:any =null

export default class HomeScreem extends React.Component<PropsInterface,IState> {


    constructor(props:PropsInterface){
        super(props)
        this.state = {
            dataSource: null,
            value:"1.00000009E14",
        }
        if (!MapView){
            MapView = requireNativeComponent("LbsMapManager");
        }
    }



    render(){


        let balance = "0";
        if(this.state.value.includes("e")||this.state.value.includes("E")){
            let num = new Number(this.state.value)
            balance = num.toLocaleString();
        }else{
            balance = this.state.value
        }
        return(
            <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
                <Text>{(parseFloat(balance) - parseFloat("11111111111111.14"))} </Text>
                <Text>{balance.length} </Text>
                <IconFont name="kaishi" size={15} color="red" />
                <IconFont name="location" size={25} color="yellow" />
                <IconFont name="jieshu" size={35} color="black" />
                <IconFont name="yuandian" size={32} color={['green', 'orange']} />
                <Text>Home!</Text>
                <Button
                    title="Go to Settings"
                    onPress={() => this.props.navigation.navigate('Settings')}
                />
                <MapView style={R.styles.map}/>

            </View>
        );
    }
}