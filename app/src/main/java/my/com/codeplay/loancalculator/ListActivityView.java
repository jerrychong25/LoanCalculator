package my.com.codeplay.loancalculator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

public class ListActivityView extends AppCompatActivity {
    private Database db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView = (ListView) findViewById(android.R.id.list);

        db = new Database(this);

        Cursor c = db.query();
        listView.setAdapter(new MyCursorAdapter(this, c));
    }
}
