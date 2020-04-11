/*
    有底部tab的界面
 */
import 'react-native-gesture-handler';
import React from 'react';
import { Text, View, ListView, Button} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import  Ionicons  from 'react-native-vector-icons/EvilIcons';
import SettingScreem from '../components/SettingScreem';
import HomeScreenView from '../components/HomeScreem';

function HomeScreen({ navigation }:{ navigation:any }) {
    return (
        <HomeScreenView navigation={navigation}/>
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
        <View style={{ width: 24, height: 24, margin: 5 }}>
            <Ionicons name={props.name} size={props.size} color={props.color} />
            {props.badgeCount > 0 && (
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
                        {props.badgeCount}
                    </Text>
                </View>
            )}
        </View>
    );
}

function HomeIconWithBadge(props) {
    props ={
        ...props,
        badgeCount:3
    }
    // You should pass down the badgeCount in some other ways like React Context API, Redux, MobX or event emitters.
    return <IconWithBadge {...props}/>;
}

const Tab = createBottomTabNavigator();

export default function App() {
    return (
        <NavigationContainer>
            <Tab.Navigator screenOptions={({ route }) => ({
                tabBarIcon: ({ focused, color, size }) => {
                    let iconName;
                    if (route.name === 'Home') {
                        iconName = focused
                            ? "id-card"
                            : "id-card";
                    } else if (route.name === 'Settings') {
                        iconName = focused ? "user" : "user";
                    }

                    // You can return any component that you like here!
                    return <HomeIconWithBadge name={iconName} size={size} color={color} />;
                },
            })}
           tabBarOptions={{
               activeTintColor: 'gray',
               inactiveTintColor: 'black',
           }}
            >
                <Tab.Screen name="Home" component={HomeScreen}/>
                <Tab.Screen name="Settings" component={SettingsScreen}/>
            </Tab.Navigator>
        </NavigationContainer>
    );
}