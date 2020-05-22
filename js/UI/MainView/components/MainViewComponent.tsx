/**
 * 首页展示
 */
import * as React from 'react';
import { View ,DeviceEventEmitter, Button} from 'react-native';
import CalendarView from "../../../Global/Calendar";
import {SYSTEM_IP} from '../../../Global/common/Const';


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

}
export default class MainViewComponent extends React.Component<Prop, State>{

    localChangedListener:any;
    hostIp:string | undefined;

    constructor(props: Prop) {
        super(props)
    }

    UNSAFE_componentWillMount(){
        this.localChangedListener = DeviceEventEmitter.addListener(SYSTEM_IP, (ip:string) => {
            console.log("[RN接收到ip变化]"+JSON.stringify(ip));
            this.hostIp = ip[`${SYSTEM_IP}`];
        });
        this.init();
    }
    async  init(){
        let map = await NativeInitModule.init();
        if (map) {
            this.hostIp = map[`${SYSTEM_IP}`];
        }
        console.log("[获取到的IP]"+JSON.stringify(map)+this.hostIp);
    }

    componentWillUnmount(){
        this.localChangedListener && this.localChangedListener.remove();
    }


    async call() {
        let url = `http://${this.hostIp}:8089`;
        console.log("[获取的Url：]"+JSON.stringify(url));
        let data = await fetch(url); //获取后台数据
        console.log("[获取的数据：]"+JSON.stringify(data));
      }


    render() {
        console.log("[MainViewComponent]");
        return (
            <View style={{ flex: 1 }}>
                <CalendarView />
                <Button
                    title={"网络接口测试"}
                    onPress={() => {
                        //进行网络接口调用
                        this.call();
                    }}
                />
            </View>
        );
    }

}