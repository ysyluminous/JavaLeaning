

# 一、npm

## 1、npm 的两层含义

1. NPM 是一个 第三方模块的托管网站，指的就是`https://www.npmjs.com/`；

2. NPM 是Node的包管理工具（全名叫做 Node package manager），在我们安装Node时候，就已经顺便也安装了 NPM 这个管理工具；

   包（Packages）所有资源（代码，模块）的集合。

我们通过npm安装的包，可以分为两类，一类是全局包，另一类是本地包

## 2、 安装和卸载全局包

1. **什么是全局的包：**安装到计算机全局环境中的包，叫做全局包；安装的全局包可以在当前电脑的任何目录下，直接通过命令行来访问；
2. **如何安装全局包：**运行 `npm install 包名 -g` 即可；其中 `-g` 参数，表示 把包安装到全局目录中的意思；
3. **全局包的安装目录：**`C:\Users\用户目录\AppData\Roaming\npm`
4. **什么样的包适合安装到全局：**工具性质的包，适合安装到全局；
5. **如何卸载全局包：**要卸载某个全局的包，直接运行`npm uninstall 包名 -g`即可；其中 `uninstall` 表示卸载的意思；

## 3、 安装和卸载本地包

1. **什么是本地的包：**跟着项目安装的包，叫做本地包；本地包都会被安装到 node_modules 目录下；

2. **注意：如果拿到一个空项目，必须在当前项目根目录中，先运行 npm init或者npm init -y 命令，初始化一个package.json的配置文件，否则包无法安装到本地项目中；【可以先尝试安装，如果不行，可以在采用此方法】**

3. **如何安装本地包：**运行

   ```
   npm i 包名 --save
   ```

    

   即可安装本地包；都安装到了当前项目的

    

   ```
   node_modules
   ```

   目录下；

   - 如果大家用的是npm 5.x的版本，可以不指定`--save`命令，如果用的是 npm 3.x 的版本，则需要手动指定 `--save`；**【（npm -v）查看npm的版本。】**

4. `package-lock.json`文件中记录了曾经装过的包的下载地址，方便下次直接下载包，能够加快装包的速度，提升装包的体验；

5. **如何卸载本地包：**使用 `npm uninstall/remove 包名 -S/-D`即可卸载指定的本地包；

注意：**在这里需要注意一点，我们项目中有一个node_modules文件夹存放，我们安装的本地包，但是如果现在我们要将该项目发给别人使用，没有比较将该包发给别人，因为太大了。我们只要将项目代码文件和package.json以及package-lock.json文件发给别人，那么对方接收到该项目，然后在cmd中将路径定位到该项目，然后执行 npm install 就可以根据package.json和package-lock.json中记录的内容进行自动的下载。**

## 4、解决 npm 下载慢问题

1. 默认，NPM在下载包的时候，连接的是国外的服务器，所以，有时候如果网速不是特别好，可能下载不下来包；此时，大家可以全局安装一个的工具，叫做 `cnpm`
2. 如何安装`cnpm`：运行 `npm i cnpm -g` 即可；
3. 如何使用`cnpm`：在装包的时候，只需要把 `npm` 替换成 `cnpm` 即可，例如：
   - 使用 `npm` 安装 `jquery`：运行 `npm i jquery -S`
   - 使用 `cnpm` 安装 `jquery`： 运行 `cnpm i jquery -S`



# 二、下载安装

## 1、下载nodejs

windows下的NodeJS安装是比较方便的（v0.6.0版本之后，支持windows native），只需要登陆官网（http://nodejs.org/），便可以看到首页的“INSTALL”按钮，直接点击就会自动下载安装了。

