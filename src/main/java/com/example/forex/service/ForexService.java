package com.example.forex.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.stereotype.Service;


import java.io.IOException;

@Service
public  class ForexService {
    private final ObjectMapper mapper;

    public ForexService(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public JsonNode GetConvertionRates(String  ApiKey) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.currencyfreaks.com/latest?apikey="+ApiKey)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        String forex = response.body().string();
        JsonNode val = mapper.readTree(forex);
        return val;
    }
}
