package com.example.prak8mysqldatainternet.ui.customwidget

import androidx.compose.material3.TopAppBarScrollBehavior

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CostumeTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {},
    onRefresh: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        actions = {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "",
                modifier = Modifier.clickable { onRefresh() }
            )
        },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        }
    )
}

