package com.example.user.businesscard;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    ui
    private ImageView telegramLink, vkLink, instagramLink;
    private Button sendEmail;
    private EditText emailTo;
//    local params
    private String url_telegram = "https://t.me/@Qworex";
    private String url_vk = "https://vk.com/dm0606";
    private String url_instagram = "https://www.instagram.com/privet_ya_dimaa/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telegramLink  = (ImageView)findViewById(R.id.telegram_link);
        vkLink        = (ImageView)findViewById(R.id.vk_link);
        instagramLink = (ImageView)findViewById(R.id.instagram_link);
        sendEmail     = (Button)findViewById(R.id.send_email);
        emailTo       = (EditText)findViewById(R.id.email_to);

        telegramLink.setOnClickListener(this);
        vkLink.setOnClickListener(this);
        instagramLink.setOnClickListener(this);
        sendEmail.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.telegram_link:
                toUrl(url_telegram);
                break;
            case R.id.vk_link:
                toUrl(url_vk);
                break;
            case R.id.instagram_link:
                toUrl(url_instagram);
                break;
            case R.id.send_email:
                String email = emailTo.getText().toString();
                composeEmail(email);
                break;
        }
    }

    private void toUrl(String url) {
        Uri page = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, page);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Toast.makeText(this, "Can't open web page. Sorry :(", Toast.LENGTH_SHORT).show();
        }
    }

    public void composeEmail (String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:dima.iskhakov@gmail.com")); // only email apps should handle this
        intent.putExtra("subject", "from you business card");
        intent.putExtra("body",body);
        if (intent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(this, "No Email app found", Toast.LENGTH_LONG).show();
        }else{
            startActivity(intent);
        }
    }
}
