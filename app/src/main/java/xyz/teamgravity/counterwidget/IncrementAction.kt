package xyz.teamgravity.counterwidget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.state.updateAppWidgetState

class IncrementAction : ActionCallback {

    override suspend fun onAction(context: Context, glanceId: GlanceId, parameters: ActionParameters) {
        updateAppWidgetState(
            context = context,
            glanceId = glanceId
        ) { preferences ->
            val count = preferences[CounterWidget.count] ?: 0
            preferences[CounterWidget.count] = count + 1
            CounterWidget.update(
                context = context,
                id = glanceId
            )
        }
    }
}