package com.example.quiz;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.text.BreakIterator;

public class MainActivity extends Activity {
    ImageView body, hair, eyebrow, eyes, moustache, beard;
    Button button1, button2, button3, button4, button5, button6;
    private static final int body_pick = 100;
    private static final int hair_pick = 101;
    private static final int eyebrow_pick = 102;
    private static final int eyes_pick = 103;
    private static final int moustache_pick = 104;
    private static final int beard_pick = 105;

    Uri bodyUri, hairUri, eyebrowUri, eyesUri, moustacheUri, beardUri;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        body = (ImageView)findViewById(R.id.body);
        hair = (ImageView)findViewById(R.id.hair);
        eyebrow = (ImageView)findViewById(R.id.eyebrow);
        eyes = (ImageView)findViewById(R.id.eyes);
        moustache = (ImageView)findViewById(R.id.moustache);
        beard = (ImageView)findViewById(R.id.beard);

        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery1();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery2();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery3();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery4();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery5();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery6();
            }
        });

        if(savedInstanceState != null){
            body.setVisibility(savedInstanceState.getInt("databody"));
            hair.setVisibility(savedInstanceState.getInt("datahair"));
            eyebrow.setVisibility(savedInstanceState.getInt("dataeyebrow"));
            eyes.setVisibility(savedInstanceState.getInt("dataeyes"));
            moustache.setVisibility(savedInstanceState.getInt("datamoustache"));
            beard.setVisibility(savedInstanceState.getInt("databeard"));

            bodyUri = savedInstanceState.getParcelable("bodyUri");
            body.setImageURI(bodyUri);
            hairUri = savedInstanceState.getParcelable("hairUri");
            hair.setImageURI(hairUri);
            eyebrowUri = savedInstanceState.getParcelable("eyebrowUri");
            eyebrow.setImageURI(eyebrowUri);
            eyesUri = savedInstanceState.getParcelable("eyesUri");
            eyes.setImageURI(eyesUri);
            moustacheUri = savedInstanceState.getParcelable("moustacheUri");
            moustache.setImageURI(moustacheUri);
            beardUri = savedInstanceState.getParcelable("beardUri");
            beard.setImageURI(beardUri);
        }

    }

    private void openGallery1() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, body_pick);
    }

    private void openGallery2() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, hair_pick);
    }

    private void openGallery3() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, eyebrow_pick);
    }

    private void openGallery4() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, eyes_pick);
    }

    private void openGallery5() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, moustache_pick);
    }

    private void openGallery6() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, beard_pick);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == body_pick){
            bodyUri = data.getData();
            body.setImageURI(bodyUri);
        }

        if (resultCode == RESULT_OK && requestCode == hair_pick){
            hairUri = data.getData();
            hair.setImageURI(hairUri);
        }

        if (resultCode == RESULT_OK && requestCode == eyebrow_pick){
            eyebrowUri = data.getData();
            eyebrow.setImageURI(eyebrowUri);
        }

        if (resultCode == RESULT_OK && requestCode == eyes_pick){
            eyesUri = data.getData();
            eyes.setImageURI(eyesUri);
        }

        if (resultCode == RESULT_OK && requestCode == moustache_pick){
            moustacheUri = data.getData();
            moustache.setImageURI(moustacheUri);
        }

        if (resultCode == RESULT_OK && requestCode == beard_pick){
            beardUri = data.getData();
            beard.setImageURI(beardUri);
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("databody", body.getVisibility());
        outState.putInt("datahair", hair.getVisibility());
        outState.putInt("dataeyebrow", eyebrow.getVisibility());
        outState.putInt("dataeyes", eyes.getVisibility());
        outState.putInt("datamoustache", moustache.getVisibility());
        outState.putInt("databeard", beard.getVisibility());
        outState.putParcelable("bodyUri", bodyUri);
        outState.putParcelable("hairUri", hairUri);
        outState.putParcelable("eyebrowUri", eyebrowUri);
        outState.putParcelable("eyesUri", eyesUri);
        outState.putParcelable("moustacheUri", moustacheUri);
        outState.putParcelable("beardUri", beardUri);
    }
}