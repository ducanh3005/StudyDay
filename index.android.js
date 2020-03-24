import {
  AppRegistry
} from 'react-native';

import ReactNativeMain from './js/UI'
import StudyDay from './js/ListTodo';
import VisitRecord from './js/VisitRecord/ListEntity';
import RNNavigator from './js/Navigator';


AppRegistry.registerComponent('ReactNativeMainActivity', () => ReactNativeMain);
AppRegistry.registerComponent('RNStudyActivity', () => StudyDay);
AppRegistry.registerComponent('ListEntityActivity',() => VisitRecord);
AppRegistry.registerComponent('RNNavigatorActivity',() => RNNavigator);