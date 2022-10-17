package com.example.myapplication.SETTINGS;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Classes.TimeTableData;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    Button upload_submit;
    String Year, Branch, Section, Date, Day, Time, SubjectName, TeacherName;
    FirebaseDatabase D1;
    DatabaseReference D1reference;

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

        upload_submit = view.findViewById(R.id.upload_submit);

        Upload_select_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectYear();
            }
        });
        Upload_select_branch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectbranch();
            }
        });
        Upload_select_section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectsection();
            }
        });
        Upload_select_Day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectday();
            }
        });
        Upload_select_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selecttime();
            }
        });
        Upload_select_subjectName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectsubjectName();
            }
        });
        Upload_select_TeacherName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectsubjectTeacher();
            }
        });

        upload_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Year = Upload_year.getText().toString();
                Branch = Upload_branch.getText().toString();
                Section = Upload_section.getText().toString();
                Day = Upload_Day.getText().toString();
                Time = Upload_Time.getText().toString();
                SubjectName = Upload_SubjectName.getText().toString();
                TeacherName = Upload_TeacherName.getText().toString();
                TimeTableData TimeTable = new TimeTableData(Year,Branch, Section, Day, Time, SubjectName, TeacherName);
                D1 = FirebaseDatabase.getInstance();
                D1reference = D1.getReference("ABESIT");
                D1reference.child("TIMETABLE").child(Year).child(Branch).child(Section).child(Day).child(Time).child(SubjectName).setValue(TimeTable).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getActivity(), "Succesfully Updated", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }

    public void selectYear(){
        AlertDialog.Builder yearalert = new AlertDialog.Builder(getActivity());
        yearalert.setTitle("Select Year");
        //yearalert.setPositiveButton("Ok",null);
        yearalert.setNeutralButton("Cancel",null);
        String[] item = {"1st", "2nd", "3rd", "4th"};
        yearalert.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Upload_year.setText(String.valueOf(item[i]));
                dialogInterface.dismiss();
            }
        });
        yearalert.show();
    }
    public void selectbranch(){
        AlertDialog.Builder branchalert = new AlertDialog.Builder(getActivity());
        branchalert.setTitle("Select Branch");
        //branchalert.setPositiveButton("Ok",null);
        branchalert.setNeutralButton("Cancel",null);
        String[] item = {"CSE", "AI", "DS", "IOT", "IT"};
        branchalert.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Upload_branch.setText(String.valueOf(item[i]));
                dialogInterface.dismiss();
            }
        });
        branchalert.show();
    }
    public void selectsection(){
        AlertDialog.Builder sectionalert = new AlertDialog.Builder(getActivity());
        sectionalert.setTitle("Select Section");
        //sectionalert.setPositiveButton("Ok",null);
        sectionalert.setNeutralButton("Cancel",null);
        String[] item = {"A", "B", "C"};
        sectionalert.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Upload_section.setText(String.valueOf(item[i]));
                dialogInterface.dismiss();
            }
        });
        sectionalert.show();
    }
    public void selectday(){
        AlertDialog.Builder dayalert = new AlertDialog.Builder(getActivity());
        dayalert.setTitle("Select Day");
        //dayalert.setPositiveButton("Ok",null);
        dayalert.setNeutralButton("Cancel",null);
        String[] item = {"Monday", "Tuesday", "Wednesday", "Thrusday", "Friday"};
        dayalert.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Upload_Day.setText(String.valueOf(item[i]));
                dialogInterface.dismiss();
            }
        });
        dayalert.show();
    }
    public void selecttime(){
        AlertDialog.Builder timealert = new AlertDialog.Builder(getActivity());
        timealert.setTitle("Select Time");
        //timealert.setPositiveButton("Ok",null);
        timealert.setNeutralButton("Cancel",null);
        String[] item = {"9 am", "9:50 am", "10:40 am", "11:30 am", "12:30 pm", "1:20 pm", "2:10 pm", "3:00 pm", "3:50 pm", "4:40 pm"};
        timealert.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Upload_Time.setText(String.valueOf(item[i]));
                dialogInterface.dismiss();
            }
        });
        timealert.show();
    }
    public void selectsubjectName(){
        AlertDialog.Builder subNamealert = new AlertDialog.Builder(getActivity());
        subNamealert.setTitle("Select Year");
        //subNamealert.setPositiveButton("Ok",null);
        subNamealert.setNeutralButton("Cancel",null);
        String year = String.valueOf(Upload_year.getEditableText());
        String[] item = new String[3];
        if(year.equals("1st")){
            item[0] = "1st";
            item[1] = "1st";
            item[2] = "1st";
        }else if(year.equals("2nd")){
            //item[0] = null;
            item[0] = "2st";
            item[1] = "2st";
            item[2] = "2st";
        } else if (year.equals("3rd")) {
            item[0] = "3st";
            item[1] = "3st";
            item[2] = "3st";
        }else{
            item[0] = "4st";
            item[1] = "4st";
            item[2] = "4st";
        }

        subNamealert.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Upload_SubjectName.setText(item[i]);
                dialogInterface.dismiss();
            }
        });

        subNamealert.show();
    }
    public void selectsubjectTeacher(){
        AlertDialog.Builder teacheralert = new AlertDialog.Builder(getActivity());
        teacheralert.setTitle("Select Teacher");
        //teacheralert.setPositiveButton("Ok",null);
        teacheralert.setNeutralButton("Cancel",null);
        String year1 = String.valueOf(Upload_year.getEditableText());
        String[] Titem = new String[3];
        if(year1.equals("1st")){
            Titem[0] = "1st";
            Titem[1] = "1st";
            Titem[2] = "1st";
        }else if(year1.equals("2nd")){
            Titem[0] = "2st";
            Titem[1] = "2st";
            Titem[2] = "2st";
        } else if (year1.equals("3rd")) {
            Titem[0] = "3st";
            Titem[1] = "3st";
            Titem[2] = "3st";
        }else{
            Titem[0] = "4st";
            Titem[1] = "4st";
            Titem[2] = "4st";
        }
        teacheralert.setSingleChoiceItems(Titem, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Upload_TeacherName.setText(String.valueOf(Titem[i]));
                dialogInterface.dismiss();
            }
        });
        teacheralert.show();
    }

}