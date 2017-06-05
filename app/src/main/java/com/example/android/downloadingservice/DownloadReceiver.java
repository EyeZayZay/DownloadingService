package com.example.android.downloadingservice;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by Android on 6/4/2017.
 */
public class DownloadReceiver extends ResultReceiver{

    private MainActivity mainActivity;

    public DownloadReceiver(Handler handler, MainActivity activity) {
        super(handler);
        mainActivity = activity;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
      mainActivity.OnImageDownload((Bitmap) resultData.getParcelable("file"));
    }
}
