package com.hades.fastlanecircle.screen.addtracktoalbum;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.hades.fastlanecircle.BR;
import com.hades.fastlanecircle.data.model.Track;
import com.hades.fastlanecircle.data.source.TrackRepository;
import com.hades.fastlanecircle.data.source.remote.TrackRemoteDataSource;
import com.hades.fastlanecircle.data.source.repository.AlbumRepository;
import com.hades.fastlanecircle.screen.detailalbum.DetailAlbumActivity;
import com.hades.fastlanecircle.util.Constant;

import java.util.List;

/**
 * Created by ADMIN on 1/14/2018.
 */

public class AddTrackViewModel extends BaseObservable implements CheckCliclListener {

    private AddTrackAdapter mAddTrackAdapter;
    private Context mContext;
    private TrackRepository mTrackRepository;
    private List<Track> mTracks;
    private int mId;
    private boolean mFinish;
    private int mKeyOpenActivity;

    public AddTrackViewModel(Context context, int id) {
        mContext = context;
        mId = id;
        mAddTrackAdapter = new AddTrackAdapter();
        mTrackRepository = new TrackRepository(TrackRemoteDataSource.getInstance());
        mAddTrackAdapter.setCheckClickListener(this);
        if (checkPermisson()) {
            getData();
        }
    }

    public void getData() {
        mTracks = mTrackRepository.getLocalTrack();
        mAddTrackAdapter.addData(mTracks);
    }

    @Bindable
    public boolean isFinish() {
        return mFinish;
    }

    public void setFinish(boolean finish) {
        mFinish = finish;
        notifyPropertyChanged(0);
    }

    @BindingAdapter("onFinish")
    public static void setImage(View view, boolean finish) {
        if (finish) {
            ((Activity) (view.getContext())).finish();
        }
    }

    @Bindable
    public AddTrackAdapter getAddTrackAdapter() {
        return mAddTrackAdapter;
    }

    public void setAddTrackAdapter(AddTrackAdapter addTrackAdapter) {
        mAddTrackAdapter = addTrackAdapter;
        notifyPropertyChanged(BR.addTrackAdapter);
    }

    public boolean checkPermisson() {
        boolean isAllow = true;
        if (ContextCompat.checkSelfPermission(mContext,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            isAllow = false;
            ActivityCompat.requestPermissions((Activity) mContext,
                    Constant.PERMISSON, Constant.REQUEST_READ_STORAGE);
        }
        return isAllow;
    }

    public void onClickSuccess() {
        for (Track track : mTracks) {
            if (!track.isChecked()) {
                continue;
            }
            AlbumRepository.getInstance(mContext).addTrack(mId, track);
        }
        switch (mKeyOpenActivity) {
            case AddTrackActivity.KEY_ADD_TRACK_ALBUM:
                break;
            case AddTrackActivity.KEY_NEW_ALBUM:
                mContext.startActivity(DetailAlbumActivity.getInstance(mContext, mId));
                break;
        }
        setFinish(true);
    }

    @Override
    public void onTrackClickListenner(Track track, int position, boolean isChecked) {
        mTracks.get(position).setChecked(!isChecked);
    }

    public void setKeyOpenActivity(int keyOpenActivity) {
        mKeyOpenActivity = keyOpenActivity;
    }
}