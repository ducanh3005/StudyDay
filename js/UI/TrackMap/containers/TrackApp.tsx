/**
 * 轨迹定位地图展示。container控件加载入口。
 */
import React from 'react';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
import reducer from '../reducers';
import { Navigator } from 'react-native-deprecated-custom-components';
let AppContainer: any = null;
const applyMiddlewareTrunk = applyMiddleware(thunk)
const createStoreWithMiddleware = applyMiddlewareTrunk(createStore as any);

 /**
  * 上个界面传递过来的props
  */
 export interface Prop{
    id:string,
 }
 /**
  * 当前界面需要的状态state
  */
 export interface State{

}
 export default class TrackApp extends React.Component<Prop>{

    store = createStoreWithMiddleware(reducer);

    constructor(props:Prop){
        super(props)
    }

    render() {
        let id = this.props.id;
        if (!(id && id.length > 0)) {
            id = new Date().toString();
        }
        if (!AppContainer) {
            AppContainer = require('./ReducerAction').default;
        }
        return (
            <Navigator
                style={{ flex: 1 }}
                renderScene={(navigator: any) => {
                    let param =  {}
                    navigator.param = param
                    return (
                        <Provider store={this.store}>
                            <AppContainer navigator={navigator} {...this.props} id = {id}/>
                        </Provider>)
                }}
            />
        );
    }

 }