package com.example.lenovo.custom;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.lenovo.custom.R.id.parent;

class Mycontact{
    public String name;
    public String phone;
    public String grade;

    public Mycontact(String a,String b,String c)
    {
        name=a;
        phone=b;
        grade=c;
    }
};

public class MainActivity extends AppCompatActivity {

    ArrayList<Mycontact> interalList = new ArrayList<Mycontact>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        interalList.add(new Mycontact("梦迪", "18656025619","大一"));
        interalList.add(new Mycontact("合合", "18158517556","大二"));
        interalList.add(new Mycontact("欢欢", "15375608084","大三"));
        interalList.add(new Mycontact("姗姗", "17821554111","大四"));

        MyListAdapter adapter=new MyListAdapter(getApplicationContext(),interalList);
        ListView myview = (ListView) findViewById(R.id.mylist);
        String[] items = {"hello", "hi", "xixixi", "hahaha", "hehehe"};
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,items);
        myview.setAdapter(adapter);
        myview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = ((TextView)view).getText().toString();
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

    }

    class MyListAdapter extends ArrayAdapter<Mycontact> {
        public MyListAdapter(Context con, ArrayList<Mycontact> users) {
            super(con, 0, users);
        }


        @Override


        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();

            View myview= inflater.inflate(R.layout.myview, null);


            Mycontact user = interalList.get(position);
            TextView tv=(TextView) myview.findViewById(R.id.textView);
            TextView tv2=(TextView) myview.findViewById(R.id.textView2);
            TextView tv3=(TextView) myview.findViewById(R.id.textView3);
            tv.setText(user.phone);
            tv2.setText(user.name);
            tv3.setText(user.grade);

            return myview;
        }
    }
}
