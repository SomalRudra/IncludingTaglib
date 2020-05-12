package com.example.nativetest;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowMeTags extends AppCompatActivity {

    TextView titleView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showmetags_layout);

        titleView=findViewById(R.id.title_id);
        Bundle extras=getIntent().getExtras();
        String title=extras.getString("title");
        titleView.setText(title);
    }
}
