package com.example.android.testing.espresso.BasicSample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.common.base.Strings;

public class ShowTextActivity extends Activity {

    public final static String KEY_EXTRA_MESSAGE =
            "com.example.android.testing.espresso.basicsample.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_text);

        Intent intent = getIntent();
        String message = Strings.nullToEmpty(intent.getStringExtra(KEY_EXTRA_MESSAGE));

        validateAndShowMessage(message);
    }

    private void validateAndShowMessage(String message) {
        if (!message.isEmpty()) {
            ((TextView) findViewById(R.id.show_text_view)).setText(message);
        } else {
            ((TextView) findViewById(R.id.show_text_view)).setText("No message to display");
        }
    }

    static protected Intent newStartIntent(Context context, String message) {
        Intent newIntent = new Intent(context, ShowTextActivity.class);
        newIntent.putExtra(KEY_EXTRA_MESSAGE, message);
        return newIntent;
    }
}
