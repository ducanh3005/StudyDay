/**
 * Created by zhongpeng on 2018/9/25.
 */
import  {
    ADD_TODO,
    TOGGLE_TODO,
} from '../actions/types'

import {
    DeviceEventEmitter
} from 'react-native'

const todos = (state = [], action) => {
    let {id, text, type} = action;
    switch (type) {
        case ADD_TODO:
            console.log(state);
            if (text && text!=null ||text!=""){
                return [
                    ...state,
                    {
                        id: id,
                        text: text,
                        completed: false
                    }
                ];
            }else {
                DeviceEventEmitter.emit('InputNull');
                return state;
            }
        case TOGGLE_TODO:
            return state.map(todo => (todo.id === id) ? {...todo, completed: !todo.completed} : todo);
        default:
            return state;
    }
};

export default todos;