import React, { Component } from 'react'
import { createStore } from 'redux'
import { Provider } from 'react-redux'
import Group from './components/Group'
import rootReducer from './reducers'

export default class App extends Component {
    render() {
        const store = createStore(rootReducer);
        return (
            <Provider store={store}>
                <Group />
            </Provider>
        );
    }
}
