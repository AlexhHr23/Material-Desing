package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {

    public static final String TAG = "Button";

    private static Component mInstance;

    Unbinder mUnbinder;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_button);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    public BottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buttom, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnEnable)
    public void onViewClicked() {
        Toast.makeText(getActivity(), R.string.status_enabled, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
