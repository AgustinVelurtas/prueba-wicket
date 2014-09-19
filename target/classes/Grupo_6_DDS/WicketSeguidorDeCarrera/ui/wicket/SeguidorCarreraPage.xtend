package Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket

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
import org.uqbar.wicket.xtend.XListView
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.apache.wicket.markup.html.form.ListMultipleChoice
import org.apache.wicket.model.Model
import org.apache.wicket.markup.html.panel.Panel
import org.uqbar.wicket.xtend.XButton
import org.apache.wicket.markup.html.form.ListChoice
import org.apache.wicket.model.PropertyModel
import org.uqbar.commons.model.IModel

class SeguidorCarreraPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	var SeguidorCarrera seguidor
	
	
	new() {
		this.seguidor= new SeguidorCarrera()
		seguidor.show
		val Form seguidorForm = new Form("seguidorCarreraForm", new CompoundPropertyModel(this.seguidor))
		this.agregarListaMaterias(seguidorForm)
		/*this.agregarDetallesMateria(seguidorForm)
		this.agregarAcciones(seguidorForm)*/
		
		this.addChild(seguidorForm)	
	}
	
	def agregarAcciones(Form parent) {
		/*parent.addChild(new XButton("Nueva Materia").onClick = [| this.agregarMateria(seguidor.materiaSeleccionada) ])
		parent.addChild(new XButton("Editar").onClick = [| this.editarNota(seguidor.notaSeleccionada) ])	
		parent.addChild(new XButton("+").onClick = [| this.agregarNota() ])
		parent.addChild(new XButton("-").onClick = [| this.eliminarNota(seguidor.notaSeleccionada) ])*/

	}
	
	def eliminarNota(Object object) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def agregarNota(Object object) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def editarNota(Object object) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def agregarMateria(Object object) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def agregarDetallesMateria(Form parent) {/*
		//Info de la materia elegida		
		parent.addChild(new Label("nombre"))
		parent.addChild(new)
		parent.addChild(new Label("anioCursada"))
		parent.addChild(new CheckBox("model.finalAprobado").setEnabled(model.finalAprobado))
		parent.addChild(new Label("profesor".setText(model.profesor)
		agregarGrillaDeNotas(parent)*/
	}

 def agregarListaMaterias(Form<SeguidorCarreraPage> parent) {
 		val listView = new XListView("materias")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(new XButton("editar").onClick = [| editar(item.modelObject) ])
			]
		parent.addChild(listView)
}
	
	def editar(Object object) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
