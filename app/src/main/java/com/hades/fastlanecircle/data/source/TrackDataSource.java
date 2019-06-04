package com.hades.fastlanecircle.data.source;

import com.hades.fastlanecircle.data.model.Track;

import java.util.List;

/**
 * Created by Sony on 1/5/2018.
 */
public interface TrackDataSource {
    /**
     * @return <T> specified type of object
     */
    interface Callback<T> {
        void onStartLoading();
        void onGetSuccess(T data);
        void onGetFailure(String message);
        void onComplete();
    }

    void getListTrack(String url, String genre, int limit, int offSet,
                      Callback<List<Track>> callback);

    List<Track> getLocalTrack();
}
