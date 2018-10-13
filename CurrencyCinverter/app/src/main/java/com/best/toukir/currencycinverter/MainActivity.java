package com.best.toukir.currencycinverter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    private InterstitialAd mInterstitialAd;
    TextView txtCustomFont2,txtCustomFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9590663615277504/9349024679");
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();

        adRequestBuilder.build();

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Toast.makeText(MainActivity.this,
                        "The interstitial is loaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.
                Intent intent = new Intent(MainActivity.this,ConvertCurrencyActivity.class);
                startActivity(intent);
            }
        });

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);


        txtCustomFont = (TextView) findViewById(R.id.txtAppame);
        txtCustomFont2 = (TextView) findViewById(R.id.txtAppamee);

        Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/Capture_it.ttf");

        txtCustomFont.setTypeface(customFont);
        txtCustomFont2.setTypeface(customFont);
    }

    public void btnConverter(View view) {


        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            // Proceed to the next level.
            Intent intent = new Intent(MainActivity.this,ConvertCurrencyActivity.class);
            startActivity(intent);

        }
    }

    public void btnClick(View view) {

        Intent intent = new Intent(MainActivity.this,nternationalCurrencyActivity.class);
        startActivity(intent);
    }

    public void btnRating(View view) {

        // App link here
        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.best.toukir.bstprogrammer"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}