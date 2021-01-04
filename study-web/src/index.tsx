import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import { historyController } from "./utils/historyController";

let _history: any;
const setHistoryHook = (hook: any) => {
  if (_history !== hook) {
    _history = hook;
    historyController.setHistory(_history);
  }
};

ReactDOM.render(
  <React.StrictMode>
    <App setHistoryHook={setHistoryHook} />
  </React.StrictMode>,
  document.getElementById("root")
);
