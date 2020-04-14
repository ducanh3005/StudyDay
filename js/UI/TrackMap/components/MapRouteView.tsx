/*
  拜访功能中的地图轨迹
*/
import React from 'react';
import {
  BackHandler,
  Platform,
  View,
  Text,
  TouchableOpacity,
  Dimensions,
  StyleSheet,
} from 'react-native';
import { Actions } from 'react-native-xsy-router-flux';
import R from '../../../Global/values';
//差一个地图控件。
import XSYMapView from '../../../native/viewManager/XSYMapView';
import { LocationType } from '../interface/dataTypeIF';
import ScheduleDetail from './ScheduleDate';
let moment = require('moment');
const { width, height } = Dimensions.get('window');

export interface IProps {
  id: string;
  selectDate: Date;
  todayPoints: any[];
  /**
   * 根据日期获取点位
   */
  getToDayPoints?: (id: string, data: Date) => void,
}
export interface IState {
  centerLocation: any; // 视图中央的位置，点击定位后移到视图中央
  dateNow: Date;//今天的日期时间（用来判断还能否点击后一天）
}

export default class MapRouteView extends React.Component<IProps, IState> {
  mapView: XSYMapView | null | undefined;
  location: LocationType | undefined;
  isFlowOpen:boolean = true;

  today = moment().date(0).hours(0).minutes(0).seconds(0).milliseconds(0).toDate();

  constructor(props: IProps) {
    super(props);
    this.state = {
      centerLocation: {},
      dateNow: this.today,
    };
  }
  componentWillMount() {
    if (Platform.OS == 'android') {
      BackHandler.addEventListener('hardwareBackPress', this.onBackAndroid);
    }
  }

  componentDidMount() {
    this.props.getToDayPoints && this.props.getToDayPoints("406", moment().toDate());
  }

  componentWillUnmount() {
    if (Platform.OS === 'android') {
      BackHandler.removeEventListener('hardwareBackPress', this.onBackAndroid);
    } else {
      this.mapView && this.mapView.clean();
    }
  }

  onBackAndroid = () => {
    this.mapView?.clean();
    this.back();
    return true;
  };

  back = () => {
    Actions.pop();
  };

  // 拿到实时定位去逆地理坐标反查
  onUpdateUserLocation = (location: LocationType) => {
    this.isFlowOpen = false;
    this.state = {
      centerLocation: location,
      dateNow: this.today,
    };
  };


  render() {
    let switchTime = this.props.selectDate;
    let todayPoints = this.props.todayPoints;
    if (todayPoints && todayPoints.length > 0) {
      this.isFlowOpen = false;
      this.state = {
        centerLocation: todayPoints[todayPoints.length - 1],
        dateNow: this.today,
      };
    }
    
    let containerStyle = Platform.OS === 'ios' ? { width: width, height: height } : { flex: 1 }

    return (
      <View style={containerStyle}>
        {this.renderTitleView()}
        {this.renderTimeSwich(switchTime)}
        {this.renderMap(todayPoints)}

        {this.calanderSelect()}
      </View>
    );
  }
  /**
   * 顶部标题
   */
  renderTitleView = () => {
    const { XSYTitleView } = require('../../../core/XSYWidget');
    return <XSYTitleView
      key="xsyTitleViews"
      title={'allowMapRoute'}
      titleStyle={{
        color: R.wordColor,
        textAlign: 'center',
        fontSize: 18,
        marginLeft: 5,
        marginRight: 5
      }}
      leftBtnConfig={{
        svgStyle: { width: 22, height: 22, marginLeft: 15, svgWidth: 24 },
        svgKey: 'xsy_back',
        svgColor: R.iconColor,
        onPress: () => this.back()
      }}
      rightBtnConfig={{
          svgStyle: { width: 24, height: 24, marginRight: 15, svgWidth: 32 },
          svgNameKey: 'calendar_32',
          theme: 'filled',
          svgColor: R.iconColor,
          onPress: () => this.refs.ScheduleDetail.showModal(this.props.selectDate.getFullYear(),this.props.selectDate.getMonth()+1,this.props.selectDate.getDate())
      }}
    />
  };
  /**
   * 前一天后一天日期
   */
  renderTimeSwich = (switchTime: Date) => {
    let hasNextDate = this.state.dateNow > switchTime;
    let nextDateStyle = hasNextDate ? { color: "#4E80F5" } : { color: "#6A7280" }
    let filledColor = hasNextDate ? "#4E80F5" : "#6A7280"
    let s1 = switchTime.getFullYear() + "/" + (switchTime.getMonth() + 1) + "/" + switchTime.getDate();
    return <View
      style={{
        height: Platform.OS == 'ios' ? (R.isIphoneX() ? 88 : 65) : 45,
        paddingTop: Platform.OS == 'ios' ? (R.isIphoneX() ? 44 : 20) : 0,
        width: width,
        backgroundColor: 'white',
        justifyContent: 'center',
        alignItems: 'center',
        flexDirection: 'row'
      }} >

      <TouchableOpacity
        style={styles.outArrow}
        onPress={(e) => {
          //当前选中的日期减去1天。
          switchTime.setDate(switchTime.getDate() - 1);
          this.props.getToDayPoints && this.props.getToDayPoints(this.props.id, switchTime);
        }}>
        <Text style={{ color: "#4E80F5" }} >{'visit_yesterday'}</Text>
      </TouchableOpacity>
      <Text style={styles.dateTitle} numberOfLines={1}>{s1}</Text>
      <TouchableOpacity
        style={styles.outArrow}
        onPress={(e) => {
          if (hasNextDate) {
            //当前选中的日期加1天。
            switchTime.setDate(switchTime.getDate() + 1);
            this.props.getToDayPoints && this.props.getToDayPoints(this.props.id, switchTime);
          }
        }}>

        <Text style={nextDateStyle} >{'visit_tomorrow'}</Text>
      </TouchableOpacity>
    </View >
  };

  /**
   * 地图组件
   */
  renderMap = (circleArray: any) => {
    let mapStyle = Platform.OS === 'ios' ? { width: width, height: height - 218 - (R.isIphoneX() ? 34 : 0) } : { flex: 1 }
    return (
      <XSYMapView
        style={mapStyle}
        mapStyle={mapStyle}
        ref={(map) => this.mapView = map}
        location={this.state.centerLocation}
        followEnabled={this.isFlowOpen}
        zoomLevel={17}
        showsUserLocation={true}
        onUpdateUserLocation={this.onUpdateUserLocation}
        markerAndRoute={circleArray}
        marker = {circleArray}
        tag = {100}
      />
    );
  };
  /**
   * 日期选择器
   */
  calanderSelect = () => {
      return (<ScheduleDetail
                ref="ScheduleDetail"
                dateChanged={(date:string) => this.setDate(date)}
              />
      );
  };


  setDate = (date: string) => {
    let time = new Date(date.replace(/-/g, '/'));
    //当前选中的日期
    this.props.getToDayPoints && this.props.getToDayPoints(this.props.id, time);
  };
}
  const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: 'center'
    },
    dateTitle: {
      color: '#182437',
      textAlign: 'center',
      fontSize: 14,
      marginLeft: 5,
      marginRight: 5,
      flex: 1
    },

    outArrow: {
      backgroundColor: 'white',
      justifyContent: 'center',
      alignItems: 'center',
      flexDirection: 'row',
      flex: 1
    },
    right_arrow: {
      width: 15,
      height: 15,
      paddingLeft: 10,
      paddingRight: 30
    },
    left_arrow: {
      width: 15,
      height: 15,
      paddingLeft: 30,
      paddingRight: 10
    }
  });
