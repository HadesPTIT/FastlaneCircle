package com.hades.fastlanecircle.screen.detailgenre;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.MenuItem;

import com.hades.fastlanecircle.R;
import com.hades.fastlanecircle.data.model.Genre;
import com.hades.fastlanecircle.databinding.ActivityGenreDetailBinding;
import com.hades.fastlanecircle.screen.detailalbum.SwipeController;
import com.hades.fastlanecircle.screen.detailalbum.SwipeControllerActions;
import com.hades.fastlanecircle.util.Constant;

/**
 * Created by Sony on 1/5/2018.
 */

public class GenreDetailActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private SwipeController swipeController;
    private GenreDetailViewModel mViewModel;

    public static Intent getInstance(Context context, Genre genre) {
        Intent intent = new Intent(context, GenreDetailActivity.class);
        intent.putExtra(Constant.EXTRA_GENRE, genre);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGenreDetailBinding activityGenreDetailBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_genre_detail);
         mViewModel = new GenreDetailViewModel(this,
                (Genre) getIntent().getSerializableExtra(Constant.EXTRA_GENRE));
        activityGenreDetailBinding.setViewModel(mViewModel);
        Toolbar toolbar = activityGenreDetailBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = findViewById(R.id.rcy);
        mAdapter = mViewModel.getGenreDetailAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
//                mAdapter.players.remove(position);
//                mAdapter.notifyItemRemoved(position);

//                mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());
                mViewModel.addPlayList(position);
                Log.d("==============", "onRightClicked: ");
            }

            @Override
            public void onLeftClicked(int position) {
                Log.d("==============", "onLeftClicked: ");
                mViewModel.addPlayList(position);

            }
        });

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c, 1);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
