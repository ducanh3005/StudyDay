/**
 * 首页展示。绑定Reducer和Action，到当前界面。
 */
import { connect } from 'react-redux';
import MainViewComponent, { Prop }  from "../components/MainViewComponent";
import * as Action from '../actions/action';
/**
 * 绑定Reducer的数据到props中，进行界面更新。
 * @param state Reducer数据
 * @param ownProps 当前界面的 props
 */
const reducerToProps: (state: any, props: any) => Prop = (state, props) => {
    console.log("[reducerToProps]");
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
    console.log("[actionToProps]");
    return {
      getToDayPoints: (componentId:string ,data:Date ) => {
        dispatch(Action.getToDayPoints(componentId,data))
      },
    }
  }
  console.log("[ReducerAction]");
export default connect(reducerToProps, actionToProps)(MainViewComponent);