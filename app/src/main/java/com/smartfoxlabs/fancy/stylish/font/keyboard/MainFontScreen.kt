package com.smartfoxlabs.fancy.stylish.font.keyboard

import androidx.annotation.ContentView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.smartfoxlabs.fancy.stylish.font.keyboard.data.FontDTO
import com.smartfoxlabs.fancy.stylish.font.keyboard.data.FontData
import com.smartfoxlabs.fancy.stylish.font.keyboard.ui.components.BottomNavigationItemsScreens
import com.smartfoxlabs.fancy.stylish.font.keyboard.ui.components.FontItems
import com.smartfoxlabs.fancy.stylish.font.keyboard.ui.theme.BottomNavigationColorPalette
import com.smartfoxlabs.fancy.stylish.font.keyboard.ui.theme.BottomNavigationTheme
import com.smartfoxlabs.fancy.stylish.font.keyboard.ui.theme.FancyFontsComposeTheme
import com.smartfoxlabs.fancy.stylish.font.keyboard.ui.theme.FontColorPalette
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    FancyFontsComposeTheme {
        Scaffold(
            bottomBar = {
                BottomNavigationBar(navController)
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)){
                MainScreenNavigationConfigurations(navController)
            }
        }
    }

}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}

@Composable
fun BottomNavigationBar(navController: NavController) {

    val bottomNavigationItems = listOf(
        BottomNavigationItemsScreens.Calligraphy,
        BottomNavigationItemsScreens.Colored,
        BottomNavigationItemsScreens.Favorites,
        BottomNavigationItemsScreens.Settings)

    BottomNavigation(backgroundColor = BottomNavigationColorPalette.primary,
        contentColor = BottomNavigationColorPalette.onPrimary) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        bottomNavigationItems.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = null
                    )},
                label = { Text(text = stringResource(id = screen.resourceId)) },
                selected = false,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)

                    }
                })
        }

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
fun BottomNavigationBar() {
    val bottomNavigationItems = listOf(
        BottomNavigationItemsScreens.Calligraphy,
        BottomNavigationItemsScreens.Colored,
        BottomNavigationItemsScreens.Favorites,
        BottomNavigationItemsScreens.Settings)

    BottomNavigation(backgroundColor = Color.Gray,
        contentColor = FontColorPalette.primaryVariant) {
        bottomNavigationItems.forEach {item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null
                    )},
                label = { Text(text = stringResource(id = item.resourceId)) },
                selectedContentColor = FontColorPalette.onPrimary,
                unselectedContentColor = FontColorPalette.primaryVariant,
                alwaysShowLabel = true,
                selected = false,
                onClick = {

                })
        }
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview(){
    BottomNavigationBar()
}

@Composable
fun CurrentScreen(titleRes: Int, fontList: MutableList<List<FontDTO>>) {
    Box(
        Modifier
            .background(Color.Green)) {
        Text(text = stringResource(id = titleRes))
            //modifier = Modifier
                //.align(Alignment.TopCenter)
                //.fillMaxSize())

        val scrollState = rememberLazyListState()

//        LazyColumn(modifier = Modifier
//            .padding(16.dp)
//            .background(Color.Blue),
//        state = scrollState) {
//            items(10) {
//                FontItems(fontsList = fontList)
//                //SelectFontItem(fontName = ) {
//
//                //}
//            }
//        }
    }
}

@Composable
private fun SelectFontItem(fontName: String, onClicked:(String) -> Unit) {
    Text(text = fontName, Modifier.clickable(onClick = {onClicked(fontName)}))
}


@Composable
fun Settings(titleRes: Int) {
    Text(text = stringResource(id = titleRes))
}
