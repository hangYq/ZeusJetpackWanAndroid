# ZeusJetpackWanAndroid

## 相关说明

1. 在实际开发中，由于业务量巨大，可能会将业务进行拆分为若干个独立模块，在这其中就会存在编译版本、版本号以及依赖的三方库难以管理或者不通开发者使用库的版本号不一致导致整个项目产生编译冲突等问题，起初 Google 官方推荐使用 ext 变量来管理各个版本号，这种方式在编辑器中无法支持跳转和提示，所以整个项目使用 buildSrc 进行构建来解决各模块库的统一管理，相关文档可以参考[1]和[2];

2. 由于使用组件化开发，组件独立运行前提就是需要是一个 application，而新建的 module 是一个 library ，所以要实现组件独立运行就需要使 module 可以在 library 和 application 之间随意切换，所以我们在 gradle.properties 中设置一个变量，用来进行标记是否可以以组件方式来进行运行。相关文档可以参考[8];

3. 使用 Navigation 创建底部导航，相关文档可以参考[9];

4. 使用 ViewPager2 & TabLayout 创建滑动视图，相关文档可以参考[10];

## 参考文档

[1] [Use buildSrc to abstract imperative logic](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#sec:build_sources)

[2] [再见吧 buildSrc, 拥抱 Composing builds 提升 Android 编译速度](https://juejin.cn/post/6844904176250519565)

[3] [Kotlin 注解处理](https://www.kotlincn.net/docs/reference/kapt.html)

[4] [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle?hl=zh-cn#declaring_dependencies)

[5] [Android KTX](https://developer.android.com/kotlin/ktx)

[6] [Android 上的 Kotlin 协程](https://developer.android.com/kotlin/coroutines?hl=zh-cn)

[7] [ARouter](https://github.com/alibaba/ARouter)

[8] [为新设备添加模块](https://developer.android.com/studio/projects/add-app-module)

[9] [Navigation 组件](https://developer.android.com/guide/navigation/navigation-getting-started?hl=zh-cn)

[10] [ViewPager2 组件](https://developer.android.com/guide/navigation/navigation-swipe-view-2)
