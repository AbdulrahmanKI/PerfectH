package com.abdulrahman.asus.PerfectHealth.Calories_menu;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.abdulrahman.asus.PerfectHealth.R;




public class buttonCaluclate extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int positionChecked;
    private double result, finalResult, wieghtNum, hieghtNum, ageNum;
    private String radioChecked;
    RadioButton male, female;
    EditText wieght, hieght, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_caluclate);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);

        hieght = (EditText) findViewById(R.id.centmeter);
        wieght = (EditText) findViewById(R.id.kilogram);
        age = (EditText) findViewById(R.id.years);

        //wieghtNum = Double.valueOf(wieght.getText().toString());

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country_arrays, R.layout.spinner);
        adapter.setDropDownViewResource(R.layout.spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        //Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                positionChecked = 1;
                break;
            case 1:
                positionChecked = 2;
                break;
            case 2:
                positionChecked = 3;
                break;
            case 3:
                positionChecked = 4;
                break;
            case 4:
                positionChecked = 5;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void radioButton(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.male:
                if (checked){
                    radioChecked = "men";
                female.setChecked(false);}
                break;
            case R.id.female:
                if (checked){
                    radioChecked = "female";
                male.setChecked(false);}
                break;
        }

    }


    public void calculate(View view)throws Exception  {
        try {
            wieghtNum = Double.valueOf(wieght.getText().toString());
            hieghtNum = Double.valueOf(hieght.getText().toString());
            ageNum = Integer.valueOf(age.getText().toString());

            Intent intent = new Intent(this,CaloriesResult.class);
            Bundle bundle = new Bundle();
            if(radioChecked == "men" || radioChecked == "female"){
                bundle.putDouble("wieght",wieghtNum);
                bundle.putDouble("hieght",hieghtNum);
                bundle.putInt("age",(int)ageNum);
                bundle.putInt("level",positionChecked);
                bundle.putString("radio",radioChecked);

                intent.putExtras(bundle);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(), "الرجاء تحديد الجنس", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "أدخل جميع الفراغات", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

