# ZeusJetpackWanAndroid

## 一、相关说明

1. 在实际开发中，由于业务量巨大，可能会将业务进行拆分为若干个独立模块，在这其中就会存在编译版本、版本号以及依赖的三方库难以管理或者不通开发者使用库的版本号不一致导致整个项目产生编译冲突等问题，起初 Google 官方推荐使用 ext 变量来管理各个版本号，这种方式在编辑器中无法支持跳转和提示，所以整个项目使用 buildSrc 进行构建来解决各模块库的统一管理，相关文档可以参考[1]和[2]；

2. 由于使用组件化开发，组件独立运行前提就是需要是一个 application，而新建的 module 是一个 library ，所以要实现组件独立运行就需要使 module 可以在 library 和 application 之间随意切换，所以我们在 gradle.properties 中设置一个变量，用来进行标记是否可以以组件方式来进行运行。相关文档可以参考[8]；

3. 使用 Navigation 创建底部导航，相关文档可以参考[9]；

4. 使用 ViewPager2 & TabLayout 创建滑动视图，相关文档可以参考[10]；

## 二、个人(小白)学习记录

### 1. 为 RecycleView 设置点击事件

本方法只讲提供自定义接口，实现思路如下：

1. 首先在 Adapter 下声明一个接口，里面提供等待实现的回调函数；
2. 声明一个延迟初始化的接口变量；
3. 在 Adapter 里实现一个函数(setOnItemClickListener)，用于给第二步声明的变量来赋值；
4. 通过 View 自带的 setOnClickListener 的回调函数调用接口的函数，实现回调的效果(注意：实现哪种按照需求就行)；
5. 最后一步，调用自定义的 setOnItemClickListener 并实现自己的回调逻辑；

具体实例代码如下：

```kotlin
class SystemAdapter(private val list: List<SystemDataItem>) : Adapter<SystemAdapter.ViewHolder>() {

// 第二步：声明一个延迟初始化变量
 private lateinit var onItemClickListener: OnItemClickListener

 // 第一步：定义一个接口
 interface OnItemClickListener {
  fun onItemClick(item: SystemDataItem.Children?)
 }

  // 第三步：设置一个函数用于设置接口
  fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
    this.onItemClickListener = onItemClickListener
  }

  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val flowTitle: TextView = view.findViewById(R.id.flow_title)
    val chipGroup: ChipGroup = view.findViewById(R.id.chip_group)
    val context: Context = view.context
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.flow_items, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.flowTitle.text = list[position].name
    if (list[position].children?.isNotEmpty() == true) {
      for (child in list[position].children!!) {
        val chip = Chip(holder.context)
        chip.text = child?.name ?: ""
        chip.textSize = 12f
        chip.width = ViewGroup.LayoutParams.WRAP_CONTENT
        chip.height = ViewGroup.LayoutParams.WRAP_CONTENT
        // 第四步：实现接口回调
        onItemClickListener.let {
          chip.apply {
            setOnClickListener{
              onItemClickListener.onItemClick(child)
            }
          }
        }
        holder.chipGroup.addView(chip)
      }
    }
  }

  override fun getItemCount(): Int {
    return list.size
  }
}

// 第五步：调用自定义的 setOnItemClickListener，并实现自己的回调逻辑
adapter.setOnItemClickListener(object : SystemAdapter.OnItemClickListener{
  override fun onItemClick(item: SystemDataItem.Children?) {
    Log.d("TAG","$item")
  }
})

```

## 三、参考文档

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

[11] [Kotlin 的泛型](https://rengwuxian.com/kotlin-generics/)
