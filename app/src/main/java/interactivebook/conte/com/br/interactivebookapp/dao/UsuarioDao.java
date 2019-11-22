package interactivebook.conte.com.br.interactivebookapp.dao;

import android.content.Context;

import interactivebook.conte.com.br.interactivebookapp.dao.helpers.DaoHelper;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;

public class UsuarioDao extends DaoHelper<Usuario> {

    public UsuarioDao(Context c) {
        super(c, Usuario.class);
    }
}
