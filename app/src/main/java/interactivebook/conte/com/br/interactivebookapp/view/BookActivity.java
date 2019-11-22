package interactivebook.conte.com.br.interactivebookapp.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.control.BookControl;

public class BookActivity extends Activity {

    private BookControl bookControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        bookControl = new BookControl(this);
    }

    public void proximaPagina(View v) {
        bookControl.proximaAction();
    }

    public void primeiraEscolha(View v) {
        bookControl.buttonIAction();
    }

    public void segundaEscolha(View v) {
        bookControl.buttonIIAction();
    }
}
