package ru.dvs.eshop.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.util.*

class DataBase(context: Context) {
    private var db: SQLiteDatabase? = null

    init {
        val dbHelper = DBHelper(context)
        db = dbHelper.writableDatabase
    }

    //Добавляет элемент в таблицу
    fun insert(table: String, sm: Map<*, *>): Long {
        val cv = ContentValues()
        for (o in sm.entries) {
            val pair = o
            if (pair.value.toString().isNotEmpty())
                cv.put(pair.key as String, pair.value.toString())
        }
        return db!!.insert(table, null, cv)
    }

    //Обновляет элемент таблицы по ID
    fun update(table: String, id: Int, sm: Map<*, *>): Long {
        val cv = ContentValues()
        for (o in sm.entries) {
            val pair = o
            if (pair.value.toString().isNotEmpty())
                cv.put(pair.key as String, pair.value.toString())
        }
        return db!!.update(table, cv, "id=" + id, null).toLong()
    }

    //Добавляет или обновляет элемент в таблицу
    fun insertOrUpdate(table: String, where: String, map: HashMap<String, String>) {
        val bd_item = query(table, null, where, null, null, null, null)
        if (bd_item != null && bd_item.moveToFirst()) {//Элемент в таблице есть - обновляем данные
            update(table, bd_item.getInt(bd_item.getColumnIndex("id")), map)
            bd_item.close()
        } else {//Элемента в таблиц нет - добавляем его
            insert(table, map)
        }
    }

    //Удаляет по запросу элемент из таблицы
    fun delete(table: String, whereClause: String, whereArgs: Array<String>): Int {
        return db!!.delete(table, whereClause, whereArgs)
    }

    //Поучает Cursor по запросу из таблицы
    fun query(table: String, columns: Array<String>?, selection: String,
              selectionArgs: Array<String>?, groupBy: String?, having: String?,
              orderBy: String?): Cursor? {
        var orderBy = orderBy
        if (orderBy == null)
            orderBy = "id DESC"
        return db!!.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
    }

    //Получает кол-во элементов в таблице по запросу
    fun getCount(table: String, where: String): Int {
        val c = db!!.query(table, null, where, null, null, null, null)
        val ret = c.count
        c.close()
        return ret
    }

    //Удаляет элемент по ID из таблицы
    fun removeById(table: String, id: Int): Int {
        return db!!.delete(table, "id = " + id, null)
    }

    fun close() {
        try {
            db!!.endTransaction()
        } catch (ignored: IllegalStateException) {
            db!!.close()
        }

        db = null
    }

