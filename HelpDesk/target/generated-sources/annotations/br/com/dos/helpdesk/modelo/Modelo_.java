package br.com.dos.helpdesk.modelo;

import br.com.dos.helpdesk.modelo.Fabricante;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-21T20:15:29")
@StaticMetamodel(Modelo.class)
public class Modelo_ { 

    public static volatile SingularAttribute<Modelo, String> nome;
    public static volatile SingularAttribute<Modelo, Long> id;
    public static volatile SingularAttribute<Modelo, Fabricante> fabricante;

}