![NodeJS安装步骤(nodejs-install.assets/6597852618937040742.jpg) - 逍遥仔 - Jones HoBlog](http://img0.ph.126.net/DdVgyGC-BR_1Kcma_FlK4w==/6597852618937040742.jpg)



## 2、安装过程

安装过程基本直接“NEXT”就可以了。

（windows的安装msi文件在过程中会直接添加path的系统变量，变量值是你的安装路径，例如“C:\Program Files\nodejs”）。



## **3、****安装完成后测试下**

安装完成后可以使用cmd（win+r然后输入cmd进入）测试下是否安装成功。

方法：在cmd下输入node -v，出现下图版本提示就是完成了NodeJS的安装。

![NodeJS安装步骤(nodejs-install.assets/1673931686598443802.jpg) - 逍遥仔 - Jones HoBlog](http://img0.ph.126.net/X6a9yRsuZQaM0z4IUjvmgw==/1673931686598443802.jpg)

 

## 4、npm的安装。

新版的NodeJS已经集成了npm，所以npm也一并安装好了。

可以在cmd命令行输入"npm -v"来测试是否成功安装。如下图，出现版本提示便OK了。



![NodeJS安装步骤(nodejs-install.assets/6597700886332404270.jpg) - 逍遥仔 - Jones HoBlog](http://img0.ph.126.net/P8n_MivIpzKylGk7Pl-k8Q==/6597700886332404270.jpg)



## 5、安装已完成

常规NodeJS的搭建到现在为止已经完成了。

## 6、npm配置

npm作为一个NodeJS的模块管理，很有必要列出一些：



## 模块路径、cache路径

先配置npm的全局模块的存放路径以及cache的路径，

例如希望将以上两个文件夹放在NodeJS的主目录下，便在NodeJs下建立"node_global"及"node_cache"两个文件夹。如下图

![NodeJS安装步骤(nodejs-install.assets/6597270977285435691.jpg) - 逍遥仔 - Jones HoBlog](http://img0.ph.126.net/fAb6MKNmQ9WUnzFZFIizzg==/6597270977285435691.jpg)



## 使用cmd命令进行配置

启动cmd，输入

npm config set prefix "C:\Program Files\nodejs\node_global"

npm config set cache "C:\Program Files\nodejs\node_cache"

如果不进行这一步设置，npm的全局安装包，将不会在node安装文件夹里。

如果这个步骤出现错误，如：operation not permitted, mkdir 'C:\Program Files\nodejs'，请使用管理员身份打开cmd命令行。

## 测试

现在我们来装个模块试试，

在cmd命令行里面，输入“npm install express -g”（“-g”这个参数意思是装到global目录下，也就是上面说设置的“C:\Program Files\nodejs\node_global”里面。）。

待cmd里面的安装过程滚动完成后，会提示“express”装在了哪、版本还有它的目录结构是怎样。如下图

![NodeJS安装步骤(nodejs-install.assets/3165749063164920570.jpg) - 逍遥仔 - Jones HoBlog](http://img0.ph.126.net/z-CvM61LjACjCc-TTAJ46g==/3165749063164920570.jpg)

## 查看环境变量

关闭cmd，打开系统对话框，“我的电脑”右键“属性”-“高级系统设置”-“高级”-“环境变量”。如下图

![NodeJS安装步骤(nodejs-install.assets/3161526938514261450.jpg) - 逍遥仔 - Jones HoBlog](http://img0.ph.126.net/2hJrDgr90LctbXIVGpdzxw==/3161526938514261450.jpg)

## 配置node_path

进入环境变量对话框，在系统变量下新建"NODE_PATH"，输入”C:\Program Files\nodejs\node_global\node_modules“。（ps：这一步相当关键。）

2014.4.19新增：由于改变了module的默认地址，所以上面的用户变量都要跟着改变一下（用户变量"PATH"修改为“C:\Program Files\nodejs\node_global\”），要不使用module的时候会导致输入命令出现“xxx不是内部或外部命令，也不是可运行的程序或批处理文件”这个错误。



## 测试

以上步骤都OK的话，我们可以再次开启cmd命令行，进入node，输入“require('express')”来测试下node的模块全局路径是否配置正确了。正确的话cmd会列出express的相关信息。如下图（如出错一般都是NODE_PATH的配置不对，可以检查下第④⑤步）

![NodeJS安装步骤(nodejs-install.assets/3324500950029677986.jpg) - 逍遥仔 - Jones HoBlog](http://img1.ph.126.net/J8WD0Um9CwrshehtnOwaFQ==/3324500950029677986.jpg)



## 安装淘宝npm（cnpm）

   (1)输入以下命令

```
npm install -g cnpm --registry=https://registry.npm.taobao.org
```

   (2)输入cnpm -v命令，查看结果

```
cnpm -v
```

##  常用命令集合

```bash
node -v #查看安装版本
npm -v #查看npm安装版本

npm config ls -l #查看配置项
```

# 常见问题

## 执行npm install报错：npm ERR! code EINTEGRITY

　　命令行执行npm install报错如下：

```
D:\frontend\viewsdev>npm install
npm ERR! code EINTEGRITY
npm ERR! sha512-8qtu6VYSXUExVPx6H8s8+OhQo0UQP7ogAoOa2bOPCvnhlpaGVYf3yh45WNa7PhhdWSOGQW3DdblqMX8UJ7Cu6g== integrity checksum failed when using sha512: wanted sha512-8qtu6VYSXUExVPx6H8s8+OhQo0UQP7ogAoOa2bOPCvnhlpaGVYf3yh45WNa7PhhdWSOGQW3DdblqMX8UJ7Cu6g== but got sha512-OvgW+e/pBS2QuX5CTDaaE+DM62t8mMk+IJfcpE3Zv1DC03DwoOKcyqRHlA+lkXWahSOPmvYZJSEDUKX0nOeLDw==. (4954746 bytes)
```

　　后来发现是npm版本问题，需要更新至最新版本：

```
D:\frontend\viewsdev>npm install -g npm
C:\Users\wulf\AppData\Roaming\npm\npx -> C:\Users\wulf\AppData\Roaming\npm\node_modules\npm\bin\npx-cli.js
C:\Users\wulf\AppData\Roaming\npm\npm -> C:\Users\wulf\AppData\Roaming\npm\node_modules\npm\bin\npm-cli.js
+ npm@6.3.0
added 396 packages in 45.85s
```

　　重新install成功：

```bash
D:\frontend\viewsdev>npm install
> wlf@1.0.0 preinstall D:\frontend\viewsdev
> npm install ./local_modules/my-htmlone ./local_modules/my-url-loader
npm WARN deprecated gulp-util@3.0.8: gulp-util is deprecated - replace it, following the guidelines at https://medium.com/gulpjs/gulp-util-ca3b1f9f9ac5
npm WARN deprecated CSSselect@0.4.1: the module is now available as 'css-select'
npm WARN deprecated CSSwhat@0.4.7: the module is now available as 'css-what'
npm WARN url-loader@0.5.9 requires a peer of file-loader@* but none is installed. You must install peer dependencies yourself.
npm WARN wlf@1.0.0 No repository field.

+ my-htmlone@0.1.9
+ my-url-loader@0.5.7
updated 2 packages and audited 131 packages in 12.198s
found 3 vulnerabilities (2 low, 1 moderate)
  run `npm audit fix` to fix them, or `npm audit` for details
npm WARN deprecated babel-preset-es2015@6.24.1: 🙌  Thanks for using Babel: we recommend using babel-preset-env now: please read babeljs.io/env to update!
npm WARN deprecated gulp-webpack@1.5.0: Has been renamed to https://www.npmjs.com/package/webpack-stream
npm WARN deprecated gulp-util@2.2.20: gulp-util is deprecated - replace it, following the guidelines at https://medium.com/gulpjs/gulp-util-ca3b1f9f9ac5
npm WARN deprecated graceful-fs@2.0.3: please upgrade to graceful-fs 4 for compatibility with current and future versions of Node.js
npm WARN deprecated react-tools@0.13.3: react-tools is deprecated. For more information, visit https://fb.me/react-tools-deprecated
npm WARN deprecated graceful-fs@3.0.11: please upgrade to graceful-fs 4 for compatibility with current and future versions of Node.js
npm WARN deprecated minimatch@2.0.10: Please update to minimatch 3.0.2 or higher to avoid a RegExp DoS issue
npm WARN deprecated browserslist@1.7.7: Browserslist 2 could fail on reading Browserslist >3.0 config used in other tools.
npm WARN deprecated minimatch@0.2.14: Please update to minimatch 3.0.2 or higher to avoid a RegExp DoS issue
npm WARN deprecated graceful-fs@1.2.3: please upgrade to graceful-fs 4 for compatibility with current and future versions of Node.js

> node-sass@4.9.2 install D:\frontend\viewsdev\node_modules\node-sass
> node scripts/install.js

Downloading binary from https://github.com/sass/node-sass/releases/download/v4.9.2/win32-x64-57_binding.node
Download complete  ] - :
Binary saved to D:\frontend\viewsdev\node_modules\node-sass\vendor\win32-x64-57\binding.node
Caching binary to C:\Users\wulf\AppData\Roaming\npm-cache\node-sass\4.9.2\win32-x64-57_binding.node

> node-sass@4.9.2 postinstall D:\frontend\viewsdev\node_modules\node-sass
> node scripts/build.js

Binary found at D:\frontend\viewsdev\node_modules\node-sass\vendor\win32-x64-57\binding.node
Testing binary
Binary is fine
npm WARN slick-carousel@1.8.1 requires a peer of jquery@>=1.8.0 but none is installed. You must install peer dependencies yourself.
npm WARN sass-loader@3.2.3 requires a peer of node-sass@^3.4.2 but none is installed. You must install peer dependencies yourself.
npm WARN wlf@1.0.0 No repository field.
npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@1.2.4 (node_modules\fsevents):
npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.2.4: wanted {"os":"darwin","arch":"any"} (current: {"os":"win32","arch":"x64"})

added 1243 packages from 760 contributors and audited 9576 packages in 186.808s
found 22 vulnerabilities (8 low, 10 moderate, 4 high)
  run `npm audit fix` to fix them, or `npm audit` for details
```





## npm ERR! Unexpected end of JSON input while parsing near '...Comment: https://open'

npm ERR! Unexpected end of JSON input while parsing near '...Comment: https://open'
因为我安装过淘宝镜像，怀疑是因此报错，上网找答案，要执行下面这句话清除下缓存：

**npm cache clean --force**

然后再重新安装一下官方的镜像：

**npm set registry https://registry.npmjs.org/**

安装完再执行 **cnpm install** 安装包安装成功，启动项目ok了



