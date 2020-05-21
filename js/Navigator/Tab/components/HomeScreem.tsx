/*
    设置界面
 */


import React from 'react';
import { Text, View,  Button} from 'react-native';
import IconFont from '../../../iconfont';
import Toast from 'react-native-simple-toast';
import * as CONS from '../../Util/util';
import CalendarView from "../../../Global/Calendar/components/CalendarView"

export interface PropsInterface {
    navigation:any
}

interface IState {
    dataSource: any,
    value:string,
}

export default class HomeScreem extends React.Component<PropsInterface,IState> {

    constructor(props:PropsInterface){
        super(props)
        this.state = {
            dataSource: null,
            value:"1.00000009E14",
        }
        console.log("[HomeScreem]"+JSON.stringify(this.props.navigation));
        // this.props.navigation.navigate(this.props.navigation.state.key)
    }

    render(){
        let balance = "0";
        if(this.state.value.includes("e")||this.state.value.includes("E")){
            let num = new Number(this.state.value)
            balance = num.toLocaleString();
        }else{
            balance = this.state.value
        }
        //首页展示日历
        return(
            <View style={{ flex: 1}}>
                <CalendarView/>
                <Text>{(parseFloat(balance) - parseFloat("11111111111111.14"))} </Text>
                <Text>{balance.length} </Text>
                <IconFont name="kaishi" size={15} color="red" />
                <IconFont name="location" size={25} color="yellow" />
                <IconFont name="jieshu" size={35} color="black" />
                <IconFont name="yuandian" size={32} color={['green', 'orange']} />
                <Text>Home!</Text>
                <Button
                    title={"key"}
                    onPress={() => {
                        Toast.show('This is a toast.');
                        this.props.navigation.navigate(CONS.APP_CENTER)
                    }}
                />
            </View>
        );
    }
}