package com.ahmed.movies;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "movie.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + Contract.MovieEntry.TABLE_NAME + " (" +
                Contract.MovieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Contract.MovieEntry.COLUMN_MOVIE_ID + " INTEGER NOT NULL, " +
                Contract.MovieEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                Contract.MovieEntry.COLUMN_IMAGE + " TEXT, " +
                Contract.MovieEntry.COLUMN_OVERVIEW + " TEXT, " +
                Contract.MovieEntry.COLUMN_RATING + " INTEGER, " +
                Contract.MovieEntry.COLUMN_DATE + " TEXT);";

        db.execSQL(SQL_CREATE_MOVIE_TABLE);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Contract.MovieEntry.TABLE_NAME);
        onCreate(db);
    }
}

