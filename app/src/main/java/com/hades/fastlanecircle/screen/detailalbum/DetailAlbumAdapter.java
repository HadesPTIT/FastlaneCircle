package com.hades.fastlanecircle.screen.detailalbum;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hades.fastlanecircle.R;
import com.hades.fastlanecircle.data.model.Track;
import com.hades.fastlanecircle.databinding.ItemAlbumDetailBinding;
import com.hades.fastlanecircle.screen.BaseOnItemClick;

import java.util.List;

/**
 * Created by Bui Danh Nam on 11/1/2018.
 */

public class DetailAlbumAdapter extends
        RecyclerView.Adapter<DetailAlbumAdapter.AlbumDetailViewHolder> {
    private List<Track> mTracks;
    private BaseOnItemClick<Track> mOnItemClick;

    public DetailAlbumAdapter(List<Track> tracks) {
        mTracks = tracks;
    }

    @Override
    public AlbumDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemAlbumDetailBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_album_detail, parent, false);
        return new AlbumDetailViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(AlbumDetailViewHolder holder, int position) {
        holder.bindData(mTracks.get(position));
    }

    public void setOnItemClick(BaseOnItemClick<Track> onItemClick) {
        mOnItemClick = onItemClick;
    }

    @Override
    public int getItemCount() {
        return mTracks != null ? mTracks.size() : 0;
    }

    public void updateData(List<Track> tracks) {
        if (tracks == null) {
            return;
        }
        mTracks.clear();
        mTracks.addAll(tracks);
        notifyDataSetChanged();
    }

    /**
     * Viewholder
     */


    public class AlbumDetailViewHolder extends RecyclerView.ViewHolder {

        private ItemAlbumDetailBinding mBinding;

        public AlbumDetailViewHolder(ItemAlbumDetailBinding itemAlbumDetailBinding) {
            super(itemAlbumDetailBinding.getRoot());
            mBinding = itemAlbumDetailBinding;
        }

        public void bindData(Track track) {
            if (track == null) {
                return;
            }
            mBinding.setListener(mOnItemClick);
            mBinding.setTrack(track);
            mBinding.setViewModel(new ItemDetailAlbumViewModel(track,
                    mOnItemClick, getAdapterPosition()));
            mBinding.executePendingBindings();
        }
    }
}
