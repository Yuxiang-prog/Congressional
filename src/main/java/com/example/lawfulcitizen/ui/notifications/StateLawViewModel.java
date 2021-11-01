package com.example.lawfulcitizen.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StateLawViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StateLawViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Matthew's fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}