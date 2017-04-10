package com.example.xvhuichuang.lianxi;

import android.annotation.TargetApi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;

import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xvhuichuang.lianxi.Util.Logs;
import com.example.xvhuichuang.lianxi.com.lianxi.UI.WaveView;
import com.example.xvhuichuang.lianxi.service.TextSer;
import com.ldoublem.thumbUplib.ThumbUpView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;


public class ParcelableActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        mThumbUpView.Like();
//        mThumbUpView.UnLike();

//        imageView = (ImageView) findViewById(R.id.image);
//        final FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2,-2);
//        lp.gravity = Gravity.BOTTOM|Gravity.CENTER;
//        waveView3.setOnWaveAnimationListener(y -> {
//            lp.setMargins(0,0,0,(int)y+2);
////            imageView.setLayoutParams(lp);
//        });


    }

}
