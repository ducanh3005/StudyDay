import styled from "styled-components";

const MainPageContainer = styled.div`
  width: 100%;
  height: 100vh;
  display: flex;
  flex-flow: column;
  .phoneBtn {
    width: 92%;
    left: 0;
    bottom: 0;
    margin: 7px 4%;
    background: #2f7dcd;
    margin-bottom: calc(7px + constant(safe-area-inset-bottom));
    margin-bottom: calc(7px + env(safe-area-inset-bottom));
  }
`;
export default MainPageContainer;
