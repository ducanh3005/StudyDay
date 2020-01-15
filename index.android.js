import {
  AppRegistry
} from 'react-native';
// import StudyDay from './src/rnt/containers/rntApp';
import StudyDay from './js/ListTodo';
import VisitRecord from './js/VisitRecord/ListEntity';

AppRegistry.registerComponent('RNStudyActivity', () => StudyDay);
AppRegistry.registerComponent('ListEntityActivity',() => VisitRecord);