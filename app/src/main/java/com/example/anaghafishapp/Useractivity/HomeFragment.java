package com.example.anaghafishapp.Useractivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.anaghafishapp.Adapter.CategoryAdapter;
import com.example.anaghafishapp.Adapter.RecommendedAdapter;
import com.example.anaghafishapp.Domain.CategoryDomain;
import com.example.anaghafishapp.Domain.FoodDomain;
import com.example.anaghafishapp.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewCategoryList, recyclerViewRecommendedList;
    private RecyclerView.Adapter adapter1, adapter2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewCategoryList = view.findViewById(R.id.view1);
        recyclerViewRecommendedList = view.findViewById(R.id.view2);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList.setLayoutManager(layoutManager1);
        recyclerViewRecommendedList.setLayoutManager(layoutManager2);

        //adapter1 = new CategoryAdapter(getCategoryList());
        adapter1 = new CategoryAdapter(requireContext(), getCategoryList());

        adapter2 = new RecommendedAdapter(getRecommendedList());
        recyclerViewCategoryList.setAdapter(adapter1);
        recyclerViewRecommendedList.setAdapter(adapter2);

        return view;
    }

    private ArrayList<CategoryDomain> getCategoryList() {
        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("  Raw  ", R.drawable.fbackground));
        categoryList.add(new CategoryDomain(" food  ", R.drawable.food1));
        categoryList.add(new CategoryDomain(" Fried ", R.drawable.brfood));
        categoryList.add(new CategoryDomain(" Curry ", R.drawable.brcurries));
        categoryList.add(new CategoryDomain("Biryani", R.drawable.brfishbiryani));
        categoryList.add(new CategoryDomain("Pickle", R.drawable.brfishpickle));
        categoryList.add(new CategoryDomain("Offer", R.drawable.brdiscount));
        // Add more categories here
        return categoryList;
    }

    private ArrayList<FoodDomain> getRecommendedList() {
        ArrayList<FoodDomain> recommendedList = new ArrayList<>();
        recommendedList.add(new FoodDomain("Paplet", "raw", 600.0, "Raw fish",4.6,45 ,84));
        recommendedList.add(new FoodDomain("Paplet fry", "brfood", 500.0,"Raw fish",4.6,45 ,94));
        recommendedList.add(new FoodDomain("Prawn Biryani", "brfishbiryani",400.0, "Raw fish",4.4,45 ,0));
        recommendedList.add(new FoodDomain("Bombill", "bombill", 300.0, "Raw fish",4.1,45 ,67));
        recommendedList.add(new FoodDomain("Prawn", "prawn", 450.0,"Raw fish",4.8,45 ,56));
        recommendedList.add(new FoodDomain("Surmai", "surmai", 400.0,"Raw fish",4.9,45 ,24));
        // Add more recommended items here
        return recommendedList;
    }



}
