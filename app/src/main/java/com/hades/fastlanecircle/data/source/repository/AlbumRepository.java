package com.hades.fastlanecircle.data.source.repository;

import android.content.Context;

import com.hades.fastlanecircle.data.model.Album;
import com.hades.fastlanecircle.data.model.Track;
import com.hades.fastlanecircle.data.source.AlbumDataSource;
import com.hades.fastlanecircle.data.source.local.sqlite.AlbumLocalDataSource;

import java.util.List;

/**
 * Created by Bui Danh Nam on 8/1/2018.
 */

public class AlbumRepository implements AlbumDataSource {
    private AlbumDataSource mLocalDataSource;

    public static AlbumRepository getInstance(Context context) {
        return new AlbumRepository(AlbumLocalDataSource.getInstance(context));
    }

    public AlbumRepository(AlbumDataSource localDataSource) {
        mLocalDataSource = localDataSource;
    }

    @Override
    public List<Album> getAllAlbum() {
        return mLocalDataSource.getAllAlbum();
    }

    @Override
    public boolean addAlbum(Album album) {
        return mLocalDataSource.addAlbum(album);
    }

    @Override
    public boolean deleteAlbum(Album album) {
        return mLocalDataSource.deleteAlbum(album);
    }

    @Override
    public Album getAlbumById(int idAlbum) {
        return mLocalDataSource.getAlbumById(idAlbum);
    }

    @Override
    public boolean updateAlbum(Album album) {
        return mLocalDataSource.updateAlbum(album);
    }

    @Override
    public Album getAlbumByName(String nameAlbum) {
        return mLocalDataSource.getAlbumByName(nameAlbum);
    }

    @Override
    public boolean addTrack(int idAlbum, Track track) {
        return mLocalDataSource.addTrack(idAlbum, track);
    }

    @Override
    public boolean addTrack(String nameAlbum, Track track) {
        return mLocalDataSource.addTrack(nameAlbum, track);
    }

    @Override
    public List<Track> getAllTrack(int idAlbum) {
        return mLocalDataSource.getAllTrack(idAlbum);
    }

    @Override
    public List<Track> getAllTrack(String nameAlbum) {
        return mLocalDataSource.getAllTrack(nameAlbum);
    }

    @Override
    public boolean removeTrack(int idAlbum, Track track) {
        return mLocalDataSource.removeTrack(idAlbum, track);
    }

    @Override
    public boolean removeTrack(String nameAlbum, Track track) {
        return mLocalDataSource.removeTrack(nameAlbum, track);
    }


    @Override
    public boolean renameAlbum(Album album) {
        return mLocalDataSource.renameAlbum(album);
    }

    @Override
    public boolean checkTrackExistAlbum(String nameAlbum, Track track) {
        return mLocalDataSource.checkTrackExistAlbum(nameAlbum, track);
    }
}
