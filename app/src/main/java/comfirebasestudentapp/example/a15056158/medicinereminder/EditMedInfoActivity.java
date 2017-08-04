package comfirebasestudentapp.example.a15056158.medicinereminder;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

public class EditMedInfoActivity extends AppCompatActivity {

    private String Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_med_info);

    }

    protected void onStart(){
        super.onStart();
        Intent intent = getIntent();
        Id = intent.getStringExtra("com.example.MAIN_MESSAGE");
        HttpRequest request= new HttpRequest("http://10.0.2.2/meds/getMedicationDetail.php?Id=" + Id);
        request.setMethod("GET");
        request.execute();

        try{
            String jsonString = request.getResponse();
            JSONObject jsonObj = new JSONObject(jsonString);
            // TODO 01: Set values in the EditText fields

            EditText medNameEditText = (EditText)findViewById(R.id.editTextName);
            medNameEditText.setText(jsonObj.getString("med_name"));
            EditText medDosageEditText = (EditText)findViewById(R.id.editTextDosage);
            medDosageEditText.setText(jsonObj.getString("med_dosage"));
            EditText medTimeEditText= (EditText)findViewById(R.id.editTextTime);
            medTimeEditText.setText(jsonObj.getString("med_time"));
            EditText medDateEditText = (EditText)findViewById(R.id.editTextDate);
            medDateEditText.setText(jsonObj.getString("med_date"));
            EditText medRemarksEditText = (EditText)findViewById(R.id.edit_textRemarks);
            medRemarksEditText.setText(jsonObj.getString("remarks"));



        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDetailsButtonClicked(View view){
        EditText medNameEditText = (EditText)findViewById(R.id.editTextName);
        EditText medDosageEditText = (EditText)findViewById(R.id.editTextDosage);
        EditText medTimeEditText = (EditText)findViewById(R.id.editTextTime);
        EditText medDateEditText = (EditText)findViewById(R.id.editTextDate);
        EditText medRemarksEditText = (EditText)findViewById(R.id.edit_textRemarks);


        //TODO 03: Send the HttpRequest to updateContact.php
        Toast.makeText(EditMedInfoActivity.this, "Updated", Toast.LENGTH_SHORT).show();

        HttpRequest request = new HttpRequest("http://10.0.2.2/meds/updateMeds.php");
        request.setMethod("POST");
        request.addData("med_name",medNameEditText.getText().toString());
        request.addData("med_dosage",medDosageEditText.getText().toString());
        request.addData("med_time",medTimeEditText.getText().toString());
        request.addData("med_date",medDateEditText.getText().toString());
        request.addData("remarks",medRemarksEditText.getText().toString());
        request.addData("id", Id);

        request.execute();



        try{

            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteRecordButtonClicked(View view){
        //TODO 04: Send HttpRequest to removeContact.php
        Toast.makeText(EditMedInfoActivity.this, "Delete", Toast.LENGTH_SHORT).show();
        HttpRequest request = new HttpRequest("http://10.0.2.2/meds/deleteMeds.php");
        request.setMethod("POST");


        request.addData("id", Id);
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
                    R.layout.activity_edit_med_info, container, false);
            return rootView;
        }
    }
    }
