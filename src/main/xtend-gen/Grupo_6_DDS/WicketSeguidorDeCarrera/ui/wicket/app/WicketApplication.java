package Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket.app;

import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.HomeMaterias;
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.HomeUbicacionMaterias;
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Materia;
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.UbicacionMateria;
import Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket.SeguidorCarreraPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.uqbar.commons.utils.ApplicationContext;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see wicket.myproject.Start#main(String[])
 */
@SuppressWarnings("all")
public class WicketApplication extends WebApplication {
  protected void init() {
    super.init();
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeUbicacionMaterias _homeUbicacionMaterias = new HomeUbicacionMaterias();
    _instance.<HomeUbicacionMaterias>configureSingleton(UbicacionMateria.class, _homeUbicacionMaterias);
    ApplicationContext _instance_1 = ApplicationContext.getInstance();
    HomeMaterias _homeMaterias = new HomeMaterias();
    _instance_1.<HomeMaterias>configureSingleton(Materia.class, _homeMaterias);
  }
  
  public Class getHomePage() {
    return SeguidorCarreraPage.class;
  }
}
