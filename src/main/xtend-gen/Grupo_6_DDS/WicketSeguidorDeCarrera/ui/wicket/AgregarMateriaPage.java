package Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket;

import Grupo_6_DDS.WicketSeguidorDeCarrera.domain.Materia;
import Grupo_6_DDS.WicketSeguidorDeCarrera.ui.wicket.SeguidorCarreraPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;

@SuppressWarnings("all")
public class AgregarMateriaPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  public AgregarMateriaPage(final SeguidorCarreraPage page) {
    final Materia nuevaMateria = new Materia();
    CompoundPropertyModel<Materia> _compoundPropertyModel = new CompoundPropertyModel<Materia>(nuevaMateria);
    final Form<Materia> nuevaMateriaForm = new Form<Materia>("nuevaMateriaForm", _compoundPropertyModel);
    TextField<String> _textField = new TextField<String>("nombre");
    this._wicketExtensionFactoryMethods.addChild(nuevaMateriaForm, _textField);
    XButton _xButton = new XButton("aceptar");
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        AgregarMateriaPage.this.agregar(nuevaMateria, page);
      }
    };
    XButton _setOnClick = _xButton.setOnClick(_function);
    this._wicketExtensionFactoryMethods.addChild(nuevaMateriaForm, _setOnClick);
    this._wicketExtensionFactoryMethods.addChild(this, nuevaMateriaForm);
  }
  
  public boolean agregar(final Materia materia, final SeguidorCarreraPage page) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field seguidor is not visible");
  }
}
