package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MenuFragment extends Fragment {

    public static final String TAG = "Menu";

    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.btnMenuPopup)
    MaterialButton btnMenuPopup;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_menu_width_min);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public MenuFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        btnMenuPopup.setOnClickListener(viewl ->{
            PopupMenu popupMenu = new PopupMenu(getActivity(), viewl);
            popupMenu.getMenuInflater().inflate(R.menu.menu_bottom_nav, popupMenu.getMenu());
            popupMenu.show();

        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}