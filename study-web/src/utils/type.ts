//打开详情界面参数
export interface URLConfig {
  path: string;
  /**
   * 打开的维度
   */
  name: NameType;
  /**
   * 数据类型
   */
  type: ValueType;
}

export enum NameType {
  "Router" = "Router",
  "Entity" = "Entity",
  "Component" = "Component",
  "UserDefined" = "UserDefined",
}

export declare type ValueType = "Open" | "Edit" | "Create";
