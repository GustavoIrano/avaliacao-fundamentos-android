package com.example.administrador.myapplication.models.persistence;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.administrador.myapplication.models.entities.ServiceUser;

/**
 * Created by Administrador on 28/05/2015.
 */
public class ServiceUserContract {

    public static final String TABLE = "service_user";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";

    public static final String[] COLUNS = {ID, NAME, PASSWORD};

    public static String createTable() {
        final StringBuilder sql = new StringBuilder();
        sql.append(" CREATE TABLE ");
        sql.append(TABLE);
        sql.append(" ( ");
        sql.append(ID + " INTEGER PRIMARY KEY, ");
        sql.append(NAME + " TEXT, ");
        sql.append(PASSWORD + " TEXT ");
        sql.append(" ); ");
        return sql.toString();
    }

    public static String insertUser(){
        final StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO ");
        sql.append(TABLE);
        sql.append(" ( ");
        sql.append(NAME + ", ");
        sql.append(PASSWORD);
        sql.append(" ) ");
        sql.append(" VALUES ");
        sql.append(" ( ");
        sql.append(" 'gustavo', ");
        sql.append(" '123' ");
        sql.append(" ); ");

        return sql.toString();
    }

    public static ContentValues getContentValues(ServiceUser serviceUser) {
        ContentValues content = new ContentValues();
        content.put(ID, serviceUser.getId());
        content.put(NAME, serviceUser.getName());
        content.put(PASSWORD, serviceUser.getPassword());
        return content;
    }

    public static ServiceUser bind(Cursor cursor) {
        if (!cursor.isBeforeFirst() || cursor.moveToNext()) {
            ServiceUser serviceUser = new ServiceUser();
            serviceUser.setId((cursor.getInt(cursor.getColumnIndex(ID))));
            serviceUser.setName((cursor.getString(cursor.getColumnIndex(NAME))));
            serviceUser.setPassword((cursor.getString(cursor.getColumnIndex(PASSWORD))));

            return serviceUser;
        }
        return null;
    }

}
