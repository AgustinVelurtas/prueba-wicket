package Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket;

import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Materia;
import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.SeguidorCarrera;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import org.uqbar.wicket.xtend.XListView;

@SuppressWarnings("all")
public class SeguidorCarreraPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private SeguidorCarrera seguidor;
  
  private Materia materiaElegida;
  
  public SeguidorCarreraPage() {
    SeguidorCarrera _seguidorCarrera = new SeguidorCarrera();
    this.seguidor = _seguidorCarrera;
    this.seguidor.show();
    CompoundPropertyModel<SeguidorCarrera> _compoundPropertyModel = new CompoundPropertyModel<SeguidorCarrera>(this.seguidor);
    final Form<SeguidorCarrera> seguidorForm = new Form<SeguidorCarrera>("seguidorCarreraForm", _compoundPropertyModel);
    this.agregarListaMaterias(seguidorForm);
    this.agregarDetallesMateria(seguidorForm);
    this._wicketExtensionFactoryMethods.addChild(this, seguidorForm);
  }
  
  public Object agregarAcciones(final Form parent) {
    return null;
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
  
  public void agregarMateria(final Object object) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Object agregarDetallesMateria(final Form parent) {
    return null;
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
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, listView);
    }
    return _xblockexpression;
  }
  
  public void editar(final Materia materiaElegida) {
    this.seguidor.setMateriaSeleccionada(materiaElegida);
  }
}
