package Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket;

import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Materia;
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.SeguidorCarrera;
import Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket.AgregarMateriaPage;
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
import org.eclipse.xtext.xbase.lib.InputOutput;
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
    final Form<Materia> materiaForm = new Form<Materia>("materiaForm", _compoundPropertyModel_1);
    this.agregarDetallesMateria(materiaForm);
    this._wicketExtensionFactoryMethods.addChild(this, seguidorForm);
    this._wicketExtensionFactoryMethods.addChild(this, materiaForm);
  }
  
  public void eliminarNota(final Object object) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void agregarNota(final Object object) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void editarNota(final Object object) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
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
      final XListView<Object> listView = new XListView<Object>("notas");
      final Procedure1<ListItem<Object>> _function = new Procedure1<ListItem<Object>>() {
        public void apply(final ListItem<Object> item) {
          Object _modelObject = item.getModelObject();
          CompoundPropertyModel<Object> _asCompoundModel = SeguidorCarreraPage.this._wicketExtensionFactoryMethods.<Object>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("fecha");
          SeguidorCarreraPage.this._wicketExtensionFactoryMethods.addChild(item, _label);
          Label _label_1 = new Label("descripcion");
          SeguidorCarreraPage.this._wicketExtensionFactoryMethods.addChild(item, _label_1);
          Label _label_2 = new Label("aprobado");
          SeguidorCarreraPage.this._wicketExtensionFactoryMethods.addChild(item, _label_2);
        }
      };
      listView.setPopulateItem(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, listView);
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
          SeguidorCarreraPage.this.agregarMateria();
        }
      };
      XButton _setOnClick = _xButton.setOnClick(_function_1);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, _setOnClick);
    }
    return _xblockexpression;
  }
  
  public void agregarMateria() {
    AgregarMateriaPage _agregarMateriaPage = new AgregarMateriaPage(this);
    this.setResponsePage(_agregarMateriaPage);
    this.seguidor.show();
  }
  
  public String editar(final Materia materiaElegida) {
    String _xblockexpression = null;
    {
      this.seguidor.setMateriaSeleccionada(materiaElegida);
      Materia _materiaSeleccionada = this.seguidor.getMateriaSeleccionada();
      String _nombre = _materiaSeleccionada.getNombre();
      _xblockexpression = InputOutput.<String>println(_nombre);
    }
    return _xblockexpression;
  }
}
