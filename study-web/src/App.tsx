import React from "react";
import { BrowserRouter } from "react-router-dom";
import MainPage from "pages/MainPage"; //测试首页

const App: React.FC = () => {
  return (
    <BrowserRouter basename="/">
      <MainPage title={"测试"} />
    </BrowserRouter>
  );
};

export default App;
