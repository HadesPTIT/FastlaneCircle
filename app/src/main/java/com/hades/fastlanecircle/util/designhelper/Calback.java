package com.hades.fastlanecircle.util.designhelper;

import com.hades.fastlanecircle.data.model.Album;

/**
 * Created by Bui Danh Nam on 18/1/2018.
 */

public interface Calback {
    void onResult(Album album);
    void onAddNewAlbum(boolean b);
}
