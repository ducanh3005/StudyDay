import { List } from "antd-mobile";
import styled from "styled-components";
export const StyledList = styled(List)<any>`
  &&& {
    .am-list-item.am-textarea-item::after {
      margin-left: 15px;
    }
    .am-list-header {
      background-color: #f2f3f7;
      padding: 16px 15px 4px 15px;
      font-size: 12px;
      color: #9da5b3;
      height: 36px;
    }
    .am-list-body {
      background-color: #ffffff;
      &::before {
        display: none;
      }
    }
  }
`;
