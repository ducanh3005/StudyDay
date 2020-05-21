/**
 * 首页展示
 */
import * as React from 'react';
import { View } from 'react-native';
import CalendarView from "../../../Global/Calendar"
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

    constructor(props: Prop) {
        super(props)
    }

    render() {
        console.log("[MainViewComponent]");
        return (
            <View style={{ flex: 1 }}>
                <CalendarView />
            </View>
        );
    }

}