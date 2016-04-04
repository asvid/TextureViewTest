package com.example.adam.textureviewtest;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;

/**
 * Created by adam on 04.04.16.
 */
public class StringRequest {
    // Tag used to cancel the request
    String  tag_string_req = "string_req";

    String url = "http://api.androidhive.info/volley/string_response.html";

    com.android.volley.toolbox.StringRequest strReq = new com.android.volley.toolbox.StringRequest(Request.Method.GET,
            url, new Response.Listener<String>() {

        @Override
        public void onResponse(String response) {
            Log.d(tag_string_req, response.toString());

        }
    }, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            VolleyLog.d(tag_string_req, "Error: " + error.getMessage());
        }
    });

}
