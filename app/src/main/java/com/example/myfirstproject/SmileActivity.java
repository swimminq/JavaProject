package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class SmileActivity extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smile);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final ImageView iv = (ImageView) findViewById(R.id.imageView1);
                    URL url = new URL("https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/082/422/178/82422178_1638431088519_1_600x600.JPG/dims/resize/Q_80,0");
                    InputStream is = url.openStream();
                    final Bitmap bm = BitmapFactory.decodeStream(is);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageBitmap(bm);
                        }
                    });
                    iv.setImageBitmap(bm);
                } catch(Exception e) {

                }
            }
        });

        t.start();
    }
}