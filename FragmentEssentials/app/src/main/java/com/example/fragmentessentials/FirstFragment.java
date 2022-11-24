package com.example.fragmentessentials;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FirstFragment extends Fragment {

    Button secondButton;
    EditText messageEditText;
    TextView messageFromSecondTextView;

    //fragment must have a default constructor
    public FirstFragment() {

    }

    //we don't inflate the layout for the fragment in the onCreate
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View secondFragmentView = inflater.inflate(R.layout.fragment_first, container, false);
        messageFromSecondTextView = secondFragmentView.findViewById(R.id.messageFromSecondTextView);
        messageEditText = secondFragmentView.findViewById(R.id.messageEditText);
        secondButton = secondFragmentView.findViewById(R.id.secondButton);
        secondButton.setOnClickListener((view)-> {

            //read the message on the editext
            String message = messageEditText.getText().toString();

            /*Load the second fragment*/
            FragmentManager manager = getParentFragmentManager();

            Fragment sf = SecondFragment.newFragment(message);

            //set the first fragment (this) as a target of the second fragment
            sf.setTargetFragment(this, 101);

            manager.beginTransaction()
                    .remove(this)
                    .add(R.id.mainLayout, sf, "SF")
                    .addToBackStack(null)
                    .commit();

        });
        return secondFragmentView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 101 && resultCode == MainActivity.RESULT_OK && data != null) {
            String message = data.getStringExtra("MESSAGE");
            messageFromSecondTextView.setText(message);
        }
    }
}
