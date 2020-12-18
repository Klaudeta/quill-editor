package org.vaadin.klaudeta.quill;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.shared.Registration;


public interface QuillValueChangeNotifier {

    default Registration addValueChangeListener(
            ComponentEventListener<QuillValueChangeEvent> listener) {
        if (this instanceof Component) {
            return ComponentUtil.addListener((Component) this, QuillValueChangeEvent.class,  listener);
        } else {
            throw new IllegalStateException(String.format(
                    "The class '%s' doesn't extend '%s'. "
                            + "Make your implementation for the method '%s'.",
                    getClass().getName(), Component.class.getSimpleName(),
                    "addValueChangeListener"));
        }
    }

    class QuillValueChangeEvent extends ComponentEvent<Component> {

        private final String value;

        public QuillValueChangeEvent(Component source, String value) {
            super(source, true);
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}

