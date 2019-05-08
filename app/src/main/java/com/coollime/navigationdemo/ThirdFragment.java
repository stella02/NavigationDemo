package com.coollime.navigationdemo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {


    public ThirdFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Getting data from the second fragment and show a toast of its message
        Bundle arguments = getArguments();
        String data = arguments.getString("KEY");
        Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    /** Trigger and handle navigation from the third fragment back to the second one */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 3rd -> 2nd back button
        Button btnThirdSecond = view.findViewById(R.id.btn_third_second);
        btnThirdSecond.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Use the native navigateUp() method to go back to the previous fragment
                // on the back stack
                Navigation.findNavController(v).navigateUp();
            }
        });
    }
}
