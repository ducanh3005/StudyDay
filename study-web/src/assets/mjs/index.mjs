import findFolder from "./common.mjs";
import createsvgtoreact from "./createsvgtoreact";
import fs from "fs";

//准备生成的目标文件夹
//执行的方法
function execute() {
  findFolder()
    .then((data) => {
      createsvgtoreact(data);
    })
    .catch((err) => {
      throw new Error(err);
    });
}
execute();
