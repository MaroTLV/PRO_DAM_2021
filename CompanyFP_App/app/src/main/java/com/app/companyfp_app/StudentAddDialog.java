package com.app.companyfp_app;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.app.companyfp_app.model.Student;

import java.util.Date;

/**
 * Created by SERGIO on 04/04/2021.
 */

public class StudentAddDialog extends DialogFragment implements View.OnClickListener {
    private EditText etName, etEmail;
    private Date date;
    private Button btAdd;

    private OnAddStudentClickListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AlertDialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.student_add_dialog, container);
        initComponents(view);
        return view;
    }

    private void initComponents(View view) {
        etName = (EditText) view.findViewById(R.id.et_name);
        etEmail = (EditText) view.findViewById(R.id.et_email);
        btAdd = (Button) view.findViewById(R.id.bt_add);
        etName.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        btAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add: {
                if (isUserInfoValidate()) {
                    Student student = new Student();
                    student.setName(etName.getText().toString());
                    student.setEmail(etEmail.getText().toString());
                    listener.onAddStudentClickListener(student);
                }
                break;
            }
        }
    }

    private boolean isUserInfoValidate() {
        return !etName.getText().toString().isEmpty() &&
                !etEmail.getText().toString().isEmpty();
    }

    public void setListener(OnAddStudentClickListener listener) {
        this.listener = listener;
    }

    public interface OnAddStudentClickListener {
        void onAddStudentClickListener(Student student);
    }
}
