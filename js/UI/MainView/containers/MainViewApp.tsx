/**
 * 首页展示。container控件加载入口。
 */
import React from 'react';
import { createStore, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
import reducer from '../reducers';
let AppContainer: any = null;
const applyMiddlewareTrunk = applyMiddleware(thunk)
const createStoreWithMiddleware = applyMiddlewareTrunk(createStore as any);

 /**
  * 上个界面传递过来的props
  */
 export interface Prop{
    navigation:any,
 }
 /**
  * 当前界面需要的状态state
  */
 export interface State{

}
 export default class MainViewApp extends React.Component<Prop,State>{

    store = createStoreWithMiddleware(reducer);

    constructor(props:Prop){
        super(props)
    }

    render() {
        console.log("[MainViewApp]");
        if (!AppContainer) {
            AppContainer = require('./ReducerAction').default;
        }
        return (
            <AppContainer store={this.store} {...this.props}/>
        );
    }

 }