<fieldset>
        <legend>
            Registro
        </legend>
        <form action="servlets/ServletRegistro" method="POST">
          <label>Usuario:</label>
          <input type="text" name="user" />
          <br />
          <label>Correo electr�nico:</label>
          <input type="text" name="email" />
          <br />
          <label>Confirma la correo electr�nico:</label>
          <input type="text" name="confirmaEmail" />
          <br />
          <label>Contrase�a:</label>
          <input type="password" name="pass" />
          <br />
          <label>Confirma la contrase�a</label>
          <input type="password" name="confirmaPass" />
          <br />
          <input type="reset" value="Vac�ar los campos" />
          <input type="submit" name="submit" value="Darse de alta" />
          </form>
    </fieldset>