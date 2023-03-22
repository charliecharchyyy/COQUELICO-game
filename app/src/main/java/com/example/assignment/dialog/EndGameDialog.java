package com.example.assignment.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.assignment.R;

import org.w3c.dom.Text;

public class EndGameDialog extends Dialog {
    public EndGameDialog(@NonNull Context context,int level) {
        super(context);
        setContentView(R.layout.endgame_dialog);
        TextView textLevel = findViewById(R.id.textLevel);
        textLevel.setText(""+level);
    }
}
