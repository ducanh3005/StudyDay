/*
    列表展示
 */

import React, {Component} from 'react'
import {
    View,
    TouchableOpacity,
    Text,
    Image,
    InteractionManager,
    FlatList
} from 'react-native';

import R from '../../../Global/values'
const NativeListModule = require('../../../Global/modules/NativeListModule');


class VisitListView extends Component {


    Pay = null;

    constructor(props) {
        super(props)
    }

    initHeaderView() {
        return (
            <View style={[R.styles.navigationView,{backgroundColor:R.color.titleBg}]}>
                <TouchableOpacity style={[R.styles.navigationButtonLeft,{backgroundColor:R.color.titleBg}]}
                    onPress={()=>this.backPress()}
                >
                    <Image style={[R.styles.navigationButton]} source={require('../../../Global/img/ic_back.png')}/>
                </TouchableOpacity>
                <Text style={[R.styles.navigationTitleFont]} numberOfLines = {1}> 标题 </Text>
                <TouchableOpacity style={[R.styles.navigationButtonRight,{backgroundColor:R.color.titleBg}]}
                    onPress={()=>this.nextPage()}
                >
                    <Image style={[R.styles.navigationButton]} source={require('../../../Global/img/heart.png')}/>
                </TouchableOpacity>
            </View>
        );
    }
    backPress(){
        InteractionManager.runAfterInteractions(() => {
            if (this.props.navigator) {
                NativeListModule.finish();
                console.log("界面需要关闭");
            } else {
                console.log("Actions界面需要关闭");
            }
        });
    }
    nextPage(){
        InteractionManager.runAfterInteractions(() => {
            if (!this.Pay) {
                this.Pay = require('../../../UI/PayEntity').default;
            }
            this.props.navigator.replace({
                component:this.Pay,
            });
            console.log("跳转下一页");

        });
    }

    render() {
        console.log("VisitListView加载数据");
        return (
            <View style={{flex: 1, backgroundColor: R.color.white}}>
                {this.initHeaderView()}
                <FlatList
                />
            </View>


        )
    }
}

export default VisitListView;