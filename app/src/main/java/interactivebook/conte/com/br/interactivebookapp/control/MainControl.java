package interactivebook.conte.com.br.interactivebookapp.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.dao.UsuarioDao;
import interactivebook.conte.com.br.interactivebookapp.dao.helpers.MyORMLiteHelper;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;
import interactivebook.conte.com.br.interactivebookapp.resource.LoginResource;
import interactivebook.conte.com.br.interactivebookapp.view.CadastrarActivity;
import interactivebook.conte.com.br.interactivebookapp.view.PasswdRecoverActivity;

public class MainControl {

    private Dao<Usuario, Integer> usuarioDao;
    private UsuarioDao usuarioOrmDao;
    private MyORMLiteHelper helper;

    private Activity activity;
    private LoginResource loginResource;
    private EditText email;
    private EditText senha;
    private Usuario usuario;

    public MainControl(Activity activity){
        this.activity = activity;
        this.loginResource = new LoginResource(this.activity);

        this.helper = new MyORMLiteHelper(activity);
        this.usuarioOrmDao = new UsuarioDao(activity);

        this.email = activity.findViewById(R.id.edit_text_email);
        this.senha = activity.findViewById(R.id.edit_text_senha);

        usuarioDao = usuarioOrmDao.getDao();

    }

    public void userValidator(){
        usuario = null;

        String e = email.getText().toString();
        String s = senha.getText().toString();

        loginResource.verificaUsuario(e,s);
    }

    public void cadastrarAction(){
        Intent it = new Intent(activity, CadastrarActivity.class);
        activity.startActivity(it);
    }

    public void recuperarAction(){
        Intent it = new Intent(activity, PasswdRecoverActivity.class);
        activity.startActivity(it);
    }
}
