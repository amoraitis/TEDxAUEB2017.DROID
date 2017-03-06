package com.example.tedxaueb.tedxaueb2017;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.*;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import Helpers.FontManager;
import Helpers.HttpRequest;
import Models.Speaker;
import okhttp3.*;

import static android.graphics.Matrix.*;
import static android.graphics.Matrix.ScaleToFit.*;
import static android.provider.UserDictionary.Words.APP_ID;
import static android.widget.Toast.*;

/**
 * Created by tasos on 2/28/2017.
 */

public class LoginActivity extends AppCompatActivity {
    ImageView profpic;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.spreadtheword),iconFont);
        profpic=(ImageView) findViewById(R.id.profpic);
        Intent i = getIntent();
        Uri profileURI = i.getParcelableExtra("ProfileURI");
        Picasso.with(LoginActivity.this)
                        .load(profileURI)
                        .into(new Target() {
                            @Override
                            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                                Bitmap mosaicBanner=BitmapFactory.decodeResource(getResources(),R.drawable.bannerforprofilepic500);
                                Bitmap mosaicBannerScaled = Bitmap.createScaledBitmap(mosaicBanner,500,50,false);
                                Bitmap bmOverlay = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                                Canvas canvas = new Canvas(bmOverlay);
                                canvas.drawBitmap(bitmap, new Matrix(), null);
                                Toast.makeText(LoginActivity.this, "Width: "+mosaicBannerScaled.getWidth(),
                                        Toast.LENGTH_LONG).show();
                                canvas.drawBitmap(mosaicBannerScaled, 0.0f,bmOverlay.getHeight()-60, null);
                                profpic.setImageBitmap(bmOverlay);

                            }

                            @Override
                            public void onBitmapFailed(Drawable errorDrawable) {
                                Toast.makeText(LoginActivity.this, "Error, draw attempt canceled.",
                                        Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onPrepareLoad(Drawable placeHolderDrawable) {

                            }
                        });
                ((Button)findViewById(R.id.share)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bitmap bitmap;
                        OutputStream output;

                        // Retrieve the image from the res folder
                        bitmap = ((BitmapDrawable)profpic.getDrawable()).getBitmap();

                        // Find the SD Card path
                        File filepath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

                        // Create a new folder AndroidBegin in SD Card
                        File dir = new File(filepath.getAbsolutePath() + "/TEDxAUEB2017/");
                        dir.mkdirs();

                        // Create a name for the saved image
                        File file = new File(dir, "myMosaic.png");

                        try {

                            // Share Intent
                            Intent share = new Intent(Intent.ACTION_SEND);

                            // Type of file to share
                            share.setType("image/jpeg");

                            output = new FileOutputStream(file);

                            // Compress into png format image from 0% - 100%
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
                            output.flush();
                            output.close();

                            // Locate the image to Share
                            Uri uri = Uri.fromFile(file);

                            // Pass the image into an Intnet
                            share.putExtra(Intent.EXTRA_STREAM, uri);

                            // Show the social share chooser list
                            startActivity(Intent.createChooser(share, "Share your Mosaic via"));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
            }

    }
