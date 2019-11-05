package com.example.taxipot_android.presenter.viewModelFactory;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.taxipot_android.domain.repository.HistoryRepository;

import java.lang.reflect.InvocationTargetException;

public class HistoryViewModelFactory implements ViewModelProvider.Factory {
    private HistoryRepository repository;

    public HistoryViewModelFactory(HistoryRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        T obj = null;
        try {
            obj = modelClass.getConstructor(HistoryRepository.class).newInstance(repository);
        } catch (NoSuchMethodException nsme) {
            Log.e("HistoryViewModelFactory", "getConstructor");
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            Log.e("HistoryViewModelFactory", "newInstance");
        }
        return obj;
    }
}
