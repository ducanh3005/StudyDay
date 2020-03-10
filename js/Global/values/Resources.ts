/*
    资源文件
 */

const color ={
    titleBg:'#bcb1ec',
    white:'#88ffff',
}

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
    }
}

var Resource ={
    color,
    styles,
}

export default Resource;