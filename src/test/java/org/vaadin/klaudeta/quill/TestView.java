package org.vaadin.klaudeta.quill;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * Test View for our {@link QuillEditor} add-on class. This class and others in the
 * test folder will not be included in the final JAR.
 */
@Route("")
public class TestView extends VerticalLayout {

    public TestView() {
        QuillEditor quillEditor = new QuillEditor();

        quillEditor.getToolbarConfigurator().noFontDecorators()
                .noColors().initEditor();

        add(quillEditor);

        quillEditor.setHeight("60%");
        Div div = new Div();
        add(div);

        quillEditor.addValueChangeListener(event -> {
            div.getElement().setProperty("innerHTML", quillEditor.getValue());
        });

        this.setSizeFull();
    }
}
