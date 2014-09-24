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

	var Form<Materia> materiaForm

	new() {

		//Inicio del dominio
		this.seguidor = new SeguidorCarrera()
		seguidor.show
		this.seguidor.materiaSeleccionada = this.seguidor.materias.head

		//Creacion de formularios
		val Form<SeguidorCarrera> seguidorForm = new Form("seguidorCarreraForm",
			new CompoundPropertyModel(this.seguidor))
		this.agregarListaMaterias(seguidorForm)

		materiaForm = new Form("materiaForm", new CompoundPropertyModel(this.seguidor.materiaSeleccionada))
		this.agregarDetallesMateria(materiaForm)

		this.addChild(seguidorForm)
		this.addChild(materiaForm)
	}

	def eliminarNota() {
		seguidor.materiaSeleccionada.notas.remove(seguidor.notaSeleccionada)
	}

	def agregarNota() {
		seguidor.materiaSeleccionada.notas.add(new Nota)
	}

	def editarNotaPage() {
		responsePage = new EditarNotaPage(this)
	}

	def setNotaSeleccionada(Nota nota) {
		seguidor.notaSeleccionada = nota
	}

	def agregarDetallesMateria(Form<Materia> parent) {

		//Info de la materia elegida		
		parent.addChild(new Label("nombre"))
		parent.addChild(new Label("anioCursada"))
		parent.addChild(new CheckBox("finalAprobado").setEnabled(seguidor.materiaSeleccionada.finalAprobado))
		parent.addChild(new Label("profesor"))

		//Grilla de notas
		val listView = new XListView("notas")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("fecha"))
			item.addChild(new Label("descripcion"))
			item.addChild(new Label("aprobado"))
			item.addChild(new XButton("seleccionar").onClick = [|seguidor.notaSeleccionada = item.modelObject])
		]
		parent.addChild(listView)

		//Botones
		parent.addChild(new XButton("+").onClick = [|this.agregarNota()])
		parent.addChild(new XButton("-").onClick = [|this.eliminarNota()])
		parent.addChild(new XButton("editarNota").onClick = [|this.editarNotaPage()])

	}

	def agregarListaMaterias(Form<SeguidorCarrera> parent) {
		val listView = new XListView("materias")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			item.addChild(new XButton("editar").onClick = [|editar(item.modelObject)])
		]
		parent.addChild(listView)
		parent.addChild(new XButton("agregarMateria").onClick = [|agregarMateriaPage()])
	}

	def agregarMateriaPage() {
		responsePage = new AgregarMateriaPage(this)

		seguidor.show
	}

	def agregarMateria(Materia materia) {
		this.seguidor.agregarMateria(materia)
	}

	def editar(Materia materiaElegida) {
		seguidor.materiaSeleccionada = materiaElegida
		materiaForm.model = new CompoundPropertyModel(seguidor.materiaSeleccionada)
	}

	def getGetNotaSeleccionada() {
		seguidor.notaSeleccionada
	}

}
