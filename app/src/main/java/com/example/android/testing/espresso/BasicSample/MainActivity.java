package com.example.android.testing.espresso.BasicSample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.common.base.Strings;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView mTextView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.changeTextBt).setOnClickListener(this);
        findViewById(R.id.activityChangeTextBtn).setOnClickListener(this);

        mTextView = findViewById(R.id.textToBeChanged);
        mEditText = findViewById(R.id.editTextUserInput);
    }

    @Override
    public void onClick(View view) {
        final String text = mEditText.getText().toString().trim();

        final int changeTextBtId = R.id.changeTextBt;
        final int activityChangeTextBtnId = R.id.activityChangeTextBtn;

        if (view.getId() == changeTextBtId) {
            validateAndSetText(text);
        } else if (view.getId() == activityChangeTextBtnId) {
            validateAndStartActivity(text);
        }
    }

    private void validateAndSetText(String text) {
        if (!text.isEmpty()) {
            mTextView.setText(text);
        } else {
            mTextView.setText("Text cannot be empty");
        }
    }

    private void validateAndStartActivity(String text) {
        if (!text.isEmpty()) {
            Intent intent = ShowTextActivity.newStartIntent(this, text);
            startActivity(intent);
        }
    }
}
