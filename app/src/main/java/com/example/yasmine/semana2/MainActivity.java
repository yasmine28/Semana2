package com.example.yasmine.semana2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView dateView;
    private int day;
    private int month;
    private int year;
    private EditText name;
    private DatePicker birthDate;
    private EditText telephone;
    private EditText email;
    private EditText note;
    private String pickerDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        if( bundle!=null && bundle.containsKey("REGISTER")) {

            final Register r = (Register) bundle.getSerializable("REGISTER");
            if (r != null) {
                name=(EditText) findViewById(R.id.complete_name);
                birthDate=(DatePicker) findViewById(R.id.datePicker);
                telephone=(EditText) findViewById(R.id.ftm_telephone);
                email=(EditText) findViewById(R.id.ftm_email);
                note=(EditText) findViewById(R.id.ftm_desc);
                String[]dateArr=r.getBirthDate().split("-");
                day=Integer.parseInt(dateArr[0]);
                month=Integer.parseInt(dateArr[1]);
                year=Integer.parseInt(dateArr[2]);
                name.setText(r.getName());
                birthDate.updateDate(year,month,day);
             //   dateView.setText(r.getBirthDate());
                telephone.setText(r.getTelephone());
                email.setText(r.getEmail());
                note.setText(r.getNotes());

            }
        }else{
            setDateOnView();
        }



        Button acept =(Button)findViewById(R.id.next_button);
        acept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 name= (EditText) findViewById(R.id.complete_name);
                 birthDate= (DatePicker) findViewById(R.id.datePicker);
                 telephone= (EditText) findViewById(R.id.ftm_telephone);
                 email= (EditText) findViewById(R.id.ftm_email);
                 note= (EditText) findViewById(R.id.ftm_desc);

                int day=birthDate.getDayOfMonth();
                int month=birthDate.getMonth();
                int year=birthDate.getYear();
                pickerDate=  String.format("%02d", day)+'-'+String.format("%02d", month)+'-'+year;
                Register reg = new Register(name.getText().toString(),
                        pickerDate,
                        telephone.getText().toString(),email.getText().toString(),note.getText().toString());
                Intent intent =new Intent(MainActivity.this,ConfirmActivity.class);
                intent.putExtra("REGISTER",reg);
                startActivity(intent);
                finish();


            }
        });




    }

    private void setDateOnView(){

        birthDate=(DatePicker) findViewById(R.id.datePicker);
        Calendar c = Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        birthDate.init(year,month,day,null);



    }
     public void hideKeyboard(View v) {
        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        //View view = v.;
        if (v != null) {
            inputManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


}
