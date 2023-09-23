package com.example.apicallusingdagger2andrxjavaexample;

import android.util.Log;

import com.example.apicallusingdagger2andrxjavaexample.model.ResponseModel;
import com.example.apicallusingdagger2andrxjavaexample.network.ApiService;

import java.util.List;

import javax.inject.Inject;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MainActivityPresenter implements MainActivityMvpPresenter{
    private ApiService apiService;
    private MainActivityMvpView view;
    @Inject
    public MainActivityPresenter(ApiService apiService) {
        this.apiService = apiService;
    }
    public void attachView(MainActivityMvpView view) {
        this.view = view;
    }

    @Override
    public void fetchData() {
        apiService.fetchData()
                .subscribeOn(Schedulers.io()) // Perform network request on a background thread
                .observeOn(AndroidSchedulers.mainThread()) // Observe results on the main thread
                .subscribe(new Observer<Response<List<ResponseModel>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response<List<ResponseModel>> response) {
                        if (view != null) {
                            if (response.code()==200) {
                                // Successful response, you can access the status code and body
                                int statusCode = response.code();
                                List<ResponseModel> responseData = response.body();
                                Log.v("ResponseData", responseData.toString());
                                view.showData(response);
                            } else {
                                // Error response, handle it accordingly
                                // You can access the error status code and error body if needed
                                int errorCode = response.code();
                                String errorBody = response.errorBody() != null ? response.errorBody().toString() : "";

                                Log.e("ErrorResponse", "Error Code: " + errorCode);
                                Log.e("ErrorResponse", "Error Body: " + errorBody);
                                // Handle the error in your UI
                                view.showError("Error: " + errorCode);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            // Handle the error here
                            view.showError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void detachView() {
        this.view = null;
    }

}
