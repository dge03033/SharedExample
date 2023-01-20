package com.example.sharedexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file";

    @Override
    protected void onDestroy() {
        //ctrl+o
        //ondes
        //액티비티가 파괴됐을때 호출해주는것
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString();//edit text에 현재 있는값.
        editor.putString("hong",value);//hong으로 value를 적어줄거야..
        editor.commit();//save완료


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText) findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared,  0);
        // 앱이 실행을 했을때 EditText가 뜨게될거고 EditText에 안드로이드 키보드를 입력후
        // 뒤로가기 종료하면 어떻게 될까??
        String value = sharedPreferences.getString("hong","");//꺼내와야하기때문에 빈값을 입력해준다.
        et_save.setText(value);

        //보통 설정에 많이쓴다.....
        //주의: 앱을 삭제할시에는 삭제된다. 말그대로 임시저장데이터.
        //안사라지는건 db연동.

    }
}