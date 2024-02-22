package com.example.shoppingmanagementapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppingmanagementapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAccount#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAccount extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentAccount() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAccount.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAccount newInstance(String param1, String param2) {
        FragmentAccount fragment = new FragmentAccount();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private String[] usernames = {"user1", "user2", "user3"};



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
        View view = inflater.inflate(R.layout.fragment_account, container, false);


        EditText usernameInput = view.findViewById(R.id.editTextTextusername);
        Button loginButton = view.findViewById(R.id.Loginfromacc);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = usernameInput.getText().toString();

                boolean isUsernameTaken = false;
                for (String username : usernames) {
                    if (username.equals(enteredUsername)) {
                        isUsernameTaken = true;
                        break;
                    }
                }

                if (isUsernameTaken) {
                    // Username is already taken, display an error message
                    Toast.makeText(getActivity(), "Username is already taken", Toast.LENGTH_SHORT).show();
                } else {
                    // Username is not taken, navigate to the other fragment
                    Bundle bundle = new Bundle();
                    bundle.putString("username", enteredUsername); // Pass the entered username
                    FragmentLogin fragmentLogin = new FragmentLogin();
                    fragmentLogin.setArguments(bundle);
                    Navigation.findNavController(view).navigate(R.id.action_fragmentAccount_to_fragmentLogin);
                }
            }
        });

        return view;
    }


    }