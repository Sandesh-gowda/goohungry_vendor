package com.pinlab.vendor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linuxy on 5/2/17.
 */

public class LoginActivity extends AppCompatActivity  {

    private EditText userID;
    private EditText password ;
    private TextView proceed;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_card
        );

        userID = (EditText)   findViewById(R.id.gh_password);

        password =(EditText)  findViewById(R.id.gh_mobile);
        proceed = (TextView)  findViewById(R.id.tvErrMsg);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uid =userID.getText().toString();
                String pwd = password.getText().toString();

                callLogin(uid,pwd);
            }
        });




    }


    private void callLogin(final String userid,final String password

    ) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://goohungrry.com/stack/v1/rlogin",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        Log.v("ASS", response.toString());


                        try {
                            JSONObject jsonobject = new JSONObject(response);


                                String userid = jsonobject.getString("uuid");
                            String userName = jsonobject.getString("uuid_name");
                            if (!userid.equals("")){
                                Myapp.getInstance().getPrefManager(MysharedPreference.Login_Preferences).storeUser(new User(userid));
                                Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                                startActivity(i);


                            }else {
                                Toast.makeText(getApplicationContext(),"Sorry Login Not Found ",Toast.LENGTH_LONG).show();

                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"Sorry Login Not Found ",Toast.LENGTH_LONG).show();

                        }


                        // setData(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(),"Sorry Login Not Found ",Toast.LENGTH_LONG).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();


                map.put("apikey", userid);
                map.put("pwd", password);


                return map;
            }
        };
        Myapp.getInstance().getRequestQueue().add(stringRequest);
    }


}
