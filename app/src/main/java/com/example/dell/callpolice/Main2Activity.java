package com.example.dell.callpolice;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Set;

public class Main2Activity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button button;
    private MyDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        databaseHelper=new MyDatabaseHelper(this,"CallPolice.db",null,1);


        editText = (EditText) findViewById(R.id.edit);
        textView = (TextView) findViewById(R.id.all_location);
        button = (Button) findViewById(R.id.button_su);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("zzzkk","aaaaaaaaaa");
                SharedPreferences pref = getSharedPreferences("area_List", MODE_PRIVATE);
                Log.e("zzzkk","aaaaaaaaaa222");
                String ss = editText.getText().toString();

                Log.e("!!",ss);
                Set<String> set_1 = pref.getStringSet(ss, null);
                String sz = "";
                Log.e("***",""+set_1.size());
                if (set_1!=null) {
                    for (String i : set_1) {
                        Log.e("!!!!!!", i);
                        sz += i + "   ";
                    }
                }else{
                    sz+="没有数据";
                }

                SQLiteDatabase db=databaseHelper.getWritableDatabase();
                Cursor cursor=db.query("Map_Name",null,null,null,null,null,null);
                if (cursor.moveToFirst()){
                    do {
                        int id =cursor.getInt(cursor.getColumnIndex("id"));
                        String map_name=cursor.getString(cursor.getColumnIndex("mapname"));
                        Log.e("读取数据库",""+id+"     "+map_name);
                        sz+=""+id+"     "+map_name;
                    }while(cursor.moveToNext());
                }
                cursor.close();
                textView.setText(sz);
            }


        });
    }
}
