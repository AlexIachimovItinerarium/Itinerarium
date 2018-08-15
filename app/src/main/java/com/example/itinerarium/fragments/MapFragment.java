package com.example.itinerarium.fragments;

import com.example.itinerarium.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;

public class MapFragment extends Fragment {

  private MapView mapView;
  private GoogleMap googleMap;
  private AppBarLayout appBarLayout;
  private Toolbar toolbar;
  private Switch swithMapVisibility;
  private Switch swithLocationTracking;
  private TextView textViewMapVisibilityLabel;
  private TextView textViewLocationTrackerLabel;

  public static MapFragment newInstance() {
    Bundle args = new Bundle();
    MapFragment fragment = new MapFragment();
    fragment.setArguments(args);
    return fragment;
  }


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_map, container, false);

    setHasOptionsMenu(true);

    mapView = rootView.findViewById(R.id.mapView);
    appBarLayout = rootView.findViewById(R.id.appbar_lay);

    initToolbarViews(rootView);
    disableAppBarScrolling(true);
    initMapView(savedInstanceState);

    return rootView;
  }

  private void disableAppBarScrolling(final Boolean isDisableScrolling) {
    CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
    AppBarLayout.Behavior behavior = new AppBarLayout.Behavior();
    behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
      @Override
      public boolean canDrag(AppBarLayout appBarLayout) {
        if (isDisableScrolling) {
          return false;
        } else {
          return true;
        }
      }
    });
    params.setBehavior(behavior);
  }

  private void initToolbarViews(View rootView) {
    toolbar = rootView.findViewById(R.id.main_activity_toolbar);
    swithMapVisibility = rootView.findViewById(R.id.switchButtonDisableEnableMap);
    swithLocationTracking = rootView.findViewById(R.id.switchButtonDisableEnableTracking);
    textViewMapVisibilityLabel = rootView.findViewById(R.id.textViewDisableMap);
    textViewLocationTrackerLabel = rootView.findViewById(R.id.textViewDisableMapTracking);

    swithMapVisibility.setOnCheckedChangeListener(new OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
          appBarLayout.setExpanded(false, true);
          textViewMapVisibilityLabel.setText(R.string.enable_map);
        } else {
          appBarLayout.setExpanded(true, true);
          textViewMapVisibilityLabel.setText(R.string.disable_map);
        }
      }
    });

  }

  private void initMapView(Bundle savedInstanceState) {
    mapView.onCreate(savedInstanceState);

    mapView.onResume();

    try {
      MapsInitializer.initialize(getActivity().getApplicationContext());
    } catch (Exception e) {
      e.printStackTrace();
    }

    mapView.getMapAsync(new OnMapReadyCallback() {
      @Override
      public void onMapReady(GoogleMap mMap) {
        googleMap = mMap;

        // For showing a move to my location button
        //googleMap.setMyLocationEnabled(true);

        // For dropping a marker at a point on the Map
        LatLng sydney = new LatLng(-34, 151);
        googleMap.addMarker(new MarkerOptions().position(sydney)
          .title("Marker Title")
          .snippet("Marker Description"));

        // For zooming automatically to the location of the marker
        CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney)
          .zoom(12)
          .build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
      }
    });
  }

  @Override
  public void onResume() {
    super.onResume();
    mapView.onResume();
  }

  @Override
  public void onPause() {
    super.onPause();
    mapView.onPause();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mapView.onDestroy();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
  }
}
