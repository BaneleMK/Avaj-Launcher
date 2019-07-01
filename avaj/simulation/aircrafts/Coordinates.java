package avaj.simulation.aircrafts;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude(){
        return this.longitude;
    }

    public int getLatitude(){
        return this.latitude;
    }

    public int getHeight(){
        return this.height;
    }

    public void setaddLongitude(int nlongitude){
        this.longitude += nlongitude;
    }

    public void setaddLatitude(int nlatitude){
        this.latitude += nlatitude;
    }

    public void setaddHeight(int nheight){
        this.height += nheight;
        if(this.height > 100){
            this.height = 100;
        }
    }
}