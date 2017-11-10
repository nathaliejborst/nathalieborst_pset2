package com.example.nathalie.nathalieborst_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChooseStory extends AppCompatActivity {
    Story storyInstance;
    List<String> Texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_story);

        View decorView = getWindow().getDecorView();

        // lists of all texts
        Texts = new ArrayList<>(Arrays.asList("simple.txt", "tarzan.txt", "clothes.txt", "dance.txt", "university.txt"));
    }

    public void goToSimple (View view) {

        // initiate header
        String choice = Texts.get(0);

        try {
            // create a new inputstream for story
            InputStream is = getAssets().open(choice);

            // initiate a new Story
            storyInstance = new Story(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // pass inputstream of story to next activity
        Intent intent = new Intent(this, FillInPlaceholders.class);
        intent.putExtra("receivedHeader", choice);
        intent.putExtra("receivedText", storyInstance);
        startActivity(intent);

    }

    public void goToTarzan (View view) {

        String choice = Texts.get(1);

        try {
            // create a new inputstream for story
            InputStream is = getAssets().open(choice);

            // initiate a new Story
            storyInstance = new Story(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // pass inputstream of story to next activity
        Intent intent = new Intent(this, FillInPlaceholders.class);
        intent.putExtra("receivedHeader", choice);
        intent.putExtra("receivedText", storyInstance);
        startActivity(intent);

    }

    public void goToClothes (View view) {

        String choice = Texts.get(2);

        try {
            // create a new inputstream for story
            InputStream is = getAssets().open(choice);

            // initiate a new Story
            storyInstance = new Story(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // pass inputstream of story to next activity
        Intent intent = new Intent(this, FillInPlaceholders.class);
        intent.putExtra("receivedHeader", choice);
        intent.putExtra("receivedText", storyInstance);
        startActivity(intent);

    }

    public void goToDance (View view) {
        String choice = Texts.get(3);

        try {
            // create a new inputstream for story
            InputStream is = getAssets().open(choice);

            // initiate a new Story
            storyInstance = new Story(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // pass inputstream of story to next activity
        Intent intent = new Intent(this, FillInPlaceholders.class);
        intent.putExtra("receivedHeader", choice);
        intent.putExtra("receivedText", storyInstance);
        startActivity(intent);

    }

    public void goToUniversity (View view) {

        String choice = Texts.get(4);

        try {
            // create a new inputstream for story
            InputStream is = getAssets().open(choice);

            // initiate a new Story
            storyInstance = new Story(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // pass inputstream of story to next activity
        Intent intent = new Intent(this, FillInPlaceholders.class);
        intent.putExtra("receivedHeader", choice);
        intent.putExtra("receivedText", storyInstance);
        startActivity(intent);

    }

    public void goToRandom (View view) {

//        List<String> Texts = new ArrayList<String>(Arrays.asList("clothes.txt", "dance.txt", "simple.txt", "tarzan.txt", "university.txt"));
        int randomText = (int) (Math.random() * 5);
        String choice = Texts.get(randomText);

        try {
            // create a new inputstream for story
            InputStream is = getAssets().open(choice);

            // initiate a new Story
            storyInstance = new Story(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // pass inputstream of story to next activity
        Intent intent = new Intent(this, FillInPlaceholders.class);
        intent.putExtra("receivedHeader", choice);
        intent.putExtra("receivedText", storyInstance);
        startActivity(intent);

    }



}
