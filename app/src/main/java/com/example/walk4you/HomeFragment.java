package com.example.walk4you;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class HomeFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        inflater.inflate(R.layout.fragment_home, container, false);

        ImageButton imageButtonInfo1 =(ImageButton) view.findViewById(R.id.imageButtonInfo);
        ImageButton imageButtonPasti1 =(ImageButton) view.findViewById(R.id.imageButtonPasti);
        ImageButton imageButtonSonno1 =(ImageButton) view.findViewById(R.id.imageButtonSonno);
        ImageButton imageButtonLivello1 =(ImageButton) view.findViewById(R.id.imageButtonlivello);
        ImageButton imageButtonPremi1 =(ImageButton) view.findViewById(R.id.imageButtonPremi);


        //activity Premi
        imageButtonPremi1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent in = new Intent(getActivity(), Premi.class);
                startActivity(in);
            }
        });

        //activity Sonno
        imageButtonSonno1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent in = new Intent(getActivity(), Sonno.class);
                startActivity(in);
            }
        });


        //activity pasti
        imageButtonPasti1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent in = new Intent(getActivity(), Pasti.class);
                startActivity(in);
            }
        });

        //activity Info Attività
        imageButtonInfo1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View v) {
                    Intent in = new Intent(getActivity(), infoAttivita.class);
                    startActivity(in);
                }
                });
        //activity Livelli
        imageButtonLivello1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),Livelli.class);
                startActivity(in);
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }




}



