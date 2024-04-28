package com.example.application.async;

import android.os.AsyncTask;
import com.example.application.model.User;
import com.example.application.retrofit.RetrofitService;
import com.example.application.retrofit.UserAPI;
import retrofit2.Call;


public class RegistrationRequestTask extends AsyncTask<Void, Void, Call<Integer>> {
    private final User user;
    public RegistrationRequestTask(User user) {
        this.user = user;
    }

    @Override
    protected Call<Integer> doInBackground(Void... voids) {
        RetrofitService retrofitService = new RetrofitService();
        UserAPI userAPI = retrofitService.getRetrofit().create(UserAPI.class);
        Call<Integer> call = userAPI.registration(user);
        return call;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Call<Integer> unused) {
        super.onPostExecute(unused);
    }
}