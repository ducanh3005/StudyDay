/**
 * 测试首页
 */
import React from "react";
import MainPageContainer from "./styled";
import { Button } from "antd-mobile";

interface State {
  title: string;
}

const MainPage: React.FC<State> = (state: State) => {
  console.log("[渲染MainPage]" + state);
  return (
    <MainPageContainer>
      <Button type="primary">primary</Button>
      <Button type="primary" inline style={{ marginRight: "4px" }}>
        inline primary
      </Button>
      <Button type="ghost" inline size="small" style={{ marginRight: "4px" }}>
        ghost
      </Button>
      <div style={{ flex: 1, overflow: "auto" }}>{state.title}</div>
    </MainPageContainer>
  );
};

export default MainPage;
