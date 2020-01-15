/*
    资源文件
 */

const color ={
    titleBg:'#444eee',
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
}

var Resource ={
    color,
    styles,
}

export default Resource;