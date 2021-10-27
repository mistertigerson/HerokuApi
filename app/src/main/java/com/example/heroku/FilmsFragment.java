package com.example.heroku;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.heroku.databinding.FragmentDetailsBinding;
import com.example.heroku.databinding.FragmentFilmsBinding;
import com.example.heroku.retrofit.Films;
import com.example.heroku.retrofit.NetworkService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsFragment extends Fragment {

    private FragmentFilmsBinding binding;
    private Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new Adapter();
        NetworkService.getmInstance().getGhibliapi()
                .getFilms()
                .enqueue(new Callback<List<Films>>() {
                    @Override
                    public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
                        if (response.isSuccessful() && response.body() != null){
                            ArrayList<Films> list = (ArrayList<Films>) response.body();
                            adapter.setList(list);
                            binding.recycler.setAdapter(adapter);
                        }else {
                            Toast.makeText(requireContext(), "аовылрпшдгурйгпшцшгпийшцп", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Films>> call, Throwable t) {
                        Toast.makeText(requireContext(), "аовылрпшдгурйгпшцшгпийшцп", Toast.LENGTH_SHORT).show();
                    }
                });
        binding.recycler.setAdapter(adapter);
        adapter.onItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onClick(Films films) {
                Bundle bundle = new Bundle();
                DetailsFragment detailsFragment = new DetailsFragment();
                bundle.putSerializable("key", films);
                detailsFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, detailsFragment).commit();

            }
        });

    }


}