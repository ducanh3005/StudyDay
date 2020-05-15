/*
    设置界面
 */


import React from 'react';
import { Text, View,  Button} from 'react-native';
import DialogModal from '../../../Global/modal/dialog/DialogModal';
import * as CONS from '../../Util/util';

export interface PropsInterface {
    navigation:any
}

interface IState {
    dataSource: any,
    isShowDialog:boolean,
}

export default class SettingScreem extends React.Component<PropsInterface,IState> {

    constructor(props:PropsInterface){
        super(props)
        this.state = {
            dataSource: null,
            isShowDialog: false,
        }
    }



    render(){
        return(
            <View style={{ flex: 1}}>
                <Text>Settings!</Text>
                <Button title="Go to Home" onPress={() => this.props.navigation.navigate(CONS.APP_HOME)} />
                <DialogModal
                    content={"确定删除个人信息吗？"}
                    confirm={this.ensureDialog}
                    cancel={this.cancelDialog}
                    visible={this.state.isShowDialog}
                />
                    <Button
                        onPress={() => {
                            this.setState({isShowDialog: true});
                        }}
                        title="点击我"
                        color="#841584"/>
            </View>
        );
    }

    // 确认
    ensureDialog = () =>{
        console.log("[ensureDialog]");
        this.setState({isShowDialog: false});
    }

    //取消
    cancelDialog = () =>{
        console.log("[cancelDialog]");
        this.setState({isShowDialog: false});
    }
}