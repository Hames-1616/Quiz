package com.news.Components

import com.news.R
import com.news.news

object mockdata {
    val topnewslist = listOf<newsdata>(
        newsdata(
            2,
            R.drawable.back,
            "Haamid",
            "Senior android developer",
            "some cascual news about the world",
            "2022-11-15 5:12PM"
        ),
        newsdata(
            3,
            R.drawable.back2,
            "Haamid",
            "Senior android developer",
            "some cascual news about the world",
            "2022-11-15 5:12PM"
        ),
        newsdata(
            4,
            R.drawable.back3,
            "Haamid",
            "Senior android developer",
            "some cascual news about the world",
            "2022-11-15 5:12PM"
        ),
        newsdata(
            5,
            R.drawable.back4,
            "Haamid",
            "Senior android developer",
            "some cascual news about the world",
            "2022-11-15 5:12PM"
        ),
        newsdata(
            6,
            R.drawable.back,
            "Haamid",
            "Senior android developer",
            "onClick: () -> Unit \t\n" +
                    "\n" +
                    "called when this FAB is clicked\n" +
                    "modifier: Modifier = Modifier \t\n" +
                    "\n" +
                    "the Modifier to be applied to this FAB\n" +
                    "shape: Shape = FloatingActionButtonDefaults.shape \t\n" +
                    "\n" +
                    "defines the shape of this FAB's container and shadow (when using elevation)\n" +
                    "containerColor: Color = FloatingActionButtonDefaults.containerColor \t\n" +
                    "\n" +
                    "the color used for the background of this FAB. Use Color.Transparent to have no color.\n" +
                    "contentColor: Color = contentColorFor(containerColor) \t\n" +
                    "\n" +
                    "the preferred color for content inside this FAB. Defaults to either the matching content color for containerColor, or to the current LocalContentColor if containerColor is not a color from the theme.\n" +
                    "elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation() \t\n" +
                    "\n" +
                    "FloatingActionButtonElevation used to resolve the elevation for this FAB in different states. This controls the size of the shadow below the FAB. Additionally, when the container color is ColorScheme.surface, this controls the amount of primary color applied as an overlay. See also: Surface.\n" +
                    "interactionSource: MutableInteractionSource = remember { MutableInteractionSource() } \t\n" +
                    "\n" +
                    "the MutableInteractionSource representing the stream of Interactions for this FAB. You can create and pass in your own remembered instance to observe Interactions and customize the appearance / behavior of this FAB in different states.\n" +
                    "content: @Composable () -> Unit \t\n" +
                    "\n" +
                    "the content of this FAB, typically an Icon",
            "2022-11-15 5:12PM"
        ),


    )

    fun getnews(newsid : Int?):newsdata
    {
        return topnewslist.first{it.id==newsid}
    }
}