package com.hades.fastlanecircle.screen.detailalbum;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.hades.fastlanecircle.R;
import com.hades.fastlanecircle.databinding.ActivityAlbumDetailBinding;
import com.hades.fastlanecircle.util.Constant;

/**
 * Created by Bui Danh Nam on 11/1/2018.
 */

public class DetailAlbumActivity extends AppCompatActivity {
    public static final int REQUEST_UPDATE_DATA = 10001;
    public DetailAlbumModelView mDetailAlbumModelView;
    private RecyclerView mRecyclerView;
    private SwipeController swipeController;
    private DetailAlbumAdapter mAdapter;

    public static Intent getInstance(Context context, int idAlbum) {
        Intent intent = new Intent(context, DetailAlbumActivity.class);
        intent.putExtra(Constant.EXTRA_ID_ALBUM, idAlbum);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAlbumDetailBinding activityAlbumDetailBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_album_detail);
        Intent intent = getIntent();
        int idAlbum = intent.getExtras().getInt(
                Constant.EXTRA_ID_ALBUM,
                Constant.VALUE_ID_ALBUM_NULL);
        mDetailAlbumModelView = new DetailAlbumModelView(this, idAlbum);
        activityAlbumDetailBinding.setViewModelAlbum(mDetailAlbumModelView);
        mRecyclerView = findViewById(R.id.recycle_view_track);
        mAdapter = mDetailAlbumModelView.getDetailAlbumAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
//                mAdapter.players.remove(position);
//                mAdapter.notifyItemRemoved(position);
                Log.d("==============", "onRightClicked: ");
                mDetailAlbumModelView.deleteTrack(position);
//                mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());
            }

            @Override
            public void onLeftClicked(int position) {
                Log.d("==============", "onLeftClicked: ");
                mDetailAlbumModelView.deleteTrack(position);

            }
        });

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c, 2);
            }
        });


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_UPDATE_DATA) {
            mDetailAlbumModelView.onUpdate();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
