/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import fs from "fs";
import path from "path";
//获取SVG文件目录
const SVG_DIR = path.join(process.cwd(), "./src/assets/svg", "/");
export const FILLED = "filled";
export const OUTLINED = "outlined";
const THEME_MAP = {
  f: FILLED,
  o: OUTLINED,
};
//读取文件
function readFile(fileName) {
  return new Promise((resolve, reject) => {
    fs.readFile(path.join(SVG_DIR, fileName), "utf8", function (err, data) {
      if (err) {
        reject(err);
      }
      const match = /(\w+)-((\w)+_(32|24))(-(o|f))?-(\d+)\.svg/gi.exec(
        fileName
      );
      if (match) {
        resolve({
          category: match[1],
          size: parseInt(match[4], 10),
          name: match ? match[2] : fileName.slice(0, fileName.lastIndexOf(".")),
          theme: THEME_MAP[match[6]] || "",
          id: parseInt(match[7], 10),
          content: data
            .replace(/xmlns(:.*)?=".*"/g, "")
            .replace(/version=".*"/g, "{...props}")
            .replace(/(width)="\w+"/, '$1="1em"')
            .replace(/(height)="\w+"/, '$1="1em"')
            .replace(/Combined-Shape/g, "Shape")
            .replace(/fill=".*"/g, "")
            .replace(/fill-rule=".*"/g, "")
            .replace(
              />.*<\/path>/g,
              'fill="currentColor" fill-rule="nonzero" />'
            )
            .replace(
              /<\?xml.*?\?>|<\!--.*?-->|<!DOCTYPE.*?>|<title>.*<\/title>|<desc>.*<\/desc>|<g.*>|<\/g>/g,
              ""
            ),
        });
      } else {
        resolve({});
      }
    });
  });
}
//读取文件夹，从文件夹中拿出所有文件名称
export default function readFolder() {
  return new Promise((resolve, reject) => {
    //从资源文件夹进行查看
    fs.readdir(SVG_DIR, function (err, files) {
      if (err) {
        reject(err);
      }
      Promise.all(files.map((fileName) => readFile(fileName)))
        .then((data) => resolve(data))
        .catch((err) => reject(err));
    });
  });
}

export const THEMES = [FILLED, OUTLINED];
