# java-minigame-demo
## 应用名称:dy
###### 说明：此demo仅供参考,请勿直接使用该代码在自己的项目中
## java部分代码使用了lombok
###### lombok安装：https://www.jianshu.com/p/2543c71a8e45
## 接入准备

[开发者注册和认证](https://doc.youzanyun.com/resource/develop-guide/27027/27062)

[应用创建](https://doc.youzanyun.com/resource/develop-guide/41356/41601)

[云测试店铺申请和使用](https://doc.youzanyun.com/resource/develop-guide/27027/27666)

[店铺认证](https://help.youzan.com/displaylist/detail_4_4-2-604)

[店铺小程序绑定](https://help.youzan.com/displaylist/detail_4_4-2-2832)

[代码拉取](https://doc.youzanyun.com/resource/develop-guide/41356/41607)

[有赞云开发者工具下载及安装](https://doc.youzanyun.com/resource/develop-guide/41185/41367)

[C端小程序自定义页面开发](https://doc.youzanyun.com/resource/develop-guide/41356/41479)

[B端嵌入页应用开发](https://doc.youzanyun.com/resource/develop-guide/41356/41480)

#### 代码结构说明
```bash
├──dy-api：接口声明 XXService.java、DTO 封装等，一般在这个模块里不会去依赖其他模块和第三方依赖
├──dy-biz：服务实现模块，除了在该模块里写 XXServiceImpl.java 外，最主要的还会在这里编写业务扩展点实现类和消息扩展点实现类
├──dy-dal：如果你的应用中用到了数据库，需要在这个模块里去写 dao、mapper 等，应用框架默认支持 druid 和 mybatis
├──dy-deploy：这个模块是用来打包的，执行 mvn package 后的最终 jar 包生成模块，所以生成后不需要去改动里面的内容，改动后可能会导致发布失败
├──dy-ui：前端扩展点定制需要在该目录下实现，创建应用后默认不会有这个目录，通过开发者工具导入项目之后会自动生成
│   ├── mp-extension，小程序定制目录
│   └── react-app-use-page，嵌入式开发脚手架目录，脚手架需要单独下载
└──dy-web：项目的一些 web 相关的类放在这个模块里，如 XXController.java，以及一些静态资源（js、css、页面等等）
```