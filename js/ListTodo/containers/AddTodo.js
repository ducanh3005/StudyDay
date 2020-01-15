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
    requireNativeComponent,
    DeviceEventEmitter
} from 'react-native'
import {connect} from 'react-redux'
import {addTodo} from '../actions'
import Value from '../../Global/common'
import store from "../../Global/stores";
import JTextView from './JTextView';
import {Navigator} from "../../VisitRecord/ListEntity/containers/containerApp";
const NativeListModule = require('../../Global/modules/NativeListModule');
const styles = StyleSheet.create({
    container: {
        flexDirection: 'row',
        backgroundColor: 'white'
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
        DeviceEventEmitter.addListener('InputNull', async() => {
            NativeListModule.showToast();
            NativeListModule.showActin(Value("success"));
            NativeListModule.showExit(Value("success"));
            for (let item =0;item< 10;item++){
                let key = await store.get(item+"");
                console.log("获取数据："+key);
            }
            alert(Value("success"));
        });


        for (let item =0;item< 10;item++){
            store.save(item+"",item+"");
        }
        console.log("保存数据："+store);
    }

    componentWillUnmount() {
        //React Native生命周期消失时。
        this.clear();
        console.log("清除数据："+store);
    }

    async clear(){
        for (let item =0;item< 10;item++){
            await store.delete(item+"");
        }
    }


    render() {
        let {dispatch} = this.props;
        console.log("增加功能的props" + JSON.stringify(this.props));
        return (
            <View style={styles.container}>
                {
                    //在这里增加Android提供的控件
                        <JTextView />
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

