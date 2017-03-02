package com.example.tedxaueb.tedxaueb2017;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.*;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import Helpers.HttpRequest;
import okhttp3.*;

import static android.provider.UserDictionary.Words.APP_ID;

/**
 * Created by tasos on 2/28/2017.
 */

public class LoginActivity extends AppCompatActivity {
    LoginButton loginButton;
    CallbackManager callbackManager;
    ImageView profpic;
    TextView info;
    String userid;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);

        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.loginlayout);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        profpic=(ImageView) findViewById(R.id.profpic);
        info=(TextView)findViewById(R.id.info);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                userid=loginResult.getAccessToken().getUserId();
                Bitmap bitmap = getFacebookProfilePicture(userid);
                if(bitmap!=null)
                    profpic.setImageBitmap(bitmap);
            }

            @Override
            public void onCancel() {
                info.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException e) {
                info.setText("Login attempt failed.");
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    public static Bitmap getFacebookProfilePicture(String userID){
        Bitmap bitmap = null;
        URL imageURL = null;
        try {
            imageURL = new URL("https://graph.facebook.com/" + userID + "/picture?type=large");
        }catch (MalformedURLException e){

        }
        try {
            bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());
        }catch (IOException d){

        }

        return bitmap;
    }


}
