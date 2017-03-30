
package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JokesTO {

    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Credit")
    @Expose
    private String credit;
    @SerializedName("Jokes")
    @Expose
    private List<Joke> jokes = null;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public List<Joke> getJokes() {
        return jokes;
    }

    public void setJokes(List<Joke> jokes) {
        this.jokes = jokes;
    }

}
