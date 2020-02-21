/*
    子控件入口
 */

import React from 'react'

import OrderPage from '../components/OrderPage'

export interface PropsInterface {
    title?:string;
    navigator:any
}

interface StateInterface {
    show:boolean
}

let key : StateInterface={
    show:true
}

class Container extends React.Component<PropsInterface,StateInterface>{


    constructor(props:PropsInterface){
        super(props)
        console.log("Container加载数据--->"+props.title);
    }


    render() {
        console.log("StateInterface"+key.show+this.props.title);
        return (
            <OrderPage {...this.props}
            />
        )
    }
}

export default Container;