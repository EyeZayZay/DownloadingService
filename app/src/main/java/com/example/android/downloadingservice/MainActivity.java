package com.example.android.downloadingservice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    DownloadReceiver mReceiver;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReceiver = new DownloadReceiver(new Handler(), this);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void OnImageDownload(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, DownloadService.class);
        intent.putExtra("url", "http://wgcl.images.worldnow.com/images/10385511_G.jpg");
        intent.putExtra("receiver", new DownloadReceiver(new Handler(), this));
        startService(intent);
    }
}
