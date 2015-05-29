package com.example.administrador.myapplication.models.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrador.myapplication.util.AppUtil;

/**
 * Created by Administrador on 28/05/2015.
 */
public final class ServiceUserRepository {

    private static class Singleton {
        public static final ServiceUserRepository INSTANCE = new ServiceUserRepository();
    }

    private ServiceUserRepository() {
        super();
    }

    public static ServiceUserRepository getInstance() {
        return Singleton.INSTANCE;
    }

    public boolean userHavePermission(String name, String password) {
        DatabaseHelper helper = new DatabaseHelper(AppUtil.CONTEXT);
        SQLiteDatabase db = helper.getReadableDatabase();
        String where = ServiceUserContract.NAME + " = ? AND " + ServiceUserContract.PASSWORD + " = ? ";
        String[] args = {name, password};
        Cursor cursor = db.query(ServiceUserContract.TABLE, ServiceUserContract.COLUNS, where, args, null, null, null);
        int qtd = cursor.getCount();
        db.close();
        helper.close();
        return qtd > 0;
    }

}
