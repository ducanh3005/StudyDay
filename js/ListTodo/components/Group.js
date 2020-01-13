import React, { Component } from 'react'
import {
    View
} from 'react-native'
import AddTodo from '../containers/AddTodo'
import Filters from './Filters'
import VisibleTodoList from '../containers/VisibleTodoList'

export default class Group extends Component {
    render() {
        return (
            <View style={{paddingHorizontal: 20, paddingVertical: 44}}>
                <AddTodo/>
                <Filters/>
                <VisibleTodoList/>
            </View>
        );
    }
}