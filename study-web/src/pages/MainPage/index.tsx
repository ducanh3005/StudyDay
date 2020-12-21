/**
 * 测试首页
 */
import React from "react";
import MainPageContainer from "./styled";
import TestView from "components/TestView";

interface State {
  title: string;
}

const MainPage: React.FC<State> = (state: State) => {
  console.log("[渲染MainPage]" + state);
  const dataSource = ["a", "b", "c", "d", "e", "f", "g"];
  return (
    <MainPageContainer>
      <TestView dataSource={dataSource} name={"TextView"} />
      <div style={{ flex: 1, overflow: "auto" }}>{state.title}</div>
    </MainPageContainer>
  );
};

export default MainPage;
