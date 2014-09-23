package Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket

import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Materia
import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.basic.Label
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Nota
import org.apache.wicket.markup.html.form.CheckBox
import org.apache.wicket.markup.html.form.TextField
import org.uqbar.wicket.xtend.XButton

class EditarNotaPage extends WebPage{
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	var Nota notaOriginal
	var Nota notaSeleccionada
	
	new(SeguidorCarreraPage page) {
		notaOriginal=page.getNotaSeleccionada
		notaSeleccionada= page.getNotaSeleccionada
		val Form<Nota> editarNotaForm= new Form("editarNotaForm",new CompoundPropertyModel(notaSeleccionada))
		editarNotaForm.addChild(new TextField<String>("fecha"))
		editarNotaForm.addChild(new TextField<String>("descripcion"))
		editarNotaForm.addChild(new CheckBox("aprobado"))
		editarNotaForm.addChild(new XButton("aceptar").onClick = [| editar(page) ])
		editarNotaForm.addChild(new XButton("volver").onClick = [| volver(page) ])
		this.addChild(editarNotaForm)
	}
	
	def volver(SeguidorCarreraPage page) {
		//Acepta igual (Ejemplo WicketCelulares hace lo mismo)
		page.setNotaSeleccionada(notaOriginal)
		responsePage= page
	}
	
	def editar(SeguidorCarreraPage page) {
		responsePage = page
	}
	
	
	
}