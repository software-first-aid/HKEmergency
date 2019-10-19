package com.example.hkemergency;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback
{
    private GoogleMap gMap;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_maps);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById( R.id.map );
        if (mapFragment != null) {
            mapFragment.getMapAsync(this );
        }
    }


    // Include the OnCreate() method here too, as described above.
    @Override
    public void onMapReady( GoogleMap googleMap )
    {
        gMap = googleMap;
        LatLng markerPos = new LatLng(48, 2 );
        googleMap.addMarker( new MarkerOptions().position( markerPos )
                .title( "Police nearby" ) );
        googleMap.moveCamera( CameraUpdateFactory.newLatLng( markerPos ) );
    }
}
