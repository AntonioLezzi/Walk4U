package com.example.walk4you;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.walk4you.Adapter.AdapterRistoranti;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.walk4you.util.Constants.ID_RISTORANTE;
import static com.example.walk4you.util.Constants.NOME_RISTORANTE;
import static com.example.walk4you.util.Constants.POSIZIONE_GPS_LAT;
import static com.example.walk4you.util.Constants.POSIZIONE_GPS_LONG;


public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private View rootView;
    GoogleMap mMap;

    private OnFragmentInteractionListener mListener;

    public MapsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        try {
            // Inflate the layout for this fragment
            rootView = inflater.inflate(R.layout.fragment_maps, container, false);

            Fragment frag = getChildFragmentManager().findFragmentById(R.id.mapView);
            SupportMapFragment mapFragment = (SupportMapFragment) frag;
            mapFragment.getMapAsync(this);
        } catch (InflateException e) {
            //Log.e("MAPS", "Inflate exception");
        }

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
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


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }else{
            if(!mMap.isMyLocationEnabled())
                mMap.setMyLocationEnabled(true);

            LocationManager lm = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
            Location myLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            if (myLocation == null) {
                Criteria criteria = new Criteria();
                criteria.setAccuracy(Criteria.ACCURACY_COARSE);
                String provider = lm.getBestProvider(criteria, true);
                myLocation = lm.getLastKnownLocation(provider);

            }

            if(myLocation!=null){
                LatLng userLocation = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 14), 1500, null);
            }
        }

        AdapterRistoranti ar = new AdapterRistoranti(getActivity());
        ar.open();
        Cursor ristoCursor = ar.fetchAllRistoranti();
        ristoCursor.moveToFirst();

        if (ristoCursor.moveToFirst()) {
            do {
                String nome = ristoCursor.getString(ristoCursor.getColumnIndex(NOME_RISTORANTE));
                double lat = ristoCursor.getDouble(ristoCursor.getColumnIndex(POSIZIONE_GPS_LAT));
                double lng = ristoCursor.getDouble(ristoCursor.getColumnIndex(POSIZIONE_GPS_LONG));

                LatLng loc = new LatLng(lat, lng);
                mMap.addMarker(new MarkerOptions().position(loc).title(nome));

            } while (ristoCursor.moveToNext());
        }
    }
}


