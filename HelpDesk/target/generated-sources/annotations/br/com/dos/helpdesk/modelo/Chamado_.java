package br.com.dos.helpdesk.modelo;

import br.com.dos.helpdesk.modelo.Equipamento;
import br.com.dos.helpdesk.modelo.Status;
import br.com.dos.helpdesk.modelo.TipoChamado;
import br.com.dos.helpdesk.modelo.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-21T20:15:29")
@StaticMetamodel(Chamado.class)
public class Chamado_ { 

    public static volatile SingularAttribute<Chamado, TipoChamado> tipoChamado;
    public static volatile SingularAttribute<Chamado, String> solucao;
    public static volatile SingularAttribute<Chamado, Usuario> tecnicoResponsavel;
    public static volatile SingularAttribute<Chamado, Equipamento> equipamento;
    public static volatile SingularAttribute<Chamado, Date> limiteAtendimento;
    public static volatile SingularAttribute<Chamado, Long> id;
    public static volatile SingularAttribute<Chamado, Usuario> usuarioAbertura;
    public static volatile SingularAttribute<Chamado, Date> dataAbertura;
    public static volatile SingularAttribute<Chamado, String> descricao;
    public static volatile SingularAttribute<Chamado, Status> status;

}