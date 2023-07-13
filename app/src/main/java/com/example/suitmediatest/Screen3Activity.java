package com.example.suitmediatest;

import static com.google.android.material.color.utilities.MaterialDynamicColors.error;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suitmediatest.Adapter.UserAdapter;
import com.example.suitmediatest.Interface.RecyclerViewInterface;
import com.example.suitmediatest.Model.UserModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Screen3Activity extends AppCompatActivity implements View.OnClickListener, RecyclerViewInterface {
    RecyclerView rv;
    UserAdapter userAdapter;
    ArrayList<UserModel> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView btnBack;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        btnBack=findViewById(R.id.btnBack);
        rv = findViewById(R.id.rvUser);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(Screen3Activity.this));

        getData();

        btnBack.setOnClickListener(this);

         }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBack:
                Intent back = new Intent(Screen3Activity.this,Screen2Activity.class);
                startActivity(back);
                userList.clear();
                finish();
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent choose = new Intent(Screen3Activity.this,Screen2Activity.class);
        String name = userList.get(position).getFirstName() +" "+userList.get(position).getLastName();

        choose.putExtra("name",name);
        startActivity(choose);
        userList.clear();
        finish();

    }

    private void getData(){
        userList = new ArrayList<>();
        userAdapter = new UserAdapter(this,userList,this);
        rv.setAdapter(userAdapter);

        String url ="https://reqres.in/api/users?page=1&per_page=10";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Res : ",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    if (jsonArray.length()>0){
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject1 =  jsonArray.getJSONObject(i);
                            String firstName = jsonObject1.getString("first_name");
                            String lastName = jsonObject1.getString("last_name");
                            String email = jsonObject1.getString("email");
                            String img = jsonObject1.getString("avatar");
                            userList.add(new UserModel(firstName,lastName,email,Uri.parse(img)));
                            Log.e("Res : ","Terinput "+email);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}