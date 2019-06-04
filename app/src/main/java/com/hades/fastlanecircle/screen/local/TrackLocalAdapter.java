package com.hades.fastlanecircle.screen.local;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hades.fastlanecircle.R;
import com.hades.fastlanecircle.data.model.Track;
import com.hades.fastlanecircle.databinding.ItemTrackLocalBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMIN on 1/7/2018.
 */

public class TrackLocalAdapter extends
        RecyclerView.Adapter<TrackLocalAdapter.ItemTrackLocalViewHolder> {

    public List<Track> getmTracks() {
        return mTracks;
    }

    private List<Track> mTracks;
    private TrackClickListener mTrackClickLisener;
    private OptionClickListener mOptionClickListener;

    public TrackLocalAdapter() {
        mTracks = new ArrayList<>();
    }

    @Override
    public ItemTrackLocalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemTrackLocalBinding itemTrackLocalBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_track_local, parent, false);
        return new ItemTrackLocalViewHolder(itemTrackLocalBinding, mTrackClickLisener,
                mOptionClickListener);
    }

    public void getData(List<Track> tracks) {
        if (tracks == null) {
            return;
        }
        mTracks.addAll(tracks);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ItemTrackLocalViewHolder holder, int position) {
        holder.bindData(mTracks.get(position));
    }

    public void setTrackClickLisener(TrackClickListener trackClickLisener) {
        mTrackClickLisener = trackClickLisener;
    }

    public void setOptionClickListener(OptionClickListener optionClickListener) {
        mOptionClickListener = optionClickListener;
    }

    @Override
    public int getItemCount() {
        return mTracks != null ? mTracks.size() : 0;
    }

    /**
     * Created by ADMIN on 1/7/2018.
     */
    public class ItemTrackLocalViewHolder extends RecyclerView.ViewHolder {
        private ItemTrackLocalBinding mBinding;
        private TrackClickListener mTrackClickListener;

        public ItemTrackLocalViewHolder(ItemTrackLocalBinding itemTrackLocalBinding,
                                        TrackClickListener trackClickLisener,
                                        OptionClickListener optionClickListener) {
            super(itemTrackLocalBinding.getRoot());
            mBinding = itemTrackLocalBinding;
            mTrackClickListener = trackClickLisener;
            mOptionClickListener = optionClickListener;
        }

        public void bindData(Track track) {
            mBinding.executePendingBindings();
            mBinding.setViewModel(
                    new ItemTrackLocalViewModel(track, mTrackClickListener, mOptionClickListener,
                            getAdapterPosition()));
        }
    }
}
