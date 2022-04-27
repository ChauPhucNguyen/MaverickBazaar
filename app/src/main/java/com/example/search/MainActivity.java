package com.example.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.ktx.Firebase;

public class MainActivity extends AppCompatActivity {
    private EditText mSearchField;
    private ImageButton mSearchBtn;
    private RecyclerView mResultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearchField = (EditText) findViewById(R.id.SearchEntry);
        mSearchBtn = (ImageButton) findViewById(R.id.ResultsSearch);
        mResultList = (RecyclerView) findViewById(R.id.SearchResults);

    }
}