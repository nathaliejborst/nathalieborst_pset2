package com.example.nathalie.nathalieborst_pset2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FillInPlaceholders extends AppCompatActivity {
    Story simpel;
    TextInputEditText editText;
    String placeholderword;
    Button submitButton;
    ProgressBar progressBar;
    int placeholders, remainingPlaceholders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_in_placeholders);


        // get story instance intent from main activity
        Intent intent = getIntent();
        String storyTitle = intent.getStringExtra("receivedHeader");
        storyTitle = storyTitle.replace(".txt", "");
        simpel = (Story) intent.getSerializableExtra("receivedText");

        // set header to name of chosen story
        TextView header = (TextView) findViewById(R.id.storyChoice);
        header.setText(storyTitle);

        // get amount of placeholders in text
        placeholders = simpel.getPlaceholderCount();
        remainingPlaceholders = 0;

        // get word to fill in placeholder
        placeholderword = simpel.getNextPlaceholder();

        // set hint to next placeholder
        editText = (TextInputEditText) findViewById(R.id.placeholderInput);
        editText.setHint(placeholderword);


        submitButton = (Button) findViewById(R.id.submitButton);

        // initialize progressbar
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(placeholders);

    }

    public void submitPlaceholder(View view) {

        // initialize string for story
        String text;

        // convert entered word into string
        String enteredWord = editText.getText().toString();

        // make sure user enters only one word
        if (enteredWord.contains(" ")) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.setMessage("please fill in only one word");
            alertDialog.show();
        } else {

            // make sure user enters a word
            if (enteredWord.equals("")) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setMessage("please fill in a word");
                alertDialog.show();
            } else {

                String word = "< " + enteredWord + " >";

                // fill in placeholder in text
                simpel.fillInPlaceholder(word);

                // clear inputvalue
                editText.setText("");

                // set hint to next placeholder
                editText.setHint(simpel.getNextPlaceholder());

                // keeps track of progress filling in the words
                remainingPlaceholders = simpel.getPlaceholderRemainingCount();
                int progressing = placeholders - (remainingPlaceholders);
                progressBar.setProgress(progressing);

                if (remainingPlaceholders == 1) {

                    submitButton.setText("Show story");

                }


                // redirects to filled in story if all placeholders have been filled in
                if (simpel.isFilledIn()) {

                    // get story
                    text = simpel.toString();

                    Intent intent = new Intent(this, PrintStory.class);
                    intent.putExtra("receivedStory", text);
                    startActivity(intent);
                }
            }

        }
    }
}
