package com.softdesign.devintensive.ui.activities;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.EditText;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.os.PersistableBundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.softdesign.devintensive.R;

import com.softdesign.devintensive.data.managers.DataManager;

import softdesign.com.devintensive.utils.RoundedAvatarDrawable;

import com.softdesign.devintensive.utils.ConstantManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static String TAG = ConstantManager.TAG_PREFIX + "Main Activity";

    private DataManager mDataManager;

    private int mCurrentEditMode = 0;

    private ImageView mCallImg;
    private CoordinatorLayout mCoordinatorLayout;
    private Toolbar mToolbar;
    private DrawerLayout mNavigationDrawer;
    ImageView mAvatar;
    private FloatingActionButton mFab;
    private EditText mUserPhone, mUserMail, mUserVk, mUserGit, mUserBio;

    private List<EditText> mUserInfoViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        mDataManager = DataManager.getInstance();
        mCallImg = (ImageView) findViewById(R.id.call_img);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_coordinator_container);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mUserPhone = (EditText) findViewById(R.id.phone_et);
        mUserMail = (EditText) findViewById(R.id.email_et);
        mUserVk = (EditText) findViewById(R.id.vk_et);
        mUserGit = (EditText) findViewById(R.id.github_et);
        mUserBio = (EditText) findViewById(R.id.bio_et);

        mUserInfoViews = new ArrayList<>();
        mUserInfoViews.add(mUserPhone);
        mUserInfoViews.add(mUserMail);
        mUserInfoViews.add(mUserVk);
        mUserInfoViews.add(mUserGit);
        mUserInfoViews.add(mUserBio);

        mAvatar = (ImageView) findViewById(R.id.avatar);
        mAvatar.setImageBitmap(RoundedAvatarDrawable.getRoundedBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.user_avatar)));


        mFab.setOnClickListener(this);
        setupToolbar();
        setupDrawer();

        if (savedInstanceState == null) {
            // активити запускается впервые
        } else {
            // активити уже создавалось
            mCurrentEditMode = savedInstanceState.getInt(ConstantManager.EDIT_MODE_KEY, 0);
            changeEditMode(mCurrentEditMode);
            loadUserInfoValue();

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mNavigationDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    @
    @ -35,13+111,13@@

    protected void onStart() {
        protected void onResume () {
            super.onResume();
            Log.d(TAG, "onResume");

        }

        @Override
        protected void onPause () {
            super.onPause();
            Log.d(TAG, "onPause");
            saveUserInfoValue();
        }

        @Override
        @ @ -65, 11 + 141, 113@@protected void onRestart () {
            @Override
            public void onClick (View v){
                switch (v.getId()) {
                    case R.id.fab:
                        if (mCurrentEditMode == 0) {
                            changeEditMode(1);
                            mCurrentEditMode = 1;
                        } else {
                            changeEditMode(0);
                            mCurrentEditMode = 0;
                        }
                        break;
                }
            }

            /**
             * закрывает Drawer по нажатию кнопки Back
             * */
            @Override
            public void onBackPressed () {
                if (mNavigationDrawer.isDrawerOpen(GravityCompat.START)) {
                    mNavigationDrawer.closeDrawer(GravityCompat.START);
                } else {
                    super.onBackPressed();
                }
            }

            @Override
            protected void onSaveInstanceState (Bundle outState){
                super.onSaveInstanceState(outState);
                outState.putInt(ConstantManager.EDIT_MODE_KEY, mCurrentEditMode);
            }

        private void showSnackbar (String message){
            Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
        }

        private void setupToolbar () {
            setSupportActionBar(mToolbar);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }

        private void setupDrawer () {
            NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    showSnackbar(item.getTitle().toString());
                    item.setChecked(true);
                    mNavigationDrawer.closeDrawer(GravityCompat.START);
                    return false;
                }
            });

        }

        private void changeEditMode ( int mode){
            if (mode == 1) {
                mFab.setImageResource(R.drawable.ic_done_black_24dp);
                for (EditText userValue : mUserInfoViews) {
                    userValue.setEnabled(true);
                    userValue.setFocusable(true);
                    userValue.setFocusableInTouchMode(true);
                }
            } else {
                mFab.setImageResource(R.drawable.ic_create_black_24dp);
                for (EditText userValue : mUserInfoViews) {
                    userValue.setEnabled(false);
                    userValue.setFocusable(false);
                    userValue.setFocusableInTouchMode(false);
                    saveUserInfoValue();
                }
            }

        }

        private void loadUserInfoValue () {
            List<String> userData = mDataManager.getPreferencesManager().loadUserProfileData();
            for (int i = 0; i < userData.size(); i++) {
                mUserInfoViews.get(i).setText(userData.get(i));
            }
        }

        private void saveUserInfoValue () {
            List<String> userData = new ArrayList<>();
            for (EditText userFieldsView : mUserInfoViews) {
                userData.add(userFieldsView.getText().toString());
            }
            mDataManager.getPreferencesManager().saveUserProfileData(userData);
        }

        }
    }
}
