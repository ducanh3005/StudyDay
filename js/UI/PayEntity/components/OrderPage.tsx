/*
    列表展示
 */

import React, {Component} from 'react'
import {
    View,
    TouchableOpacity,
    Text,
    Image,
    InteractionManager
} from 'react-native';
import R from '../../../Global/values'

class OrderPage extends Component {

    constructor(props) {
        super(props)
    }

    initHeaderView() {
        return (
            <View style={[R.styles.navigationView,{backgroundColor:R.color.titleBg}]}>
                <TouchableOpacity style={[R.styles.navigationButtonLeft,{backgroundColor:R.color.titleBg}]}
                    onPress={()=>this.backPress()}
                >
                    <Image style={[R.styles.navigationButton]} source={require('../../../Global/img/heart.png')}/>
                </TouchableOpacity>
                <Text style={[R.styles.navigationTitleFont]} numberOfLines = {1}> 皇后 </Text>
                <TouchableOpacity style={[R.styles.navigationButtonRight,{backgroundColor:R.color.titleBg}]}
                >
                    <Image style={[R.styles.navigationButton]} source={require('../../../Global/img/heart.png')}/>
                </TouchableOpacity>
            </View>
        );
    }
    backPress(){
        InteractionManager.runAfterInteractions(() => {
            if (this.props.navigator) {
                console.log("界面需要关闭");
                this.props.navigator.pop();
            } else {
                console.log("Actions界面需要关闭");
            }
        });
    }

    render() {
        console.log("VisitListView加载数据");
        return (
            <View style={{flex: 1, backgroundColor: R.color.white}}>
                {this.initHeaderView()}
            </View>


        )
    }
}

export default OrderPage;