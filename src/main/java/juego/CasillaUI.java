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

    public CasillaUI(Casilla casilla) {
        boton = new Button();
        this.casilla = casilla;
        tam =50;

        Image image = cargarImagen(actualizarURL());
        ImageView imagenCasilla = new ImageView(image);
        imagenCasilla.setFitHeight(tam);
        imagenCasilla.setFitWidth(tam);

        boton.setGraphic(imagenCasilla);

        this.getChildren().add(imagenCasilla);

        this.setCursor(Cursor.HAND);
        this.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 6, 0, 2, 2);");
    }

    public String actualizarURL() {
        String url = "";
        if (casilla.isDescubierta()) {
            url = "/juego/ImagenesMinas/FondoDeBloqueRoto.png";
        } else {
            if (casilla.isMina()) {
                url = "/juego/ImagenesMinas/BombaConFondo.png";
            } else {
                url = "/juego/ImagenesMinas/FondoDescubierto"+casilla.getMinasAdyacentes()+".png";
                System.out.println(casilla.getMinasAdyacentes());
            }
        }
        return url;
    }

    public Image cargarImagen(String url) {
        this.getChildren().clear();

        try {
            if (url == null || url.isEmpty()) return null;

            return new Image(Objects.requireNonNull(getClass().getResource(url)).toExternalForm(), tam, tam, true, true);
        } catch (Exception e) {
            System.out.println("La imagen no cargo: " + url + " → " + e.getMessage());
            return null;
        }
    }

    public Button getBoton() { return boton; }
}
