package com.softdesign.devintensive.ui.activities;

/**
 * Created by texadmin on 27.06.2016.
 */

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.softdesign.devintensive.utils.ConstantManager;

public class BaseActivity extends AppCompatActivity {
    static final String TAG = ConstantManager.TAG_PREFIX + BaseActivity;

    public void showProgress(){

    }

    public void hideProgress(){

    }

    public void showError(String message,Exception error){

    }

    public void showToast(String message){
        Toast.makeText(this,)

    }
}
