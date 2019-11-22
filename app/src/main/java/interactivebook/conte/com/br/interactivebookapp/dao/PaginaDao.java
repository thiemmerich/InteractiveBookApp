package interactivebook.conte.com.br.interactivebookapp.dao;

import android.content.Context;

import interactivebook.conte.com.br.interactivebookapp.dao.helpers.DaoHelper;
import interactivebook.conte.com.br.interactivebookapp.model.Pagina;

public class PaginaDao extends DaoHelper<Pagina> {

    public PaginaDao(Context c) {
        super(c, Pagina.class);
    }
}
