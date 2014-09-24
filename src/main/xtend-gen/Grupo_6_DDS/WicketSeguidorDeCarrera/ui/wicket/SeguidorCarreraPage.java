package Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket;

import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Materia;
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Nota;
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.SeguidorCarrera;
import Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket.AgregarMateriaPage;
import Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket.EditarNotaPage;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.utils.Observable;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import org.uqbar.wicket.xtend.XListView;

@SuppressWarnings("all")
public class SeguidorCarreraPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  @Observable
  private SeguidorCarrera seguidor;
  
  private Form<Materia> materiaForm;
  
  public SeguidorCarreraPage() {
    SeguidorCarrera _seguidorCarrera = new SeguidorCarrera();
    this.seguidor = _seguidorCarrera;
    this.seguidor.show();
    List<Materia> _materias = this.seguidor.getMaterias();
    Materia _head = IterableExtensions.<Materia>head(_materias);
    this.seguidor.setMateriaSeleccionada(_head);
    CompoundPropertyModel<SeguidorCarrera> _compoundPropertyModel = new CompoundPropertyModel<SeguidorCarrera>(this.seguidor);
    final Form<SeguidorCarrera> seguidorForm = new Form<SeguidorCarrera>("seguidorCarreraForm", _compoundPropertyModel);
    this.agregarListaMaterias(seguidorForm);
    Materia _materiaSeleccionada = this.seguidor.getMateriaSeleccionada();
    CompoundPropertyModel<Materia> _compoundPropertyModel_1 = new CompoundPropertyModel<Materia>(_materiaSeleccionada);
    Form<Materia> _form = new Form<Materia>("materiaForm", _compoundPropertyModel_1);
    this.materiaForm = _form;
    this.agregarDetallesMateria(this.materiaForm);
    this._wicketExtensionFactoryMethods.addChild(this, seguidorForm);
    this._wicketExtensionFactoryMethods.addChild(this, this.materiaForm);
  }
  
  public boolean eliminarNota() {
    Materia _materiaSeleccionada = this.seguidor.getMateriaSeleccionada();
    ArrayList<Nota> _notas = _materiaSeleccionada.getNotas();
    Nota _notaSeleccionada = this.seguidor.getNotaSeleccionada();
    return _notas.remove(_notaSeleccionada);
  }
  
  public boolean agregarNota() {
    Materia _materiaSeleccionada = this.seguidor.getMateriaSeleccionada();
    ArrayList<Nota> _notas = _materiaSeleccionada.getNotas();
    Nota _nota = new Nota();
    return _notas.add(_nota);
  }
  
  public void editarNotaPage() {
    EditarNotaPage _editarNotaPage = new EditarNotaPage(this);
    this.setResponsePage(_editarNotaPage);
  }
  
  public void setNotaSeleccionada(final Nota nota) {
    this.seguidor.setNotaSeleccionada(nota);
  }
  
  public MarkupContainer agregarDetallesMateria(final Form<Materia> parent) {
    MarkupContainer _xblockexpression = null;
    {
      Label _label = new Label("nombre");
      this._wicketExtensionFactoryMethods.addChild(parent, _label);
      Label _label_1 = new Label("anioCursada");
      this._wicketExtensionFactoryMethods.addChild(parent, _label_1);
      CheckBox _checkBox = new CheckBox("finalAprobado");
      Materia _materiaSeleccionada = this.seguidor.getMateriaSeleccionada();
      Boolean _finalAprobado = _materiaSeleccionada.getFinalAprobado();
      Component _setEnabled = _checkBox.setEnabled((_finalAprobado).booleanValue());
      this._wicketExtensionFactoryMethods.addChild(parent, _setEnabled);
      Label _label_2 = new Label("profesor");
      this._wicketExtensionFactoryMethods.addChild(parent, _label_2);
      final XListView<Nota> listView = new XListView<Nota>("notas");
      final Procedure1<ListItem<Nota>> _function = new Procedure1<ListItem<Nota>>() {
        public void apply(final ListItem<Nota> item) {
          Nota _modelObject = item.getModelObject();
          CompoundPropertyModel<Nota> _asCompoundModel = SeguidorCarreraPage.this._wicketExtensionFactoryMethods.<Nota>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("fecha");
          SeguidorCarreraPage.this._wicketExtensionFactoryMethods.addChild(item, _label);
          Label _label_1 = new Label("descripcion");
          SeguidorCarreraPage.this._wicketExtensionFactoryMethods.addChild(item, _label_1);
          Label _label_2 = new Label("aprobado");
          SeguidorCarreraPage.this._wicketExtensionFactoryMethods.addChild(item, _label_2);
          XButton _xButton = new XButton("seleccionar");
          final Procedure0 _function = new Procedure0() {
            public void apply() {
              Nota _modelObject = item.getModelObject();
              SeguidorCarreraPage.this.seguidor.setNotaSeleccionada(_modelObject);
            }
          };
          XButton _setOnClick = _xButton.setOnClick(_function);
          SeguidorCarreraPage.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick);
        }
      };
      listView.setPopulateItem(_function);
      this._wicketExtensionFactoryMethods.addChild(parent, listView);
      XButton _xButton = new XButton("+");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          SeguidorCarreraPage.this.agregarNota();
        }
      };
      XButton _setOnClick = _xButton.setOnClick(_function_1);
      this._wicketExtensionFactoryMethods.addChild(parent, _setOnClick);
      XButton _xButton_1 = new XButton("-");
      final Procedure0 _function_2 = new Procedure0() {
        public void apply() {
          SeguidorCarreraPage.this.eliminarNota();
        }
      };
      XButton _setOnClick_1 = _xButton_1.setOnClick(_function_2);
      this._wicketExtensionFactoryMethods.addChild(parent, _setOnClick_1);
      XButton _xButton_2 = new XButton("editarNota");
      final Procedure0 _function_3 = new Procedure0() {
        public void apply() {
          SeguidorCarreraPage.this.editarNotaPage();
        }
      };
      XButton _setOnClick_2 = _xButton_2.setOnClick(_function_3);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, _setOnClick_2);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer agregarListaMaterias(final Form<SeguidorCarrera> parent) {
    MarkupContainer _xblockexpression = null;
    {
      final XListView<Materia> listView = new XListView<Materia>("materias");
      final Procedure1<ListItem<Materia>> _function = new Procedure1<ListItem<Materia>>() {
        public void apply(final ListItem<Materia> item) {
          Materia _modelObject = item.getModelObject();
          CompoundPropertyModel<Materia> _asCompoundModel = SeguidorCarreraPage.this._wicketExtensionFactoryMethods.<Materia>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("nombre");
          SeguidorCarreraPage.this._wicketExtensionFactoryMethods.addChild(item, _label);
          XButton _xButton = new XButton("editar");
          final Procedure0 _function = new Procedure0() {
            public void apply() {
              Materia _modelObject = item.getModelObject();
              SeguidorCarreraPage.this.editar(_modelObject);
            }
          };
          XButton _setOnClick = _xButton.setOnClick(_function);
          SeguidorCarreraPage.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick);
        }
      };
      listView.setPopulateItem(_function);
      this._wicketExtensionFactoryMethods.addChild(parent, listView);
      XButton _xButton = new XButton("agregarMateria");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          SeguidorCarreraPage.this.agregarMateriaPage();
        }
      };
      XButton _setOnClick = _xButton.setOnClick(_function_1);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, _setOnClick);
    }
    return _xblockexpression;
  }
  
  public void agregarMateriaPage() {
    AgregarMateriaPage _agregarMateriaPage = new AgregarMateriaPage(this);
    this.setResponsePage(_agregarMateriaPage);
    this.seguidor.show();
  }
  
  public boolean agregarMateria(final Materia materia) {
    return this.seguidor.agregarMateria(materia);
  }
  
  public void editar(final Materia materiaElegida) {
    this.seguidor.setMateriaSeleccionada(materiaElegida);
    Materia _materiaSeleccionada = this.seguidor.getMateriaSeleccionada();
    CompoundPropertyModel<Materia> _compoundPropertyModel = new CompoundPropertyModel<Materia>(_materiaSeleccionada);
    this.materiaForm.setModel(_compoundPropertyModel);
  }
  
  public Nota getGetNotaSeleccionada() {
    return this.seguidor.getNotaSeleccionada();
  }
}
