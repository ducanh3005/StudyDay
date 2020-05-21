

import React from 'react';

import {Calendar, CalendarList, Agenda} from 'react-native-calendars';

export interface PropsInterface {

}



export default class CalendarView extends React.Component<PropsInterface>{
    constructor(props:PropsInterface){
        super(props)
    }


    render(){
        return(
            <Calendar
                // Initially visible month. Default = Date()
                current={'2020-03-01'}
                // Minimum date that can be selected, dates before minDate will be grayed out. Default = undefined
                // minDate={'2012-05-10'}
                // Maximum date that can be selected, dates after maxDate will be grayed out. Default = undefined
                // maxDate={'2012-05-30'}
                // Handler which gets executed on day press. Default = undefined
                onDayPress={(day) => {console.log('selected day', day)}}
                // Month format in calendar title. Formatting values: http://arshaw.com/xdate/#Formatting
                monthFormat={'yyyy MM'}
                // Handler which gets executed when visible month changes in calendar. Default = undefined
                onMonthChange={(month) => {console.log('month changed', month)}}
                // Hide month navigation arrows. Default = false
                hideArrows={false}
                // Replace default arrows with custom ones (direction can be 'left' or 'right')
                // renderArrow={(direction) => (<Arrow />)}
                // Do not show days of other months in month page. Default = false
                hideExtraDays={true}
                // If hideArrows=false and hideExtraDays=false do not switch month when tapping on greyed out
                // day from another month that is visible in calendar page. Default = false
                disableMonthChange={false}
                // If firstDay=1 week starts from Monday. Note that dayNames and dayNamesShort should still start from Sunday.
                firstDay={7}
                // Hide day names. Default = false
                hideDayNames={false}
                />
        );
    }

}