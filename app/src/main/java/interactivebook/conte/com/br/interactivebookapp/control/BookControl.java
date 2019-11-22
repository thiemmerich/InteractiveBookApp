package interactivebook.conte.com.br.interactivebookapp.control;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.model.Livro;
import interactivebook.conte.com.br.interactivebookapp.model.Pagina;
import interactivebook.conte.com.br.interactivebookapp.view.LobbyActivity;

public class BookControl {

    private Activity activity;
    private Livro livro;
    private Pagina paginaAtual;
    private TextView textView;
    private RelativeLayout layoutProxima;
    private LinearLayout layoutBtn;

    public BookControl(Activity activity) {
        this.activity = activity;

        initcomponents();
    }

    private void initcomponents() {

        livro = (Livro) this.activity.getIntent().getSerializableExtra("livro");
        textView = (TextView) activity.findViewById(R.id.layoutResult);
        layoutProxima = activity.findViewById(R.id.layoutProxima);
        layoutBtn = activity.findViewById(R.id.layoutBtn);

        paginaAtual = getPagina("1");
        textView.setText(paginaAtual.getConteudo());

    }

    private Pagina getPagina(String j) {
        for (int i = 0; i < livro.getPaginas().size(); i++) {
            if (livro.getPaginas().get(i).getNumPagina().equals(j)) {
                layoutProxima.setVisibility(View.VISIBLE);

                return livro.getPaginas().get(i);
            }
        }
        return null;
    }

    public void proximaAction() {

        if (paginaAtual == null) {
            Intent i = new Intent(activity, LobbyActivity.class);
            activity.startActivity(i);
        } else {
            String pPagina = String.valueOf(Integer.parseInt(paginaAtual.getNumPagina()) + 1);
            paginaAtual = getPagina(pPagina);
            if(paginaAtual!=null){
                textView.setText(paginaAtual.getConteudo());
            }

        }

        if (paginaAtual.getPergunta() == null) {
            layoutProxima.setVisibility(View.VISIBLE);
        } else {
            layoutBtn.setVisibility(View.VISIBLE);
        }


    }

    public void buttonIAction() {
        visibilidade();
        String pPagina = paginaAtual.getPergunta().getRespostas().get(0).getNext().getNumPagina();
        paginaAtual = getPagina(pPagina);
        textView.setText(paginaAtual.getConteudo());
    }

    public void buttonIIAction() {
        visibilidade();
        String pPagina = paginaAtual.getPergunta().getRespostas().get(1).getNext().getNumPagina();
        paginaAtual = getPagina(pPagina);
        textView.setText(paginaAtual.getConteudo());

    }

    private void visibilidade() {
        layoutProxima.setVisibility(View.VISIBLE);
        layoutBtn.setVisibility(View.INVISIBLE);
    }

}
