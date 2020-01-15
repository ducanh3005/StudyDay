/*
    进入的界面
 */
import React, {Component} from 'react';
import {createStore} from 'redux';
import {Provider} from 'react-redux';
import rootReducer from "../reducers";
import {Navigator} from 'react-native-deprecated-custom-components';
import Container from "./Container";
import R from '../../../Global/values'

export default class containerApp extends Component {
    Container = null;

    constructor(props) {
        super(props);
    }

    render() {
        const store = createStore(rootReducer);
        if (!this.Container) {
            this.Container = require('./Container').default;
        }
        console.log("加载的控件：" + Container)
        return (
            <Navigator
                style={[{flex: 1}, {backgroundColor: R.color.white}]}
                initialRoute={{component: this.Container}}
                renderScene={(router, navigator) => {
                    let Component = router.component;
                    console.log("获取的控件：" + Component)
                    return (
                        <Provider store={store}>
                            <Component navigator={navigator}{...router.params}{...this.props}/>
                        </Provider>)
                }}
            />

        );
    }
}

