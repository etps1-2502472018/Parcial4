package sv.edu.utec.parcial4.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDHelper extends SQLiteOpenHelper {


    public BDHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MD_Clientes (ID_Cliente int primary key," +
                "sNombreCliente text," +
                "sApellidosCliente text," +
                "sDireccionCliente text," +
                "sCiudadCliente)");

        //db.execSQL("CREATE TABLE MD_ClienteVehiculo ()");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
