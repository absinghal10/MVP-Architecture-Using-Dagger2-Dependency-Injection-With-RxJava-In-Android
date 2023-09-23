package com.example.apicallusingdagger2andrxjavaexample;

import com.example.apicallusingdagger2andrxjavaexample.model.ResponseModel;
import java.util.List;
import retrofit2.Response;

public interface MainActivityMvpView {
    void showData(Response<List<ResponseModel>> response);
    void showError(String errorMessage);
}
