import componentPropsType from "../../../base/viewBase/componentPropsType";
export interface IProps extends componentPropsType {
  headerLabel?: string; //分组菜单内的文字
  collapsed: boolean; //分组展开收缩状态
  dataSource: any[]; // 设置包含的界面信息
}
