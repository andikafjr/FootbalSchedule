package com.abdhilabs.footbalschedule.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.abdhilabs.footbalschedule.model.Favorite
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper(ctx: Context) :
    ManagedSQLiteOpenHelper(ctx, "FavoriteTeam.db", null, 2) {

    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as MyDatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        //Here create tables
        db.createTable(
            Favorite.TABLE_FAVORITE,
            true,
            Favorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            Favorite.MATCH_ID to TEXT + UNIQUE,
            Favorite.MATCH_NAME to TEXT,
            Favorite.MATCH_DATE to TEXT,
            Favorite.MATCH_ID_HOME to TEXT,
            Favorite.MATCH_ID_AWAY to TEXT,
            Favorite.MATCH_HOME_NAME to TEXT,
            Favorite.MATCH_AWAY_NAME to TEXT,
            Favorite.MATCH_HOME_SCORE to TEXT,
            Favorite.MATCH_AWAY_SCORE to TEXT,
            Favorite.MATCH_HOME_GOALS to TEXT,
            Favorite.MATCH_AWAY_GOALS to TEXT,
            Favorite.MATCH_HOME_SHOTS to TEXT,
            Favorite.MATCH_AWAY_SHOTS to TEXT,
            Favorite.MATCH_HOME_GOALKEEPER to TEXT,
            Favorite.MATCH_AWAY_GOALKEEPER to TEXT,
            Favorite.MATCH_HOME_DEFENSE to TEXT,
            Favorite.MATCH_AWAY_DEFENSE to TEXT,
            Favorite.MATCH_HOME_MIDFIELD to TEXT,
            Favorite.MATCH_AWAY_MIDFIELD to TEXT,
            Favorite.MATCH_HOME_FORWARD to TEXT,
            Favorite.MATCH_AWAY_FORWARD to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(Favorite.TABLE_FAVORITE, true)
    }
}

val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)