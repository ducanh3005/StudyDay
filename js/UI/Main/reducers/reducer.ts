/*
    设置条目展示隐藏
 */

import { visibilityFilters } from '../../../global';
import {SET_VISIBILITY_FILTER} from "../../../ListTodo/actions/types";
const { SHOW_ALL } = visibilityFilters;
export default function ItemShow(state = SHOW_ALL,action){
    let {type, filter} = action;
    switch (type){
        case SET_VISIBILITY_FILTER:
            return filter;
        default:
            return state
    }
}