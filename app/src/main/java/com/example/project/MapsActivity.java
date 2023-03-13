package com.example.project;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.project.databinding.ActivityMapsBinding;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private double latitude = 0;
    private double longitude = 0;
    private Geocoder geocoder;
    private List<Address> addresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);
        Geocoder geocoder = new Geocoder(this);
        List<Address> addresses = null;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    public void getPGeo(String locationName)
    {
        try {
            addresses = geocoder.getFromLocationName(locationName, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (addresses != null && !addresses.isEmpty()) {
            Address address = addresses.get(0);
            latitude = address.getLatitude();
            longitude = address.getLongitude();
            Log.d("TAG", "Latitude: " + latitude + ", Longitude: " + longitude);
            LatLng markP = new LatLng(latitude, longitude);
        }
    }
    public void markP(GoogleMap googleMap)
    {
        LatLng markP = new LatLng(latitude, longitude);
        googleMap.addMarker(new MarkerOptions()
                .position(markP)
                .title("Marker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(markP));
    }

    public double calculatingDis()
    {
        double earthRadius = 3958.75;

        double dLat = Math.toRadians(lat1-lat2);
        double dLng = Math.toRadians(lng1-lng2);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(lat1)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = earthRadius * c;
    }
}

