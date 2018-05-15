package com.from.dididache.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.from.dididache.view.PersonInfornationView;

/**
 * Created by USER on 2018/5/12.
 */

public class PersonInfornationActivity extends Activity{
    private ImageView img_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PersonInfornationView personInfornationView=new PersonInfornationView(this);
        img_back=personInfornationView.getImgBcak();
        setContentView(personInfornationView);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
