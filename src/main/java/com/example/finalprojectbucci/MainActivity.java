package com.example.finalprojectbucci;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.net.*; //enables google maps URi

import androidx.appcompat.app.AppCompatActivity;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;


public class MainActivity extends AppCompatActivity {

    Button directionsButton; //declares button object for the directions button

    Button aboutUsButton;//declares button for About us
    ImageButton aboutUsImageButton; //declares image button for About Us
    ImageButton locateImageButton; //declares image button for locate
    SwipeButton directions; //declares swipebutton for getting directions (locate -- HUGO TODO make directions/locate the same nam e
    SwipeButton aboutUs;

    /**the below SwipeButtons are placeholders, necessary only to get the application to run correctly and crash.*/
    SwipeButton catering;
    SwipeButton reservations;
    SwipeButton mixer;
    SwipeButton counter;
    SwipeButton ordering;
    SwipeButton menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creates the action for when the user swipes the arrow from left to right
        directions = (SwipeButton) findViewById(R.id.buttonGetDirections); //gets the directions button ID from the xml
        directions.setOnStateChangeListener(new OnStateChangeListener() { //state change means the user interacted with the button
            @Override
            public void onStateChange(boolean active) {

                /**when the user swipes "get directions", they are transferred to the Google Maps app, where it will ask them to enable location services.
                 * (note -- this should work on your emulator)
                 * Since the emulator location is at the google offices, and Ace Restaurant is in philly (by my design),
                 * google maps SHOULD show a cross country trip.
                */
                String uri = String.format("http://maps.google.com/maps?daddr=%f,%f (%s)", 39.952583, -75.165222, "Ace Restaurant");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);

            }
        });
        //creates the action for when the user swipes the arrow from left to right for the about us slection
        aboutUs = (SwipeButton) findViewById(R.id.aboutUsButton) ;
        aboutUs.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {

                openAboutUsPage();

            }
        });

        /**
         * These next instances are purely placeholders. The swipe button logic will not work without having a swipebutton created
         * for the particular R.id.button. These lead nowhere, but are necessary for functionality.
         **/

        reservations = (SwipeButton) findViewById(R.id.buttonReservations);
        reservations.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {

                //NULL
            }
        });

        mixer = (SwipeButton) findViewById(R.id.buttonMixer);
        mixer.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                //NULL
            }
        });

        catering = (SwipeButton) findViewById(R.id.buttonCatering);
        catering.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                //NULL
            }
        });

        counter = (SwipeButton) findViewById(R.id.buttonCount);
        counter.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                //NULL
            }
        });

        ordering = (SwipeButton) findViewById(R.id.buttonOrder);
        ordering.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                //NULL
            }
        });

        menu = (SwipeButton) findViewById(R.id.buttonMenu);
        menu.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                //NULL
            }
        });

        /** END NULL SWIPE BUTTONS**/



        //Image buttons to enable onclick activities

        //aboutUs
        //sets the above declared variable aboutUsImageButton equal to an image button then provides the xml id to associate it with
        aboutUsImageButton = (ImageButton) findViewById(R.id.imageButtonAboutUs);
        aboutUsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutUsPage();
            }
        }); //opens up the about us page method

        //Get directions (locate)
        locateImageButton = (ImageButton) findViewById(R.id.imageButtonLocate); //finds the locate button by its xml id
        locateImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**when the user presses "locate", they are transferred to the Google Maps app, where it will ask them to enable location services.
                 * (note -- this should work on your emulator)
                 * Since the emulator location is at the google offices, and Ace Restaurant is in philly (by my design),
                 * google maps SHOULD show a cross country trip.
                 */
                String uri = String.format("http://maps.google.com/maps?daddr=%f,%f (%s)", 39.952583, -75.165222, "Ace Restaurant");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);

            }
        }); //set an onclick listener that points to the openDirectionsPage method

    }



    //method which opens the About us Page
    public void openAboutUsPage(){
        //create an intent
        Intent aboutUsIntent = new Intent(this, AboutUs.class); //or getApplicationContext();?
        startActivity(aboutUsIntent);//starts the intent created to open the About Us Class

    }

    //TODO delete
    //method which opens the Locate.java class (get directions)
    public void openLocatePage(){
        //create an intent
        Intent locateIntent = new Intent(this, Locate.class);
        startActivity(locateIntent); //enables the intent (opens the locate page)
    }
}
