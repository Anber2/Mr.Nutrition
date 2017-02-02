package com.mawaqaa.mrnutrition.volley;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anson on 1/23/2017.
 */

public class ServerConnectionChannel {
    private static final String TAG = "ServerConnectionChannel";
    private int BABTAIN_BACKOFF_MULT = 2;
    private int BABTAIN_MAX_RETRIES = 2;


    public ServerConnectionChannel() {
    }

    public void doSendJsonRequest(MrNutritionRequest mrNutritionRequest) {
        RequestQueue queue = VolleyUtils.getRequestQueue();
        try {
            JSONObject jsonObject = mrNutritionRequest.jsonObject;

            MrNutritionJsonRequest myReq = new MrNutritionJsonRequest(
                    mrNutritionRequest.method, mrNutritionRequest.mReqUrl,
                    jsonObject, createReqSuccessListener(mrNutritionRequest),
                    createReqErrorListener(mrNutritionRequest)) {
                protected Map<String, String> getParams()
                        throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "text/json");
                    return params;
                }
            };

            myReq.setRetryPolicy(new DefaultRetryPolicy(
                    DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 20,
                    BABTAIN_MAX_RETRIES,
                    BABTAIN_BACKOFF_MULT));

            //myReq.setHeader("Cache-Control", "no-cache");
            //myReq.setHeader("Content-Type", "text/json");

            queue.add(myReq);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Response.ErrorListener createReqErrorListener(final MrNutritionRequest mrNutritionRequest) {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "ReqErrorListener" + error.getMessage());
                MrNutritionResponse batainResponse = new MrNutritionResponse();
                batainResponse.mReqUrl = mrNutritionRequest.mReqUrl;
//                TabDealBaseActivity.getTabDealBaseActivity().serviceResponseError(batainResponse);
            }
        };
    }

    private Response.Listener<JSONObject> createReqSuccessListener(final MrNutritionRequest mrNutritionRequest) {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "ReqSuccessListener :" + mrNutritionRequest.mReqUrl);
                MrNutritionResponse batainResponse = new MrNutritionResponse();
                batainResponse.mReqUrl = mrNutritionRequest.mReqUrl;
                batainResponse.jsonObject = response;
//                TabDealBaseActivity.getTabDealBaseActivity().serviceResponseSuccess(batainResponse);
            }
        };
    }
}
