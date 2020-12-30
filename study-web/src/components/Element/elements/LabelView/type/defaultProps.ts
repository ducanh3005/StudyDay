/**
 * 当使用的地方不传递样式时，使用该默认样式进行展示。
 */
import { name } from "../interface/dataType";
export const defaultProps = {
  style: {
    container: {
      margin: "5px",
      padding: "5px",
      border: "1px solid #54caa1",
      borderRadius: "3px",
    },
    label: {
      color: "#929292",
      fontSize: 14,
      fontFamily: "PingFangSC-Medium",
    },
    border: {
      width: "1px",
      border: "1px #54caa1 solid",
      marginLeft: "4px",
      marginRight: "4px",
    },
  },
  name: "无",
  defaultValue: "未填写",
  objectKey: name,
};
