package com.example.body_mass_index_rabin_gurung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.body_mass_index_rabin_gurung.Presenter.Presenter;

public class MainActivity extends AppCompatActivity {
    public Button btnsubmit;
    private TextView tvresult;
    private EditText etfirst, etSecond;
    private Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsubmit = findViewById(R.id.btnsubmit);
        tvresult = findViewById(R.id.tvresult);
        etfirst = findViewById(R.id.etFirst);
        etSecond = findViewById(R.id.etSecond);
        presenter = new Presenter(this);
    }

    public void CheckForInput(){
        if(TextUtils.isEmpty(etfirst.getText())){
            etfirst.setError("Please enter your height");
            return;
        }
        if(TextUtils.isEmpty(etSecond.getText())){
            etSecond.setError("Please enter your weight");
            return;
        }

    }


    public float getHeight(){
        return Float.parseFloat(etfirst.getText().toString());
    }
    public float getWeight(){
        return Float.parseFloat(etSecond.getText().toString());
    }

    public void setResult(String result){
        tvresult.setText(result);
    }

    public void setToast(String status){
        Toast.makeText(MainActivity.this,status,Toast.LENGTH_SHORT).show();
    }

}
