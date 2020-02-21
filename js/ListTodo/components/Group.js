import React, { Component } from 'react'
import {
    View,
    TouchableOpacity,
    Text,
    InteractionManager,
    Image
} from 'react-native';
import { Keyboard } from 'react-native';
import {Actions} from 'react-native-xsy-router-flux';
import AddTodo from '../containers/AddTodo'
import Filters from './Filters'
import VisibleTodoList from '../containers/VisibleTodoList'
import R from "../../Global/values";

export default class Group extends Component {

    initHeaderView() {
        return (
            <View style={[R.styles.navigationView,{backgroundColor:R.color.titleBg}]}>
                <TouchableOpacity style={[R.styles.navigationButtonLeft,{backgroundColor:R.color.titleBg}]}
                                  onPress={()=>this.backPress()}>
                    <Image style={[R.styles.navigationButton]} source={require('../../Global/img/heart.png')}/>
                </TouchableOpacity>
                <Text style={[R.styles.navigationTitleFont]} numberOfLines = {1}> 标题 </Text>
                <TouchableOpacity style={[R.styles.navigationButtonRight,{backgroundColor:R.color.titleBg}]}>
                    <Image style={[R.styles.navigationButton]} source={require('../../Global/img/heart.png')}/>
                </TouchableOpacity>
            </View>
        );
    }
    backPress(){
        InteractionManager.runAfterInteractions(() => {
            Keyboard.dismiss();
            if (this.props.navigator) {
                console.log("界面需要关闭");
                this.props.navigator.pop();
            } else {
                console.log("Actions界面需要关闭");
                Actions.pop();
            }
        });
    }
    render() {
        return (

            <View style={{flex: 1, backgroundColor: R.color.white}}>
                {this.initHeaderView()}
                <View style={[{margin:5,backgroundColor:R.color.white}]}>
                    <AddTodo/>
                    <Filters/>
                    <VisibleTodoList/>
                </View>
            </View>
        );
    }
}