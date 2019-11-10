package com.example.taxipot_android.domain.usecase;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.util.UseCase;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public abstract class HistoryUseCase<T> extends UseCase<T> {
    public abstract void getHistories(String userId, DisposableObserver disposable);
}
