package Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Materia
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.markup.html.form.TextField
import org.uqbar.wicket.xtend.XButton

class AgregarMateriaPage extends WebPage{
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
		
	new(SeguidorCarreraPage page) {
		val nuevaMateria = new Materia
		val Form<Materia> nuevaMateriaForm= new Form("nuevaMateriaForm",new CompoundPropertyModel(nuevaMateria))
		nuevaMateriaForm.addChild(new TextField<String>("nombre"))
		nuevaMateriaForm.addChild(new XButton("aceptar").onClick = [| agregar(nuevaMateria,page) ])
		this.addChild(nuevaMateriaForm)
	}
	
	def agregar(Materia materia, SeguidorCarreraPage page) {
		page.seguidor.agregarMateria(materia)
	}
	
	
	
}