package com.tedxaueb.tedxaueb2017;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.tedxaueb.tedxaueb2017.Manifest.permission;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import Helpers.FontManager;

import static com.microsoft.azure.mobile.MobileCenter.LOG_TAG;

/**
 * Created by tasos on 2/28/2017.
 */

public class LoginActivity extends AppCompatActivity {
    String[] perms = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};

    int permsRequestCode = 200;
    ImageView profpic;
    private SharedPreferences sharedPreferences;
    ProgressBar shareprogress;
    Bitmap bmOverlay;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.spreadtheword),iconFont);
        profpic=(ImageView) findViewById(R.id.profpic);
        Intent i = getIntent();
        shareprogress=(ProgressBar) findViewById(R.id.shareprogress);
        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(shareprogress, "progress", 100000, 0);
        progressAnimator.setDuration(30000);
        progressAnimator.setInterpolator(new AccelerateInterpolator());
        progressAnimator.start();
        final Uri profileURI = i.getParcelableExtra("ProfileURI");
        final Button share = (Button)findViewById(R.id.share);
        share.setVisibility(View.GONE);
        Picasso.with(LoginActivity.this)
                        .load(profileURI)
                        .into(new Target() {
                            @Override
                            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                Bitmap mosaicBanner=BitmapFactory.decodeResource(getResources(),R.drawable.bannerforprofilepic500);
                                Bitmap mosaicBannerScaled = Bitmap.createScaledBitmap(mosaicBanner,500,50,false);
                                bmOverlay = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                                Canvas canvas = new Canvas(bmOverlay);
                                canvas.drawBitmap(bitmap, new Matrix(), null);
                                canvas.drawBitmap(mosaicBannerScaled, 0.0f,bmOverlay.getHeight()-60, null);
                                profpic.setImageBitmap(bmOverlay);
                                share.setVisibility(View.VISIBLE);
                                shareprogress.setVisibility(View.INVISIBLE);
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
                ((Button) findViewById(R.id.share)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shareprogress.setVisibility(View.VISIBLE);
                        if (shouldAskPermission()) {
                            if(hasPermission(perms[0]) && hasPermission(perms[1])){

                            }else{
                                if(!hasPermission(perms[0]) && !hasPermission(perms[1])) {
                                    requestPermissions(perms, permsRequestCode);
                                }
                            }

                        }
                        FileOutputStream output;
                        Bitmap bitmap = ((BitmapDrawable) profpic.getDrawable()).getBitmap();
                        // Find the SD Card path
                        File filepath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

                        // Create a new folder AndroidBegin in SD Card
                        File dir = new File(filepath.getAbsolutePath());
                        dir.mkdirs();

                        // Create a name for the saved image
                        File file = new File(dir, "myMosaic.png");

                        try {

                            // Share Intent
                            Intent share = new Intent(Intent.ACTION_SEND);

                            // Type of file to share
                            share.setType("image/png");
                            output = new FileOutputStream(file);

                            // Compress into png format image from 0% - 100%
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
                            output.flush();
                            output.close();
                            // Locate the image to Share
                            //if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                                Uri uri=null;
                                if(file.exists()){
                                    uri = Uri.fromFile(file);
                                }else{
                                    uri = getTheLatestPic();
                                }

                                //getApplicationContext().grantUriPermission("com.tedxaueb.tedxaueb2017",uri,Intent.FLAG_GRANT_READ_URI_PERMISSION);

                                // Pass the image into an Intnet
                                share.putExtra(Intent.EXTRA_STREAM, uri);

                                // Show the social share chooser list
                                startActivity(Intent.createChooser(share, "Share your Mosaic with"));
                            //}else{
                                Toast.makeText(getContext(),"Share your image from your Gallery",Toast.LENGTH_LONG).show();
                            //}

                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            shareprogress.setVisibility(View.GONE);
                        }
                    }
                });
            }
    public Uri getTheLatestPic(){
        String[] projection = new String[]{
                MediaStore.Images.ImageColumns._ID,
                MediaStore.Images.ImageColumns.DATA,
                MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
                MediaStore.Images.ImageColumns.DATE_TAKEN,
                MediaStore.Images.ImageColumns.MIME_TYPE
        };
        final Cursor cursor = getContext().getContentResolver()
                .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null,
                        null, MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC");
        if (cursor.moveToFirst()) {
            String imageLocation = cursor.getString(1);
            File imageFile = new File(imageLocation);
            if (imageFile.exists()) {   // TODO: is there a better way to do this?
                return Uri.fromFile(imageFile);

            }
        }
        return null;
    }

    public Context getContext() {
        return getApplicationContext();
    }


    public Uri getShareImageUri(){
        Drawable mDrawable = profpic.getDrawable();
        Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

        String path = MediaStore.Images.Media.insertImage(getContentResolver(),
                mBitmap, "myMosaic", null);

        return Uri.parse(path);
    }
    private boolean shouldAskPermission(){

        return(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M);

    }
    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults){

        switch(permsRequestCode){

            case 200:

                boolean writeAccepted = grantResults[0]== PackageManager.PERMISSION_GRANTED;
                if(writeAccepted)markAsAsked(perms[0]);
                boolean readAccepted = grantResults[1]==PackageManager.PERMISSION_GRANTED;
                if(readAccepted)markAsAsked(perms[1]);
                break;

        }
    }
    @SuppressLint("NewApi")
    private boolean hasPermission(String permission){

        if(canMakeSmores()){

            return(checkSelfPermission(permission)==PackageManager.PERMISSION_GRANTED);

        }

        return true;

    }
    private boolean shouldWeAsk(String permission){

        return (sharedPreferences.getBoolean(permission, true));

    }



    private void markAsAsked(String permission){

        sharedPreferences.edit().putBoolean(permission, false).apply();

    }
    private boolean canMakeSmores() {
        return(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP_MR1);
    }
}
