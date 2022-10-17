package com.example.myapplication.SETTINGS;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UploadTTData#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UploadTTData extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText Upload_year, Upload_branch, Upload_section, Upload_Date, Upload_Day, Upload_Time, Upload_SubjectName, Upload_TeacherName;
    ImageView Upload_select_year, Upload_select_branch, Upload_select_section, Upload_select_date,  Upload_select_Day
            , Upload_select_Time, Upload_select_subjectName, Upload_select_TeacherName;

    public UploadTTData() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UploadTTData.
     */
    // TODO: Rename and change types and number of parameters
    public static UploadTTData newInstance(String param1, String param2) {
        UploadTTData fragment = new UploadTTData();
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
        return inflater.inflate(R.layout.fragment_upload_t_t_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Upload_year = view.findViewById(R.id.upload_year);
        Upload_branch = view.findViewById(R.id.upload_branch);
        Upload_section = view.findViewById(R.id.upload_section);
        Upload_Day = view.findViewById(R.id.upload_Day);
        Upload_Time = view.findViewById(R.id.upload_Time);
        Upload_SubjectName = view.findViewById(R.id.upload_SubjectName);
        Upload_TeacherName = view.findViewById(R.id.upload_teacherName);

        Upload_select_year = view.findViewById(R.id.upload_year_select);
        Upload_select_branch = view.findViewById(R.id.upload_branch_select);
        Upload_select_section = view.findViewById(R.id.upload_section_select);
        Upload_select_Day = view.findViewById(R.id.upload_Day_select);
        Upload_select_Time = view.findViewById(R.id.upload_Time_select);
        Upload_select_subjectName = view.findViewById(R.id.upload_SubjectName_select);
        Upload_select_TeacherName = view.findViewById(R.id.upload_teacherName_select);

        Upload_select_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectYear();
            }
        });
    }

    public void selectYear(){
        AlertDialog.Builder yearalert = new AlertDialog.Builder(getActivity());
        yearalert.setTitle("Select Year");
        yearalert.setPositiveButton("Ok",null);
        yearalert.setNeutralButton("Cancel",null);
        String[] item = {"1st", "2nd", "3rd", "4th"};
        yearalert.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Upload_year.setText(String.valueOf(item[i]));
            }
        });
        yearalert.show();
    }
    public void selectbranch(){
        AlertDialog.Builder branchalert = new AlertDialog.Builder(getActivity());
        branchalert.setTitle("Select Branch");
        branchalert.setPositiveButton("Ok",null);
        branchalert.setNeutralButton("Cancel",null);
        String[] item = {"CSE", "AI", "DS", "IOT", "IT"};
        branchalert.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Upload_branch.setText(String.valueOf(item[i]));
            }
        });
        branchalert.show();
    }
    public void selectsection(){
        AlertDialog.Builder sectionalert = new AlertDialog.Builder(getActivity());
        sectionalert.setTitle("Select Section");
        sectionalert.setPositiveButton("Ok",null);
        sectionalert.setNeutralButton("Cancel",null);
        String[] item = {"A", "B", "C"};
        sectionalert.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Upload_section.setText(String.valueOf(item[i]));
            }
        });
        sectionalert.show();
    }
    public void selectday(){
        AlertDialog.Builder dayalert = new AlertDialog.Builder(getActivity());
        dayalert.setTitle("Select Day");
        dayalert.setPositiveButton("Ok",null);
        dayalert.setNeutralButton("Cancel",null);
        String[] item = {"Monday", "Tuesday", "Wednesday", "Thrusday", "Friday"};
        dayalert.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Upload_Day.setText(String.valueOf(item[i]));
            }
        });
        dayalert.show();
    }
    public void selecttime(){
        AlertDialog.Builder yearalert = new AlertDialog.Builder(getActivity());
        yearalert.setTitle("Select Time");
        yearalert.setPositiveButton("Ok",null);
        yearalert.setNeutralButton("Cancel",null);
        String[] item = {"9 am", "9:50 am", "10:40 am", "11:30 am", ""};
        yearalert.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Upload_year.setText(String.valueOf(item[i]));
            }
        });
        yearalert.show();
    }
    public void selectsubjectName(){
        AlertDialog.Builder yearalert = new AlertDialog.Builder(getActivity());
        yearalert.setTitle("Select Year");
        yearalert.setPositiveButton("Ok",null);
        yearalert.setNeutralButton("Cancel",null);
        String[] item = {"1st", "2nd", "3rd", "4th"};
        yearalert.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Upload_year.setText(String.valueOf(item[i]));
            }
        });
        yearalert.show();
    }
    public void selectsubjectTeacher(){
        AlertDialog.Builder yearalert = new AlertDialog.Builder(getActivity());
        yearalert.setTitle("Select Year");
        yearalert.setPositiveButton("Ok",null);
        yearalert.setNeutralButton("Cancel",null);
        String[] item = {"1st", "2nd", "3rd", "4th"};
        yearalert.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Upload_year.setText(String.valueOf(item[i]));
            }
        });
        yearalert.show();
    }

}