package lt.testas.userlist.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import lt.testas.userlist.theme.theme.TestUserTheme

@Composable
@NonRestartableComposable
fun ColumnScope.Gap(height: Dp = TestUserTheme.dimen.elementGap) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
@NonRestartableComposable
fun ColumnScope.GapWeight(weight: Float = 1f) {
    Spacer(modifier = Modifier.weight(weight))
}

@Composable
@NonRestartableComposable
fun ColumnScope.GapHalf() {
    Gap(TestUserTheme.dimen.elementGap / 2)
}

@Composable
@NonRestartableComposable
fun RowScope.Gap(height: Dp = TestUserTheme.dimen.elementGap) {
    Spacer(modifier = Modifier.width(height))
}

@Composable
@NonRestartableComposable
fun RowScope.GapWeight(weight: Float = 1f) {
    Spacer(modifier = Modifier.weight(weight))
}

@Composable
@NonRestartableComposable
fun RowScope.GapHalf() {
    Gap(TestUserTheme.dimen.elementGap / 2)
}

