package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("F8iNvpJuD1mkfH3H9Ign3M02UaYfcI5bH6j9OvNc")
                .clientKey("NB2XFaQCkVotg38MwEM9516dGvPTcQ0LLhoYU9mK")
                .server("https://parseapi.back4app.com")
                .build()
        );


    }
}
