package com.example.user.exersice1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText someText;
    private Button previewBtn;
    private String transferText;
    private static final String KEY_TEXT = "textFromMainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        someText = (EditText)findViewById(R.id.someText);
        previewBtn = (Button)findViewById(R.id.previewBtn);

        previewBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.previewBtn){
            transferText = someText.getText().toString();
            openSecondActivity();
        }
    }

    private void openSecondActivity() {

//        Intent secondActivityIntent = new Intent(this, SecondActivity.class);
//        secondActivityIntent.putExtra(KEY_TEXT, transferText);
//        startActivity(secondActivityIntent);

        SecondActivity.start(this, transferText);

    }
}
