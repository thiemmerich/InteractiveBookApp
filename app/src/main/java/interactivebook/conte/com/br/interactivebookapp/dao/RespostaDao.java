package interactivebook.conte.com.br.interactivebookapp.dao;

import android.content.Context;

import interactivebook.conte.com.br.interactivebookapp.dao.helpers.DaoHelper;
import interactivebook.conte.com.br.interactivebookapp.model.Resposta;

public class RespostaDao extends DaoHelper<Resposta> {
    public RespostaDao(Context c) {
        super(c, Resposta.class);
    }
}
