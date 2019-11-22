package interactivebook.conte.com.br.interactivebookapp.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.control.ConfigControl;

public class ConfigActivity extends Activity {

    private ConfigControl configControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        configControl = new ConfigControl(this);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }


    public void cancelar(View view) {
        configControl.cancelarAction();
    }

    public void alterar(View view) {
        configControl.alterarAction();
    }
}
