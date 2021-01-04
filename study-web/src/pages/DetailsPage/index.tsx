/**
 * 测试首页
 */
import React from "react";
import DetailsPageContainer from "./styled";
import { NavBar, Button } from "antd-mobile";
import { useHistory } from "react-router-dom";
import { historyController } from "utils/historyController";
import { NameType } from "utils/type";
import { MAIN_PAGE } from "../../routes/routePath";

const DetailsPage: React.FC = () => {
  const history = useHistory();
  if (history !== historyController.getHistory()) {
    historyController.setHistory(history);
  }
  const back = () => {
    const params = {
      key: "goToDetailsPage",
    };
    historyController.openEntityPage(
      { path: MAIN_PAGE, name: NameType.Entity, type: "Open" },
      params
    );
  };

  return (
    <div>
      <NavBar mode="light">{"详情界面"}</NavBar>
      <DetailsPageContainer>
        <Button onClick={back}>network failure</Button>
      </DetailsPageContainer>
    </div>
  );
};

export default DetailsPage;
