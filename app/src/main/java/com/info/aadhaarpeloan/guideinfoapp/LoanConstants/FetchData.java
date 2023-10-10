package com.info.aadhaarpeloan.guideinfoapp.LoanConstants;

import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class FetchData extends Application {
    private static FetchData fetchData;
    private RequestQueue requestQueue;
    private static Context context;

    private FetchData(Context context) {
        FetchData.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized FetchData getInstance(Context context) {
        if (fetchData == null) {
            fetchData = new FetchData(context);
        }
        return fetchData;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}