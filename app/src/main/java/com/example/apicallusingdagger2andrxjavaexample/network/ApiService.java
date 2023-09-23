package com.example.apicallusingdagger2andrxjavaexample.network;

import com.example.apicallusingdagger2andrxjavaexample.model.ResponseModel;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URL="https://cat-fact.herokuapp.com/";
    @GET("facts")
    Observable<Response<List<ResponseModel>>> fetchData();
}

