package com.app.companyfp_app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.companyfp_app.R;
import com.app.companyfp_app.retrofit.User;

import java.util.List;

/**
 * Created by roma on 03.11.15.
 */
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<User> students;

    public StudentAdapter(List<User> students) {
        this.students = students;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        holder.tvName.setText(students.get(position).getName());
        //String email = SimpleRealmApp.getInstance().getString(R.string.email) + " " + students.get(position).getEmail();
        //holder.tvEmail.setText(email);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvEmail;

        public StudentViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tv_student_name);
            tvEmail = (TextView) itemView.findViewById(R.id.tv_email);
        }
    }

}
