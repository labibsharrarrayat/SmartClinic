package com.example.smartclinic1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        EditText nric_input = (EditText)findViewById(R.id.nric);
        nric_input.setTransformationMethod(new AsteriskPassword());

        EditText name_input = (EditText)findViewById(R.id.fullname);
        name_input.setTransformationMethod(new AsteriskPassword());

        EditText password_input = (EditText)findViewById(R.id.create_password);
        password_input.setTransformationMethod(new AsteriskPassword());

        EditText confirm_input = (EditText)findViewById(R.id.confirm_password);
        confirm_input.setTransformationMethod(new AsteriskPassword());

        Button submit = (Button)findViewById(R.id.button6);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main6Activity.this,Main7Activity.class));
            }
        });

    }

    public class AsteriskPassword extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return new PasswordCharSequence(source);
        }

        private class PasswordCharSequence implements CharSequence {
            private CharSequence mSource;
            public PasswordCharSequence(CharSequence source) {
                mSource = source; // Store char sequence
            }
            public char charAt(int index) {
                return '*'; // This is the important part
            }
            public int length() {
                return mSource.length(); // Return default
            }
            public CharSequence subSequence(int start, int end) {
                return mSource.subSequence(start, end); // Return default
            }
        }
    };


}


