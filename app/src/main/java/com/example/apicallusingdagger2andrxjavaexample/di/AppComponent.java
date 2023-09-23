package com.example.apicallusingdagger2andrxjavaexample.di;

import com.example.apicallusingdagger2andrxjavaexample.MainActivityPresenter;
import com.example.apicallusingdagger2andrxjavaexample.view.MainActivity;
import com.example.apicallusingdagger2andrxjavaexample.network.NetworkModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ApiModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(MainActivityPresenter mainActivityPresenter);
}
