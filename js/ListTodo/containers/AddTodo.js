/**
 * Created by zhongpeng on 2018/9/25.
 */
import React, {Component} from 'react'
import {
    View,
    TextInput,
    Text,
    TouchableOpacity,
    StyleSheet,
    Platform,
    requireNativeComponent,
    DeviceEventEmitter,
    Alert
} from 'react-native'
import {connect} from 'react-redux'
import {addTodo} from '../actions'
import Value from '../../Global/common'
import NativeListModule from '../modules/NativeListModule';
const ToastView = requireNativeComponent("ToastManager", null) ;

const styles = StyleSheet.create({
    container: {
        flexDirection: 'row',
    },
    input: {
        flex: 1,
        borderWidth: 1,
        borderColor: '#324dd3',
        textAlign: 'center',
    },
    button: {
        backgroundColor: 'green',
        textAlign: 'center',
        padding: 20,
    }
});

class AddTodo extends Component {
    constructor(props) {
        super(props);
        this.inputValue = '';
        DeviceEventEmitter.addListener('InputNull', () => {
            NativeListModule.showToast();
            NativeListModule.showActin(Value("success"));
            NativeListModule.showExit(Value("success"));
            alert(Value("success"));
        });
    }

    render() {
        let {dispatch} = this.props;
        console.log("增加功能的props" + JSON.stringify(this.props));
        return (
            <View style={styles.container}>
                {
                        <ToastView style={styles.button}/>
                }
                <TextInput
                    style={styles.input}
                    onChangeText={text => this.inputValue = text}
                />
                <TouchableOpacity onPress={() => (dispatch)(addTodo(this.inputValue))}>
                    <Text style={styles.button}>新增</Text>
                </TouchableOpacity>
            </View>
        )
    }
}


export default connect()(AddTodo)

