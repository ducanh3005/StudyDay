/*
    设置界面
 */


import React from 'react';
import { Text, View,  Button} from 'react-native';
export interface PropsInterface {
    navigation:any
}

interface IState {
    dataSource: any,
}

export default class SettingScreem extends React.Component<PropsInterface,IState> {

    constructor(props:PropsInterface){
        super(props)
        this.state = {
            dataSource: null,
        }
    }



    render(){
        return(
            <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
                <Text>Settings!</Text>
                <Button title="Go to Home" onPress={() => this.props.navigation.navigate('Home')} />

            </View>
        );
    }
}