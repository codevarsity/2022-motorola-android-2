package com.example.fragmentessentials;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    TextView messageTextView;
    Button sendToFirstButton;
    EditText messageToFirstEditText;

    public static Fragment newFragment(String message) {
        SecondFragment sf = new SecondFragment();

        //wrap the message in a bundle object so that it can be sent to second fragment
        Bundle bundle = new Bundle();
        bundle.putString("MESSAGE", message);
        sf.setArguments(bundle);
        return sf;
    }


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View secondFragmentView = inflater.inflate(R.layout.fragment_second, container, false);
        messageTextView = secondFragmentView.findViewById(R.id.messageTextView);

        //get access to the arguments bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            String message = bundle.getString("MESSAGE");
            if (message != null) {
                messageTextView.setText(message);
            }
        }

        messageToFirstEditText = secondFragmentView.findViewById(R.id.firstMessageEditText);

        sendToFirstButton = secondFragmentView.findViewById(R.id.sendToFirstButton);
        sendToFirstButton.setOnClickListener((view)-> {
            String message = messageToFirstEditText.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("MESSAGE", message);
            getTargetFragment().onActivityResult(101, Activity.RESULT_OK, intent);

            FragmentManager manager = getParentFragmentManager();
            manager.popBackStack();
        });

        return secondFragmentView;
    }
}