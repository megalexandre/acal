/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.User;

/**
 *
 * @author alexandre
 */
public interface UsuarioInterface {

    void AdicionarUsuario(User usuario);
    void AlterarUsuario(User usuario);
    void ApagarUsuario(User usuario);
    
}
