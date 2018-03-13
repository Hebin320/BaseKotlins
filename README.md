# 前言

公司之前是做外包的，所以，做过了很多项目，一开始的时候都是新建项目的；后面做多了，就觉得，有很多共同的东西，完全可以复制过来，不需要每次都重写。于是我就建了个基础的项目，引入了一些常用的第三方库，也写了一些常用的方法或者类，如果接到新项目，就直接复制这个基础项目，进行开发就可以了，省去很多事情。
#项目介绍
项目已经上传到GitHub上了，有什么好的建议，记得给我留言；

[https://github.com/Hebin320/BaseKotlins](https://github.com/Hebin320/BaseKotlins)


<H3>第三方库</H3>

- **[multi-image-selector][1]（图片选择库）**
- **[rollviewpager][2]（自动轮播的Viewpager）**
- **[superrecyclerview][3]（支持上拉、下拉的Recyclerview）**
- **[Glide][4]（图片加载库）**
- **[AgentWeb][5]（简单易用的WebView）**
- **[OKGo][6]（网络请求库）**

以上是这个项目中大部分的第三方库，还有一些，像Gson一样的库我就没列出来了。
部分库是本地导入的，并没有用gradle的方式，主要是为了可以修改库里面的样式，
比如说，选择图片的界面，Recyclerview没有更多的统一布局等等。

<H3>实用类、方法</H3>
除了第三方库，项目里面还写了很多比较实用的方法或者类

- **[UniversalDialog][7]**
通过简单的几行代码，就可以创建一个Dialog，而且自由度高，可以设置位置、动画、边距等等
```
 fun show() {
        UniversalDialog.create(context)
                .setTransparent()
                .setType("1")
                .setLayoutId(R.layout.activity_main)
                .setAnimations(R.style.AnimTop)
                .show()
    }
```
- **[TouchImageView][8]**
支持手势缩放，双击缩放的ImageView
- **[DomainActivity][9]**
设置、自定义域名的界面
- **MVP框架**
- **Glide显示圆角、圆形的工具类**
- **设置Recyclerview的工具类**
- **EditText的工具类**
- **管理Activity的工具类**
- **动画加载库**
...
...




[1]: https://github.com/lovetuzitong/MultiImageSelector
[2]: https://github.com/Jude95/RollViewPager/
[3]: https://github.com/supercwn/SuperRecycleView
[4]: https://github.com/bumptech/glide
[5]: https://github.com/Justson/AgentWeb
[6]: https://github.com/jeasonlzy/okhttp-OkGo
[7]: https://github.com/Hebin320/BaseKotlins/blob/master/universallib/src/main/java/com/hebin/widget/dialog/UniversalDialog.kt
[8]: https://github.com/Hebin320/BaseKotlins/blob/master/universallib/src/main/java/com/hebin/widget/preview/TouchImageView.java
[9]: https://github.com/Hebin320/BaseKotlins/blob/master/app/src/main/java/com/hebin/project/ui/universal/DomainActivity.kt
