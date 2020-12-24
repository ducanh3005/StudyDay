import React, { Suspense } from "react";
import {
  // Redirect,
  Route,
  BrowserRouter as Router,
  Switch,
} from "react-router-dom";
import routerConfig from "./routes/index";
// import { MAIN_PAGE } from "./routes/routePath";
// import { LocaleProvider } from "antd-mobile";
import BlankComp from "./components/BlankComp";

import { BrowserRouter } from "react-router-dom";
import MainPage from "pages/MainPage"; //测试首页
const isDebug = true;

const App: React.FC = () => {
  if (isDebug) {
    return (
      <BrowserRouter basename="/">
        <MainPage title={"测试"} />
      </BrowserRouter>
    );
  } else {
    return (
      <Suspense fallback={<BlankComp />}>
        {/* <LocaleProvider locale={{}}> */}
        <React.Fragment>
          <Router>
            <Switch>
              {routerConfig
                .filter((rc) => rc.open)
                .map(({ path, component }) => (
                  <Route path={path} component={component} exact key={path} />
                ))}
              {/* <Redirect to={MAIN_PAGE} /> */}
            </Switch>
          </Router>
        </React.Fragment>
        {/* </LocaleProvider> */}
      </Suspense>
    );
  }
};

export default App;
