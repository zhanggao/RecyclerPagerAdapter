# RecyclerPagerAdapter
Recycler PagerAdapter
#### 像ListView一样缓存itemView的PagerAdapter。

> 1.PagerAdapter默认不缓存itemView，每次instantiateItem时通常都是创建一个新的view，当ViewPager页数非常多时可能有性能问题。

> 2.RecyclerPagerAdapter在instantiateItem时尝试从缓存池去取itemView，并从缓存池移除掉该itemView，
当缓存池没有时才去创建itemView。
在destroyItem时，将itemView添加到缓存池中。

> 3.当你的ViewPager的item页数比较多并且每页都是一样的布局时才应该用RecyclerPagerAdapter，否则只需要按通常的写法。
