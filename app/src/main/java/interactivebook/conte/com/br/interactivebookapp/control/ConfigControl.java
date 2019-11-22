package interactivebook.conte.com.br.interactivebookapp.control;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;
import interactivebook.conte.com.br.interactivebookapp.resource.UsuarioResource;
import interactivebook.conte.com.br.interactivebookapp.view.ConfigActivity;

public class ConfigControl {

    private Activity activity;
    private UsuarioResource usuarioResource;
    private Usuario usuario;

    private EditText nome;
    private EditText sobrenome;
    private EditText passwd;
    private EditText repasswd;
    private String email;

    public ConfigControl(Activity activity){
        this.activity = activity;
        this.usuarioResource = new UsuarioResource(this.activity);

        this.nome = activity.findViewById(R.id.config_edit_text_nome);
        this.sobrenome = activity.findViewById(R.id.config_edit_text_sobrenome);
        this.passwd = activity.findViewById(R.id.config_edit_text_senha);
        this.repasswd = activity.findViewById(R.id.config_edit_text_confirma_senha);

        this.email = this.activity.getIntent().getSerializableExtra("email").toString();
    }

    public void alterarAction(){
        Usuario user = new Usuario();
        user.setEmail(email);

        if(this.passwd.getText().toString().equalsIgnoreCase(this.repasswd.getText().toString())){
            user.setSenha(passwd.getText().toString());

            if(nome.getText().toString() != null || nome.getText().toString() != "") {
                user.setNome(nome.getText().toString());


            } else {
                Toast.makeText(activity, "Digite seu nome", Toast.LENGTH_SHORT).show();
                return;
            }

            if(sobrenome.getText().toString() != null || sobrenome.getText().toString() != ""){
                user.setSobrenome(sobrenome.getText().toString());
            } else {
                Toast.makeText(activity, "Digite seu sobrenome", Toast.LENGTH_SHORT).show();
                return;
            }

        } else {
            Toast.makeText(activity, "Senha incorreta", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            usuarioResource.cadastrarUsuario(user);
        } catch (Exception e) {
            Toast.makeText(activity, "Falha ao cadastrar usuario", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void cancelarAction(){
        this.activity.finish();
    }
}
