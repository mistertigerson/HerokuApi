package com.example.heroku;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.heroku.databinding.FragmentDetailsBinding;
import com.example.heroku.retrofit.Films;


public class DetailsFragment extends Fragment {

    private Films films;

    private FragmentDetailsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        films = (Films) getArguments().getSerializable("key");

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.text.setText(films.getTitle());
        binding.text2.setText(films.getProducer());
        binding.text3.setText(films.getDirector());
        binding.text4.setText(films.getOriginalTitleRomanised());
    }
}