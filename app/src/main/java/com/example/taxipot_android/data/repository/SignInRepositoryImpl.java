package com.example.taxipot_android.data.repository;

import android.util.Log;

import com.example.taxipot_android.data.datasource.UserDataSource;
import com.example.taxipot_android.data.remote.RemoteAPI;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.repository.SignInRepository;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;

public class SignInRepositoryImpl implements SignInRepository {
    RemoteAPI api;

    public SignInRepositoryImpl(RemoteAPI api) {
        this.api = api;
    }

    public Single<User> signIn(User user) {
        return api.signIn(user).doOnSuccess(new Consumer<User>() {
                                                @Override
                                                public void accept(User user) throws Exception {
                                                    Log.e(this.getClass().getSimpleName(), "Login 시도");
                                                }
                                            }

        ).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                switch (throwable.getMessage()) {
                    case "HTTP 404" : {Log.e(this.getClass().getSimpleName(),"404"); break;}
                    default: {
                        Log.e(this.getClass().getSimpleName(),throwable.getMessage());
                    }
                }
            }
        });
    }
}
