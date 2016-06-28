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
import com.softdesign.devintensive.utils.CircleImage;
import com.softdesign.devintensive.utils.ConstantManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = ConstantManager.TAG_PREFIX + "MainActivity";
    private DataManager mDataManager;
    private ImageView callImage;
    private List<EditText> mUserInfo;
    private CoordinatorLayout mCoordinatorLayout;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FloatingActionButton mFab;
    EditText mMobile, mEmail, mAccount, mGithub, mAboutMe;
    boolean mCurrent = false;

    /**
     * Метод вызывается при создании активити после изменения конфигурации/возврата к текушей
     * активити после его уничтожения.
     * <p>
     * в данном методе инициализируются/производится:
     * - UI пользовательский интерфейс (статика)
     * - инициализация статических данных активити
     * - связь данных со списками (инициализация адаптеров)
     * <p>
     * Не запускать длительные операции по работе с данными в onCreate() !!!
     *
     * @param savedInstanceState - объект со значениями сохраненными в Bundle - состояние UI
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.app_name_me);
        Log.d(TAG, "onCreate");
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_coordinator_container);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mFab = (FloatingActionButton) findViewById(R.id.my_fab);
        mMobile = (EditText) findViewById(R.id.main_phone);
        mEmail = (EditText) findViewById(R.id.main_email);
        mDataManager = DataManager.getInstance();
        mAccount = (EditText) findViewById(R.id.main_profile);
        mGithub = (EditText) findViewById(R.id.main_github);
        mAboutMe = (EditText) findViewById(R.id.main_aboutme);
        mUserInfo = new ArrayList<>();
        mUserInfo.add(mMobile);
        mUserInfo.add(mEmail);
        mUserInfo.add(mAccount);
        mUserInfo.add(mGithub);
        mUserInfo.add(mAboutMe);
        setupActionBar();
        setupDrawerLayout();
        mFab.setOnClickListener(this);
        callImage.setOnClickListener(this);
        if (savedInstanceState == null) {
            //активити звпускается впервые
            /*showSnackbar("активити звпускается впервые");
            showToast("активити звпускается впервые");*/
        } else {
            //активити уже создавалось

        }
    }

    /**
     * Метод вызывается при старте активити перед моментом того как UI станет достепен пользователю
     * как правило в данном методе происходит регистрация подписки на событиея остановка которых была
     * произведена в onStop()
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        @ @ -56, 4 + 118, 146@@protected void onDestroy () {
            super.onDestroy();
            Log.d(TAG, "onDestroy");
        }
    }

    /**
     * Метод вызывается когда активити становится доступен пользователю для взаимодействия
     * в данном методе как правило происходит запуск анимаций/аудио/видео/запуск BroadcastReceiver
     * необходимых для реализации UI логика/запуск выполнение потоков и т.д.
     * метод должен быть максимально легковесным для максимальной отзывчивости UI
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    /**
     * Метод вызывается когда текущая активити теряет фокус но остается видимой(всплытие
     * диалогового окна/частичное перекрытие другой активити и т.д)
     * <p>
     * в данном методе реализуют сохранение легковесных UI данных/анимаций/аудио/видео  и т.д
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    /**
     * Метод вызывается когда активити становится невидимым для пользователя.
     * в данном методе происходит отписка от событий, остановка сложных анимаций, сложные операции по
     * сохранению данных/прерывание запущенных потоков и т.д.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    /**
     * Метод вызывается при окончании работы активити (когда это происходит системно или после вызова
     * метода finish())
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /**
     * Метод вызывается при рестарте активити/возобнавлении работы после вызова метода onStop()
     * в данном методе реализуется спецификация бизнес логики которая должна быть реализована именно
     * при рестарте активности - например запрос к серверу который необходимо вызвать при возвращении
     * из другой активности (обновление данных, подписка на определенное событие проинициализированное
     * на другом экране/специфическая бизнес логика завязанная именно на перезапуске активити)
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_call:
                break;
            case R.id.my_fab:
                if (!mCurrent) {
                    changeEditMode(true);
                    mCurrent = true;
                } else {
                    changeEditMode(false);
                    mCurrent = false;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putBoolean(ConstantManager.EDIT_MODE, mCurrent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.drawer_myaccount:
                item.setCheckable(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.drawer_commands:
                item.setCheckable(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return true;
    }

    private void showSnackbar(String message) {
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupDrawerLayout() {
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        setupDrawerHeader(navigationView, getRoundBitmap(R.mipmap.user_default_pic), "Sanches", "gk707@mail.ru");
    }

    private void setupDrawerHeader(NavigationView navigationView, Bitmap avatar, String myName, String email) {
        View view = navigationView.getHeaderView(0);
        if (avatar != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.profile_image);
            imageView.setImageBitmap(avatar);
        }
        if (myName != null) {
            TextView textView = (TextView) view.findViewById(R.id.username_drawer_header);
            textView.setText(myName);
        }
    }

    private Bitmap getRoundBitmap(int drawableRes) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), drawableRes);
        bitmap = CircleImage.getRoundedBitmap(bitmap);
        return bitmap;
    }

    private void changeEditMode(boolean mode) {
        if (mode) {
            mFab.setImageResource(R.drawable.ic_done_black_24dp);
            for (View userValue : mUserInfo) {
                userValue.setEnabled(true);
                userValue.setFocusable(true);
                userValue.setFocusableInTouchMode(true);
            }
        } else {
            mFab.setImageResource(R.drawable.ic_create_black_24dp);
            for (View userValue : mUserInfo) {
                userValue.setEnabled(false);
                userValue.setFocusable(false);
                userValue.setFocusableInTouchMode(false);
            }
        }
    }

    private void loadUserInfoValue() {
        List<String> userData = mDataManager.getPreferencesManager().loadUserData();
        for (int i = 0; i < userData.size(); i++) {
            mUserInfo.get(i).setText(userData.get(i));
        }
    }

    private void saveUserInfoValue() {
        List<String> userData = new ArrayList<>();
        for (EditText userField : mUserInfo) {
            userData.add(userField.getText().toString());
        }
        mDataManager.getPreferencesManager().saveUserData(userData);
    }

}
