package com.example.apicallusingdagger2andrxjavaexample.di;

import com.example.apicallusingdagger2andrxjavaexample.network.ApiService;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {
    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
