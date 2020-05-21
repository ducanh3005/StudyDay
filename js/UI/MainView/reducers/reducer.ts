/*
    设置条目展示隐藏
 */
import * as ActionType from '../actions/actionType';
let moment = require('moment');
const initState = {
    id: 'default',
    instances: {
        'default': {
            selectDate:moment().toDate(),
            todayPoints:[],
        }
    }    
}

const reducer = (state = initState, action: { type: any; id: string; selectDate:Date; todayPoints:any[] }) => {
    let newState = state;
    switch (action.type) {
        case ActionType.DATE_CHANGE:
              newState = {
                ...state,
                id: action.id,
                instances: {
                    ...state.instances,
                    [action.id]: {
                        selectDate: action.selectDate,
                        todayPoints:action.todayPoints
                    }
                }
            }
        default:
            break;
    }
    return newState;
}

export default reducer