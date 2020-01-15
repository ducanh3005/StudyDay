/*
    子控件入口
 */


import React, { Component } from 'react'
import VisitListView from '../components/VisitListView'
class Container extends Component{

    constructor(props){
        super(props)
        console.log("Container加载数据");
    }

    render() {
        return (
            <VisitListView {...this.props}
            />
        )
    }
}

export default Container;