/**
 * 测试首页
 */
import React from "react";
import MainPageContainer from "./styled";
import TestView from "components/TestView";
import { Toast, WhiteSpace, WingBlank, Button } from "antd-mobile";
interface State {
  title: string;
}

const MainPage: React.FC<State> = (state: State) => {
  const dataSource = ["a", "b", "c", "d", "e", "f", "g"];
  function handleClick() {
    Toast.info("this.props.name", 1);
  }
  return (
    <MainPageContainer>
      <WingBlank>
        <WhiteSpace />
        <div onClick={handleClick}>{state.title}</div>
      </WingBlank>
      <Button onClick={handleClick}>network failure</Button>
      <TestView dataSource={dataSource} name={"TextView"} />
    </MainPageContainer>
  );
};

export default MainPage;
