package xyz.teamgravity.counterwidget

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

object CounterWidget : GlanceAppWidget() {

    val count = intPreferencesKey("count")

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val increment = context.getString(R.string.increment)
        provideContent {
            Column(
                verticalAlignment = Alignment.Vertical.CenterVertically,
                horizontalAlignment = Alignment.Horizontal.CenterHorizontally,
                modifier = GlanceModifier
                    .fillMaxSize()
                    .background(Color.DarkGray)
            ) {
                Text(
                    text = (currentState(key = count) ?: 0).toString(),
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        color = ColorProvider(Color.White),
                        fontSize = 26.sp
                    )
                )
                Button(
                    text = increment,
                    onClick = actionRunCallback(IncrementAction::class.java)
                )
            }
        }
    }
}