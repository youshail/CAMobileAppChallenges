package com.example.camobileappchallenges

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*

   This is a normal class that will inherit from application
   to give dagger hilt the information about our application
   also we need to add this to our androidManifest
 */

@HiltAndroidApp
class AccountApplication : Application()