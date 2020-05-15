/*
    资源文件
 */

import {
    StyleSheet,
    Dimensions,
    Platform
} from 'react-native';
let { width,height} = Dimensions.get('window');
const hairlineWidth = StyleSheet.hairlineWidth;

const color ={
    titleBg:'#bcb1ec',
    white:'#88ffff',
    focusedTab:'#40E0D0',
    unfocusedTab:'#D4F2E7',
}

/* eslint no-bitwise: 0 */
const hashCode = (str:any) => {
    let hash = 15;
    for (let ii = str.length - 1; ii >= 0; ii--) {
        hash = ((hash << 5) - hash) + str.charCodeAt(ii);
    }
    return hash;
};

const styles = {
    navigationView:{
        flexDirection: 'row',
        height:  44,
        alignItems: 'center'
    },
    navigationButtonLeft: {
        marginTop: 0,
        marginLeft:10,
        color:color.white,
        fontSize:15
    },
    navigationButton: {
        width: 24,
        height: 20,
    },
    navigationButtonRight: {
        marginTop: 0,
        marginRight:10,
        color:color.white,
        fontSize:15
    },
    navigationTitleFont: {
        marginTop: 0,
        color: color.white,
        textAlign: 'center',
        fontSize: 18,
        flex:1
    },

    box: {
        paddingTop: 4,
        flexDirection: 'column',
        justifyContent: 'flex-start',
        alignItems: 'center',
    },
    text20: {
        color: '#aaf10c',
        fontSize: 20,
        textAlign: 'center',
    },
    text16: {
        color: '#d38322',
        fontSize: 16,
        textAlign: 'center',
    },
    text14: {
        color: '#b326a1',
        fontSize: 14,
        textAlign: 'center',
    },
    text12: {
        color: '#601685',
        fontSize: 12,
        textAlign: 'center',
    },
    text10: {
        color: '#6A7280',
        fontSize: 10,
        textAlign: 'center',
    },
    row: {
        flexDirection: 'row',
        justifyContent: 'center',
        padding: 10,
        backgroundColor: '#F6F6F6',
    },
    thumb: {
        width: 64,
        height: 64,
    },
    text: {
        flex: 1,
    },
    map: {
        width: width,
        height: height,
    },
}

const isIphoneX = () => {
    const dimen = Dimensions.get('window');
    return (
        Platform.OS === 'ios' &&
        !Platform.isPad &&
        !Platform.isTVOS &&
        (dimen.height === 812 || dimen.width === 812) ||
        (dimen.height === 896 || dimen.width === 896) ||
        (dimen.height === 1125 || dimen.width === 828) ||
        (dimen.height === 1792 / 3 || dimen.width === 1792 / 3)
    );
}

let Resource ={
    color,
    styles,
    hairlineWidth,
    hashCode,
    isIphoneX,
}



export default Resource;