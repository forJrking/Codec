package com.king.codec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.king.codec.codec.DES3;
import com.king.codec.codec.Digest;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.et)
    AppCompatEditText mEt;
    @InjectView(R.id.textView2)
    AppCompatTextView mTextView2;
    private String mSrc;

    //String KEY = Digest.MD5.getMessage("user");
    String KEY2 = Digest.SHA256.getMessage("user");
    private String mTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


    }

    public String get(){
       return mEt.getText().toString();
    }
    @OnClick({R.id.btn1, R.id.btn2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1://加密
                try {
                    String encrypt = DES3.encrypt(KEY2, get());
                    mTemp = encrypt;
                    mTextView2.append("\r\n加密:"+encrypt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn2://解密

                try {
                    String decrypt = DES3.decrypt(KEY2, mTemp);
                    mTextView2.append("\r\n解密:"+decrypt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
