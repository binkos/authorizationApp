package com.uladzislau_pravalenak.authorizationapp.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navigator.LocalNavigator
import com.uladzislau_pravalenk.authorizationapp.core.extensions.currentOrThrow
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen() {
    val navigator = LocalNavigator.currentOrThrow
    val coroutineScope = rememberCoroutineScope()

    val pageItems by remember {
//        listOf<String>()
        val pageInfos = listOf(
            PageInfo(R.drawable.icon_create_account, R.string.create_account_page_message),
            PageInfo(R.drawable.icon_fingerprint, R.string.set_pin_page_message),
            PageInfo(R.drawable.icon_send_invite, R.string.create_financial_page_message),
        )

        mutableStateOf(pageInfos)
    }
    val pagerState = rememberPagerState()
    val isStartButtonVisible by remember(pagerState.currentPage) {
        derivedStateOf { pagerState.currentPage == pageItems.lastIndex }
    }

    Box(Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState,
            pageCount = pageItems.size
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Magenta),
            ) {
                Spacer(modifier = Modifier.weight(1f))

                val drawableRes = pageItems[it].iconDrawableRes
                Image(
                    modifier = Modifier
                        .size(64.dp)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = drawableRes),
                    contentDescription = drawableRes.toString()
                )

                Spacer(modifier = Modifier.weight(2f))
            }
        }

        OnboardingCardPage(
            modifier = Modifier.align(Alignment.BottomCenter),
            pagerState = pagerState,
            pageItems = pageItems,
            isStartButtonVisible = isStartButtonVisible,
            onContinueButtonClicked = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            },
            onStartButtonClicked = {
                navigator.navigate(AppFlowRoutes.SIGN_UP_FLOW.name) {
                    popUpTo(AppFlowRoutes.ONBOARDING.name) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

@Composable
@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
private fun OnboardingCardPage(
    modifier: Modifier,
    pagerState: PagerState,
    pageItems: List<PageInfo>,
    isStartButtonVisible: Boolean,
    onContinueButtonClicked: () -> Unit,
    onStartButtonClicked: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.33f)
            .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
            .background(MaterialTheme.colors.surface)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPagerIndicator(pagerState = pagerState, pageCount = pageItems.size)

        Text(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            text = stringResource(id = pageItems[pagerState.currentPage].textStringRes),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        if (isStartButtonVisible) {
            OnboardingButton(stringResource(R.string.start_app_flow), onStartButtonClicked)
        } else {
            OnboardingButton(stringResource(R.string.continue_onboarding), onContinueButtonClicked)
        }
    }
}

@Composable
private fun OnboardingButton(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp),
        onClick = onClick
    ) {
        Text(text = text)
    }
}