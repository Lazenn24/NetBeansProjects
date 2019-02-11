package com.mycompany.practicauno.datamodel.entities;

import com.mycompany.practicauno.datamodel.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-06T20:28:59")
@StaticMetamodel(Registros.class)
public class Registros_ { 

    public static volatile SingularAttribute<Registros, Date> fecha;
    public static volatile SingularAttribute<Registros, String> tipo;
    public static volatile SingularAttribute<Registros, Usuario> idUs;
    public static volatile SingularAttribute<Registros, Integer> id;

}