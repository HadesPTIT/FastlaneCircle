package com.hades.fastlanecircle.screen.fragmentplay;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hades.fastlanecircle.R;
import com.hades.fastlanecircle.data.source.local.SharePreferences;
import com.hades.fastlanecircle.databinding.FragmentPlayTrackBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayTrackFragment extends Fragment {

    private PlayViewModel mPlayViewModel;

    public PlayTrackFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentPlayTrackBinding view = DataBindingUtil.inflate(inflater,
                R.layout.fragment_play_track, container, false);
        mPlayViewModel = new PlayViewModel(SharePreferences.getInstance().getListTrack(),
                SharePreferences.getInstance().getTrack());
        view.setViewModel(mPlayViewModel);
        return view.getRoot();

    }

}
