package com.hades.fastlanecircle.screen.home;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.hades.fastlanecircle.BR;
import com.hades.fastlanecircle.data.model.Genre;
import com.hades.fastlanecircle.data.source.repository.GenresRepository;
import com.hades.fastlanecircle.screen.detailgenre.GenreDetailActivity;

/**
 * Created by Bui Danh Nam on 5/1/2018.
 */

public class HomeViewModel extends BaseObservable implements OnItemClickListener {
    private HomeAdapter mHomeAdapter;
    private Context mContext;

    public HomeViewModel(Context context) {
        mContext = context;
        mHomeAdapter = new HomeAdapter(GenresRepository.getListGenres());
        mHomeAdapter.setOnItemClickListener(this);
    }

    @Bindable
    public HomeAdapter getHomeAdapter() {
        return mHomeAdapter;
    }

    public void setHomeAdapter(HomeAdapter homeAdapter) {
        mHomeAdapter = homeAdapter;
        notifyPropertyChanged(BR.homeAdapter);
    }

    @Override
    public void onClick(Genre genres) {
        mContext.startActivity(GenreDetailActivity.getInstance(mContext, genres));

    }

}
