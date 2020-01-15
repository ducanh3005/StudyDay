/*
    原生封装的控件在这里进行使用
 */
import React,{Component} from 'react';
import {
    StyleSheet,
    requireNativeComponent
} from 'react-native'
let ToastView = null;

class JTextView extends Component{
    render() {
        if (!ToastView){
            ToastView = requireNativeComponent("ToastManager");
        }
        return(<ToastView style={styles.button}/>);
    }

}

const styles = StyleSheet.create({
    button: {
        textAlign: 'center',
        margin: 20,
        flex: 1
    }
});


export default JTextView;