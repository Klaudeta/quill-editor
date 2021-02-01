package org.vaadin.klaudeta.quill;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
        quillEditor.getToolbarConfigurator().noFontDecorators().noColors().initEditor();
        quillEditor.setHeight("20em");
        add(quillEditor);

        add(new HorizontalLayout(
                new Button("Clear Editor", event -> quillEditor.clear()),
                new Button("Toggle ReadOnly", event -> quillEditor.setReadOnly(!quillEditor.isReadOnly()))
        ));

        Div div = new Div();
        div.getStyle().set("overflow", "auto");
        div.setHeight("20em");
        div.setWidth("20em");
        add(div);

        quillEditor.addValueChangeListener(event -> {
            div.getElement().setProperty("innerHTML", quillEditor.getValue());
        });

        this.setSizeFull();
    }

}