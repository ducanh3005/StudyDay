/**
 * 路由入口
 */
import React from "react";
import * as PATH from "./routePath";
const MainPage = React.lazy(() => import("pages/MainPage")); //测试首页

interface RoutesConfig {
  path: string;
  component: React.ComponentType<any>;
}
const routerConfig: Array<RoutesConfig> = [
  {
    path: PATH.MAIN_PAGE,
    component: MainPage,
  },
];

export default routerConfig;
