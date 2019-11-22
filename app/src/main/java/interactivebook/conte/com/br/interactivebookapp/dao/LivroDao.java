package interactivebook.conte.com.br.interactivebookapp.dao;

import android.content.Context;

import interactivebook.conte.com.br.interactivebookapp.dao.helpers.DaoHelper;
import interactivebook.conte.com.br.interactivebookapp.model.Livro;

public class LivroDao extends DaoHelper<Livro> {

    public LivroDao(Context c) {
        super(c, Livro.class);
    }
}
