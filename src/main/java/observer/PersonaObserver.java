package observer;

import interfaces.Observer;
import javax.swing.JTextArea;

public class PersonaObserver implements Observer {

    private JTextArea textArea;

    public PersonaObserver(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void update() {
        if (textArea != null) {
            textArea.append("Se ha producido un cambio en los datos de Persona.\n");
        }
    }
}
