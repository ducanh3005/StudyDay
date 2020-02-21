/*
    进入的界面
 */
import React from 'react';
import R from '../../../Global/values';

import {createStore} from 'redux';
import {Provider} from 'react-redux';
import rootReducer from "../reducers";
import {Navigator} from 'react-native-deprecated-custom-components';

export default class PayContainer extends React.Component {
    private Container: any;
    constructor(props) {
        super(props);
    }

    render() {
        const store = createStore(rootReducer);

        if (!this.Container) {
            this.Container = require('./Container').default;
        }
        console.log("PayContainer：" + this.Container)
        return (
            <Navigator
                style={[{flex: 1}, {backgroundColor: R.color.white}]}
                initialRoute={{component: this.Container}}
                renderScene={(router, navigator) => {
                    let Component = router.component;
                    console.log("PayContainer：" + Component)
                    return (
                        <Provider store={store}>
                            <Component navigator={navigator}{...router.params}{...this.props}/>
                        </Provider>)
                }}
            />

        );
    }
}

