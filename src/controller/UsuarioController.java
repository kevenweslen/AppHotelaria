package controller;

import dao.UsuariosDAO;
import model.Usuario;

public class UsuarioController {
    private final UsuariosDAO usuariosDAO;    /*construtor para inicializar objeto UsuariosController()    Ao incializa-lo, o construtor de UsuariosDao() será executado, o que significa que    a camada de Controle estará verificando se os parâmetros necessarios foram informados    para que sejam enviados às requisiçoes (package DAO - data acess object)    */

    public UsuarioController() {
        this.usuariosDAO = new UsuariosDAO();
    }    /*metedo para verificar se os parametros necessarios para autenticação estao presentes, ou seja,    nao podem ser vazios ou nulos. se estiverem presentes, um objetode Usuarios é inicializado como    uma instancia    */

    public boolean verificarUsuario(String email, String senha) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return false;
        }
        Usuario usuario = new Usuario("", email, senha, 0);
        return usuariosDAO.altenticarUsuario(usuario);
    }
}