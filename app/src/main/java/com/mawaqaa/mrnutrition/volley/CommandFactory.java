package com.mawaqaa.mrnutrition.volley;

import com.android.volley.Request;

import org.json.JSONObject;

/**
 * Created by anson on 1/23/2017.
 */

public class CommandFactory {


    public void sendgetCommand(String url) {

        ServerConnectionChannel serverConnectionChannel = VolleyUtils
                .getServerConnectionChannel();
        serverConnectionChannel.doSendJsonRequest(createGetRequest(url));

    }

    public void sendPostCommand(String url, JSONObject jsonObject) {

        ServerConnectionChannel serverConnectionChannel = VolleyUtils
                .getServerConnectionChannel();
        serverConnectionChannel.doSendJsonRequest(createPostRequest(url, jsonObject));

    }


    /*method for get method*/
    private MrNutritionRequest createGetRequest(String url) {
        MrNutritionRequest babtainRequest = new MrNutritionRequest();
        babtainRequest.method = Request.Method.GET;
        babtainRequest.mReqUrl = url;
        return babtainRequest;

    }

    /*method for post method*/
    private MrNutritionRequest createPostRequest(String url, JSONObject jsonObject) {
        MrNutritionRequest babtainRequest = new MrNutritionRequest();
        babtainRequest.method = Request.Method.POST;
        babtainRequest.mReqUrl = url;
        babtainRequest.jsonObject = jsonObject;
        return babtainRequest;

    }
}
