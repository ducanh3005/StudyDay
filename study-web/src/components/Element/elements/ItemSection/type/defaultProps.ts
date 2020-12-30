/**
 * 当使用的地方不传递样式时，使用该默认样式进行展示。
 */
import { name } from "../interface/dataType";
export const defaultProps = {
  style: {
    container: {
      margin: "5px",
      padding: "5px",
      height: "40px",
      backgroundColor: "#ffe3e3",
    },
    headLabel: {
      color: "#929292",
      fontSize: 14,
      fontFamily: "PingFangSC-Medium",
    },
  },
  headerLabel: "",
  objectKey: name,
};
