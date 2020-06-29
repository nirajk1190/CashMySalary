package com.cashmysalary.api;

import com.cashmysalary.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {
    @POST()
    Call<LoginResponse> createUser (@Body LoginResponse loginResponse);
}
