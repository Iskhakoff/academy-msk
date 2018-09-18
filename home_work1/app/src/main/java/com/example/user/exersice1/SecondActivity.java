package com.example.user.exersice1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_TEXT = "textFromMainActivity";
    private TextView textForSend;
    private Button sendEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String someText = getIntent().getStringExtra(KEY_TEXT);

        textForSend = (TextView)findViewById(R.id.textForSend);
        sendEmail = (Button)findViewById(R.id.sendEmail);

        textForSend.setText(String.valueOf(someText));


        sendEmail.setOnClickListener(this);
    }

    public static void start(Activity activity, String text) {

        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra(KEY_TEXT, text);
        activity.startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.sendEmail){
            composeEmail(textForSend.getText().toString());
        }
    }

    public void composeEmail (String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:andr.academy.msk@gmail.com")); // only email apps should handle this
        intent.putExtra("body", body);
        intent.putExtra("subject","Hello, Android Academy MSK!");
        if (intent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(this, "No Email app found", Toast.LENGTH_LONG).show();
        }else{
            startActivity(intent);
        }
    }
}
