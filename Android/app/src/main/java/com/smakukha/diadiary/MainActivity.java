package com.smakukha.diadiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

import com.smakukha.diadiary.entity.*;
import com.smakukha.diadiary.db.*;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("[DiaDiary]", "Creating DBHelper ...");
        this.dbHelper = DBHelper.getDBHelper(this);
        TagFilter filter = new TagFilter(1, 2, "Measure", null);
        Log.d("[DiaDiary]", filter.getWhereClause());
        List<Tag> tag = TagDao.get(filter);
        Log.d("[DiaDiary]", "Tag size - " + tag.size());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void getMesuresList (View view) {
        Intent intent = new Intent(this, MeasuresListActivity.class);
        startActivity(intent);
    }
}
