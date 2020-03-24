/*
    日历展示
 */


import React from 'react';

import CalendarView from "../components/CalendarView"

export interface PropsInterface {
}


export default class Container extends React.Component<PropsInterface> {
    constructor(props:PropsInterface){
        super(props)
    }

    render() {
        return (
                <CalendarView/>
            )
    }

}