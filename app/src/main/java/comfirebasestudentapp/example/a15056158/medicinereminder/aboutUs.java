package comfirebasestudentapp.example.a15056158.medicinereminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class aboutUs extends AppCompatActivity {

    TextView tvAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        tvAbout = (TextView) findViewById(R.id.tvAbout);
        tvAbout.setText("Always have the trouble of remebering what medication to consume, or what is the correct time to take it.\n" +
                "This application allows you to record the medication that you are require to consume, to make sure your taking your medication on time.");


    }
}
