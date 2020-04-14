/**
 * 轨迹定位地图展示。绑定Reducer和Action，到当前界面。
 */
import { connect } from 'react-redux';
import MapRouteView, { IProps }  from "../components/MapRouteView";
import * as Action from '../actions/action';
/**
 * 绑定Reducer的数据到props中，进行界面更新。
 * @param state Reducer数据
 * @param ownProps 当前界面的 props
 */
const reducerToProps: (state: any, props: any) => IProps = (state, props) => {
    let data = state.instances[props.id] || state.instances[state.id]
    return {
      id:state.id,
      selectDate:data.selectDate,
      todayPoints:data.todayPoints,
    }
  }
  
  /**
   * 绑定Action方法到props中。
   * @param dispatch 
   * @param props 
   */
  const actionToProps = (dispatch: any, props: any) => {
  
    return {
      getToDayPoints: (componentId:string ,data:Date ) => {
        dispatch(Action.getToDayPoints(componentId,data))
      },
    }
  }

export default connect(reducerToProps, actionToProps)(MapRouteView);