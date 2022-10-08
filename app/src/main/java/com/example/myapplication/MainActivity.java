package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    //private Button button;
    FirebaseAuth mAuth;

    //FOR RECYCLERVIEW



    ActivityMainBinding binding,binding2;

//    ConstraintLayout main_Attandance, main_TimeTable, main_Result, main_Event,cr;
//    ConstraintLayout main_Syllabus;
//    ConstraintLayout main_DateSheet, main_Gallery;
//    ConstraintLayout main_Faculty, main_Hostel;
//
//    //COLLEGECLUB VALUES
//    String[] cllg_club_heading,cllg_club_title;
//    int[] cllg_club_imageResourceId;
//    int[] cllg_club_background;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
        //FRAGMENT SWITCHING

        binding.bar.setOnItemSelectedListener(item ->{
            switch(item.getItemId()){
                case R.id.main_navbar_Home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.main_navbar_Alert:
                    replaceFragment(new AlertsFragment());
                    break;
                case R.id.main_navbar_settings:
                    replaceFragment(new SettingsFragment());
                    break;
                case R.id.main_navbar_profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });
        //button = findViewById(R.id.signoutbtn);
        mAuth = FirebaseAuth.getInstance();
        //cr = findViewById(R.id.main_syllabus);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//                startActivity(intent);
//            }
//        });
//        cr.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Syllabus", Toast.LENGTH_SHORT).show();
//            }
//        });
        //RECYCLERVIEW
//        recyclerView = findViewById(R.id.main_collegeclub_recyclerview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
//        recyclerView.setHasFixedSize(true);
//
//        circle1ArrayList = new ArrayList<mainCircleCLASS>();
//        AdapterCircle = new mainCircleADAPTER(this,circle1ArrayList);
//        recyclerView.setAdapter(AdapterCircle);
//
//        cllg_club_heading = new String[]{
//          "GFG Chapters", "GDSC", "Aayam",
//        };
//        cllg_club_title = new String[]{
//                "Technical Club","Technical Club","Cultural Club"
//        };
//        cllg_club_imageResourceId = new int[]{
//            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d
//        };
//        cllg_club_background = new int[]{
//                R.drawable.main_faculty_bgnd, R.drawable.main_hostle_bgnd, R.drawable.main_datesheet_bgnd, R.drawable.main_gallery_bgnd
//        };
        //getData();
//        binding.bar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch(view.getId()){
//                    case R.id.github:
//                        Toast.makeText(MainActivity.this, "Git", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.code:
//                        Toast.makeText(MainActivity.this, "Code", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.kit:
//                        Toast.makeText(MainActivity.this, "Kit", Toast.LENGTH_SHORT).show();
//                        break;
//
//                }
//            }
//        });
    }

//    private void getData() {
//        //Log.d("Check", String.valueOf(heading.length));
//        for(int i=0 ; i< cllg_club_heading.length ; i++){
//            //mainCircleCLASS circleclass = new mainCircleCLASS(heading[i],imageResourceId[i]);
//            Log.d("Check", String.valueOf(i));
//            circle1ArrayList.add(new mainCircleCLASS(cllg_club_heading[i],cllg_club_title[i],cllg_club_imageResourceId[i]));
//            //Log.d("Check", String.valueOf(circle1ArrayList.get(heading)));
//        }
//        AdapterCircle.notifyDataSetChanged();
//    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user == null){
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }
    }

    //FOR REPLACING FRAGMENT
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransition = fragmentManager.beginTransaction();
        fragmentTransition.replace(R.id.main_frameLayout,fragment);
        fragmentTransition.commit();
    }

//    public void onClick(View view){
//        switch(view.getId()){
//            case R.id.github:
//                Toast.makeText(this, "Github", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.code:
//                Toast.makeText(this, "Code", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.kit:
//                Toast.makeText(this, "Kit", Toast.LENGTH_SHORT).show();
//                break;
//
//        }
//    }
}