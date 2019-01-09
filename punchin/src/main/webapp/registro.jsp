<fieldset>
        <legend>
            Registro
        </legend>
        <form action="servlets/ServletRegistro" method="POST">
          <label>Usuario:</label>
          <input type="text" name="user" />
          <br />
          <label>Correo electrónico:</label>
          <input type="text" name="email" />
          <br />
          <label>Confirma la correo electrónico:</label>
          <input type="text" name="confirmaEmail" />
          <br />
          <label>Contraseña:</label>
          <input type="password" name="pass" />
          <br />
          <label>Confirma la contraseña</label>
          <input type="password" name="confirmaPass" />
          <br />
          <input type="reset" value="Vacíar los campos" />
          <input type="submit" name="submit" value="Darse de alta" />
          </form>
    </fieldset>