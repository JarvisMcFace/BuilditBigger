package com.udacity.gradle.builditbigger.backend;

import com.example.Joke;

/**
 * Created by David on 3/26/17.
 */

public class JokeBean {

    Joke joke;


    public JokeBean(Joke joke) {
        this.joke = joke;
    }

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }
}
