package com.example.translator.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.translator.domain.repository.DataStoreRepository
import com.example.translator.util.Constants.ON_BOARDING_PREFS_KEY
import com.example.translator.util.Constants.ON_BOARDING_PREFS_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = ON_BOARDING_PREFS_NAME)

class DataStoreRepositoryImpl @Inject constructor(
    private val context: Context
): DataStoreRepository {

    private object PrefsKey {
        val onBoardingKey = booleanPreferencesKey(name = ON_BOARDING_PREFS_KEY)
    }

    private val dataStore = context.dataStore

    override suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PrefsKey.onBoardingKey] = completed
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                val onBoardingState = preferences[PrefsKey.onBoardingKey] ?: false
                onBoardingState
            }
    }

}