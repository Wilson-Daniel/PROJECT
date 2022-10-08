package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ADAPTER.mainCircleADAPTER;
import com.example.myapplication.AdapterCLASS.mainCircleCLASS;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@java.lang.SuppressWarnings("ALL")
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String[] cllg_club_heading,cllg_club_title;
    int[] cllg_club_imageResourceId;
    int[] cllg_club_background;
    ArrayList<mainCircleCLASS> circle1ArrayList;
    mainCircleADAPTER AdapterCircle;
    RecyclerView recyclerView;

    ConstraintLayout home_attendence, home_timeTable, home_result, home_events;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        recyclerView = view.findViewById(R.id.main_collegeclub_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);
        AdapterCircle = new mainCircleADAPTER(getContext(),circle1ArrayList);
        recyclerView.setAdapter(AdapterCircle);
        AdapterCircle.notifyDataSetChanged();

        home_attendence = view.findViewById(R.id.home_attendence);
        home_events = view.findViewById(R.id.home_events);
//        home_result = view.findViewById(R.id.home_result);
//        home_timeTable = view.findViewById(R.id.home_timeTable);

        home_attendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new AttendanceFragment());
            }
        });
        home_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "jjjj", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getData() {
        circle1ArrayList = new ArrayList<mainCircleCLASS>();
        cllg_club_heading = new String[]{
          "GFG Chapters", "GDSC", "Aayam",
        };
        cllg_club_title = new String[]{
                "Technical Club","Technical Club","Cultural Club"
        };
        cllg_club_imageResourceId = new int[]{
            R.drawable.main_recyc_gfg,R.drawable.main_recyc_gdsc,R.drawable.c,R.drawable.d
        };
        cllg_club_background = new int[]{
                R.drawable.main_faculty_bgnd, R.drawable.main_hostle_bgnd, R.drawable.main_datesheet_bgnd, R.drawable.main_gallery_bgnd
        };
        //Log.d("Check", String.valueOf(heading.length));
        for(int i=0 ; i< cllg_club_heading.length ; i++){
            //mainCircleCLASS circleclass = new mainCircleCLASS(heading[i],imageResourceId[i]);
//            Log.d("Check", String.valueOf(i));
            circle1ArrayList.add(new mainCircleCLASS(cllg_club_heading[i],cllg_club_title[i],cllg_club_imageResourceId[i]));
            //Log.d("Check", String.valueOf(circle1ArrayList.get(heading)));
        }

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransition = fragmentManager.beginTransaction();
        fragmentTransition.replace(R.id.home_framelayout,fragment);
        fragmentTransition.commit();
    }
}