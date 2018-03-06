package com.example.a16047.topbar_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyTopBar mTopBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topbar);
        //getActionBar().hide();
        mTopBar= (MyTopBar) findViewById(R.id.mytopBar);
        System.out.println("MyTopBar: mTitleText="+mTopBar.mTitleView.getText());
        mTopBar.setmListener(new topbarClickListener(){
            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this,"right",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this,"left",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
