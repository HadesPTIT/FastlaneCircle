package com.hades.fastlanecircle.screen.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hades.fastlanecircle.screen.favourite.FavoriteTrackFragment;
import com.hades.fastlanecircle.screen.home.HomeFragment;
import com.hades.fastlanecircle.screen.local.LocalFragment;
import com.hades.fastlanecircle.screen.playlist.PlaylistFragment;

/**
 * Created by Sony on 1/4/2018.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private static final int TAB_COUNT = 4;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TabType.HOME:
                return HomeFragment.newInstance();
            case TabType.PLAY_LIST:
                return PlaylistFragment.newInstance();
            case TabType.LOCAL:
                return LocalFragment.newInstance();
            case TabType.FAVORITE:
                return FavoriteTrackFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}
