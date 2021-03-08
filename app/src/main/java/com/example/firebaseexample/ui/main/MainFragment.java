package com.example.firebaseexample.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firebaseexample.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainFragment extends Fragment {

    private SharedViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DatabaseReference base = FirebaseDatabase.getInstance().getReference();
        DatabaseReference users = base.child("users");

        mViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        mViewModel.getUser().observe(getViewLifecycleOwner(), user -> {
            DatabaseReference uid = users.child(user.getUid());
            DatabaseReference incidencies = uid.child("incidencies");
        });
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}