package com.dnb.vipps.android.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

const val NAVIGATION_ANIMATION_TIME = 300

/**
 * An [NavHost] that sets default transition animations. This nav host should be used in order to ensure a uniform navigation experience
 * throughout the app.
 *
 * @param navController the navController for this host
 * @param startDestination the route for the start destination
 * @param modifier the modifier to be applied to the layout
 * @param builder the builder used to construct the graph
 */
@Composable
fun MyNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    builder: NavGraphBuilder.() -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        contentAlignment = contentAlignment,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(NAVIGATION_ANIMATION_TIME),
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(NAVIGATION_ANIMATION_TIME),
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(NAVIGATION_ANIMATION_TIME),
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(NAVIGATION_ANIMATION_TIME),
            )
        },
        builder = builder,
    )
}
