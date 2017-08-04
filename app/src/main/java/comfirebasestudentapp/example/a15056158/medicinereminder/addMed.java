package comfirebasestudentapp.example.a15056158.medicinereminder;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class addMed extends AppCompatActivity {

    private TextView textView;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_med);

    }

    protected void onStart(){
        super.onStart();

    }
    public void addNewRecordButtonClicked(View view){
        EditText medNameEditText = (EditText)findViewById(R.id.editTextName);
        EditText medDosageEditText = (EditText)findViewById(R.id.editTextDosage);
        EditText medTimeEditText = (EditText)findViewById(R.id.editTextTime);
        EditText medDateEditText = (EditText)findViewById(R.id.editTextDate);
        EditText medRemarksEditText = (EditText)findViewById(R.id.edit_textRemarks);


        //TODO 02: Send the HttpRequest to createNewEntry.php
        Toast.makeText(addMed.this, "Submitted", Toast.LENGTH_SHORT).show();


        HttpRequest request = new HttpRequest("http://10.0.2.2/meds/addMeds.php");
        request.setMethod("POST");
        request.addData("med_name",medNameEditText.getText().toString());
        request.addData("med_dosage",medDosageEditText.getText().toString());
        request.addData("med_time",medTimeEditText.getText().toString());
        request.addData("med_date",medDateEditText.getText().toString());
        request.addData("remarks",medRemarksEditText.getText().toString());
        request.execute();


        try{
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(
                    R.layout.activity_add_med, container, false);
            return rootView;
        }
    }
    }
