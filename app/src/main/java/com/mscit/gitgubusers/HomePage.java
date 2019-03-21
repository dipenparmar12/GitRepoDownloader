package com.mscit.gitgubusers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    TextView editText_qry;

    RadioGroup radioGroupSearchType;
    RadioButton selectedRadioButton;
    Button btn_submit;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        editText_qry = findViewById(R.id.editText_qry);

        btn_submit = findViewById(R.id.btn_submit);

        radioGroupSearchType = findViewById(R.id.radioGroup_search_type);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioButtonId = radioGroupSearchType.getCheckedRadioButtonId();
                selectedRadioButton = findViewById(radioButtonId);

                Log.e("dipen","HomePage QryText :"+editText_qry.getText().toString());

                if("ByUserId".equals(selectedRadioButton.getText().toString()) ){
                    intent = new Intent(getApplicationContext(), GitUserDetailActivity.class);
                    intent.putExtra("textViewSearchQry",editText_qry.getText().toString());
                    startActivity(intent);
                }else{
                    intent = new Intent(getApplicationContext(), RepoSearchByQueryParaActivity.class);
//                    intent = new Intent(getApplicationContext(), GitRepoDetailActivity.class);
                    intent.putExtra("textViewSearchQry",editText_qry.getText().toString());
                    startActivity(intent);
                }

            }
        });

    }

}
