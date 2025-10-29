package juego;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class CasillaUI extends StackPane {

    private Casilla casilla;
    private Button boton;
    private final ImageView imagenCasilla;
    private final int tam;

    public CasillaUI(Casilla casilla) {
        this.casilla = casilla;
        tam =50;

        Image image = cargarImagen("a");
        imagenCasilla = new ImageView(image);
        imagenCasilla.setFitHeight(tam);
        imagenCasilla.setFitWidth(tam);
        this.getChildren().add(imagenCasilla);

        this.setCursor(Cursor.HAND);
        this.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 6, 0, 2, 2);");
    }

    public String actualizarURL(){
        String url="";
        if(!casilla.isDescubierta()){
            url ="/juego/ImagenesMinas/FondoDescubiertoRoto.png";
        }else{
            if(casilla.isMina()){
                url ="/juego/ImagenesMinas/BombaConFondo.png";
            }else {
                switch (casilla.getMinasAdyacentes()) {
                    case 0:
                        url = "/juego/ImagenesMinas/FondoDescubierto0.png";
                        break;
                    case 1:
                        url = "/juego/ImagenesMinas/FondoDescubierto1.png";
                        break;
                    case 2:
                        url = "/juego/ImagenesMinas/FondoDescubierto2.png";
                        break;
                    case 3:
                        url = "/juego/ImagenesMinas/FondoDescubierto3.png";
                        break;
                    case 4:
                        url = "/juego/ImagenesMinas/FondoDescubierto4.png";
                        break;
                    case 5:
                        url = "/juego/ImagenesMinas/FondoDescubierto5.png";
                        break;
                    case 6:
                        url = "/juego/ImagenesMinas/FondoDescubierto6.png";
                        break;
                    case 7:
                        url = "/juego/ImagenesMinas/FondoDescubierto7.png";
                        break;
                    case 8:
                        url = "/juego/ImagenesMinas/FondoDescubierto8.png";
                        break;
                }
            }
        }

        return url;
    }

    public Image cargarImagen(String url) {
        this.getChildren().clear();

        try {
            if (url == null || url.isEmpty()) return null;

            Image image = new Image(url, tam, tam, true, true);
            return image.isError() ? null : image;

        } catch (Exception e) {
            System.out.println("La imagen no cargo: " + url + " → " + e.getMessage());
            return null;
        }
    }

    public Button getBoton() { return boton; }
}
