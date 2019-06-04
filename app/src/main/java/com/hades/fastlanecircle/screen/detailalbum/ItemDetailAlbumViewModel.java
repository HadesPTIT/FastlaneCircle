package com.hades.fastlanecircle.screen.detailalbum;

import android.databinding.BaseObservable;
import android.view.View;

import com.hades.fastlanecircle.data.model.Track;
import com.hades.fastlanecircle.screen.BaseOnItemClick;
import com.hades.fastlanecircle.util.Constant;

/**
 * Created by ADMIN on 1/6/2018.
 */

public class ItemDetailAlbumViewModel extends BaseObservable {
    private BaseOnItemClick<Track> mOnItemClick;
    private Track mTrack;
    private int mPosition;

    public ItemDetailAlbumViewModel(Track track, BaseOnItemClick<Track> baseOnItemClick, int position) {
        mTrack = track;
        mPosition = position;
        mOnItemClick = baseOnItemClick;
    }

    public String getPosition() {
        return String.valueOf(mPosition);
    }

    public String getTitle() {
        return mTrack != null ? mTrack.getTitle() : "";
    }

    public String getArtist() {
        if (mTrack != null) {
            return mTrack.getPublisherMetadata() != null ? mTrack.getPublisherMetadata().getArtist()
                    : "";
        }
        return "";
    }

    public String getUrl() {
        return mTrack != null ? mTrack.getArtworkUrl() : Constant.LINK_DEFAULT;
    }

    public void onClickTrack(View view) {
        if (mOnItemClick == null) {
            return;
        }
        mOnItemClick.onItemClick(mTrack, mPosition);
    }
}
