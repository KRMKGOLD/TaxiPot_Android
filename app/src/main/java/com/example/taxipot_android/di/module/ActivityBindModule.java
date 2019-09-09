package com.example.taxipot_android.di.module;

import com.example.taxipot_android.di.ActivityScope;
import com.example.taxipot_android.di.module.activity.MainActivityModule;
import com.example.taxipot_android.di.module.activity.SignInActivityModule;
import com.example.taxipot_android.di.module.activity.SignUp2ActivityModule;
import com.example.taxipot_android.di.module.activity.SignUpActivityModule;
import com.example.taxipot_android.presenter.ui.activity.MainActivity;
import com.example.taxipot_android.presenter.ui.activity.SignInActivity;
import com.example.taxipot_android.presenter.ui.activity.SignUp2Activity;
import com.example.taxipot_android.presenter.ui.activity.SignUpActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = SignInActivityModule.class)
    abstract SignInActivity provideSignInActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = SignUpActivityModule.class)
    abstract SignUpActivity provideSignUpActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = SignUp2ActivityModule.class)
    abstract SignUp2Activity provideSignUp2Activity();

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity provideMainActivity();
}
