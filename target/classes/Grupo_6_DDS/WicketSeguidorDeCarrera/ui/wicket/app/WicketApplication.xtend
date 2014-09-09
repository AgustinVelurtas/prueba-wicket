package Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket.app;

import org.apache.wicket.protocol.http.WebApplication;

import Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket.HomePage;
import org.uqbar.commons.utils.ApplicationContext
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.UbicacionMateria
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.HomeUbicacionMaterias
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Materia
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.HomeMaterias
import Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket.SeguidorCarreraPage

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see wicket.myproject.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    
    override protected init() {
		super.init()
		ApplicationContext.instance.configureSingleton(UbicacionMateria, new HomeUbicacionMaterias)
		ApplicationContext.instance.configureSingleton(Materia, new HomeMaterias)
	}
	
	override getHomePage() {
		return SeguidorCarreraPage
	}

}
