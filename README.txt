CREATED BY: Daniel Victor Alexander Gilder

INTRODUCTION:

    -This project is a Recipe App that allows users to save and view the best recommendations for food recipes.
    -The app was developed in the Java programming language with the Android SDK on Android Studio.

    -Application Specification:
        1. Multiple Pages: COMPLETED
            A. Recommended Recipes Page (MainActivity.java)
            B. Saved Recipes Page (SavedRecipes.java)
            C. Recipe Page (RecipePage.java)
            D. Saved Recipe Page (SavedItem.java)

        2. Both Explicit and Implicit Intent: COMPLETED
            A. Explicit Intent Example: When the user switches between menu pages or from the recommended recipes to a specific clicked recipe
            B. Implicit Intent Example: There is only 1 case of implicit intents in this application,  when the user clicks on the View full details button
               on the recipe page this takes the user to a webpage in the devices browser application.

        3. Has Menu(s) : COMPLETED
            -There is a menu button in the top right corner of the Recommended Recipes (MainActivity) and SavedRecipes page, this allows
             users to navigate between the 2 pages.

        4. Use RecyclerView: COMPLETED
            -A RecyclerView is utilised on both the Recommended Recipes page (MainActivity) and SavedRecipes page, to allow the user
             to scroll through the options.

        5. Use Data storage: COMPLETED
            -For Data storage the app employs Firebase, an open source Google backend noSQL database system.

        6. Use Internet: COMPLETED
            -This application has 2 instances of networking operations
            A. When the application fetches images of recipe URLs to display in the activities and loads webpages from URLs.
            B. The 2nd instance is when the application requests the databases document objects  and sends it over the internet
               to be displayed on the UI.


DESIGN RATIONALE:

    -Layout:


    -Storage:
        The plan for the original design was to utilise the SharedPreferences for this prototype project. However in the implementation phase
        of the development process issues with creating and accessing SharedPreferences arose that couldn't be resolved. So an alternative solution for storage
        handling was to use an external database, Firebase. Not only did this work but this was a much more realistic method for storing recipe data
        as in the real if there thousands of recipes, storing all that data in the SharedPreferences would have expended the devices
        system resources and performance. In addition. It wouldn't have made sense to store data in shared preferences because how would new
        recipes be recommended to the user in the future.

        My reason for choosing SharedPreferences storage at the start was simply due to simplicity and to speed up the development process for the project deadline.



CHALLENGES FACED:



FUTURE IMPROVEMENTS:

    -Errors and Bugs:

    -Design Improvements:
        1. Remove the View Recipe Button from the recycler views, this button isn't necessary as users can access the recipe page
            just by clicking the recycler view item. Not only does this reduce code clutter but also created the screen overall visually clearer
            and more aesthetic.



    -Potential features to add:
        1. Login/Sign Up system, this could allow users to access there favourite recipes from any device.
        2. A feature that allows users to enter their food preferences and/or dietary requirements
           which would allow for better recipe recommendations.
        3. With the new current trend of AI technology in 2023, a possible feature could be to train a machine learning model
           to generate recipes using openAIs Davinci model and then hook up this functionality to the apps interface and database
           to allow users to develop custom AI generated recipes using an API.