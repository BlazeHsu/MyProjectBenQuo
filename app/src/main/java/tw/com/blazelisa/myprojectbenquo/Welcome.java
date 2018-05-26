package tw.com.blazelisa.myprojectbenquo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import tw.com.blazelisa.myprojectbenquo.config.Config;


public class Welcome extends AppCompatActivity {
    private TextView title,context;
    private ImageView logo;
    private String logo_url = "image/tomson.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome.this,GiudeActivity.class);
                startActivity(intent);
            }
        },3000);
    }

    private void init() {
        title = findViewById(R.id.title_tv);
        context = findViewById(R.id.text_tv);
        logo = findViewById(R.id.logo_iv);

//        使用Glide套gif檔
        Glide.with(Welcome.this).asGif().load(Config._URL+logo_url).into(logo);

    }
}
