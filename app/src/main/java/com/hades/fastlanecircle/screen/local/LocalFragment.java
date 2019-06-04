package com.hades.fastlanecircle.screen.local;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hades.fastlanecircle.R;
import com.hades.fastlanecircle.databinding.FragmentLocalBinding;
import com.hades.fastlanecircle.util.Constant;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocalFragment extends Fragment {

    TrackLocalViewModel mViewModel;

    public LocalFragment() {
        // Required empty public constructor
    }

    public static LocalFragment newInstance() {
        return new LocalFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mViewModel = new TrackLocalViewModel(getContext());
        FragmentLocalBinding fragmentLocalBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_local, container, false);

        View view = fragmentLocalBinding.getRoot();
        fragmentLocalBinding.setViewModel(mViewModel);
        return view.getRootView();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Constant.REQUEST_READ_STORAGE) {
            // TODO: 1/11/2018
            mViewModel.getTracks();
        }
    }

}
