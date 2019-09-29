package com.BCIS.brak_trak_api_tester;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiCaller {


    private final String tempUrl = "http://10.100.10.103/api/temp";
    private final String ppgUrl = "http://10.100.10.103/api/ppg";
    RequestQueue requestQueue;

    ApiCaller(Context target) {
        this.requestQueue = Volley.newRequestQueue(target);
    }

    public Temp[] getAllTemp() {

        JsonArrayRequest objectRequest = new JsonArrayRequest(this.tempUrl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    JSONObject target = response.getJSONObject(0);
                    Temp temp = new Temp(target.getInt("id"),(float)target.getDouble("temp"),target.get("time").toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(objectRequest);
        return null;

    }


}
