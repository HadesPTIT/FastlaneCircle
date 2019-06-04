package com.hades.fastlanecircle.screen.addtracktoalbum;


import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.hades.fastlanecircle.R;
import com.hades.fastlanecircle.databinding.ActivityAddTrackBinding;
import com.hades.fastlanecircle.util.Constant;

/**
 * Created by ADMIN on 1/14/2018.
 */

public class AddTrackActivity extends AppCompatActivity {
    public static final int KEY_NEW_ALBUM = 102;
    public static final int KEY_ADD_TRACK_ALBUM = 1021;
    private AddTrackViewModel mViewModel;

    public static Intent getInstance(Context context, int idAlbum, int KEY) {
        Intent intent = new Intent(context, AddTrackActivity.class);
        intent.putExtra(Constant.EXTRA_ID_ALBUM, idAlbum);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.putExtra(Constant.EXTRA_OPENT_ADDTRACT, KEY);
        return intent;
    }

    public int getKeyOpenActivity() {
        return this.getIntent().getIntExtra(Constant.EXTRA_OPENT_ADDTRACT, KEY_ADD_TRACK_ALBUM);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddTrackBinding activityAddTrackBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_add_track);
        mViewModel = new AddTrackViewModel(this,
                getIntent().getIntExtra(Constant.EXTRA_ID_ALBUM, 0));
        activityAddTrackBinding.setViewModel(mViewModel);
        mViewModel.setKeyOpenActivity(getKeyOpenActivity());

        getSupportActionBar().setTitle(R.string.title_add_album);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Constant.REQUEST_READ_STORAGE) {
            mViewModel.getData();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sucess, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sucess:
                mViewModel.onClickSuccess();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
