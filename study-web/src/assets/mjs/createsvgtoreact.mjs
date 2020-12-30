/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
/**
 * 使用SVG生成对应React的组件
 */
import fs from "fs";
import path from "path";

export default function (data) {
  let defaultExport = "";
  let lazyDefaultExport = `import * as React from 'react';
  `;
  const COMPS_DIR = "./src/components/Element/base";
  if (!fs.existsSync(COMPS_DIR)) {
    fs.mkdirSync(COMPS_DIR);
  }
  const WEB_DIST_DIR = path.join(process.cwd(), `${COMPS_DIR}/svg`);
  if (!fs.existsSync(WEB_DIST_DIR)) {
    fs.mkdirSync(WEB_DIST_DIR);
  }
  // const MOB_DIST_DIR = path.join(process.cwd(), `${COMPS_DIR}/react-native`);
  // if (!fs.existsSync(MOB_DIST_DIR)) {
  //   fs.mkdirSync(MOB_DIST_DIR);
  // }
  const plantProps = (content) =>
    content
      .replace(/(width|height)="1em"/g, '$1={props.$1 || "1em"}')
      .replace(/("currentColor")/g, "{props.fill || $1}")
      .replace(/fill-rule/g, "fillRule")
      .replace(/id="((?!").)+"/, "");
  const nameFile = (name, theme) => `${name}_${theme}`;
  data
    .filter(({ name }) => !!name)
    .forEach(({ name, theme, content }) => {
      let fileName = name;
      const fileContent = plantProps(content);
      switch (theme) {
        case "outlined":
          defaultExport += `export { default as ${name} } from "./${fileName}"; export { default as ${nameFile(
            name,
            theme
          )} } from "./${fileName}";`;
          lazyDefaultExport += `export const ${name} = React.lazy(() => import(/* webpackChunkName: "${fileName}" */ './${fileName}'));
        `;
          lazyDefaultExport += `export const ${nameFile(
            name,
            theme
          )} = React.lazy(() => import(/* webpackChunkName: "${fileName}" */ './${fileName}'));
        `;
          break;
        case "filled":
          fileName = nameFile(name, theme);
          defaultExport += `export { default as ${fileName} } from "./${fileName}";`;
          lazyDefaultExport += `export const ${fileName} = React.lazy(() => import(/* webpackChunkName: "${fileName}" */ './${fileName}'));
        `;
          break;
        default:
          lazyDefaultExport += `export const ${name} = React.lazy(() => import(/* webpackChunkName: "${fileName}" */ './${fileName}'));
        `;
          lazyDefaultExport += `export const ${nameFile(
            name,
            "outlined"
          )} = React.lazy(() => import(/* webpackChunkName: "${fileName}" */ './${fileName}'));
        `;
          lazyDefaultExport += `export const ${nameFile(
            name,
            "filled"
          )} = React.lazy(() => import(/* webpackChunkName: "${fileName}" */ './${fileName}'));
        `;
          defaultExport += `export { default as ${name} } from "./${fileName}"; export { default as ${nameFile(
            name,
            "outlined"
          )} } from "./${fileName}"; export { default as ${nameFile(
            name,
            "filled"
          )} } from "./${fileName}";`;
          break;
      }
      fs.writeFile(
        `${WEB_DIST_DIR}/${fileName}.tsx`,
        `import * as React from 'react';
const SvgComponent = (props: any) => (${fileContent});
export default SvgComponent;`,
        (err) => {
          if (err) {
            throw new Error(err);
          }
        }
      );
      //       fs.writeFile(
      //         `${MOB_DIST_DIR}/${fileName}.tsx`,
      //         `import Svg, { Path } from "react-native-svg"
      // import * as React from 'react';
      // const SvgComponent = (props: any) => (${fileContent
      //           .replace(/<svg/, "<Svg")
      //           .replace(/<\/svg/, "</Svg")
      //           .replace(/<path/, "<Path")});
      // export default SvgComponent;`,
      //         (err) => {
      //           if (err) {
      //             throw new Error(err);
      //           }
      //         }
      //       );
    });
  // fs.writeFile(`${MOB_DIST_DIR}/index.ts`, defaultExport, (err) => {
  //   if (err) {
  //     throw new Error(err);
  //   }
  // });
  // fs.writeFile(`${MOB_DIST_DIR}/index.d.ts`, defaultExport, (err) => {
  //   if (err) {
  //     throw new Error(err);
  //   }
  // });
  fs.writeFile(`${WEB_DIST_DIR}/index.ts`, defaultExport, (err) => {
    if (err) {
      throw new Error(err);
    }
  });
  fs.writeFile(`${WEB_DIST_DIR}/lazyIndex.ts`, lazyDefaultExport, (err) => {
    if (err) {
      throw new Error(err);
    }
  });
  fs.writeFile(`${WEB_DIST_DIR}/index.d.ts`, defaultExport, (err) => {
    if (err) {
      throw new Error(err);
    }
  });
}
