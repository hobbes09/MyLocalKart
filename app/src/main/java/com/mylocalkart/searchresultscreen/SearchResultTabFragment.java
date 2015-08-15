package com.mylocalkart.searchresultscreen;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.global.models.MiniProduct;
import com.mylocalkart.R;

import java.util.ArrayList;

public class SearchResultTabFragment extends Fragment {

    GridView gvSearchResults;
    ArrayList<MiniProduct> gridArray = new ArrayList<MiniProduct>();
    CustomGridViewAdapter customGridAdapter;
    View fragmentLayoutView;


    public SearchResultTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentLayoutView = inflater.inflate(R.layout.activity_search_screen_tab_results, container, false);
        return fragmentLayoutView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // set gridView items
        Bitmap miniProductIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.camera_icon);
        String miniProductName = "Nikon D3000";
        String miniProductPrice = "Rs. 30000";
        gridArray.add(new MiniProduct(miniProductIcon, miniProductName, miniProductPrice));
        gridArray.add(new MiniProduct(miniProductIcon, miniProductName, miniProductPrice));
        gridArray.add(new MiniProduct(miniProductIcon, miniProductName, miniProductPrice));
        gridArray.add(new MiniProduct(miniProductIcon, miniProductName, miniProductPrice));
        gridArray.add(new MiniProduct(miniProductIcon, miniProductName, miniProductPrice));
        gridArray.add(new MiniProduct(miniProductIcon, miniProductName, miniProductPrice));
        gridArray.add(new MiniProduct(miniProductIcon, miniProductName, miniProductPrice));
        gridArray.add(new MiniProduct(miniProductIcon, miniProductName, miniProductPrice));



        gvSearchResults = (GridView)fragmentLayoutView.findViewById(R.id.gvSearchResults);
        customGridAdapter = new CustomGridViewAdapter(getActivity(), R.layout.grid_search_screen_tab_results, gridArray);
        gvSearchResults.setAdapter(customGridAdapter);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
