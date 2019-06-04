package com.hades.fastlanecircle.data.source.remote;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import com.hades.fastlanecircle.data.model.Track;
import com.hades.fastlanecircle.util.Constant;
import com.hades.fastlanecircle.util.StringUtil;

/**
 * Created by Sony on 1/11/2018.
 */

public class TrackDownloadManager {
    private Track mTrack;
    private Context mContext;

    public TrackDownloadManager(Context context, Track track) {
        mContext = context;
        mTrack = track;
    }

    public void download() {
        DownloadManager downloadManager = (DownloadManager)
                mContext.getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(
                StringUtil.getUrlDownload(mTrack.getUri())));
        request.setNotificationVisibility(DownloadManager.Request
                .VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setTitle(mTrack.getTitle());
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
                mTrack.getTitle() + Constant.FILE_EXTENTION);
        downloadManager.enqueue(request);
    }
}
