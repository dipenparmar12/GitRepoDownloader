package com.mscit.gitgubusers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    TextView editText_qry;

    RadioGroup radioGroupSearchType;
    RadioButton selectedRadioButton, radioButton_users, radioButton_repos;

    Button btn_submit;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        editText_qry = findViewById(R.id.editText_qry);
        btn_submit = findViewById(R.id.btn_submit);

        radioGroupSearchType = findViewById(R.id.radioGroup_search_type);
//        radioButton_users = findViewById(R.id.radioButton_users);
//        radioButton_repos = findViewById(R.id.radioButton_repos);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioButtonId = radioGroupSearchType.getCheckedRadioButtonId();
                selectedRadioButton = findViewById(radioButtonId);


                Log.e("dipen","HomePage QryText :"+editText_qry.getText().toString());

                intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("radioGroupSearchType",selectedRadioButton.getText());
                intent.putExtra("textViewSearchQry",editText_qry.getText().toString());
                startActivity(intent);
            }
        });

//        if(getIntent().getExtras().getString("textViewSearchQry").toString()){
//            editText_qry.setText(getIntent().getExtras().getString("textViewSearchQry"));
//        }
        

    }
}
