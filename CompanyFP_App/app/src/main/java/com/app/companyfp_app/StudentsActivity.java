package com.app.companyfp_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.app.companyfp_app.adapter.StudentAdapter;
import com.app.companyfp_app.model.Student;
import com.app.companyfp_app.retrofit.WebService;
import com.app.companyfp_app.retrofit.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class StudentsActivity extends AppCompatActivity {

    private Retrofit mRestAdapter;

    private WebService mWebService;

    private RecyclerView rvStudents;
    private StudentAdapter adapter;

    private List<User> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add_student);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.fab_add_student: {
                        showAddStudentDialog();
                        break;
                    }
                }
            }
        });


        // Crear adaptador Retrofit
        mRestAdapter = new Retrofit.Builder()
                .baseUrl(WebService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // Crear conexión a los Web Service
        mWebService = mRestAdapter.create(WebService.class);

        Call<List<User>> loginCall = mWebService.listStudents();

        loginCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                // Procesar errores
                if (!response.isSuccessful()) {
                    showError("Ha ocurrido un error. Contacte al administrador");
                    return;
                }
                showStudents(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                showError(t.getMessage());
            }
        });

        initRecyclerListener();
    }


    private void initRecyclerListener() {
        rvStudents = (RecyclerView) findViewById(R.id.rv_students);
        rvStudents.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvStudents.setItemAnimator(new DefaultItemAnimator());

        ItemTouchHelper swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override

            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        swipeToDismissTouchHelper.attachToRecyclerView(rvStudents);
    }


    private void showAddStudentDialog() {
        final StudentAddDialog dialog = new StudentAddDialog();
        dialog.show(getSupportFragmentManager(), dialog.getClass().getName());
        dialog.setListener(new StudentAddDialog.OnAddStudentClickListener() {
            @Override
            public void onAddStudentClickListener(Student student) {
                dialog.dismiss();
                showStudents(students);
            }
        });
    }

    public void showStudents(List<User> students) {
        this.students = students;
        adapter = new StudentAdapter(students);
        rvStudents.setAdapter(adapter);
    }


    private void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

}
