package com.fareez.mycv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NotaActivity extends AppCompatActivity {

    private List<String> tasks;
    private EditText taskEditText;
    private Button addButton;
    private TextView taskListTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        taskEditText = findViewById(R.id.taskEditText);
        addButton = findViewById(R.id.addButton);
        taskListTextView = findViewById(R.id.taskListTextView);

        tasks = loadTasksFromFile();
        updateTaskList();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskEditText.getText().toString().trim();
                if (!task.isEmpty()) {
                    tasks.add(task);
                    saveTasksToFile(tasks);
                    taskEditText.setText("");
                    updateTaskList();
                }
            }
        });
    }

    // Save a list of tasks to a file
    private void saveTasksToFile(List<String> tasks) {
        try {
            FileOutputStream fos = openFileOutput("tasks.txt", Context.MODE_PRIVATE);
            for (String task : tasks) {
                fos.write((task + "\n").getBytes());
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load tasks from a file
    private List<String> loadTasksFromFile() {
        List<String> tasks = new ArrayList<>();
        try {
            FileInputStream fis = openFileInput("tasks.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(line);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }


    private void updateTaskList() {
        StringBuilder taskList = new StringBuilder();
        for (String task : tasks) {
            taskList.append(task).append("\n");
        }
        taskListTextView.setText(taskList.toString());
    }
}