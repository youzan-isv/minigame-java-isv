# 电商云 - 嵌入页脚手架（react）

## 概述

该脚手架是为了便于开发者开发能够嵌入有赞 saas 后台的页面而提供。

为了保证该脚手架能够正常使用，请将该脚手架目录放置在开发者仓库的 xxx-ui 目录下

## 嵌入交互流程

![avatar](https://img.yzcdn.cn/upload_files/2020/09/11/FikhnHLP-XPsL6ddeG6KhaSZ8gLN.png)

## 嵌入页面开发基本流程

1. 本地开发

```
npm run dev
```

编译完成后，可通过

- https://localhost:9000
- http://localhost:9001
  访问页面，进行本地基本功能的开发。待功能开发完毕后，通过测试店铺购买当前处于未上架状态的应用，然后在开发者工具中预览应用使用页嵌入 saas 后台的样式

2. diy 开发环境发布

```
npm run build
```

该命令：

1. 将 js、css 编译到 dist 目录下，同时将 js、css 资源上传到有赞 cdn 上
2. 生成一个 html 入口文件，将 cdn 上资源的地址挂载到 window 对象上。

html 上的挂载的全局变量：
| 变量 | 类型 | 描述 |
| ---------------- | ------ | -------------- |
| window.jsUrl | object | js 资源地址 |
| window.cssUrl | object | css 资源地址 |
| window.userToken | string | 用户信息 token |

后端定义好页面的路由，在处理页面路由的 controller 里返回生成的 html 文件。push 代码后，在 diy 平台上进行开发环境代码的发布

联系有赞云运营给当前开发的应用打上嵌入测试标，然后通过测试店铺购买当前应用，在测试店铺后台预览页面

3. diy 生产环境发布

待开发环境发布完成后，在 diy 平台上进行生产环境代码的发布

然后通过测试店铺购买当前处于未上架状态的应用，然后在开发者工具中预览页面嵌入 saas 后台的效果

## 调试资源

本地开发的情况下，window 对象上将不会挂载 userToken, 可使用下面的测试 userToken 和 key 作为 mock 数据

测试 key:1c9860b75c164b0a829d2865a80073ce
测试 userToken:
6PsMxylPwA8beGhTKInwAIKm4j2zWRoKEmXvpqfhZtKXCA7MxeGjb%2FDLp3%2BhuEoILheIaJ9wPKZ8%0ArIUnZhCQ5Wuz8fIVQNUrsCR5KWAwnnfH8UqsP3RYk%2BC769p0JJHQ

userToken 的解密操作可参照 https://doc.youzanyun.com/doc#/content/35700/36503

阶段 4 中附带的加解密 demo

## FAQ

### 为什么在 diy 后台发布后的嵌入页面在浏览器中显示白屏？

通过本脚手架生成的 html 仅支持在 saas 后台展示，所以通过浏览器直接访问会显示白屏。

### userToken 会挂载到哪个位置？怎么获取？

在页面嵌入有赞 saas 后台后，userToken 会被挂载到使用页的 window 对象上。在本地开发过程中，可认为能够通过 window.userToken 获取 userToken 以进行鉴权操作。

### 该脚手架支持多页吗？

暂时默认只支持大单页。

### 应用使用页地址在哪配置？

有容器工具型：应用上架的时候，可以配置使用页路由地址
有容器自用型：在应用概况的登录回调地址栏配置

### 页面嵌入 saas 后台支持哪些类型的应用？

目前只支持有容器应用。无容器应用页面短期内不考虑支持嵌入 saas 后台。

### 在嵌入 saas 后台的页面内是否有禁用的操作？

1. 禁用了新开 tab 跳转外部页面的操作
2. 禁用了 alert()，confirm() 等浏览器默认弹窗。如有相关需求，请使用 zent 中的弹窗组件

## 目录结构说明：

```bash
.
├── README.md
├── config.json               配置文件
├── dist-dev                  本地 npm run dev后打包出的资源目录
├── dist                      通过 npm run build打包出的资源目录
├── package.json
├── src
│   ├── index.css
│   ├── index.jsx
│   └── main.js               代码入口
├── webpack                   打包配置文件目录
└── yarn.lock
```

## TODO

1. 脚手架能支持多页
2. 脚手架支持非嵌入页面的开发
