package beans.prj.newsapp.ui.home;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import beans.prj.newsapp.etc.Categories;
import beans.prj.newsapp.ui.base.BaseFragment;

import java.util.ArrayList;

public class CategoryVpAdapter extends FragmentPagerAdapter {

    private ArrayList<BaseFragment> fragments;

    public CategoryVpAdapter(FragmentManager fm) {
        super(fm);

        fragments = new ArrayList<>();

        for(Categories category : Categories.values()) {
            fragments.add(NewsListFragment.newInstance(category.getTitle()));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Categories.values()[position].getTitle();
    }
}
