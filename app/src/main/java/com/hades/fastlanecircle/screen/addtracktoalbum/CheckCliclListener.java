package com.hades.fastlanecircle.screen.addtracktoalbum;

import com.hades.fastlanecircle.data.model.Track;

/**
 * Created by ADMIN on 1/14/2018.
 */

public interface CheckCliclListener {
    void onTrackClickListenner(Track track, int position, boolean isChecked);
}
