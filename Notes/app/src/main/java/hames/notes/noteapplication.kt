package hames.notes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//application is the top level class the project can hold
@HiltAndroidApp//gives hilt access to the entire application
//now hilt can supply dependencies to any part of the app
class noteapplication : Application() {

}