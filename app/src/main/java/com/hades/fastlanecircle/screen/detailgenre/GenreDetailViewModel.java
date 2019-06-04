package com.hades.fastlanecircle.screen.detailgenre;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.hades.fastlanecircle.BR;
import com.hades.fastlanecircle.R;
import com.hades.fastlanecircle.data.model.Album;
import com.hades.fastlanecircle.data.model.Genre;
import com.hades.fastlanecircle.data.model.Track;
import com.hades.fastlanecircle.data.source.TrackDataSource;
import com.hades.fastlanecircle.data.source.TrackRepository;
import com.hades.fastlanecircle.data.source.local.SharePreferences;
import com.hades.fastlanecircle.data.source.remote.TrackRemoteDataSource;
import com.hades.fastlanecircle.data.source.repository.AlbumRepository;
import com.hades.fastlanecircle.screen.EndSrcollListenner;
import com.hades.fastlanecircle.screen.moretrack.MoreTrackFragment;
import com.hades.fastlanecircle.screen.playtrack.PlayTrackActivity;
import com.hades.fastlanecircle.util.Constant;
import com.hades.fastlanecircle.util.designhelper.Calback;
import com.hades.fastlanecircle.util.designhelper.CusDialog;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Sony on 1/5/2018.
 */

public class GenreDetailViewModel extends BaseObservable implements TrackClickListener,
        MoreInfoClickListener {

    private GenreDetailAdapter mGenreDetailAdapter;
    private Genre mGenre;
    private Context mContext;
    private TrackRepository mTrackRepository;
    public ObservableField<EndSrcollListenner> mEndSrcollListenner = new ObservableField<>();
    int offSet = Constant.OFF_SET_DEFAULT;

    public GenreDetailViewModel(Context context, Genre genre) {
        mContext = context;
        mGenre = genre;
        mTrackRepository = new TrackRepository(TrackRemoteDataSource.getInstance());
        mGenreDetailAdapter = new GenreDetailAdapter();
        mGenreDetailAdapter.setTrackClickListener(this);
        mGenreDetailAdapter.setMoreInfoClickListener(this);
        getData(Constant.OFF_SET_DEFAULT);
        mEndSrcollListenner.set(new EndSrcollListenner() {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                getData(offSet + 20);
                checkListTrack();
            }
        });
    }

    public void checkListTrack() {
        if (mGenre.getKeyname().equals(SharePreferences.getInstance().getGenre())) {
            SharePreferences.getInstance().putListTrack(new Gson().toJson(
                    mGenreDetailAdapter.getData()));
        }
    }

    private void getData(int offSet) {
        mTrackRepository.getListTrack(Constant.BASE_URL + Constant.PARA,
                mGenre.getKeyname(), Constant.LIMIT_DEFAULT, offSet,
                new TrackDataSource.Callback<List<Track>>() {
                    @Override
                    public void onStartLoading() {

                    }

                    @Override
                    public void onGetSuccess(List<Track> data) {
                        mGenreDetailAdapter.addData(data);
                        mEndSrcollListenner.get().resetState();
                    }

                    @Override
                    public void onGetFailure(String message) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Bindable
    public GenreDetailAdapter getGenreDetailAdapter() {
        return mGenreDetailAdapter;
    }

    public void setmGenreDetailAdapter(GenreDetailAdapter genreDetailAdapter) {
        this.mGenreDetailAdapter = genreDetailAdapter;
        notifyPropertyChanged(BR.genreDetailAdapter);
    }

    @Bindable
    public Genre getGenre() {
        return mGenre;
    }

    public void setGenre(Genre genre) {
        mGenre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Override
    public void onItemTrackClick(Track track, int position) {
        // TODO: 1/10/2018 open playtrackactivity
        SharePreferences.getInstance().putListTrack(new Gson().toJson(
                mGenreDetailAdapter.getData()));
        SharePreferences.getInstance().putTrack(new Gson().toJson(track));
        SharePreferences.getInstance().putIndex(position);
        SharePreferences.getInstance().putGenre(getGenre().getKeyname());
        mContext.startActivity(PlayTrackActivity.getInstance(mContext));

    }

    @Override
    public void onClickMore(Track track) {
        MoreTrackFragment.newInstance(track)
                .show(((AppCompatActivity) mContext).getSupportFragmentManager(), null);
    }

    public void addPlayList(int position) {
        try {
            handleAddPlaylisy(mGenreDetailAdapter.getData().get(position));
        } catch (Exception x) {

        }
    }

    private void handleAddPlaylisy(final Track track) {
        List<Album> albums = AlbumRepository.getInstance(mContext).getAllAlbum();
        CusDialog cusDialog = new CusDialog();
        cusDialog.showDialog(mContext, albums);
        cusDialog.setCalback(new Calback() {
            @Override
            public void onResult(Album album) {
                boolean result = AlbumRepository.getInstance(mContext).addTrack(album.getId(), track);
                mGenreDetailAdapter.notifyDataSetChanged();
                if (result) {
                    Toast.makeText(mContext, "Thêm Thành Công !! ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "Bài hát đã có trong playlist !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAddNewAlbum(boolean b) {
                if (b) {
                    handleAddNewAlbum(track);
                }
            }
        });

    }

    private void handleAddNewAlbum(final Track track) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(R.string.title_add_album);
        builder.setMessage(R.string.msg_name_album);
        final EditText input = new EditText(builder.getContext());
        builder.setView(input);
        builder.setPositiveButton(R.string.action_add, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nameAlbum = input.getText().toString().trim();
                if (nameAlbum.isEmpty()) {
                    Toast.makeText(
                            mContext, R.string.msg_err_name_null, Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
                Album albumTemp = new Album();
                albumTemp.setName(nameAlbum);
                boolean result = AlbumRepository.getInstance(mContext).addAlbum(albumTemp);
                mGenreDetailAdapter.notifyDataSetChanged();
                if (result) {
                    boolean resultAddAbum = AlbumRepository.getInstance(mContext).addTrack(nameAlbum, track);
                    if (resultAddAbum) {
                        Toast.makeText(mContext, "Thêm Thành Công !! ", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mContext, "Thêm Thất Bại !! ", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(
                            mContext, R.string.msg_err_name_exist, Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton(R.string.action_cancel, null);
        builder.show();
    }

}
