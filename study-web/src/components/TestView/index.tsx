/**
 * 测试控件
 */
import React from "react";
import { withRouter } from "react-router-dom";
import { Wrapper, Button } from "./styled";
import { Toast } from "antd-mobile";
import { RouteComponentProps } from "react-router";
// import _ from "lodash";
import { LabelView, ItemSection } from "../../components/Element/elements";
import { DETAILS_PAGE } from "../../routes/routePath";
import { historyController } from "utils/historyController";
import { NameType } from "utils/type";

interface IProps extends RouteComponentProps {
  name: string;
  dataSource: string[];
}

interface State {
  value: string;
  header: string;
}

class TestView extends React.PureComponent<IProps, State> {
  constructor(props: IProps) {
    super(props);
    this.state = {
      value: "",
      header: "标题栏",
    } as State;
  }

  goToDetailsPage = () => {
    const params = {
      key: "goToDetailsPage",
    };
    historyController.openEntityPage(
      { path: DETAILS_PAGE, name: NameType.Entity, type: "Open" },
      params
    );
  };

  handleClick = async () => {
    this.setState({ value: this.props.name });
    console.log(this.props.name);
    Toast.show(this.props.name);
  };

  render() {
    return (
      <Wrapper>
        <Button primary={false} onClick={this.goToDetailsPage}>
          Normal
        </Button>
        <Button primary={true} onClick={this.goToDetailsPage}>
          Primary
        </Button>
        <ItemSection
          headerLabel={this.state.header}
          collapsed={false}
          dataSource={this.getChildView()}
        />
      </Wrapper>
    );
  }

  getChildView = () => {
    const views = [];
    for (let i = 0; i < 10; i++) {
      views.push(
        <LabelView
          key={this.state.header + i}
          style={{
            LabelView: {
              container: {
                margin: "5px",
                padding: "5px",
                // border: "1px solid #54caa1",
                backgroundColor: "#cccccc",
                borderRadius: "3px",
              },
              label: {
                color: "#182437",
                fontSize: 16,
                fontFamily: "PingFangSC-Medium",
              },
            },
          }}
          name={"第" + i + "行"}
          value={"第" + i + "值"}
          objectKey={this.state.header + i}
        />
      );
    }
    return views;
  };
}

export default withRouter(TestView);
