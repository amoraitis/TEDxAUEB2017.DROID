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
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import Helpers.FontManager;
import Helpers.HttpRequest;
import okhttp3.*;

import static android.graphics.Matrix.*;
import static android.graphics.Matrix.ScaleToFit.*;
import static android.provider.UserDictionary.Words.APP_ID;
import static android.widget.Toast.*;

/**
 * Created by tasos on 2/28/2017.
 */

public class LoginActivity extends AppCompatActivity {
    LoginButton loginButton;
    CallbackManager callbackManager;
    ImageView profpic;
    String userid;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.spreadtheword),iconFont);
        FacebookSdk.sdkInitialize(this);
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.loginlayout);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        profpic=(ImageView) findViewById(R.id.profpic);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                userid=loginResult.getAccessToken().getUserId();
                Uri imageUri = Profile.getCurrentProfile().getProfilePictureUri(400, 400);
                Picasso.with(LoginActivity.this)
                        .load(imageUri)
                        .into(new Target() {
                            @Override
                            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                Bitmap mosaicBanner=BitmapFactory.decodeResource(getResources(),R.drawable.bannerforprofilepic500);
                                Bitmap bmOverlay = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                                Canvas canvas = new Canvas(bmOverlay);
                                canvas.drawBitmap(bitmap, new Matrix(), null);
                                Toast.makeText(LoginActivity.this, "Width: "+mosaicBanner.getWidth(),
                                        Toast.LENGTH_LONG).show();
                                canvas.drawBitmap(mosaicBanner, 0.0f,bmOverlay.getHeight()-60, null);
                                profpic.setImageBitmap(bmOverlay);

                            }

                            @Override
                            public void onBitmapFailed(Drawable errorDrawable) {
                                Toast.makeText(LoginActivity.this, "eror dra attempt canceled.",
                                        Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onPrepareLoad(Drawable placeHolderDrawable) {

                            }
                        });
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this, "Login attempt canceled.",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(LoginActivity.this, "Login attempt failed.",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


}
