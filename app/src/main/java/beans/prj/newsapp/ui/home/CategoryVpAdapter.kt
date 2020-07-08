package beans.prj.newsapp.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import beans.prj.newsapp.etc.Categories
import beans.prj.newsapp.ui.base.BaseFragment
import java.util.*

class CategoryVpAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val fragments: ArrayList<BaseFragment<*, *>>
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return Categories.values()[position].title
    }

    init {
        fragments = ArrayList()
        for (category in Categories.values()) {
            fragments.add(NewsListFragment.Companion.newInstance(category.title))
        }
    }
}