/**
 * 测试控件
 */
import React from "react";
import { withRouter } from "react-router-dom";
import {
  Wrapper,
  // Title,
  // TextViewContainer,
  // Container,
  // Input,
  // Button,
} from "./styled";
import { Toast } from "antd-mobile";
import { RouteComponentProps } from "react-router";
// import _ from "lodash";
import { LabelView, ItemSection } from "../../components/Element/elements";

interface IProps extends RouteComponentProps {
  name: string;
  dataSource: string[];
}

interface State {
  value: string;
}

class TestView extends React.PureComponent<IProps, State> {
  constructor(props: IProps) {
    super(props);
    this.state = {
      value: "",
    } as State;
  }

  handleClick = async () => {
    this.setState({ value: this.props.name });
    console.log(this.props.name);
    Toast.show(this.props.name);
  };

  render() {
    return (
      <Wrapper>
        {/* <Title>{this.props.name}</Title>
        <Container>
          {_.forEach(this.props.dataSource, (item: string) => {
            console.log(item);
            return (
              <TextViewContainer
                onClick={() => {
                  this.handleClick();
                }}
              >
                {item + this.props.name}
              </TextViewContainer>
            );
          }) || null}
          <TextViewContainer
            onClick={() => {
              this.handleClick();
            }}
          >
            {this.props.name}
          </TextViewContainer>
        </Container>
        <Input readOnly={true} placeholder="@mxstbr" type="text" />
        <Input readOnly={true} value="@geelen" type="text" />
        <Button primary={false}>Normal</Button>
        <Button primary={true}>Primary</Button> */}
        <ItemSection
          headerLabel={"国家经济"}
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
        <div>
          <LabelView
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
            objectKey={this.props.name + i}
          />
          <LabelView />
        </div>
      );
    }
    return views;
  };
}

export default withRouter(TestView);
