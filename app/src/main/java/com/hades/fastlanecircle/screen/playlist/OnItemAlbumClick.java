package com.hades.fastlanecircle.screen.playlist;

import android.widget.ImageView;

import com.hades.fastlanecircle.data.model.Album;

/**
 * Created by Bui Danh Nam on 8/1/2018.
 */

public interface OnItemAlbumClick {
    void onItemClick(Album album);

    void onItemMoreClick(ImageView imageView, Album album);
}
