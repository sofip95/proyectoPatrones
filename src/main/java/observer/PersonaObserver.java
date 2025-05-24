package observer;

import interfaces.Observer;

public class PersonaObserver implements Observer {

    @Override
    public void update() {
        System.out.println("Se ha producido un cambio en los datos de Persona.");
    }
}
