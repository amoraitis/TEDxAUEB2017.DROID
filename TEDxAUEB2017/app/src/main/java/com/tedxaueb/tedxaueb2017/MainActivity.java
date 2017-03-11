package com.tedxaueb.tedxaueb2017;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.analytics.Analytics;
import com.microsoft.azure.mobile.crashes.Crashes;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends Activity {
    LoginButton loginButton;
    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;
    ProfileTracker profileTracker;
    public String userid;
    static Uri profileUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.premain);
        MobileCenter.start(getApplication(), "fb3ef734-0989-4973-93ce-331f9e137395", Analytics.class, Crashes.class);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

                public void onSuccess(final LoginResult loginResult) {
                    userid = loginResult.getAccessToken().getUserId();
                    if(!isFacebookInstalled()){
                        //without Facebook app
                        profileUri = Uri.parse("https://graph.facebook.com/" + userid + "/picture?width=" + 400 +"&height=" + 400);
                    }else {
                        //with Facebook app
                                profileUri = Profile.getCurrentProfile().getProfilePictureUri(400, 400);
                    }
                    Intent branding = new Intent(MainActivity.this, LoginActivity.class);
                    branding.putExtra("ProfileURI", profileUri);
                    LoginManager.getInstance().logOut();
                    startActivity(branding);
                }

                @Override
                public void onCancel() {
                    Toast.makeText(MainActivity.this, "Login attempt canceled.",
                            Toast.LENGTH_LONG).show();
                }


                @Override
                public void onError(FacebookException e) {
                    Toast.makeText(MainActivity.this, "Login attempt failed.",
                            Toast.LENGTH_LONG).show();
                }
            });
            Button cancel = (Button) findViewById(R.id.cancel);
            cancel.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, MainMActivity.class);
                    startActivity(i);
                }
            });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public boolean isFacebookInstalled(){
        try{
            ApplicationInfo info = getPackageManager().
                    getApplicationInfo("com.facebook.katana", 0 );
            return true;
        } catch( PackageManager.NameNotFoundException e ){
            return false;
        }
    }

}
