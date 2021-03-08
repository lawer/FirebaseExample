package com.example.firebaseexample.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseUser;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<FirebaseUser> user;

    public LiveData<FirebaseUser> getUser() {
        if (user == null) {
            user = new MutableLiveData<>();
        }
        return user;
    }

    public void setUser(FirebaseUser passedUser) {
       user.postValue(passedUser);
    }
}