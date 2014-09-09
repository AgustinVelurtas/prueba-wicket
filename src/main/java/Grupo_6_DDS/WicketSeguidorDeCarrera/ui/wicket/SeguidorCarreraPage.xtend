package Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket

import java.io.Serializable
import java.util.List
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Materia
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Nota
import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.SeguidorCarrera
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.markup.html.form.CheckBox
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.TextField

class SeguidorCarreraPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	var SeguidorCarrera seguidor
	
	new () {
		this.seguidor= new SeguidorCarrera
		val Form<SeguidorCarrera> seguidorForm = new Form<SeguidorCarrera>("seguidorCarreraForm", new CompoundPropertyModel<SeguidorCarrera>(this.seguidor))
		this.setTitle("Seguidor de carrera")
		new Label(new Panel(mainPanel)).setText("Seguidor de carrera").setFontSize(30)
		
		val form = new Panel(mainPanel) 
		form.layout = new HorizontalLayout
		
		crearListaMaterias(form)
		crearDetallesMateria(form)
		
	}		
}