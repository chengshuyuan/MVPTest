# 1 MVC架构
## MVC架构介绍
现在的Android程序大多采用MVC的架构，MVC的架构软件可以分为三个部分：
- 视图(View): 用户界面
- 控制器(Controller) : 业务逻辑
- 模型(Model) : 数据保存

MVC架构的核心如下图所示：
![image](http://img.blog.csdn.net/20150511165134625)
View传送指令到Controller， Controller完成业务逻辑后，要求Model改变状态，Model将新的数据发送到View，用户得到反馈。
## MVC架构存在的问题
在MVC架构中，一般XML布局文件和Activity的setContentView等充当了View角色，Activity的其他代码充当Controller角色，其他数据来源充当了Model角色。Activity担当的责任非常之重，而且违背了单一职责原则。

# MVP架构
MVP架构的软件可以分为三个部分：
- 模型(Model) 用来做实际数据的操作，又是也需要创建一个Model的抽象接口Model Interface来降低耦合。
- 视图(View) 也就是Android的Activity，同事需要创建一个View的抽象接口View Interface，需要View实现接口，View通过View Interface与Presenter进行交互，降低耦合。
- 表示层(Presenter): 作为View与Model交互的中间纽带，处理与用户交互的交互逻辑。

下图展示了MVC架构的核心：
![image](http://img.blog.csdn.net/20150511165134625)

# MVC和MVP对比
MVP架构：
- View不直接与Model交互，而是通过与中间层Presenter交互来与Model间接交互
- Presenter与View的交互是通过接口来进行的
- 通常View与Presenter与一对一的

MVC架构：
- View可以与Model直接交互
- Controller是基于行为的，可以被多个View共享

MVP是从经典的MVC演变而来， 它们的基本思想是有想通的地方：Controller/Presenter负责逻辑的处理，MOdel提供数据，View负责显示。作为一种新的模式，MVP与MVC有着一个重大的区别：在MVP中View并不能直接使用Model，它们之间的通信是通过Presenter来进行的，所有的交互都发生在Presenter内部，而在MVC中View会直接从Model中读取数据而不是通过Controller。

