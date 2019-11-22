package interactivebook.conte.com.br.interactivebookapp.dao;

import android.content.Context;

import interactivebook.conte.com.br.interactivebookapp.dao.helpers.DaoHelper;
import interactivebook.conte.com.br.interactivebookapp.model.Pergunta;

public class PerguntaDao extends DaoHelper<Pergunta> {
    public PerguntaDao(Context c) {
        super(c, Pergunta.class);
    }
}
