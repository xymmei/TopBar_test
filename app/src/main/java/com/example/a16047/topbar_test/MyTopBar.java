package com.example.a16047.topbar_test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.content.ContentValues.TAG;
import static android.widget.RelativeLayout.TRUE;

/**
 * Created by 16047 on 2018/3/6.
 */

public class MyTopBar extends RelativeLayout {
    int mLeftTextColor;
    int mRightTextColor;
    int mTitleTextColor;
    Drawable mLeftBackground,mRightBackground;
    String mLeftText,mRightText,mTitleText;
    float mTitleSize;

    Button mLeftButton,mRightButton;
    TextView mTitleView;
    LayoutParams mLeftParams,mRightParams,mTitleParams;

    topbarClickListener mListener;

    public void setmListener(topbarClickListener mListener) {
        this.mListener = mListener;
    }

    public MyTopBar(Context context) {
        super(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public MyTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.TopBar);
        mLeftBackground=ta.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText=ta.getString(R.styleable.TopBar_leftText);
        mLeftTextColor=ta.getColor(R.styleable.TopBar_leftTextColor,0);
        mRightBackground=ta.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText=ta.getString(R.styleable.TopBar_rightText);
        mRightTextColor=ta.getColor(R.styleable.TopBar_rightTextColor,0);
        mTitleSize=ta.getDimension(R.styleable.TopBar_titleTextSize,10);
        mTitleText=ta.getString(R.styleable.TopBar_title);
        mTitleTextColor=ta.getColor(R.styleable.TopBar_titleTextColor,0);
        Log.i(TAG, "MyTopBar: mLeftText="+mLeftText);
        Log.i(TAG, "MyTopBar: mLeftBackground="+mLeftBackground);
        Log.i(TAG, "MyTopBar: mLeftTextColor="+mLeftTextColor);
        Log.i(TAG, "MyTopBar: mTitleSize="+mTitleSize);
        Log.i(TAG, "MyTopBar: mTitleText="+mTitleText);
        ta.recycle();
        mLeftButton=new Button(context);
        mRightButton=new Button(context);
        mTitleView=new TextView(context);

        mLeftButton.setText(mLeftText);
        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);

        mRightButton.setText(mRightText);
        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);

        mTitleView.setText(mTitleText);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleSize);
        mTitleView.setGravity(Gravity.CENTER);

        Log.i(TAG, "MyTopBar: mTitleText="+mTitleView.getText());
        mLeftParams=new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT
        );
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(mLeftButton,mLeftParams);

        mRightParams=new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT
        );
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightButton,mRightParams);

        mTitleParams=new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT
        );
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        mTitleView.setLayoutParams(mTitleParams);
        addView(mTitleView);
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.leftClick();
            }
        });
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.rightClick();
            }
        });

    }
    public MyTopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public void setButtonVisable(int id,boolean flag){
        if(flag){
            if(id==0){
                mLeftButton.setVisibility(View.VISIBLE);
            }else {
                mRightButton.setVisibility(View.VISIBLE);
            }
        }else{
            if(id==0){
                mLeftButton.setVisibility(View.GONE);
            }else{
                mRightButton.setVisibility(View.GONE);
            }
        }
    }
}
