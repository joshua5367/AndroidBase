package com.cychoo.androidbase;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by cy.choo on 12/16/2017.
 * Sample activity to show basic ui layout and its test class as in src->androidTest->java->com.cy.androidbase->SampleInstrumentalTest
 */

public class SampleActivity  extends AppCompatActivity{
    private EditText et_sample_edittext_1;
    private TextView tv_sample_textview_1;
    private Button btn_sample_button_1;
    private Button btn_sample_button_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        // load buttons and text views
        et_sample_edittext_1 = (EditText)findViewById(R.id.sample_edittext_1);
        tv_sample_textview_1 = (TextView)findViewById(R.id.sample_textview_1);
        btn_sample_button_1 = (Button)findViewById(R.id.sample_button_1);
        btn_sample_button_2 = (Button)findViewById(R.id.sample_button_2);

        // add event handler for buttons
        btn_sample_button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), et_sample_edittext_1.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        btn_sample_button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_sample_textview_1.setText(R.string.sample_text2_after);
            }
        });
    }
}
