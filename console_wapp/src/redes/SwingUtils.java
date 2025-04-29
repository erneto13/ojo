package redes;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("unused")
public class SwingUtils {

    /**
     * Busca un componente con el nombre especificado en el contenedor especificado.
     * @param container El contenedor en el que buscar.
     * @param componentName El nombre del componente a buscar.
     * @return El componente encontrado, o null si no se encontró ningún componente con el nombre especificado.
     */
    public static Component findComponentByName(Container container, String componentName) {
        if (componentName.equals(container.getName())) {
            return container;
        }
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (componentName.equals(component.getName())) {
                return component;
            } else if (component instanceof Container) {
                Component subComponent = findComponentByName((Container) component, componentName);
                if (subComponent != null) {
                    return subComponent;
                }
            }
        }
        return null;
    }

}
