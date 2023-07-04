## iterator
> 一个一个遍历

“不要只使用具体类来编程，要优先使用抽象类和接口来编程”

迭代器模式的类图  
![img.png](src%2Fmain%2Fresources%2Fimg%2Fimg.png)

## Adapter  
> 加一个“适配器”以便于复用

Adapter模式有两种
- 类适配器模式（使用继承的适配器）--> classadapter包
- 对象适配器模式（使用委托的适配器）--> objadapter包

### 角色
**Target(对象)**  
该角色负责定义所需的方法，由Print接口和Print类扮演  【笔记本电脑正常工作所需的直流12伏特电压】  
**Client(请求者)**  
该角色负责使用Target角色所定义的方法进行具体的处理，由Main类扮演  【直流12伏特电源所驱动的笔记本电脑】  
**Adaptee(被适配)**  
Adaptee是一个持有既定方法的角色。由Banner类扮演  【家庭使用的120伏特交流电压】  
**Adapter(适配)**  
Adapter模式的主人公，负责满足Target角色的需求，将家庭使用的120伏特交流电压转换成直流12伏特电压的**适配器**,
由PrintBanner类扮演  

> 在类适配器模式中，Adapter角色通过继承来使用Adaptee角色，而在对象适配器模式中，
Adapter角色通过委托来使用Adaptee角色。

## Template Method
> 将具体处理交给子类

### 里氏替换原则
子类可以扩展父类的功能，但不能改变父类原有的功能  
也就是说：子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。

疑惑：尽量不要重写父类的方法？重写了可以通过运行时判断具体的执行对象执行具体的重写方法啊，为什么不要重写？

无论在父类类型的变量中保存哪个子类的实例，程序都可以正常工作，这种原则称为里氏替换
原则(The Liskov Substitution Principle,LSP)。当然，LSP并非仅限于Template Method模式，
它是通用的继承原则。

## Factory Method
> 将实例的生成交给子类




