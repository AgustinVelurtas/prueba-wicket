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
import org.uqbar.commons.utils.Observable

class SeguidorCarreraPage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	@Observable
	var SeguidorCarrera seguidor
	
	new() {
		this.seguidor= new SeguidorCarrera()
		seguidor.show
		this.seguidor.materiaSeleccionada= this.seguidor.materias.head
		
		val Form<SeguidorCarrera> seguidorForm = new Form("seguidorCarreraForm", new CompoundPropertyModel(this.seguidor))
		this.agregarListaMaterias(seguidorForm)
		
		val Form<Materia> materiaForm= new Form("materiaForm",new CompoundPropertyModel(this.seguidor.materiaSeleccionada))
		this.agregarDetallesMateria(materiaForm)
		//this.agregarAcciones(seguidorForm)
		
		this.addChild(seguidorForm)	
		this.addChild(materiaForm)
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
	
	
	def agregarDetallesMateria(Form<Materia> parent) {
		//Info de la materia elegida		
		parent.addChild(new Label("nombre"))
		parent.addChild(new Label("anioCursada")) 
		parent.addChild(new CheckBox("finalAprobado").setEnabled(seguidor.materiaSeleccionada.finalAprobado))
		parent.addChild(new Label("profesor"))
		//Grilla de notas
		 val listView= new XListView("notas") 
		 listView.populateItem = [ item |
		 	item.model= item.modelObject.asCompoundModel
		 	item.addChild(new Label("fecha"))
		 	item.addChild(new Label("descripcion"))
		 	item.addChild(new Label("aprobado"))
		 ]
		 parent.addChild(listView)
	}

 def agregarListaMaterias(Form<SeguidorCarrera> parent) {
 		val listView = new XListView("materias")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(new XButton("editar").onClick = [| editar(item.modelObject) ])
			]
		parent.addChild(listView)
		parent.addChild(new XButton("agregarMateria").onClick=[|agregarMateria()])
}
	
	def agregarMateria() {
		responsePage = new AgregarMateriaPage(this) 
		
		seguidor.show
	}
	
	def editar(Materia materiaElegida) {
		seguidor.materiaSeleccionada= materiaElegida
		println(seguidor.materiaSeleccionada.nombre)
	}

}
