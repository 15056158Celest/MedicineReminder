package comfirebasestudentapp.example.a15056158.medicinereminder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton imgAbout,imgCheck,imgReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgAbout = (ImageButton)findViewById(R.id.imageButtonAbout);
        imgReminder = (ImageButton)findViewById(R.id.imageButtonReminder);
        imgCheck = (ImageButton)findViewById(R.id.imageButtonInformation);

        final Context context = this;

        imgAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, aboutUs.class);
                startActivity(intent);

            }
        });

        imgCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MedList.class);
                startActivity(intent);

            }
        });

        imgReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, addMed.class);
                startActivity(intent);

            }
        });
    }
}
