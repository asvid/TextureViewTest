package com.example.adam.textureviewtest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends Activity implements TextureView.SurfaceTextureListener {

    MyTxView textureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textureView = (MyTxView) findViewById(R.id.textureView);
        textureView.setSurfaceTextureListener(this);

        Log.d("MyTxView", "init" + textureView.getWidth() + " | " + textureView.getHeight());
//        getShitDone();


    }

    private void otherShit() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String URL = "http://webcam.st-malo.com/axis-cgi/mjpg/video.cgi?resolution=352x288";
                textureView.setSource(MjpegInputStream.read(URL));            }
        }).start();

    }

    private void getShitDone() {
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    InputStream i = new URL("http://webcam.st-malo.com/axis-cgi/mjpg/video.cgi?resolution=352x288").openStream();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        textureView.init();
        otherShit();
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }
}
