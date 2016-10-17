package com.example.yasmine.semana2;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ConfirmActivity extends AppCompatActivity {
    private TextView nameView;
    private TextView dateView;
    private TextView telephoneView;
    private TextView emailView;
    private TextView descView;
    private Button editBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Bundle bundle = getIntent().getExtras();
        final Register r = (Register)bundle.getSerializable("REGISTER");

        nameView=(TextView) findViewById(R.id.sec_lbl_Name);
        dateView=(TextView) findViewById(R.id.sec_lbl_birthdate);
        telephoneView=(TextView) findViewById(R.id.sec_lbl_tel);
        emailView=(TextView) findViewById(R.id.sec_lbl_email);
        descView=(TextView) findViewById(R.id.sec_lbl_desc);

        nameView.setText(r.getName());
        dateView.setText(r.getBirthDate());
        telephoneView.setText(r.getTelephone());
        emailView.setText(r.getEmail());
        descView.setText(r.getNotes());

        descView=(Button) findViewById(R.id.sec_edit_button);
        descView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfirmActivity.this, r.toString(), Toast.LENGTH_LONG).show();
                Intent intent =new Intent(ConfirmActivity.this,MainActivity.class);
                intent.putExtra("REGISTER",r);
                startActivity(intent);
                finish();
            }
        });


       // Snackbar.make(this, getResources().getString(R.string.app_name),Snackbar.LENGTH_SHORT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.circled_chevron_left_50);


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
        return super.onKeyDown(keyCode, event);
    }
}
