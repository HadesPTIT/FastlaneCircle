package com.hades.fastlanecircle.screen.favourite;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hades.fastlanecircle.R;
import com.hades.fastlanecircle.databinding.FragmentFavoriteBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteTrackFragment extends Fragment {

    public FavoriteTrackFragment() {
    }

    public static FavoriteTrackFragment newInstance() {
        return new FavoriteTrackFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FavoriteViewModel mViewModel = new FavoriteViewModel(getContext());
        FragmentFavoriteBinding fragmentFavoriteBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_favorite, container, false);
        fragmentFavoriteBinding.setViewModel(mViewModel);
        return fragmentFavoriteBinding.getRoot();
    }

}
