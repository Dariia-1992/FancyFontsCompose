package com.smartfoxlabs.fancy.stylish.font.keyboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.smartfoxlabs.fancy.stylish.font.keyboard.data.FontDTO
import com.smartfoxlabs.fancy.stylish.font.keyboard.data.FontData
import com.smartfoxlabs.fancy.stylish.font.keyboard.ui.components.BottomNavigationItemsScreens


@Preview
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomNavigationItems = listOf(
        BottomNavigationItemsScreens.Calligraphy,
        BottomNavigationItemsScreens.Colored,
        BottomNavigationItemsScreens.Favorites,
        BottomNavigationItemsScreens.Settings)

    Scaffold(
        bottomBar = {
            AppBottomNavigation(navController = navController, items = bottomNavigationItems)
        },
    ) {
        MainScreenNavigationConfigurations(navController)
    }
}

@Composable
private fun MainScreenNavigationConfigurations(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomNavigationItemsScreens.Calligraphy.route) {
        composable(BottomNavigationItemsScreens.Calligraphy.route){
            CurrentScreen(titleRes = BottomNavigationItemsScreens.Calligraphy.resourceId, fontList = mutableListOf(
                FontData.fonts))
        }
        composable(BottomNavigationItemsScreens.Colored.route) {
            CurrentScreen(titleRes = BottomNavigationItemsScreens.Colored.resourceId, fontList = mutableListOf(
                FontData.fonts))
        }
        composable(BottomNavigationItemsScreens.Favorites.route) {
            CurrentScreen(titleRes = BottomNavigationItemsScreens.Favorites.resourceId, fontList = mutableListOf(
                FontData.fonts))
        }
        composable(BottomNavigationItemsScreens.Settings.route) {
            Settings(titleRes = BottomNavigationItemsScreens.Settings.resourceId)
        }
    }
}

@Composable
private fun AppBottomNavigation(navController: NavHostController, items: List<BottomNavigationItemsScreens>) {
    BottomNavigation() {
        val currentRoute = currentRoute(navController = navController)
        items.forEach { screen->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = screen.icon), contentDescription = null) },
                label = { Text(text = stringResource(id = screen.resourceId)) },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                })
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString("id")
}

@Composable
fun CurrentScreen(titleRes: Int, fontList: MutableList<List<FontDTO>>) {
    Box(
        Modifier
            .padding(16.dp)
            .background(Color.Green)) {
        Text(text = stringResource(id = titleRes))
    }
}


@Composable
fun Settings(titleRes: Int) {
    Text(text = stringResource(id = titleRes))
}
