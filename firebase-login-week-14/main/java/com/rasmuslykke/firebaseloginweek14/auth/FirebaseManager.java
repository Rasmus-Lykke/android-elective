package com.rasmuslykke.firebaseloginweek14.auth;

import android.view.View;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rasmuslykke.firebaseloginweek14.LoginActivity;

public class FirebaseManager {

    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private static FirebaseManager instance = new FirebaseManager();
    private FirebaseUser user;

    public FirebaseManager () {}

    public static FirebaseManager getInstance() {
        return instance;
    }

    public boolean isSignedIn(){
        user = auth.getCurrentUser();
        return user != null;
    }

    public void signIn(String email, String password, final LoginActivity activity) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            user = auth.getCurrentUser();
                            activity.startMainActivity();
                            System.out.println("Sign in success! " + task.getResult().getUser().getEmail());
                        } else {
                            user = null;
                            System.out.println("Sign in failed! " + task.getException());
                        }
                    }
                });
    }

    public void signOut(){
        user = null;
        auth.signOut();
    }

}
