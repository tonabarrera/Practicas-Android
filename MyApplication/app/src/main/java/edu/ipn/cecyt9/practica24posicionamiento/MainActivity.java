package edu.ipn.cecyt9.practica24posicionamiento;
//Importamos lo necesario
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
//Librerias para usar los mapas
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//La clase debe de heredar de FragmentActivity para poder poner un fragmento
// y que actue como una actividad
//Se debe implementar OnMapClickListener para detectar los clicks en el mapa
public class MainActivity extends FragmentActivity implements GoogleMap.OnMapClickListener {
    private GoogleMap map; //Con GoogleMap le damos funcinalidad a nuestro mapa
    //Coordenadas de varios lugares
    private static final LatLng CECYT9 = new LatLng(19.453514, -99.175197);
    public static final LatLng ESCOM = new LatLng(19.504544, -99.146578);
    public static final LatLng UPIITA = new LatLng(19.511512, -99.125865);
    public static final LatLng UPIICSA = new LatLng(19.396357, -99.089843);
    public static final LatLng ESCA = new LatLng(19.453348, -99.167337);
    public static final LatLng ESFM = new LatLng(19.502587, -99.134223);
    public static final LatLng arregloLat[] = new LatLng[]{ESCOM, UPIITA, UPIICSA, ESCA, ESFM};
    static final String[] nombres = new String[]{"ESCOM", "UPIITA", "UPIICSA", "ESCA", "ESFM"};
    String[] descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos la descripcion de los lugares
        descripcion = getResources().getStringArray(R.array.array_descripcion);
        //Inicializamos el mapa
        map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE); //Tipo de mapa
        map.setMyLocationEnabled(true); //Ver mi ubicacion
        map.getUiSettings().setZoomControlsEnabled(false); //Controles de zoom
        map.getUiSettings().setCompassEnabled(true); //La brujula
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(CECYT9, 18)); //Nos ubicamos en la batiz
        //Esto añade un marcador
        map.addMarker(new MarkerOptions()
                .position(CECYT9) //La posicion
                .title("CECYT9") //El titulo del marcador
                .snippet("CECYT 9 \"Juan de Dios Batiz\" ") //La descripcion del marcador
                .icon(BitmapDescriptorFactory
                        .fromResource(android.R.drawable.ic_menu_compass))) //El tipo de icono
                .setAnchor(0.5f, 0.5f);
        //Un for para poner los otros  5 lugares
        for(int i = 0; i<arregloLat.length; i++){
            map.addMarker(new MarkerOptions()
                    .position(arregloLat[i])
                    .title(nombres[i])
                    .snippet(descripcion[i])
                    .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_menu_compass)));
        }
        map.setOnMapClickListener(this); //Para detectar los clicks
    }
    //Estos metodos nos ubican en las coordenadas que se les indican
    public void onClickMoveBatiz(View view) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(CECYT9, 18));
    }

    public void onClickMoveESCOM(View view) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(ESCOM, 18));
    }

    public void onClickMoveUPIITA(View view) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(UPIITA, 18));
    }

    public void onClickMoveUPICSA(View view) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(UPIICSA, 18));
    }
    public void onClickMoveESCA(View view) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(ESCA, 18));
    }
    public void onClickMoveESFM(View view) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(ESFM, 18));
    }
    //Me muestra mi ubicacion actual
    public void onClickMoveActual(View view) {
        if (map.getMyLocation() != null){
            //Obtenemos nuestras coordenadas
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                    map.getMyLocation().getLatitude(), map.getMyLocation().getLongitude()), 18));
        }
    }
    //Añadimos nuevos marcadores cuando pulsamos el boton correspondiente
    public void onClickAddMarker(View view) {
        map.addMarker(new MarkerOptions()
                //Obtenemos las coordenadas del centro de la pantalla
                .position(new LatLng(map.getCameraPosition()
                .target.latitude, map.getCameraPosition().target.longitude)));
    }
    //Añadde un marcador donde se detecta el click
    @Override
    public void onMapClick(LatLng latLng) {
        map.addMarker(new MarkerOptions()
                .position(latLng)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
    }
}
