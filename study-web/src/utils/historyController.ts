/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
/**
 * 基础跳转封装库
 */
import { History } from "history";
import { URLConfig } from "./type";
let _history: History;
export const historyController = {
  //进行初始化history
  setHistory: (history: History) => {
    _history = history;
  },
  getHistory: () => {
    return _history;
  },
  /**
   * 打开界面
   * @param _conf 页面参数
   * @param value 传入的数据
   */
  openEntityPage: async (_conf: URLConfig, value: any) => {
    console.log(_conf);
    console.log(value);
    switch (_conf.type) {
      case "Create":
        _history.push({
          pathname: _conf.path,
          state: value,
        });
        break;
      case "Open":
        _history.push({
          pathname: _conf.path,
          state: value,
        });
        break;
      case "Edit":
        _history.push({
          pathname: _conf.path,
          state: value,
        });
        break;
      default:
        break;
    }
  },
};
