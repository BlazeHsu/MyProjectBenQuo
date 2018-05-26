package tw.com.blazelisa.myprojectbenquo;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GiudeActivity extends AppCompatActivity {
    private TextView gide_tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giude);
        gide_tv = findViewById(R.id.giude_tv);
        gide_tv.setText("GuideActivity");

    }
}
