package interactivebook.conte.com.br.interactivebookapp.dao.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import interactivebook.conte.com.br.interactivebookapp.model.Livro;
import interactivebook.conte.com.br.interactivebookapp.model.Pagina;
import interactivebook.conte.com.br.interactivebookapp.model.Pergunta;
import interactivebook.conte.com.br.interactivebookapp.model.Resposta;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;

public class MyORMLiteHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    public MyORMLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Usuario.class);
            TableUtils.createTable(connectionSource, Livro.class);
            TableUtils.createTable(connectionSource, Pagina.class);
            TableUtils.createTable(connectionSource, Pergunta.class);
            TableUtils.createTable(connectionSource, Resposta.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Usuario.class, true);
            TableUtils.dropTable(connectionSource, Livro.class, true);
            TableUtils.dropTable(connectionSource, Pagina.class, true);
            TableUtils.dropTable(connectionSource, Pergunta.class, true);
            TableUtils.dropTable(connectionSource, Resposta.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
