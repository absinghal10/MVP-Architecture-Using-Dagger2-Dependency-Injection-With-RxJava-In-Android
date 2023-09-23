package com.example.apicallusingdagger2andrxjavaexample.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.apicallusingdagger2andrxjavaexample.MainActivityMvpView;
import com.example.apicallusingdagger2andrxjavaexample.MainActivityPresenter;
import com.example.apicallusingdagger2andrxjavaexample.R;
import com.example.apicallusingdagger2andrxjavaexample.di.MyApp;
import com.example.apicallusingdagger2andrxjavaexample.model.ResponseModel;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainActivityMvpView {
    @Inject
    MainActivityPresenter mainActivityPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inject dependencies
        MyApp.getAppComponent().inject(this);
        // Attach the view to the presenter
        mainActivityPresenter.attachView(this);
        // Call API using the presenter
        mainActivityPresenter.fetchData();
    }

    @Override
    public void showData(Response<List<ResponseModel>> response) {
        Toast.makeText(this, "Getting Response Successfully", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void showError(String errorMessage) {

    }
}