    private inner class DBHelper internal constructor(context: Context) : SQLiteOpenHelper(context, "appEShop", null, 1) {

        //При создании базы данных
        override fun onCreate(db: SQLiteDatabase) {
            Log.d(LOG_TAG, "--- onCreate database ---")
            ////////////////////
            Log.d(LOG_TAG, "--- Create com_eshop_categories")
            db.execSQL("CREATE TABLE com_eshop_categories (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "original_id INTEGER NOT NULL," +
                    "is_enabled INTEGER NOT NULL DEFAULT '1'," +
                    "title TEXT NOT NULL," +
                    "ordering INTEGER DEFAULT NULL," +
                    "parent_id INTEGER DEFAULT NULL," +
                    "description TEXT," +
                    "icon TEXT," +
                    "meta_keys TEXT," +
                    "meta_desc TEXT," +
                    "url TEXT DEFAULT NULL," +
                    "tpl TEXT DEFAULT NULL);" +
                    "CREATE INDEX IF NOT EXISTS uniq ON com_eshop_categories (id, original_id);"
            )
            ///////////////////Мы сделали категорию шаблон категорий, чтобы когда вы кодили категорию... всё, договорились, теперь всё ясно!(нет)
            Log.d(LOG_TAG, "--- Create com_eshop_chars")
            db.execSQL("CREATE TABLE com_eshop_chars (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "original_id INTEGER NOT NULL," +
                    "is_enabled INTEGER NOT NULL DEFAULT '1'," +
                    "title TEXT NOT NULL," +
                    "type TEXT NOT NULL," +
                    "`group` TEXT NOT NULL," +
                    "units TEXT NOT NULL," +
                    "is_custom INTEGER NOT NULL DEFAULT '1'," +
                    "is_published INTEGER NOT NULL DEFAULT '1'," +
                    "`values` TEXT," +
                    "categories TEXT," +
                    "ordering INTEGER DEFAULT NULL);" +
                    "CREATE INDEX IF NOT EXISTS uniq ON com_eshop_chars (id, original_id);"
            )
            /////////////////////
            Log.d(LOG_TAG, "--- Create com_eshop_delivery_methods")
            db.execSQL("CREATE TABLE com_eshop_delivery_methods (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "original_id INTEGER NOT NULL," +
                    "is_enabled INTEGER NOT NULL DEFAULT '1'," +
                    "ordering INTEGER DEFAULT NULL," +
                    "title TEXT NOT NULL," +
                    "description TEXT," +
                    "icon TEXT," +
                    "price FLOAT DEFAULT NULL);" +
                    "CREATE INDEX IF NOT EXISTS uniq ON com_eshop_delivery_methods (id, original_id);"
            )
            ////////////////////
            Log.d(LOG_TAG, "--- Create com_eshop_items")
            db.execSQL("CREATE TABLE com_eshop_items (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "original_id INTEGER NOT NULL," +
                    "is_enabled INTEGER NOT NULL DEFAULT '1'," +
                    "ordering INTEGER DEFAULT NULL," +
                    "category_id INTEGER DEFAULT NULL," +
                    "art_no TEXT DEFAULT NULL," +
                    "title TEXT NOT NULL," +
                    "date_pub DATETIME DEFAULT CURRENT_TIMESTAMP," +
                    "price FLOAT DEFAULT NULL," +
                    "price_old TEXT DEFAULT NULL," +
                    "quantity FLOAT DEFAULT NULL," +
                    "desc_short TEXT," +
                    "desc_full TEXT," +
                    "vendor_id INTEGER DEFAULT NULL," +
                    "category_add_id TEXT," +
                    "img TEXT," +
                    "images TEXT," +
                    "chars TEXT," +
                    "meta_keys TEXT," +
                    "meta_desc TEXT," +
                    "url TEXT DEFAULT NULL," +
                    "tpl TEXT DEFAULT NULL);" +
                    "CREATE INDEX IF NOT EXISTS uniq ON com_eshop_items (id, original_id);"
            )
            ////////////////////
            Log.d(LOG_TAG, "--- Create com_eshop_payment_types")
            db.execSQL("CREATE TABLE com_eshop_payment_types (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "original_id INTEGER NOT NULL," +
                    "is_enabled INTEGER NOT NULL DEFAULT '1'," +
                    "ordering INTEGER DEFAULT NULL," +
                    "name TEXT DEFAULT NULL," +
                    "title TEXT DEFAULT NULL," +
                    "description TEXT," +
                    "icon TEXT NOT NULL," +
                    "options TEXT NOT NULL);" +
                    "CREATE INDEX IF NOT EXISTS uniq ON com_eshop_payment_types (id, original_id);"
            )
            ////////////////////
            Log.d(LOG_TAG, "--- Create com_eshop_vendors")
            db.execSQL("CREATE TABLE com_eshop_vendors (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "original_id INTEGER NOT NULL," +
                    "parent_id INTEGER NOT NULL," +
                    "is_enabled INTEGER NOT NULL DEFAULT '1'," +
                    "title TEXT DEFAULT NULL," +
                    "icon TEXT," +
                    "description TEXT," +
                    "url TEXT DEFAULT NULL," +
                    "ordering INTEGER DEFAULT NULL);" +
                    "CREATE INDEX IF NOT EXISTS uniq ON com_eshop_vendors (id, original_id);"
            )

        }

        //При обновлении приложения
        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS appEShop")
            onCreate(db)
        }
    }

    companion object {

        private val LOG_TAG = "DataBase"
    }


}