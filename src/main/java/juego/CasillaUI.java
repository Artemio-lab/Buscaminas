package juego;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.Objects;

public class CasillaUI extends StackPane {

    private final Casilla casilla;
    private final Button boton;
    private final int tam;
    private Runnable descubrirCasilla;

    public CasillaUI(Casilla casilla) {
        this.casilla = casilla;
        this.tam = 50;
        this.boton = new Button();

        Image image = cargarImagen(actualizarURL());
        ImageView imagenCasilla = new ImageView(image);
        imagenCasilla.setFitHeight(tam);
        imagenCasilla.setFitWidth(tam);
        boton.setGraphic(imagenCasilla);

        boton.setOnAction(e -> {
            if (!casilla.isDescubierta() && descubrirCasilla != null) {
                descubrirCasilla.run();
            }
        });

        this.getChildren().add(boton);
        this.setCursor(Cursor.HAND);
    }

    public String actualizarURL() {
        if (!casilla.isDescubierta()) {
            return "/juego/ImagenesMinas/FondoDeBloqueRoto.png";
        } else if (casilla.isMina()) {
            return "/juego/ImagenesMinas/BombaConFondo.png";
        } else {
            return "/juego/ImagenesMinas/FondoDescubierto" + casilla.getMinasAdyacentes() + ".png";
        }
    }

    public Image cargarImagen(String url) {
        try {
            return new Image(Objects.requireNonNull(getClass().getResource(url)).toExternalForm(), tam, tam, true, true);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen: " + url);
            return null;
        }
    }

    public void setOnDescubrir(Runnable accion) {
        this.descubrirCasilla = accion;
    }
}
