/**
 * 路由入口
 */
import React from "react";
import * as PATH from "./routePath";
const MainPage = React.lazy(() => import("pages/MainPage")); //测试首页

const DetailsPage = React.lazy(() => import("pages/DetailsPage")); //详情页

interface RoutesConfig {
  path: string;
  component: React.ComponentType<any>;
  open: true;
}
const routerConfig: Array<RoutesConfig> = [
  {
    //首页
    path: PATH.MAIN_PAGE,
    component: MainPage,
    open: true,
  },
  {
    //详情页
    path: PATH.DETAILS_PAGE,
    component: DetailsPage,
    open: true,
  },
];

export default routerConfig;
