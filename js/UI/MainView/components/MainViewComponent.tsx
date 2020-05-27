/**
 * 首页展示
 */
import * as React from 'react';
import { View ,DeviceEventEmitter, Button} from 'react-native';
import CalendarView from "../../../Global/Calendar";
import {SYSTEM_IP,NATIVE_GET_CALL} from '../../../Global/common/Const';


const NativeInitModule = require('../../../Global/modules/NativeInitModule');
/**
 * 上个界面传递过来的props
 */
export interface Prop {

}
/**
 * 当前界面需要的状态state
 */
export interface State {
    hostIp:string,//当前界面获取到的IP地址
}
export default class MainViewComponent extends React.Component<Prop, State>{

    ipChangedListener:any;//ip发生变化通知RN
    nativeGetCallListener:any;//原生接口调用回传通知RN

    constructor(props: Prop) {
        super(props)
        //初始化ip
        this.state = {
            hostIp:'',
        }
    }

    UNSAFE_componentWillMount(){
        this.ipChangedListener = DeviceEventEmitter.addListener(SYSTEM_IP, (ip) => {
            console.log("[RN接收到ip变化]"+JSON.stringify(ip));
            this.state = {
                hostIp:ip[`${SYSTEM_IP}`],
            }
        });
        this.nativeGetCallListener = DeviceEventEmitter.addListener(NATIVE_GET_CALL,(result) =>{
            console.log("[RN接收到原生接口请求数据]"+JSON.stringify(result));
            if (result&&result.json) {
                console.log("[RN接收到原生接口请求数据]"+result.json.code);
            }
        });
        this.init();
    }
    async  init(){
        let map = await NativeInitModule.init();
        if (map) {
            this.state = {
                hostIp:map[`${SYSTEM_IP}`],
            }
        }
        console.log("[获取到的IP]"+JSON.stringify(map)+this.state);
    }

    UNSAFE_componentWillUnmount(){
        this.ipChangedListener && this.ipChangedListener.remove();
    }


    async getCall() {
        //get请求测试
        let url = `http://${this.state.hostIp}:8089/mobile/key?ip=${this.state.hostIp}&key=${this.state.hostIp}`;
        console.log("[获取的Url：]"+JSON.stringify(url));
        let data = await fetch(url); //获取后台数据
        data = await data.json();
        console.log("[获取的数据：]"+JSON.stringify(data));
    }

    async postCall() {
       //post请求测试
       let url = `http://${this.state.hostIp}:8089/mobile/value`;
       console.log("[获取的Url：]"+JSON.stringify(url));
        let obj = { over: 1};
        let options = {
          //请求头
          method: "POST",
          headers: {
            accept: "application/x-www-form-urlencoded",
            "Content-Type": "application/x-www-form-urlencoded"
          },
          body: JSON.stringify(obj)
        };
        console.log("[获取的参数：]"+JSON.stringify(options));
        let data = await fetch(url, options); //获取后台数据
        data = await data.json(); //解析获取的数据
        console.log("[获取的数据：]"+JSON.stringify(data));
    }

    
    async nativeGetCall() {
        //get请求测试
        let map = await NativeInitModule.get();
    }
    render() {
        console.log("[MainViewComponent]");
        return (
            <View style={{ flex: 1 }}>
                <CalendarView />
                <Button
                    title={"RN网络接口测试get"}
                    onPress={() => {
                        //进行网络接口调用
                        this.getCall();
                    }}
                />
                <View style ={{height:10}}/>
                <Button
                    title={"RN网络接口测试post"}
                    onPress={() => {
                        //进行网络接口调用
                        this.postCall();
                    }}
                />
                 <View style ={{height:10}}/>
                <Button
                    title={"原生网络接口测试get"}
                    onPress={() => {
                        //进行网络接口调用
                        this.nativeGetCall();
                    }}
                />
            </View>
        );
    }

}