package pe.edu.utp.util;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public interface DocumentListenerUtil extends DocumentListener{
    void update(DocumentEvent e);

    @Override
    default void insertUpdate(DocumentEvent e) {
        update(e);
    }
    @Override
    default void removeUpdate(DocumentEvent e) {
        update(e);
    }
    @Override
    default void changedUpdate(DocumentEvent e) {
        update(e);
    }
}
