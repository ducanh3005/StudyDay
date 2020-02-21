/*
    进入的界面
 */
import React from 'react';



import { Router, Scene, Actions } from 'react-native-xsy-router-flux';
import { Provider, connect } from 'react-redux';


import { createStore, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
const RouterWithRedux = connect()(Router);
import reducers from '../reducers';
const createStoreWithMiddleware = applyMiddleware(thunk)(createStore);
const store = createStoreWithMiddleware(reducers);

export default class MainApp extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return(
            <Provider store={store}>
                <RouterWithRedux>


                </RouterWithRedux>
            </Provider>
        )
    }
}

