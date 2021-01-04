/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import React, { Suspense } from "react";
import {
  Redirect,
  Route,
  BrowserRouter as Router,
  Switch,
} from "react-router-dom";
import routerConfig from "./routes/index";
import { MAIN_PAGE } from "./routes/routePath";
import BlankComp from "./components/BlankComp";
import { useHistory } from "react-router-dom";

function App(props: any) {
  const hook = useHistory();
  props.setHistoryHook(hook);
  const routes = routerConfig
    .filter((rc) => rc.open)
    .map(({ path, component }) => (
      <Route path={path} component={component} exact key={path} />
    ));
  return (
    <Suspense fallback={<BlankComp />}>
      <Router>
        <Switch>
          {routes}
          <Redirect to={MAIN_PAGE} />
        </Switch>
      </Router>
    </Suspense>
  );
}

export default App;
