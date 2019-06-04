package com.hades.fastlanecircle.screen.favourite;

import android.view.View;

import com.hades.fastlanecircle.data.model.Track;

/**
 * Created by Sony on 1/15/2018.
 */

public interface FavoriteClickListener {

    void onTrackClick(Track track, int posChange, View view);
}
