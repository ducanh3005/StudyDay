/*
    有底部tab的界面
 */
import 'react-native-gesture-handler';
import React from 'react';
import { Text, View, ListView, Button} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import SettingScreem from '../components/SettingScreem';
import MapScreem from '../components/MapScreem';
import HomeScreenView from '../components/HomeScreem';
import Ionicons from '../../../iconfont';
import * as CONS from '../../Util/util';
import R from '../../../Global/values';

function HomeScreen({ navigation }:{ navigation:any }) {
    //想办法修改角标
    return (
        <HomeScreenView navigation={navigation}/>
    );
}

function MapScreen({ navigation }:{ navigation:any }) {
    return (
        <MapScreem navigation={navigation}/>
    );
}

function StudyScreen({ navigation }:{ navigation:any }) {
    return (
        <View/>
    );
}

function WorkScreen({ navigation }:{ navigation:any }) {
    return (
        <View/>
    );
}

function SettingsScreen({ navigation }:{ navigation:any }) {
    return (
        <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
            <SettingScreem navigation={navigation}/>
        </View>
    );



}

function IconWithBadge(props:any) {
    return (
        <View style={{ width: 24, height: 44, margin: 15 }}>
            <Ionicons style={{ margin: 5 }} name={props.name} size={props.size} color={props.color} />
            {props.count && props.count > 0 && (
                <View
                    style={{
                        // On React Native < 0.57 overflow outside of parent will not work on Android, see https://git.io/fhLJ8
                        position: 'absolute',
                        right: -6,
                        top: -3,
                        backgroundColor: 'red',
                        borderRadius: 6,
                        width: 12,
                        height: 12,
                        justifyContent: 'center',
                        alignItems: 'center',
                    }}
                >
                    <Text style={{ color: 'white', fontSize: 10, fontWeight: 'bold' }}>
                        {props.count}
                    </Text>
                </View>
            )}
        </View>
    );
}

const Tab = createBottomTabNavigator();

export default function App() {
    return (
        <NavigationContainer>
            <Tab.Navigator 
                screenOptions={({ route }) => ({
                    tabBarIcon: ({ focused, color, size }) => {
                        let iconName;
                        if (route.name === CONS.APP_HOME) {
                            iconName = "shouye";
                        } else if (route.name === CONS.APP_MAP) {
                            iconName = "area";
                        } else if (route.name === CONS.APP_STUDY) {
                            iconName = "xuexihuodong-";
                        } else if (route.name === CONS.APP_WORK) {
                            iconName = "gongzuotai";
                        } else if (route.name === CONS.APP_CENTER) {
                            iconName = "solid-person";
                        }
                        // 可以返回所有控件。
                        return <IconWithBadge name={iconName} size={size} color={color}/>;
                    },
                })}
                tabBarOptions={{
                    activeTintColor: R.color.focusedTab,
                    inactiveTintColor: R.color.unfocusedTab,
                }}
            >
                <Tab.Screen name={CONS.APP_HOME} component={HomeScreen}/>
                <Tab.Screen name={CONS.APP_MAP} component={MapScreen}/>
                <Tab.Screen name={CONS.APP_STUDY} component={StudyScreen}/>
                <Tab.Screen name={CONS.APP_WORK} component={WorkScreen}/>
                <Tab.Screen name={CONS.APP_CENTER} component={SettingsScreen}/>
            </Tab.Navigator>
        </NavigationContainer>
    );
}